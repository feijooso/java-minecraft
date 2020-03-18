package model.mapa;

import Excepciones.FueraDeMapaException;
import javafx.scene.image.Image;
import model.jugador.Jugador;
import model.mapa.casilleromapa.CasilleroMapa;
import model.materiales.Material;

import java.util.HashMap;

public class Mapa {

    private HashMap<String, CasilleroMapa> tabla;
    private int dimension;

    public Mapa(int dimension) {

        this.dimension = dimension;
        tabla = new HashMap<>();

        for (int i = 1; i < dimension; i++){
            for(int j = 1; j < dimension; j++){
                 String clave = i+"+"+j;
                 tabla.put(clave, new CasilleroMapa());
            }
        }
    }

    public void guardar (Material a_guardar, Posicion posicion){
        CasilleroMapa casilleroMapa = tabla.get(posicion.toString());
        casilleroMapa.guardar(a_guardar);

    }
    public void mover (Jugador jugador, Posicion posicion){

            CasilleroMapa casilleroMapa = tabla.get(posicion.toString());
            if(casilleroMapa == null) {
                jugador.cambiarPosicionAtaque(posicion);
                throw new FueraDeMapaException();
            }
            casilleroMapa.mover(jugador, posicion);
    }

    public boolean posicionEstaOcupada (Posicion posicion){
            CasilleroMapa casilleroMapa = tabla.get(posicion.toString());
            return casilleroMapa.estaOcupado();
    }

    public Material contenidoDe (Posicion posicion){
            CasilleroMapa casilleroMapa = tabla.get(posicion.toString());
            return casilleroMapa.contenido();
    }

    public Image imagen(Posicion posicion) throws Exception{
        CasilleroMapa casilleroMapa = tabla.get(posicion.toString());
        return casilleroMapa.imagen();
    }

    public CasilleroMapa casilleroEn (Posicion posicion){
        return tabla.get(posicion.toString());
    }

    public int dimension(){
        return dimension;
    }

    public void desocuparCasillero(Posicion posicion) {
        CasilleroMapa casilleroMapa = tabla.get(posicion.toString());
        casilleroMapa.desocuparse();
    }
}
