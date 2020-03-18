package jugador;

import model.Juego.JuegoTest;
import model.herramientas.Pico;
import model.herramientas.PicoFino;
import model.jugador.Jugador;
import model.jugador.inventario.Inventario;
import model.materiales.Madera;
import model.materiales.Piedra;
import org.junit.Assert;
import org.junit.Test;

public class PruebasJugadorRompeMaterialYSeAgregaAlInventario {

    @Test
    public void test01JugadorAtacaMaderaYSeAgregaASuInventario() {
        JuegoTest juego = new JuegoTest();
        Inventario inventario = juego.obtenerJugador().obtenerInventario();

        juego.moverJugadorHaciaElOeste();
        juego.moverJugadorHaciaElNorte();

        for (int i=0; i<5; i++) {
            juego.jugadorGolpear();
        }

        Assert.assertEquals(inventario.cantidadDeMadera(), 1);
        Assert.assertEquals(inventario.cantidadDeMateriales(), 1);
    }

    @Test
    public void test02JugadorAtacaPiedraYSeAgregaASuInventario() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Inventario inventario = jugador.obtenerInventario();

        jugador.cambiarHerramientaEquipada(new Pico(new Madera()));
        juego.moverJugadorHaciaElEste();
        juego.moverJugadorHaciaElNorte();

        for (int i=0; i<15; i++) {
            juego.jugadorGolpear();
        }

        Assert.assertEquals(inventario.cantidadDePiedra(), 1);
        Assert.assertEquals(inventario.cantidadDeMateriales(), 1);
    }

    @Test
    public void test03JugadorAtacaMetalYSeAgregaASuInventario() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Inventario inventario = jugador.obtenerInventario();

        jugador.cambiarHerramientaEquipada(new Pico(new Piedra()));
        juego.moverJugadorHaciaElEste();
        juego.moverJugadorHaciaElSur();

        for (int i=0; i<13; i++) {
            juego.jugadorGolpear();
        }

        Assert.assertEquals(inventario.cantidadDeMetal(), 1);
        Assert.assertEquals(inventario.cantidadDeMateriales(), 1);
    }

    @Test
    public void test04JugadorAtacaDiamanteYSeAgregaASuInventario() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Inventario inventario = jugador.obtenerInventario();

        jugador.cambiarHerramientaEquipada(new PicoFino());
        juego.moverJugadorHaciaElOeste();
        juego.moverJugadorHaciaElSur();

        for (int i=0; i<5; i++) {
            juego.jugadorGolpear();
        }

        Assert.assertEquals(inventario.cantidadDeDiamante(), 1);
        Assert.assertEquals(inventario.cantidadDeMateriales(), 1);
    }

    @Test
    public void test05JugadorRompeMaterialYSigueAtacandoPeroSuInventarioNoAumenta() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Inventario inventario = jugador.obtenerInventario();

        jugador.cambiarHerramientaEquipada(new PicoFino());
        juego.moverJugadorHaciaElOeste();
        juego.moverJugadorHaciaElNorte();

        for (int i=0; i<5; i++) {
            juego.jugadorGolpear();
        }

        Assert.assertEquals(inventario.cantidadDeMadera(), 1);
        Assert.assertEquals(inventario.cantidadDeMateriales(), 1);
    }

    @Test
    public void test06JugadorRompeMaterialYElCasilleroEsDesocupado() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();

        jugador.cambiarHerramientaEquipada(new PicoFino());
        juego.moverJugadorHaciaElOeste();
        juego.moverJugadorHaciaElNorte();

        for (int i=0; i<5; i++) {
            juego.jugadorGolpear();
        }

        Assert.assertFalse(juego.obtenerMapa().posicionEstaOcupada(jugador.obtenerPosicionAtaque()));
    }

}
