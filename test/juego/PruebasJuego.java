package juego;

import model.Juego.JuegoTest;
import model.jugador.Jugador;
import model.mapa.Mapa;
import model.mapa.Posicion;
import model.materiales.*;
import org.junit.Assert;
import org.junit.Test;

public class PruebasJuego {

    @Test
    public void test01JugadorComienzaEnColumnaDos(){

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicion = jugador.obtenerPosicionActual();

        Assert.assertEquals(2, posicion.getDireccionColumna());
    }

    @Test
    public void test02JugadorComienzaEnFilaDos() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicion = jugador.obtenerPosicionActual();

        Assert.assertEquals(2, posicion.getDireccionFila());
    }

    @Test
    public void test03MaderaComienzaEnFilaUnoColumnaUno() {

        JuegoTest juego = new JuegoTest();
        Mapa mapa = juego.obtenerMapa();
        Posicion posicion = new Posicion(1,1);
        Material material = mapa.contenidoDe(posicion);

        Assert.assertSame(Madera.class, material.getClass());
    }

    @Test
    public void test04PiedraComienzaEnFilaUnoColumnaTres() {

        JuegoTest juego = new JuegoTest();
        Mapa mapa = juego.obtenerMapa();
        Posicion posicion = new Posicion(1,3);
        Material material = mapa.contenidoDe(posicion);

        Assert.assertSame(Piedra.class, material.getClass());
    }

    @Test
    public void test05MetalComienzaEnFilaTresColumnaTres() {

        JuegoTest juego = new JuegoTest();
        Mapa mapa = juego.obtenerMapa();
        Posicion posicion = new Posicion(3,3);
        Material material = mapa.contenidoDe(posicion);

        Assert.assertSame(Metal.class, material.getClass());
    }

    @Test
    public void test06DiamanteComienzaEnFilaTresColumnaUno() {

        JuegoTest juego = new JuegoTest();
        Mapa mapa = juego.obtenerMapa();
        Posicion posicion = new Posicion(3,1);
        Material material = mapa.contenidoDe(posicion);

        Assert.assertSame(Diamante.class, material.getClass());
    }

    @Test
    public void test07JugadorPuedeMoverseHaciaElNorte() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicionNorte = new Posicion(1,2);

        juego.moverJugadorHaciaElNorte();
        Posicion posicionActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicionNorte.toString(), posicionActual.toString());
    }

    @Test
    public void test08JugadorPuedeMoverseHaciaElSur() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicionSur = new Posicion(3,2);

        juego.moverJugadorHaciaElSur();
        Posicion posicionActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicionSur.toString(), posicionActual.toString());
    }

    @Test
    public void test09JugadorPuedeMoverseHaciaElEste() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicionEste = new Posicion(2,3);

        juego.moverJugadorHaciaElEste();
        Posicion posicionActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicionEste.toString(), posicionActual.toString());
    }

    @Test
    public void test10JugadorPuedeMoverseHaciaElOeste() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicionOeste = new Posicion(2,1);

        juego.moverJugadorHaciaElOeste();
        Posicion posicionActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicionOeste.toString(), posicionActual.toString());
    }

    @Test
    public void test11JugadorNoPuedeMoverseAlNorteLuegoDeIrAlOestePuesHayMaderaYSeQuedaAhi() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();

        juego.moverJugadorHaciaElOeste();
        Posicion posicionOeste = jugador.obtenerPosicionActual();
        juego.moverJugadorHaciaElNorte();
        Posicion posicionActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicionOeste.toString(), posicionActual.toString());
    }

    @Test
    public void test12JugadorNoPuedeMoverseAlNorteLuegoDeIrAlEstePuesHayPiedraYSeQuedaAhi() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();

        juego.moverJugadorHaciaElEste();
        Posicion posicionEste = jugador.obtenerPosicionActual();
        juego.moverJugadorHaciaElNorte();
        Posicion posicionActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicionEste.toString(), posicionActual.toString());
    }

    @Test
    public void test13JugadorNoPuedeMoverseAlSurLuegoDeIrAlOestePuesHayDiamanteYSeQuedaAhi() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();

        juego.moverJugadorHaciaElOeste();
        Posicion posicionOeste = jugador.obtenerPosicionActual();
        juego.moverJugadorHaciaElSur();
        Posicion posicionActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicionOeste.toString(), posicionActual.toString());
    }

    @Test
    public void test14JugadorNoPuedeMoverseAlSurLuegoDeIrAlEstePuesHayMetalYSeQuedaAhi() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();

        juego.moverJugadorHaciaElEste();
        Posicion posicionEste = jugador.obtenerPosicionActual();
        juego.moverJugadorHaciaElSur();
        Posicion posicionActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicionEste.toString(), posicionActual.toString());
    }

    @Test
    public void test15JugadorNoPuedeMoverseAlEsteLuegoDeIrAlNortePuesHayPiedraYSeQuedaAhi() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();

        juego.moverJugadorHaciaElNorte();
        Posicion posicionNorte = jugador.obtenerPosicionActual();
        juego.moverJugadorHaciaElEste();
        Posicion posicionActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicionNorte.toString(), posicionActual.toString());
    }

    @Test
    public void test16JugadorNoPuedeMoverseAlOesteLuegoDeIrAlNortePuesHayMaderaYSeQuedaAhi() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();

        juego.moverJugadorHaciaElNorte();
        Posicion posicionNorte = jugador.obtenerPosicionActual();
        juego.moverJugadorHaciaElOeste();
        Posicion posicionActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicionNorte.toString(), posicionActual.toString());
    }

    @Test
    public void test17JugadorNoPuedeMoverseAlEsteLuegoDeIrAlSurPuesHayMetalYSeQuedaAhi() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();

        juego.moverJugadorHaciaElSur();
        Posicion posicionSur = jugador.obtenerPosicionActual();
        juego.moverJugadorHaciaElEste();
        Posicion posicionActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicionSur.toString(), posicionActual.toString());
    }

    @Test
    public void test18JugadorNoPuedeMoverseAlOesteLuegoDeIrAlSurPuesHayDiamanteYSeQuedaAhi() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();

        juego.moverJugadorHaciaElSur();
        Posicion posicionSur = jugador.obtenerPosicionActual();
        juego.moverJugadorHaciaElOeste();
        Posicion posicionActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicionSur.toString(), posicionActual.toString());
    }

    @Test
    public void test19JugadorVuelveASuPosicionInicialAlMoverseAlEsteYLuegoAlOeste() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicionInicial = jugador.obtenerPosicionActual();

        juego.moverJugadorHaciaElEste();
        juego.moverJugadorHaciaElOeste();
        Posicion posicionActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicionInicial.toString(), posicionActual.toString());
    }

    @Test
    public void test20JugadorVuelveASuPosicionInicialAlMoverseAlOesteYLuegoAlEste() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicionInicial = jugador.obtenerPosicionActual();

        juego.moverJugadorHaciaElOeste();
        juego.moverJugadorHaciaElEste();
        Posicion posicionActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicionInicial.toString(), posicionActual.toString());
    }

    @Test
    public void test21JugadorVuelveASuPosicionInicialAlMoverseAlNorteYLuegoAlSur() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicionInicial = jugador.obtenerPosicionActual();

        juego.moverJugadorHaciaElNorte();
        juego.moverJugadorHaciaElSur();
        Posicion posicionActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicionInicial.toString(), posicionActual.toString());
    }

    @Test
    public void test22JugadorVuelveASuPosicionInicialAlMoverseAlSurYLuegoAlNorte() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        Posicion posicionInicial = jugador.obtenerPosicionActual();

        juego.moverJugadorHaciaElSur();
        juego.moverJugadorHaciaElNorte();
        Posicion posicionActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicionInicial.toString(), posicionActual.toString());
    }

    @Test
    public void test23JugadorNoPuedeSalirseDelMapaPorElSur() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();

        juego.moverJugadorHaciaElSur();
        Posicion posicionSur = jugador.obtenerPosicionActual();
        juego.moverJugadorHaciaElSur();
        Posicion posicionActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicionSur.toString(), posicionActual.toString());
    }

    @Test
    public void test24JugadorNoPuedeSalirseDelMapaPorElNorte() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();

        juego.moverJugadorHaciaElNorte();
        Posicion posicionNorte = jugador.obtenerPosicionActual();
        juego.moverJugadorHaciaElNorte();
        Posicion posicionActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicionNorte.toString(), posicionActual.toString());
    }

    @Test
    public void test25JugadorNoPuedeSalirseDelMapaPorElEste() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();

        juego.moverJugadorHaciaElEste();
        Posicion posicionEste = jugador.obtenerPosicionActual();
        juego.moverJugadorHaciaElEste();
        Posicion posicionActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicionEste.toString(), posicionActual.toString());
    }

    @Test
    public void test26JugadorNoPuedeSalirseDelMapaPorElOeste() {

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();

        juego.moverJugadorHaciaElOeste();
        Posicion posicionOeste = jugador.obtenerPosicionActual();
        juego.moverJugadorHaciaElOeste();
        Posicion posicionActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicionOeste.toString(), posicionActual.toString());
    }

    @Test
    public void test27MoverJugadorAlNorteCambiaPosicionDeAtaque(){

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();

        Posicion posicion = jugador.obtenerPosicionActual();

        juego.moverJugadorHaciaElNorte();

        Assert.assertEquals(posicion.getDireccionFila()-2,jugador.obtenerPosicionAtaque().getDireccionFila());


    }

    @Test
    public void test28MoverJugadorAlOesteCambiaPosicionDeAtaque(){

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();

        Posicion posicion = jugador.obtenerPosicionActual();

        juego.moverJugadorHaciaElOeste();

        Assert.assertEquals(posicion.getDireccionColumna()-2,jugador.obtenerPosicionAtaque().getDireccionColumna());


    }

    @Test
    public void test29MoverJugadorAlSurCambiaPosicionDeAtaque(){

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();

        Posicion posicion = jugador.obtenerPosicionActual();

        juego.moverJugadorHaciaElSur();

        Assert.assertEquals(posicion.getDireccionFila()+2,jugador.obtenerPosicionAtaque().getDireccionFila());


    }

    @Test
    public void test30MoverJugadorAlEsteCambiaPosicionDeAtaque(){

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();

        Posicion posicion = jugador.obtenerPosicionActual();

        juego.moverJugadorHaciaElEste();

        Assert.assertEquals(posicion.getDireccionColumna()+2,jugador.obtenerPosicionAtaque().getDireccionColumna());


    }

    @Test
    public void test31JugadorNoSePuedeMoverYPosicionAtaqueNoCambia(){

        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();

        juego.moverJugadorHaciaElNorte();
        Posicion posAtaque = jugador.obtenerPosicionAtaque();
        juego.moverJugadorHaciaElNorte();

        Assert.assertTrue(posAtaque.equals(jugador.obtenerPosicionAtaque()));

    }
}
