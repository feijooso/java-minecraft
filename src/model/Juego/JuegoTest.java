package model.Juego;

import model.mapa.*;
import model.jugador.*;
import model.materiales.*;

public class JuegoTest extends JuegoBase {

    public JuegoTest() {
        super();
        mapa = new Mapa(4);
        jugador = new Jugador(new Posicion(2,2));
        inicializarMapa();
    }

    @Override
    void inicializarMapa() {
        Posicion posicion_madera = new Posicion(1, 1);
        Posicion posicion_piedra = new Posicion(1, 3);
        Posicion posicion_metal = new Posicion(3, 3);
        Posicion posicion_diamante = new Posicion(3, 1);

        mapa.guardar(new Madera(), posicion_madera);
        mapa.guardar(new Piedra(), posicion_piedra);
        mapa.guardar(new Metal(), posicion_metal);
        mapa.guardar(new Diamante(), posicion_diamante);
    }
}

