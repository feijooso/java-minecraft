package JavaFX.VistaMapa;

import Excepciones.HerramientaGastadaException;
import JavaFX.AlgoCraft;
import JavaFX.VentanaBase;
import JavaFX.Construccion.VistaEscenaFabricacionHerramientas;
import JavaFX.inventario.VistaInventario;
import JavaFX.vistaJugador.VistaJugador;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Juego.Juego;
import model.herramientas.Herramienta;
import model.jugador.Jugador;
import model.mapa.Mapa;
import model.materiales.Material;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VentanaJuego extends VentanaBase implements VistaInventario.Listener {

    private final int INSTRUCCIONES_ANCHO = 150;

    private Juego juego;
    private ImageView imagenHerramientaEquipada;
    private BarraDurabilidad barraDurabilidad;
    private MediaPlayer sonidoMovimientoJugador;
    private ImageView vistaSonidoMusica;
    private ImageView vistaSonidoEfectos;
    private Image imagenSonidoEfectos;

    public VentanaJuego(Juego juego, ImageView vistaSonidoMusica)throws FileNotFoundException{

        this.vistaSonidoMusica = vistaSonidoMusica;
        this.juego = juego;
        String archivoSonidoCaminar = "Sonidos/caminar.wav";
        Media mediaSonidoCaminar = new Media(new File(archivoSonidoCaminar).toURI().toString());
        sonidoMovimientoJugador = new MediaPlayer(mediaSonidoCaminar);


        imagenSonidoEfectos = new Image(new FileInputStream(AlgoCraft.IMAGE_PATH + "sonidoE.png"));

        Image imagenSinSonidoEfectos = new Image(new FileInputStream(AlgoCraft.IMAGE_PATH + "sinSonidoE.png"));

        vistaSonidoEfectos = new ImageView(imagenSonidoEfectos);
        vistaSonidoEfectos.setFitWidth(50);
        vistaSonidoEfectos.setFitHeight(50);

        vistaSonidoEfectos.setOnMouseClicked(event -> {
            if(vistaSonidoEfectos.getImage() == imagenSonidoEfectos) {
                vistaSonidoEfectos.setImage(imagenSinSonidoEfectos);
            } else {
                vistaSonidoEfectos.setImage(imagenSonidoEfectos);
            }
        });
    }

    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);

        BorderPane layoutRaiz = new BorderPane();
        VistaJugador vistaJugador = new VistaJugador(juego.obtenerJugador());

        VistaMapa vistaMapa = new VistaMapa(juego.obtenerMapa());

        layoutRaiz.setOnKeyPressed(new EventHandler<KeyEvent>(){
            public void handle(KeyEvent event) {


                switch (event.getCode()) {
                    case UP:
                        juego.moverJugadorHaciaElNorte();
                        ejecutarSonido(sonidoMovimientoJugador);
                        break;

                    case DOWN:
                        juego.moverJugadorHaciaElSur();
                        ejecutarSonido(sonidoMovimientoJugador);
                        break;

                    case LEFT:
                        juego.moverJugadorHaciaElOeste();
                        ejecutarSonido(sonidoMovimientoJugador);
                        break;

                    case RIGHT:
                        juego.moverJugadorHaciaElEste();
                        ejecutarSonido(sonidoMovimientoJugador);
                        break;

                    case SPACE:
                        try {
                             vistaMapa.actualizar(juego.jugadorGolpear());
                            barraDurabilidad.actualizar(juego.obtenerJugador().obtenerHerramientaEquipada().durabilidad());
                            Mapa mapa = juego.obtenerMapa();
                            Jugador jugador = juego.obtenerJugador();
                            Material materialAtacado = mapa.contenidoDe(jugador.obtenerPosicionAtaque());
                            ejecutarSonido(materialAtacado.sonido());
                        } catch (HerramientaGastadaException ex) {
                            System.out.println("Herramienta destruida");
                            juego.obtenerJugador().removerHerramientaEquipada();
                            imagenHerramientaEquipada.setImage(null);
                        } catch (Exception e) {
                            System.out.println("Ataco al material");
                        }
                        break;
                    case I:
                        try {
                            VistaInventario vistaInventario = new VistaInventario(juego.obtenerJugador(), VentanaJuego.this);
                            vistaInventario.start(new Stage());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case C:
                        try {
                            VistaEscenaFabricacionHerramientas vistaConstruccion = new VistaEscenaFabricacionHerramientas(juego.obtenerJugador().obtenerInventario());
                            vistaConstruccion.start(new Stage());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                }
                vistaJugador.move();
                event.consume();
            }
        });

        layoutRaiz.setCenter(vistaMapa);
        layoutRaiz.getChildren().add(vistaJugador);
        layoutRaiz.setRight(addInstruccionsPane(vistaMapa.obtenerTamaño(), juego.obtenerJugador().obtenerHerramientaEquipada()));
        Scene scene = new Scene(layoutRaiz, vistaMapa.obtenerTamaño() + INSTRUCCIONES_ANCHO, vistaMapa.obtenerTamaño());
        stage.setScene(scene);
        stage.show();
        layoutRaiz.requestFocus();
    }

    public void ejecutarSonido(MediaPlayer sonido) {

        if(vistaSonidoEfectos.getImage() == imagenSonidoEfectos) {
            sonido.seek(new Duration(0));
            sonido.play();
        } else {
            //nada
        }

    }

    private VBox addInstruccionsPane(int alto, Herramienta herramientaEquipada) throws Exception {
        VBox layout = new VBox();
        layout.minWidth(INSTRUCCIONES_ANCHO);
        layout.minHeight(alto);
        layout.setAlignment(Pos.CENTER);

        HBox sonidos = new HBox();
        sonidos.getChildren().add(vistaSonidoMusica);
        sonidos.getChildren().add(vistaSonidoEfectos);
        layout.getChildren().add(sonidos);

        Label labelNombreUsuario = new Label(juego.obtenerNombreUsuario());
        labelNombreUsuario.setStyle("-fx-font: 24 arial;");
        labelNombreUsuario.setPadding(new Insets(30, 0, 10, 0));
        layout.getChildren().add(labelNombreUsuario);

        Label labelTitulo = new Label("Instrucciones");
        labelTitulo.setMinSize(70,70);
        layout.getChildren().add(labelTitulo);

        Label labelDireciones = new Label("Direcciones");
        layout.getChildren().add(labelDireciones);

        ImageView arrowsView = new ImageView(new Image(new FileInputStream(AlgoCraft.IMAGE_PATH + "flechas_teclado.png")));
        arrowsView.setFitWidth(50);
        arrowsView.setFitHeight(50);
        layout.getChildren().add(arrowsView);

        Label labelAtaque = new Label("Ataque");
        layout.getChildren().add(labelAtaque);

        ImageView imagenAtaque = new ImageView(new Image(new FileInputStream(AlgoCraft.IMAGE_PATH + "barra_espacio.png")));
        imagenAtaque.setFitWidth(90);
        imagenAtaque.setFitHeight(50);
        layout.getChildren().add(imagenAtaque);

        Label labelInventario = new Label("Inventario");
        layout.getChildren().add(labelInventario);

        ImageView imagenInventario = new ImageView(new Image(new FileInputStream(AlgoCraft.IMAGE_PATH + "i.png")));
        imagenInventario.setFitWidth(30);
        imagenInventario.setFitHeight(30);
        layout.getChildren().add(imagenInventario);

        Label labelConstructor = new Label("Constructor");
        layout.getChildren().add(labelConstructor);

        ImageView imagenConstructor = new ImageView(new Image(new FileInputStream(AlgoCraft.IMAGE_PATH + "c.png")));
        imagenConstructor.setFitWidth(30);
        imagenConstructor.setFitHeight(30);
        layout.getChildren().add(imagenConstructor);

        Label labelGuiones = new Label("______________");
        layout.getChildren().add(labelGuiones);

        Label labelHerramientaEquipada = new Label("Herramienta equipada");
        layout.getChildren().add(labelHerramientaEquipada);

        imagenHerramientaEquipada = new ImageView(new Image(new FileInputStream(herramientaEquipada.getImage())));
        imagenHerramientaEquipada.setFitWidth(60);
        imagenHerramientaEquipada.setFitHeight(60);
        layout.getChildren().add(imagenHerramientaEquipada);

        barraDurabilidad = new BarraDurabilidad(juego.obtenerJugador().obtenerHerramientaEquipada().durabilidad());
        layout.getChildren().add(barraDurabilidad);

        return layout;
    }

    @Override
    public void herramientaCambiada(Herramienta herramienta) {
        try {
            imagenHerramientaEquipada.setImage(new Image(new FileInputStream(herramienta.getImage())));
            barraDurabilidad.actualizar(herramienta.durabilidad());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
