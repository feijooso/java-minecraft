package jugador;

import Excepciones.NoHayHerramientaEnInventarioException;
import model.herramientas.Hacha;
import model.herramientas.Pico;
import model.herramientas.PicoFino;
import model.jugador.inventario.Inventario;
import model.materiales.Madera;
import model.materiales.Metal;
import model.materiales.Piedra;
import org.junit.Assert;
import org.junit.Test;

public class PruebasInventarioHerramienta {

    @Test
    public void test01InventarioEstaVacioAlCrearse() {
        Inventario inventario = new Inventario();
        Assert.assertEquals(inventario.cantidadDeHerramientas(), 0);
    }

    @Test(expected = NoHayHerramientaEnInventarioException.class)
    public void test02NoSePuedeObtenerHachaMaderaDeInventarioVacio() {
        Inventario inventario = new Inventario();

        inventario.obtenerHachaMadera();
    }

    @Test(expected = NoHayHerramientaEnInventarioException.class)
    public void test03NoSePuedeObtenerHachaDePiedraDeInventarioVacio() {
        Inventario inventario = new Inventario();

        inventario.obtenerHachaPiedra();
    }

    @Test(expected = NoHayHerramientaEnInventarioException.class)
    public void test04NoSePuedeObtenerHachaDeMetalDeInventarioVacio() {
        Inventario inventario = new Inventario();

        inventario.obtenerHachaMetal();
    }

    @Test(expected = NoHayHerramientaEnInventarioException.class)
    public void test05NoSePuedeObtenerPicoDeMaderaDeInventarioVacio() {
        Inventario inventario = new Inventario();

        inventario.obtenerPicoMadera();
    }

    @Test(expected = NoHayHerramientaEnInventarioException.class)
    public void test06NoSePuedeObtenerPicoDePiedraDeInventarioVacio() {
        Inventario inventario = new Inventario();

        inventario.obtenerPicoPiedra();
    }

    @Test(expected = NoHayHerramientaEnInventarioException.class)
    public void test07NoSePuedeObtenerPicoDeMetalDeInventarioVacio() {
        Inventario inventario = new Inventario();

        inventario.obtenerPicoMetal();
    }

    @Test(expected = NoHayHerramientaEnInventarioException.class)
    public void test06NoSePuedeObtenerPicoFinoDeInventarioVacio() {
        Inventario inventario = new Inventario();

        inventario.obtenerPicoFino();
    }

    @Test
    public void test07AgregarHachaDeMadera() {
        Inventario inventario = new Inventario();
        Hacha hacha = new Hacha(new Madera());

        inventario.agregar(hacha);

        Assert.assertEquals(inventario.cantidadHachaMadera(), 1);
    }

    @Test
    public void test08AgregarHachaDePiedra() {
        Inventario inventario = new Inventario();
        Hacha hacha = new Hacha(new Piedra());

        inventario.agregar(hacha);

        Assert.assertEquals(inventario.cantidadHachaPiedra(), 1);
    }

    @Test
    public void test09AgregarHachaDeMetal() {
        Inventario inventario = new Inventario();
        Hacha hacha = new Hacha(new Metal());

        inventario.agregar(hacha);

        Assert.assertEquals(inventario.cantidadHachaMetal(), 1);
    }

    @Test
    public void test10AgregarPicoDeMadera() {
        Inventario inventario = new Inventario();
        Pico pico = new Pico(new Madera());

        inventario.agregar(pico);

        Assert.assertEquals(inventario.cantidadPicoMadera(), 1);
    }

    @Test
    public void test11AgregarPicoDePiedra() {
        Inventario inventario = new Inventario();
        Pico pico = new Pico(new Piedra());

        inventario.agregar(pico);

        Assert.assertEquals(inventario.cantidadPicoPiedra(), 1);
    }

    @Test
    public void test12AgregarPicoDeMetal() {
        Inventario inventario = new Inventario();
        Pico pico = new Pico(new Metal());

        inventario.agregar(pico);

        Assert.assertEquals(inventario.cantidadPicoMetal(), 1);
    }

    @Test
    public void test13AgregarPicoFino() {
        Inventario inventario = new Inventario();
        PicoFino picoFino = new PicoFino();

        inventario.agregarPicoFino(picoFino);

        Assert.assertEquals(inventario.cantidadPicoFino(), 1);
    }

    @Test
    public void test14ObtenerHachaMadera() {
        Inventario inventario = new Inventario();
        Hacha hacha = new Hacha(new Madera());

        inventario.agregar(hacha);

        Assert.assertNotNull(inventario.obtenerHachaMadera());
        Assert.assertEquals(inventario.cantidadHachaMadera(), 0);
    }

