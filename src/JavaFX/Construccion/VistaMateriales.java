package JavaFX.Construccion;

import javafx.scene.layout.HBox;
import java.io.FileNotFoundException;

public class VistaMateriales extends HBox  {

    public VistaMateriales(VistaMaterial.Listener listener) throws FileNotFoundException {
        this.getChildren().add(new VistaMaterial("Madera",1, listener));
        this.getChildren().add(new VistaMaterial("Piedra",1, listener));
        this.getChildren().add(new VistaMaterial("Metal",1, listener));
        this.getChildren().add(new VistaMaterial("Diamante",1, listener));
        this.setSpacing(5);
    }

}
