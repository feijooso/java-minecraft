package JavaFX;

import JavaFX.VistaMapa.VentanaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Juego.Juego;


import java.io.File;
import java.io.FileInputStream;

public class AlgoCraft extends VentanaBase {

    //El "Algocraft tienen que cambiarlo por el nombre de la carpeta de su proyecto.

    public static final String IMAGE_PATH = "../tp2/Imagenes/";
    private MediaPlayer backgroundMusic;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);
        Juego juego = new Juego();

        VBox layout = new VBox();
        layout.setSpacing(100);
        layout.setStyle("-fx-background-color: beige;");
        layout.setPadding(new Insets(40, 50, 10, 300));

        Text textoComienzo = new Text(50, 50, "ALGOCRAFT");
        textoComienzo.setFont(Font.font("Verdana", FontWeight.BLACK, 30));
        textoComienzo.setFill(Color.DARKGREY);

        layout.getChildren().add(textoComienzo);

        String archivoSonidoMinecraft = "Sonidos/minecraft.wav";
        Media mediaSonidoMinecraft = new Media(new File(archivoSonidoMinecraft).toURI().toString());
        backgroundMusic = new MediaPlayer(mediaSonidoMinecraft);
        backgroundMusic.setOnEndOfMedia(new Runnable() {
            public void run() {
                backgroundMusic.seek(Duration.ZERO);
            }
        });
        backgroundMusic.play();

        TextField textNombre = new TextField();
        textNombre.setPromptText("Ingrese su nombre aqui");
        textNombre.setPrefSize(180, 50);

       // Image portada = new Image(new FileInputStream(AlgoCraft.IMAGE_PATH + "portada.jpg"));
       // ImageView vistaDePortada = new ImageView(portada);
       // layout.getChildren().add(vistaDePortada);
        Image imagenSonidoMusica = new Image(new FileInputStream(AlgoCraft.IMAGE_PATH + "sonidoM.png"));
        Image imagenSinSonidoMusica = new Image(new FileInputStream(AlgoCraft.IMAGE_PATH + "sinSonidoM.png"));
        int imagenSonidoTamaño = 50;
        ImageView vistaSonidoMusica = new ImageView(imagenSonidoMusica);
        vistaSonidoMusica.setFitHeight(imagenSonidoTamaño);
        vistaSonidoMusica.setFitWidth(imagenSonidoTamaño);

        vistaSonidoMusica.setOnMouseClicked(event -> {
            if(backgroundMusic.isMute()) {
                backgroundMusic.setMute(false);
                vistaSonidoMusica.setImage(imagenSonidoMusica);
            } else {
                backgroundMusic.setMute(true);
                vistaSonidoMusica.setImage(imagenSinSonidoMusica);
            }
        });

        Image jugar = new Image(new FileInputStream(AlgoCraft.IMAGE_PATH + "jugar.jpg"));
        ImageView vistaDeJugar = new ImageView(jugar);
        Button botonJugar = new Button("Jugar", vistaDeJugar);
        botonJugar.setPrefSize(180,80);
        botonJugar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try{
                    juego.setearNombreUsuario(textNombre.getText().toString());
                    backgroundMusic.setVolume(0.5);
                    VentanaJuego ventanaJuego = new VentanaJuego(juego, vistaSonidoMusica);
                    ventanaJuego.start(new Stage());
                }catch (Exception exception) {
                    exception.printStackTrace();
                }
                stage.close();
            }
        });

        layout.getChildren().addAll(textNombre, botonJugar, vistaSonidoMusica);

        Scene scene = new Scene(layout, 800, 900);
        stage.setScene(scene);
        stage.show();

    }


}