    @Test
    public void test15ObtenerHachaPiedra() {
        Inventario inventario = new Inventario();
        Hacha hacha = new Hacha(new Piedra());

        inventario.agregar(hacha);

        Assert.assertNotNull(inventario.obtenerHachaPiedra());
        Assert.assertEquals(inventario.cantidadHachaPiedra(), 0);
    }

    @Test
    public void test16ObtenerHachaMetal() {
        Inventario inventario = new Inventario();
        Hacha hacha = new Hacha(new Metal());

        inventario.agregar(hacha);

        Assert.assertNotNull(inventario.obtenerHachaMetal());
        Assert.assertEquals(inventario.cantidadHachaMetal(), 0);
    }

    @Test
    public void test17ObtenerPicoMadera() {
        Inventario inventario = new Inventario();
        Pico pico = new Pico(new Madera());

        inventario.agregar(pico);

        Assert.assertNotNull(inventario.obtenerPicoMadera());
        Assert.assertEquals(inventario.cantidadPicoMadera(), 0);
    }

    @Test
    public void test18ObtenerPicoPiedra() {
        Inventario inventario = new Inventario();
        Pico pico = new Pico(new Piedra());

        inventario.agregar(pico);

        Assert.assertNotNull(inventario.obtenerPicoPiedra());
        Assert.assertEquals(inventario.cantidadPicoPiedra(), 0);
    }

    @Test
    public void test17ObtenerPicoMetal() {
        Inventario inventario = new Inventario();
        Pico pico = new Pico(new Metal());

        inventario.agregar(pico);

        Assert.assertNotNull(inventario.obtenerPicoMetal());
        Assert.assertEquals(inventario.cantidadPicoMetal(), 0);
    }

    @Test
    public void test18ObtenerPicoFino() {
        Inventario inventario = new Inventario();
        PicoFino picoFino = new PicoFino();

        inventario.agregar(picoFino);

        Assert.assertNotNull(inventario.obtenerPicoFino());
        Assert.assertEquals(inventario.cantidadPicoFino(), 0);
    }

    @Test(expected = NoHayHerramientaEnInventarioException.class)
    public void test19ObtenerDosVecesHachaMaderaYFalla() {
        Inventario inventario = new Inventario();
        Hacha hacha = new Hacha(new Madera());

        inventario.agregar(hacha);

        inventario.obtenerHachaMadera();
        inventario.obtenerHachaMadera();
    }

    @Test(expected = NoHayHerramientaEnInventarioException.class)
    public void test19ObtenerDosVecesHachaPiedraYFalla() {
        Inventario inventario = new Inventario();
        Hacha hacha = new Hacha(new Piedra());

        inventario.agregar(hacha);

        inventario.obtenerHachaPiedra();
        inventario.obtenerHachaPiedra();
    }

    @Test(expected = NoHayHerramientaEnInventarioException.class)
    public void test20ObtenerDosVecesHachaMetalYFalla() {
        Inventario inventario = new Inventario();
        Hacha hacha = new Hacha(new Metal());

        inventario.agregar(hacha);

        inventario.obtenerHachaPiedra();
        inventario.obtenerHachaPiedra();
    }

    @Test(expected = NoHayHerramientaEnInventarioException.class)
    public void test21ObtenerDosVecesPicoMaderaYFalla() {
        Inventario inventario = new Inventario();
        Pico pico = new Pico(new Madera());

        inventario.agregar(pico);

        inventario.obtenerPicoMadera();
        inventario.obtenerPicoMadera();
    }

    @Test(expected = NoHayHerramientaEnInventarioException.class)
    public void test22ObtenerDosVecesPicoPiedraYFalla() {
        Inventario inventario = new Inventario();
        Pico pico = new Pico(new Piedra());

        inventario.agregar(pico);

        inventario.obtenerPicoPiedra();
        inventario.obtenerPicoPiedra();
    }

    @Test(expected = NoHayHerramientaEnInventarioException.class)
    public void test23ObtenerDosVecesPicoMetalYFalla() {
        Inventario inventario = new Inventario();
        Pico pico = new Pico(new Metal());

        inventario.agregar(pico);

        inventario.obtenerPicoMetal();
        inventario.obtenerPicoMetal();
    }

    @Test(expected = NoHayHerramientaEnInventarioException.class)
    public void test23ObtenerDosVecesPicoFinoYFalla() {
        Inventario inventario = new Inventario();
        PicoFino picoFino = new PicoFino();

        inventario.agregar(picoFino);

        inventario.obtenerPicoFino();
        inventario.obtenerPicoFino();
    }
}
