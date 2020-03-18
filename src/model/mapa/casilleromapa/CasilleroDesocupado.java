package model.mapa.casilleromapa;

import JavaFX.AlgoCraft;
import javafx.scene.image.Image;
import model.mapa.Posicion;
import model.materiales.Material;
import model.jugador.Jugador;

import java.io.FileInputStream;


public class CasilleroDesocupado extends EstadoCasillero {

    @Override
    public Material guardar(Material a_guardar){
        return a_guardar;
    }

    @Override
    public void mover(Jugador jugador, Posicion posicion) {
        jugador.cambiarPosicion(posicion);
    }

    @Override
    public boolean estaOcupado(){
        return false;
    }

    @Override
    public Image imagen(Material material) throws Exception {
        return new Image(new FileInputStream(AlgoCraft.IMAGE_PATH + "casilleroDesocupado.png"));
    }
}
