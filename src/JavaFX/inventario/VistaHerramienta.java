package JavaFX.inventario;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.herramientas.Herramienta;

import java.io.FileInputStream;

public class VistaHerramienta extends VBox {

    protected Herramienta herramienta;
    protected Text textoCantidad;

    public VistaHerramienta(Herramienta herramienta, LayoutHerramientas.HerramientaSeleccionada seleccionada) throws Exception {
        this.herramienta = herramienta;

        Image imagenHerramienta = new Image(new FileInputStream(herramienta.getImage()));
        ImageView vistaHerramienta = new ImageView(imagenHerramienta);
        vistaHerramienta.setFitHeight(80);
        vistaHerramienta.setFitWidth(80);

        vistaHerramienta.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    seleccionada.seleccionar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        getChildren().add(vistaHerramienta);

        textoCantidad = new Text();
        getChildren().add(textoCantidad);
    }

    public Herramienta obtenerHerramienta() {
        return herramienta;
    }

    public void agregarseEnLayout(LayoutHerramientas layoutHerramientas, int cantidadHerramientas) {
        if (cantidadHerramientas == 0) {
            layoutHerramientas.getChildren().remove(this);
            return;
        }

        textoCantidad.setText("cant: " + cantidadHerramientas);
        layoutHerramientas.getChildren().add(this);
    }

    public interface Listener {
        void onClick(VistaHerramienta vistaHerramienta);
    }
}
