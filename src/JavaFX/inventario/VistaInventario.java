package JavaFX.inventario;

import JavaFX.AlgoCraft;
import JavaFX.VentanaBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.herramientas.Herramienta;
import model.jugador.Jugador;


import java.io.FileInputStream;


public class VistaInventario extends VentanaBase implements LayoutHerramientas.Listener {

    private Jugador jugador;
    private Group layout;
    private VistaHerramientaEquipada vistaHEquipada;
    private LayoutHerramientas layoutHerramientas;
    private Listener listener;

    public VistaInventario(Jugador jugador, Listener listener) {
        this.jugador = jugador;
        this.listener = listener;
    }

    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);

        layout = new Group();

        String pathJugador = AlgoCraft.IMAGE_PATH + jugador.getClass().getSimpleName() + ".png";
        Image imagenJugador = new Image(new FileInputStream(pathJugador));
        ImageView vistaImagenJugador = new ImageView(imagenJugador);
        vistaImagenJugador.setY(0);
        vistaImagenJugador.setX(600);
        layout.getChildren().add(vistaImagenJugador);

        VistaHerramientaEquipada vistaHerramientaEquipada = new VistaHerramientaEquipada(jugador.obtenerHerramientaEquipada());
        layout.getChildren().add(vistaHerramientaEquipada);
        vistaHEquipada = vistaHerramientaEquipada;

        layoutHerramientas = new LayoutHerramientas(jugador.obtenerInventario().obtenerInventarioHerramientas());
        layoutHerramientas.setLayoutX(10);
        layoutHerramientas.setLayoutY(400);
        layoutHerramientas.setListener(this);
        layout.getChildren().add(layoutHerramientas);

        LayoutMateriales layoutMateriales = new LayoutMateriales(jugador.obtenerInventario().obtenerInventarioMateriales());
        layoutMateriales.setLayoutX(10);
        layoutMateriales.setLayoutY(600);
        layout.getChildren().add(layoutMateriales);

        Button botonVolver = new Button("Volver al mapa");

        botonVolver.setPrefSize(180,40);
        botonVolver.setLayoutX(600);
        botonVolver.setLayoutY(640);
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
        layout.getChildren().add(botonVolver);


        Scene scene = new Scene(layout, 800, 700);
        stage.setScene(scene);
        stage.show();



    }


    @Override
    public void heramientaClickeada(Herramienta herramienta) {

        jugador.cambiarHerramientaEquipada(herramienta);
        try {
            vistaHEquipada.actualizar(herramienta);
            layoutHerramientas.actualizar();
            listener.herramientaCambiada(herramienta);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public interface Listener {
        void herramientaCambiada(Herramienta herramienta);
    }

}
