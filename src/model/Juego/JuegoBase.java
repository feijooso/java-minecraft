package model.Juego;

import Excepciones.FueraDeMapaException;
import Excepciones.MaterialDestruidoException;
import Excepciones.NoSePuedeOcuparCasilleroException;
import model.jugador.Jugador;
import model.mapa.Mapa;
import model.mapa.Posicion;
import model.materiales.Material;

public abstract class JuegoBase {

    protected Mapa mapa;
    protected Jugador jugador;
    protected String nombreUsuario;

    public JuegoBase(){

    }

    private void moverJugadorHacia(Posicion posicion) {
        try {
            mapa.mover(jugador, posicion);

        } catch(NoSePuedeOcuparCasilleroException e) {
            System.out.println("Casillero ocupado");
        } catch(FueraDeMapaException e) {
            System.out.println("Casillero fuera del Mapa");
        }
    }

    public void moverJugadorHaciaElNorte() {
        moverJugadorHacia(jugador.obtenerPosicionAlNorte());
    }

    public void moverJugadorHaciaElSur() {
        moverJugadorHacia(jugador.obtenerPosicionAlSur());
    }

    public void moverJugadorHaciaElEste() {
        moverJugadorHacia(jugador.obtenerPosicionAlEste());
    }

    public void moverJugadorHaciaElOeste() {
        moverJugadorHacia(jugador.obtenerPosicionAlOeste());
    }

    public Jugador obtenerJugador(){
        return jugador;
    }

    public Mapa obtenerMapa() {
        return mapa;
    }

    public Posicion jugadorGolpear() {
        try {
            Material materialAtacado = mapa.contenidoDe(jugador.obtenerPosicionAtaque());
            jugador.golpear(materialAtacado);
        } catch (MaterialDestruidoException e) {
            jugador.agregarAlInventario(e.obtenerMaterialDestruido());
            mapa.desocuparCasillero(jugador.obtenerPosicionAtaque());
        }
        return jugador.obtenerPosicionAtaque();
    }

    public void setearNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String obtenerNombreUsuario() {
        return nombreUsuario;
    }

    abstract void inicializarMapa();
}
