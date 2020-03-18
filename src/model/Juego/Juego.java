package model.Juego;

import model.jugador.Jugador;
import model.mapa.Mapa;
import model.mapa.Posicion;
import model.materiales.Diamante;
import model.materiales.Madera;
import model.materiales.Metal;
import model.materiales.Piedra;

public class Juego extends JuegoBase {

    public Juego() {
        super();
        mapa = new Mapa(9);
        jugador = new Jugador(new Posicion(4, 5));
        inicializarMapa();
    }

    @Override
    void inicializarMapa() {
        mapa.guardar(new Diamante(), new Posicion(1, 1));
        mapa.guardar(new Diamante(), new Posicion(1, 8));
        mapa.guardar(new Diamante(), new Posicion(8, 1));
        mapa.guardar(new Diamante(), new Posicion(8, 8));

        mapa.guardar(new Metal(), new Posicion(1, 2));
        mapa.guardar(new Metal(), new Posicion(1, 3));
        mapa.guardar(new Metal(), new Posicion(5, 8));
        mapa.guardar(new Metal(), new Posicion(6, 4));
        mapa.guardar(new Metal(), new Posicion(7, 1));
        mapa.guardar(new Metal(), new Posicion(7, 2));
        mapa.guardar(new Metal(), new Posicion(7, 4));
        mapa.guardar(new Metal(), new Posicion(8, 2));
        mapa.guardar(new Metal(), new Posicion(8, 4));

        mapa.guardar(new Piedra(), new Posicion(2, 2));
        mapa.guardar(new Piedra(), new Posicion(2, 5));
        mapa.guardar(new Piedra(), new Posicion(4, 3));
        mapa.guardar(new Piedra(), new Posicion(4, 4));
        mapa.guardar(new Piedra(), new Posicion(4, 8));
        mapa.guardar(new Piedra(), new Posicion(5, 5));
        mapa.guardar(new Piedra(), new Posicion(6, 6));
        mapa.guardar(new Piedra(), new Posicion(7, 8));
        mapa.guardar(new Piedra(), new Posicion(8, 7));

        mapa.guardar(new Madera(), new Posicion(2, 1));
        mapa.guardar(new Madera(), new Posicion(2, 7));
        mapa.guardar(new Madera(), new Posicion(2, 8));
        mapa.guardar(new Madera(), new Posicion(3, 1));
        mapa.guardar(new Madera(), new Posicion(3, 8));
        mapa.guardar(new Madera(), new Posicion(4, 7));
        mapa.guardar(new Madera(), new Posicion(5, 2));
        mapa.guardar(new Madera(), new Posicion(5, 4));
        mapa.guardar(new Madera(), new Posicion(6, 5));
        mapa.guardar(new Madera(), new Posicion(7, 3));
        mapa.guardar(new Madera(), new Posicion(7, 5));
        mapa.guardar(new Madera(), new Posicion(8, 3));
        mapa.guardar(new Madera(), new Posicion(8, 5));


    }


}
