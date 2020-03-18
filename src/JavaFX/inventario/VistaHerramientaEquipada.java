package JavaFX.inventario;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.herramientas.Herramienta;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VistaHerramientaEquipada extends VBox {

    private ImageView vistaHerramienta;

    public VistaHerramientaEquipada(Herramienta herramienta) throws Exception{
        Image imagenHerramienta = new Image(new FileInputStream(herramienta.getImage()));
        vistaHerramienta = new ImageView(imagenHerramienta);
        vistaHerramienta.setFitHeight(150);
        vistaHerramienta.setFitWidth(150);
        Text texto = new Text("Herramienta equipada");
        getChildren().add(vistaHerramienta);
        getChildren().add(texto);
    }

    public void actualizar(Herramienta herramienta) {
        try {
            Image imagenHerramienta = new Image(new FileInputStream(herramienta.getImage()));
            vistaHerramienta.setImage(imagenHerramienta);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
