package model.mapa.casilleromapa;

import javafx.scene.image.Image;
import model.mapa.Posicion;
import model.materiales.Material;
import model.jugador.Jugador;

public class CasilleroMapa {

    private EstadoCasillero estado;
    private Material contenido;

    public CasilleroMapa(){
        estado = new CasilleroDesocupado();
    }

    public void guardar(Material a_guardar){
        contenido = estado.guardar(a_guardar);
        estado = new CasilleroOcupado();
    }

    public Image imagen() throws Exception{
        return estado.imagen(contenido);
    }

    public void mover(Jugador jugador, Posicion posicion){

        estado.mover(jugador, posicion);
    }

    public Material contenido() {
        return contenido;
    }

    public boolean estaOcupado() {
        return estado.estaOcupado();
    }

    public void desocuparse() {
        contenido = null;
        estado = new CasilleroDesocupado();
    }
}
