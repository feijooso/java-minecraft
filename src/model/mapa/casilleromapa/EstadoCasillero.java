package model.mapa.casilleromapa;

import javafx.scene.image.Image;
import model.mapa.Posicion;
import model.materiales.Material;
import model.jugador.Jugador;


public abstract class EstadoCasillero {

    public abstract Material guardar(Material a_guardar);

    public abstract void mover(Jugador jugador, Posicion posicion);

    public abstract boolean estaOcupado();

    public abstract Image imagen(Material material) throws Exception;
}
