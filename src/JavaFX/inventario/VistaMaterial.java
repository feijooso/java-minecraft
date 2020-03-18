package JavaFX.inventario;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.materiales.Material;

import java.io.FileInputStream;

public class VistaMaterial extends VBox {

    public VistaMaterial(Material material, int cantidadMaterial) throws Exception{
        Image imagenMaterial = new Image(new FileInputStream(material.getImage()));
        ImageView vistaMaterial = new ImageView(imagenMaterial);
        Text textoCantidad = new Text("cant: " + cantidadMaterial);
        getChildren().add(vistaMaterial);
        getChildren().add(textoCantidad);

    }
}
