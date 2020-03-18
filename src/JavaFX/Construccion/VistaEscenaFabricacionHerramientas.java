package JavaFX.Construccion;

import Excepciones.NoSePudoContruirHerramientaException;
import JavaFX.AlgoCraft;
import JavaFX.VentanaBase;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Construccion.TablaDeContruccion;
import model.herramientas.Herramienta;
import model.jugador.inventario.Inventario;
import model.materiales.Material;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VistaEscenaFabricacionHerramientas extends VentanaBase implements VistaCasilleroPanel.Listener {

    Group root;
    Scene escena;
    TablaDeContruccion tablaDeContruccion;
    Inventario inventario;
    ImageView casillaResultado;
    Image imagenVacia;
    Herramienta herramientaConstruida;

    public VistaEscenaFabricacionHerramientas(Inventario inventario) {
        this.inventario = inventario;
    }

    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);

        tablaDeContruccion = new TablaDeContruccion();

        VistaPanelConstruccion panel = new VistaPanelConstruccion(this, inventario.obtenerInventarioMateriales());
        panel.setLayoutX(50);
        panel.setLayoutY(50);
        stage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case ESCAPE:
                        panel.recomponer();
                        break;
                }
            }
        });

        imagenVacia = new Image(new FileInputStream(AlgoCraft.IMAGE_PATH + "cuadradoVacio.png"));
        casillaResultado = new ImageView(imagenVacia);
        casillaResultado.setFitHeight(50);
        casillaResultado.setFitWidth(50);
        casillaResultado.setX(300);
        casillaResultado.setY(100);

        Button botonConstruir = new Button("construir");
        botonConstruir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(herramientaConstruida == null) return;
                inventario.agregar(herramientaConstruida);
                panel.limpiar();
                casillaResultado.setImage(imagenVacia);
                herramientaConstruida = null;
            }
        });
        botonConstruir.setLayoutX(212.5);
        botonConstruir.setLayoutY(112.5);

        Button botonVolver = new Button("Volver al mapa");

        botonVolver.setPrefSize(120,30);
        botonVolver.setLayoutX(250);
        botonVolver.setLayoutY(350);
        botonVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try{
                    stage.close();
                }catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });

        root = new Group(casillaResultado, botonConstruir, panel, botonVolver);
        escena = new Scene(root, 400, 400);


        stage.setScene(escena);
        stage.show();
    }

    @Override
    public void materialAgregado(Material material, int posicion) {
        tablaDeContruccion.insertar(material, posicion);
        try {
            herramientaConstruida = tablaDeContruccion.construir();
            Image image = new Image(new FileInputStream(herramientaConstruida.getImage()));
            casillaResultado.setImage(image);
        } catch (NoSePudoContruirHerramientaException ex) {
            casillaResultado.setImage(imagenVacia);
        } catch (FileNotFoundException notFoundExp) {
            notFoundExp.printStackTrace();
        }
    }

    @Override
    public void removerMaterial(int posicion) {
        tablaDeContruccion.remover(posicion);
    }
}
