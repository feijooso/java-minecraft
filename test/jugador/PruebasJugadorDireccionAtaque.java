package jugador;

import model.Juego.JuegoTest;
import model.jugador.Jugador;
import model.mapa.Posicion;
import org.junit.Assert;
import org.junit.Test;

public class PruebasJugadorDireccionAtaque {

    @Test
    public void test01JugadorSeMueveAlNorteYSuPosicionDeAtaqueEsSuNorte() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicionAtaqueEsperada = new Posicion(0, 2);

        juego.moverJugadorHaciaElNorte();

        Assert.assertTrue(jugador.obtenerPosicionAtaque().equals(posicionAtaqueEsperada));
    }

    @Test
    public void test02JugadorSeMueveAlSurYSuPosicionDeAtaqueEsElSur() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicionAtaqueEsperada = new Posicion(4, 2);

        juego.moverJugadorHaciaElSur();

        Assert.assertTrue(jugador.obtenerPosicionAtaque().equals(posicionAtaqueEsperada));
    }

    @Test
    public void test03JugadorSeMueveAlEsteYSuPosicionDeAtaqueEsElEste() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicionAtaqueEsperada = new Posicion(2, 4);

        juego.moverJugadorHaciaElEste();

        Assert.assertTrue(jugador.obtenerPosicionAtaque().equals(posicionAtaqueEsperada));
    }

    @Test
    public void test04JugadorSeMueveAlOesteYSuPosicionDeAtaqueEsElOeste() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicionAtaqueEsperada = new Posicion(2, 0);

        juego.moverJugadorHaciaElOeste();

        Assert.assertTrue(jugador.obtenerPosicionAtaque().equals(posicionAtaqueEsperada));
    }

    @Test
    public void test05JugadorNoPuedeMoverseAlNortePeroSuPosicionDeAtaqueEsElNorte() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicionAtaqueEsperada = new Posicion(1, 1);

        juego.moverJugadorHaciaElOeste();
        juego.moverJugadorHaciaElNorte();

        Assert.assertTrue(jugador.obtenerPosicionAtaque().equals(posicionAtaqueEsperada));
    }

    @Test
    public void test06JugadorNoPuedeMoverseAlSurPeroSuPosicionDeAtaqueEsElSur() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicionAtaqueEsperada = new Posicion(3, 1);

        juego.moverJugadorHaciaElOeste();
        juego.moverJugadorHaciaElSur();

        Assert.assertTrue(jugador.obtenerPosicionAtaque().equals(posicionAtaqueEsperada));
    }

    @Test
    public void test07JugadorNoPuedeMoverseAlEstePeroSuPosicionDeAtaqueEsElEste() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicionAtaqueEsperada = new Posicion(1, 3);

        juego.moverJugadorHaciaElNorte();
        juego.moverJugadorHaciaElEste();

        Assert.assertTrue(jugador.obtenerPosicionAtaque().equals(posicionAtaqueEsperada));
    }

    @Test
    public void test08JugadorNoPuedeMoverseAlOestePeroSuPosicionDeAtaqueEsElOeste() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicionAtaqueEsperada = new Posicion(1, 1);

        juego.moverJugadorHaciaElNorte();
        juego.moverJugadorHaciaElOeste();

        Assert.assertTrue(jugador.obtenerPosicionAtaque().equals(posicionAtaqueEsperada));
    }

    @Test
    public void test09JugadorIntentaSalirseDelMapaPorElNorteYSuPosicionDeAtaqueNoCambia() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicionAtaqueEsperada = new Posicion(0, 2);

        juego.moverJugadorHaciaElNorte();
        juego.moverJugadorHaciaElNorte();
        juego.moverJugadorHaciaElNorte();
        juego.moverJugadorHaciaElNorte();

        Assert.assertTrue(jugador.obtenerPosicionAtaque().equals(posicionAtaqueEsperada));
    }

    @Test
    public void test10JugadorIntentaSalirseDelMapaPorElSurYSuPosicionDeAtaqueNoCambia() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicionAtaqueEsperada = new Posicion(4, 2);

        juego.moverJugadorHaciaElSur();
        juego.moverJugadorHaciaElSur();
        juego.moverJugadorHaciaElSur();
        juego.moverJugadorHaciaElSur();

        Assert.assertTrue(jugador.obtenerPosicionAtaque().equals(posicionAtaqueEsperada));
    }

    @Test
    public void test11JugadorIntentaSalirseDelMapaPorElEsteYSuPosicionDeAtaqueNoCambia() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicionAtaqueEsperada = new Posicion(2, 4);

        juego.moverJugadorHaciaElEste();
        juego.moverJugadorHaciaElEste();
        juego.moverJugadorHaciaElEste();
        juego.moverJugadorHaciaElEste();

        Assert.assertTrue(jugador.obtenerPosicionAtaque().equals(posicionAtaqueEsperada));
    }

    @Test
    public void test12JugadorIntentaSalirseDelMapaPorElOesteYSuPosicionDeAtaqueNoCambia() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicionAtaqueEsperada = new Posicion(2, 0);

        juego.moverJugadorHaciaElOeste();
        juego.moverJugadorHaciaElOeste();
        juego.moverJugadorHaciaElOeste();
        juego.moverJugadorHaciaElOeste();

        Assert.assertTrue(jugador.obtenerPosicionAtaque().equals(posicionAtaqueEsperada));
    }
}
