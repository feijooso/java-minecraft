package JavaFX.VistaMapa;

import javafx.scene.image.ImageView;
import model.mapa.casilleromapa.CasilleroMapa;

public class VistaCasilleroMapa extends ImageView {


    public VistaCasilleroMapa(CasilleroMapa casilleroMapa, int dimension) throws Exception{
        super(casilleroMapa.imagen());
        setFitWidth(dimension);
        setFitHeight(dimension);
    }

}