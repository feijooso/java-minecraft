package JavaFX.inventario;

import javafx.scene.layout.HBox;
import model.jugador.inventario.InventarioMateriales;
import model.materiales.Diamante;
import model.materiales.Madera;
import model.materiales.Metal;
import model.materiales.Piedra;

public class LayoutMateriales extends HBox {

    public LayoutMateriales(InventarioMateriales inventarioMateriales) throws Exception{

        VistaMaterial vistaMadera = new VistaMaterial(new Madera(), inventarioMateriales.cantidadDeMadera());
        getChildren().add(vistaMadera);

        VistaMaterial vistaMetal = new VistaMaterial(new Metal(), inventarioMateriales.cantidadDeMetal());
        getChildren().add(vistaMetal);

        VistaMaterial vistaPiedra = new VistaMaterial(new Piedra(), inventarioMateriales.cantidadDePiedra());
        getChildren().add(vistaPiedra);

        VistaMaterial vistaDiamante = new VistaMaterial(new Diamante(), inventarioMateriales.cantidadDeDiamante());
        getChildren().add(vistaDiamante);
    }
}
