package JavaFX.Construccion;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VistaMaterial extends VBox {

    ImageView vistaImagen;
    int cantidad;

    public VistaMaterial(String imagen, int valorCantidad, Listener listener) throws FileNotFoundException {

        this.cantidad = valorCantidad;

        vistaImagen = new ImageView(new Image(new FileInputStream("C:\\Users\\Luan\\Desktop\\"+imagen+".png")));
        vistaImagen.setFitWidth(50);
        vistaImagen.setFitHeight(50);

        Label nombre = new Label(imagen);

        Label indicadorCantidad = new Label(Integer.toString(valorCantidad));
        indicadorCantidad.setMaxWidth(50);
        indicadorCantidad.setAlignment(Pos.CENTER);

        this.getChildren().addAll(nombre, vistaImagen, indicadorCantidad);

        vistaImagen.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(cantidad <= 0)
                    return;

                cantidad--;
                indicadorCantidad.setText(Integer.toString(cantidad));
                Dragboard db = vistaImagen.startDragAndDrop(TransferMode.ANY);

                ClipboardContent contenido = new ClipboardContent();
                contenido.putString(imagen);
                db.setContent(contenido);

                event.consume();

                listener.recibirImagenArrastrada(vistaImagen);
            }
        });

        vistaImagen.setOnDragDone(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                listener.terminoDeDragear();
            }
        });
    }

    public interface Listener {
        void recibirImagenArrastrada(ImageView vistaImagen);
        void terminoDeDragear();
    }

}
