package JavaFX.VistaMapa;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.mapa.Mapa;
import model.mapa.Posicion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VistaMapa extends VBox {

    public static final int TAMAÑO_CASILLERO = 80;

    private Map<String, VistaCasilleroMapa> casilleros;
    private Mapa mapa;
    private int tamanio;

    public VistaMapa(Mapa mapa) throws Exception{

        this.mapa = mapa;
        casilleros = new HashMap<>();
        tamanio = (mapa.dimension()-1)* TAMAÑO_CASILLERO;

        for (int i = 1; i < mapa.dimension(); i++){

            HBox horizontalLayout = generateHbox();
            getChildren().add(horizontalLayout);

            for(int j = 1; j < mapa.dimension(); j++){

                Posicion posicion = new Posicion(i, j);
                VistaCasilleroMapa vistaCasilleroMapa = new VistaCasilleroMapa(mapa.casilleroEn(posicion), TAMAÑO_CASILLERO);
                casilleros.put(posicion.toString(), vistaCasilleroMapa);
                horizontalLayout.getChildren().add(vistaCasilleroMapa);
            }

        }
    }

    public void actualizar(Posicion posicion) throws Exception{
        VistaCasilleroMapa a_actualizar = casilleros.get(posicion.toString());
        a_actualizar.setImage(mapa.imagen(posicion));
    }

    public int obtenerTamaño() {
        return tamanio;
    }

    private HBox generateHbox() {
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(0, 0, 0, 0));
        hBox.setSpacing(0);
        return hBox;
    }

}
