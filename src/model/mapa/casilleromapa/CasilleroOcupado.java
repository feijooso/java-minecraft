package model.mapa.casilleromapa;

import Excepciones.NoSePuedeOcuparCasilleroException;
import javafx.scene.image.Image;
import model.mapa.Posicion;
import model.materiales.Material;
import model.jugador.Jugador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CasilleroOcupado extends EstadoCasillero{

    @Override
    public Material guardar(Material a_guardar){
        throw new NoSePuedeOcuparCasilleroException();

    }

    @Override
    public void mover(Jugador jugador, Posicion posicion) {
        jugador.cambiarPosicionAtaque(posicion);
        throw new NoSePuedeOcuparCasilleroException();
    }

    @Override
    public boolean estaOcupado(){
        return true;
    }

    @Override
    public Image imagen(Material material) throws Exception {
        return new Image(new FileInputStream(material.imagen()));
    }
}
