package jugador;

import model.Juego.JuegoTest;
import model.herramientas.Hacha;
import model.herramientas.Pico;
import model.herramientas.PicoFino;
import model.jugador.Jugador;
import model.materiales.Madera;
import model.materiales.Material;
import model.materiales.Metal;
import model.materiales.Piedra;
import org.junit.Assert;
import org.junit.Test;

public class PruebasJugadorAtacaCasillero {

    private static final double RANGO_BASE = 0.1;

    @Test
    public void test01JugadorAtacaACasilleroSinMaterialYNoPierdeDurabilidadSuHachaDeMadera() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();

        juego.jugadorGolpear();
        Assert.assertEquals(jugador.obtenerHerramientaEquipada().durabilidad(), new Hacha(new Madera()).durabilidad(), RANGO_BASE);
    }

    @Test
    public void test02JugadorAtacaCasilleroFueraDelMapaYNoPierdeDurabilidad() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        juego.moverJugadorHaciaElNorte();
        juego.moverJugadorHaciaElNorte();

        juego.jugadorGolpear();

        Assert.assertEquals(jugador.obtenerHerramientaEquipada().durabilidad(), new Hacha(new Madera()).durabilidad(), RANGO_BASE);
    }

    @Test
    public void test03JugadorAtacaMaderaDentroDeCasilleroConHachaDeMadera() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        float durabilidadHerramientaEquipada = jugador.obtenerHerramientaEquipada().durabilidad();

        juego.moverJugadorHaciaElNorte();
        juego.moverJugadorHaciaElOeste();

        Material materialGolpeado = juego.obtenerMapa().contenidoDe(jugador.obtenerPosicionAtaque());
        int durabilidadMaterialGolpeado = materialGolpeado.durabilidad();

        juego.jugadorGolpear();

        Assert.assertEquals(jugador.obtenerHerramientaEquipada().durabilidad(), durabilidadHerramientaEquipada - new Hacha(new Madera()).fuerza(), RANGO_BASE);
        Assert.assertEquals(materialGolpeado.durabilidad(), durabilidadMaterialGolpeado - jugador.obtenerHerramientaEquipada().fuerza());
    }

    @Test
    public void test04JugadorAtacaPiedraDentroDeCasilleroConHachaMadera() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        float durabilidadHerramientaEquipada = jugador.obtenerHerramientaEquipada().durabilidad();

        juego.moverJugadorHaciaElSur();
        juego.moverJugadorHaciaElOeste();

        Material materialGolpeado = juego.obtenerMapa().contenidoDe(jugador.obtenerPosicionAtaque());
        int durabilidadMaterialGolpeado = materialGolpeado.durabilidad();

        juego.jugadorGolpear();

        Assert.assertEquals(jugador.obtenerHerramientaEquipada().durabilidad(), durabilidadHerramientaEquipada - new Hacha(new Madera()).fuerza(), RANGO_BASE);
        Assert.assertEquals(materialGolpeado.durabilidad(), durabilidadMaterialGolpeado);
    }

    @Test
    public void test05JugadorAtacaPiedraDentroDeCasilleroConPicoDeMadera() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        jugador.cambiarHerramientaEquipada(new Pico(new Madera()));
        float durabilidadHerramientaEquipada = jugador.obtenerHerramientaEquipada().durabilidad();

        juego.moverJugadorHaciaElNorte();
        juego.moverJugadorHaciaElEste();

        Material materialGolpeado = juego.obtenerMapa().contenidoDe(jugador.obtenerPosicionAtaque());
        int durabilidadMaterialGolpeado = materialGolpeado.durabilidad();

        juego.jugadorGolpear();

        Assert.assertEquals(jugador.obtenerHerramientaEquipada().durabilidad(), durabilidadHerramientaEquipada - new Pico(new Madera()).fuerza(), RANGO_BASE);
        Assert.assertEquals(materialGolpeado.durabilidad(), durabilidadMaterialGolpeado - jugador.obtenerHerramientaEquipada().fuerza());
    }

    @Test
    public void test06JugadorAtacaMetalDentroDeCasilleroConPicoDeMadera() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        jugador.cambiarHerramientaEquipada(new Pico(new Madera()));
        float durabilidadHerramientaEquipada = jugador.obtenerHerramientaEquipada().durabilidad();

        juego.moverJugadorHaciaElSur();
        juego.moverJugadorHaciaElEste();

        Material materialGolpeado = juego.obtenerMapa().contenidoDe(jugador.obtenerPosicionAtaque());
        int durabilidadMaterialGolpeado = materialGolpeado.durabilidad();

        juego.jugadorGolpear();

        Assert.assertEquals(jugador.obtenerHerramientaEquipada().durabilidad(), durabilidadHerramientaEquipada - new Pico(new Madera()).fuerza(), RANGO_BASE);
        Assert.assertEquals(materialGolpeado.durabilidad(), durabilidadMaterialGolpeado);
    }

    @Test
    public void test07JugadorAtacaMetalDentroDeCasilleroConPicoDePiedra() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        jugador.cambiarHerramientaEquipada(new Pico(new Piedra()));
        float durabilidadHerramientaEquipada = jugador.obtenerHerramientaEquipada().durabilidad();

        juego.moverJugadorHaciaElSur();
        juego.moverJugadorHaciaElEste();

        Material materialGolpeado = juego.obtenerMapa().contenidoDe(jugador.obtenerPosicionAtaque());
        int durabilidadMaterialGolpeado = materialGolpeado.durabilidad();

        juego.jugadorGolpear();

        Assert.assertEquals(jugador.obtenerHerramientaEquipada().durabilidad(), durabilidadHerramientaEquipada - new Pico(new Piedra()).fuerza() / 1.5f, RANGO_BASE);
        Assert.assertEquals(materialGolpeado.durabilidad(), durabilidadMaterialGolpeado - new Pico(new Piedra()).fuerza());
    }

    @Test
    public void test08JugadorAtacaDiamanteDentroDeCasilleroConPicoDeMetal() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        jugador.cambiarHerramientaEquipada(new Pico(new Metal()));

        juego.moverJugadorHaciaElSur();
        juego.moverJugadorHaciaElOeste();

        Material materialGolpeado = juego.obtenerMapa().contenidoDe(jugador.obtenerPosicionAtaque());
        int durabilidadMaterialGolpeado = materialGolpeado.durabilidad();

        juego.jugadorGolpear();

        Assert.assertEquals(jugador.obtenerHerramientaEquipada().durabilidad(), new Pico(new Metal()).durabilidad(), RANGO_BASE);
        Assert.assertEquals(materialGolpeado.durabilidad(), durabilidadMaterialGolpeado);
    }

    @Test
    public void test09JugadorAtacaDiamanteDentroDeCasilleroConPicoFino() {
        JuegoTest juego = new JuegoTest();
        Jugador jugador = juego.obtenerJugador();
        jugador.cambiarHerramientaEquipada(new PicoFino());
        float durabilidadHerramientaEquipada = jugador.obtenerHerramientaEquipada().durabilidad();

        juego.moverJugadorHaciaElSur();
        juego.moverJugadorHaciaElOeste();

        Material materialGolpeado = juego.obtenerMapa().contenidoDe(jugador.obtenerPosicionAtaque());
        int durabilidadMaterialGolpeado = materialGolpeado.durabilidad();

        juego.jugadorGolpear();

        Assert.assertEquals(jugador.obtenerHerramientaEquipada().durabilidad(), durabilidadHerramientaEquipada - new PicoFino().durabilidad() * 0.1f, RANGO_BASE);
        Assert.assertEquals(materialGolpeado.durabilidad(), durabilidadMaterialGolpeado - new PicoFino().fuerza());
    }
}
