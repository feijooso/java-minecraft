package JavaFX.Construccion;

import javafx.scene.layout.GridPane;
import model.jugador.inventario.InventarioMateriales;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class VistaPanelConstruccion extends GridPane {

    private InventarioMateriales inventarioMateriales;
    private List<VistaCasilleroPanel> listaCasilleros;

    public VistaPanelConstruccion(VistaCasilleroPanel.Listener listener, InventarioMateriales inventarioMateriales) throws FileNotFoundException {
        int posicion = 0;
        this.inventarioMateriales = inventarioMateriales;
        listaCasilleros = new ArrayList<>();
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                VistaCasilleroPanel casilleroPanel = new VistaCasilleroPanel(listener, posicion, inventarioMateriales);
                listaCasilleros.add(casilleroPanel);
                this.add(casilleroPanel, j, i);
                posicion++;
            }
        }
    }

    public void limpiar() {
        for (VistaCasilleroPanel panel : listaCasilleros) {
            panel.limpiar();
        }
    }

    public void recomponer() {
        for (VistaCasilleroPanel casillero : listaCasilleros) {
            inventarioMateriales.agregar(casillero.obtenerMaterialActual());
        }
    }

}
