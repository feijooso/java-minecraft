package herramientas;

import Excepciones.HerramientaGastadaException;
import model.herramientas.Pico;
import model.materiales.Diamante;
import model.materiales.Madera;
import model.materiales.Metal;
import model.materiales.Piedra;
import org.junit.Assert;
import org.junit.Test;

public class PruebasPico {

    private static final double RANGO_BASE = 0.1;

    @Test
    public void test01DurabilidadInicialPicoDeMaderaEs100() {
        Pico pico = new Pico(new Madera());
        Assert.assertEquals(100, pico.durabilidad(), RANGO_BASE);
    }

    @Test
    public void test02FuerzaPicoDeMaderaEs2() {
        Pico pico = new Pico(new Madera());
        Assert.assertEquals(2, pico.fuerza());
    }

    @Test
    public void test03DurabilidadInicialPicoDePiedraEs200() {
        Pico pico = new Pico(new Piedra());
        Assert.assertEquals(200, pico.durabilidad(), RANGO_BASE);
    }

    @Test
    public void test04FuerzaPicoDePiedraEs4() {
        Pico pico = new Pico(new Piedra());
        Assert.assertEquals(4, pico.fuerza());
    }

    @Test
    public void test05DurabilidadInicialPicoDeMetalEs400() {
        Pico pico = new Pico(new Metal());
        Assert.assertEquals(400, pico.durabilidad(), RANGO_BASE);
    }

    @Test
    public void test06FuerzaPicoDeMetalEs12() {
        Pico pico = new Pico(new Metal());
        Assert.assertEquals(12, pico.fuerza());
    }

    @Test
    public void test07PicoMaderaGolpeaMaderaYPierdeDurabilidad() {
        Madera bloqueMadera = new Madera();
        Pico picoMadera = new Pico(new Madera());

        float durabilidadPico = picoMadera.durabilidad();
        int fuerzaPicoMadera = picoMadera.fuerza();
        picoMadera.golpear(bloqueMadera);

        Assert.assertEquals(picoMadera.durabilidad(),durabilidadPico - fuerzaPicoMadera, RANGO_BASE);
    }

    @Test
    public void test08PicoMaderaGolpeaPiedraYPierdeDurabilidad() {
        Piedra bloquePiedra = new Piedra();
        Pico picoMadera = new Pico(new Madera());

        float durabilidadPico = picoMadera.durabilidad();
        int fuerzaPicoMadera = picoMadera.fuerza();
        picoMadera.golpear(bloquePiedra);

        Assert.assertEquals(picoMadera.durabilidad(),durabilidadPico - fuerzaPicoMadera, RANGO_BASE);
    }

    @Test
    public void test09PicoMaderaGolpeaMetalYPierdeDurabilidad() {
        Metal bloqueMetal = new Metal();
        Pico picoMadera = new Pico(new Madera());

        float durabilidadPico = picoMadera.durabilidad();
        int fuerzaPicoMadera = picoMadera.fuerza();
        picoMadera.golpear(bloqueMetal);

        Assert.assertEquals(picoMadera.durabilidad(),durabilidadPico - fuerzaPicoMadera, RANGO_BASE);
    }

    @Test
    public void test10PicoMetalGolpeaMaderaUnaVezYDurabilidadNoCambia() {
        Madera bloqueMadera = new Madera();
        Pico picoMetal = new Pico(new Metal());

        float durabilidadPico = picoMetal.durabilidad();
        picoMetal.golpear(bloqueMadera);

        Assert.assertEquals(picoMetal.durabilidad(), durabilidadPico, RANGO_BASE);
    }

    @Test
    public void test11PicoMetalGolpeaMaderaCincoVecesYDurabilidadNoCambia() {
        Madera bloqueMadera = new Madera();
        Pico picoMetal = new Pico(new Metal());

        float durabilidadPico = picoMetal.durabilidad();

        picoMetal.golpear(bloqueMadera);
        picoMetal.golpear(bloqueMadera);
        picoMetal.golpear(bloqueMadera);
        picoMetal.golpear(bloqueMadera);
        picoMetal.golpear(bloqueMadera);

        Assert.assertEquals(picoMetal.durabilidad(), durabilidadPico, RANGO_BASE);
    }

    @Test
    public void test12PicoMetalGolpeaMetalUnaVezYDurabilidadNoCambia() {
        Metal bloqueMetal = new Metal();
        Pico picoMetal = new Pico(new Metal());

        float durabilidadPico = picoMetal.durabilidad();
        picoMetal.golpear(bloqueMetal);

        Assert.assertEquals(picoMetal.durabilidad(), durabilidadPico, RANGO_BASE);
    }

    @Test
    public void test12PicoMetalGolpeaMetalCincoVecesYDurabilidadNoCambia() {
        Metal bloqueMetal = new Metal();
        Pico picoMetal = new Pico(new Metal());

        float durabilidadPico = picoMetal.durabilidad();

        picoMetal.golpear(bloqueMetal);
        picoMetal.golpear(bloqueMetal);
        picoMetal.golpear(bloqueMetal);
        picoMetal.golpear(bloqueMetal);
        picoMetal.golpear(bloqueMetal);

        Assert.assertEquals(picoMetal.durabilidad(), durabilidadPico, RANGO_BASE);
    }


    @Test
    public void test13PicoMetalGolpeaPiedraUnaVezYDurabilidadNoCambia() {
        Piedra bloquePiedra = new Piedra();
        Pico picoMetal = new Pico(new Metal());

        float durabilidadPico = picoMetal.durabilidad();
        picoMetal.golpear(bloquePiedra);

        Assert.assertEquals(picoMetal.durabilidad(), durabilidadPico, RANGO_BASE);
    }

    @Test
    public void test14PicoMetalGolpeaPiedraCincoVecesYDurabilidadNoCambia() {
        Diamante bloque = new Diamante();
        Pico picoMetal = new Pico(new Metal());

        float durabilidadPico = picoMetal.durabilidad();

        picoMetal.golpear(bloque);
        picoMetal.golpear(bloque);
        picoMetal.golpear(bloque);
        picoMetal.golpear(bloque);
        picoMetal.golpear(bloque);

        Assert.assertEquals(picoMetal.durabilidad(), durabilidadPico, RANGO_BASE);
    }

    @Test
    public void test15PicoMetalGolpeaMadera10VecesYDurabilidadEsCero() {
        Madera bloqueMadera = new Madera();
        Pico picoMetal = new Pico(new Metal());

        picoMetal.golpear(bloqueMadera);
        picoMetal.golpear(bloqueMadera);
        picoMetal.golpear(bloqueMadera);
        picoMetal.golpear(bloqueMadera);
        picoMetal.golpear(bloqueMadera);
        picoMetal.golpear(bloqueMadera);
        picoMetal.golpear(bloqueMadera);
        picoMetal.golpear(bloqueMadera);
        picoMetal.golpear(bloqueMadera);
        picoMetal.golpear(bloqueMadera);

        Assert.assertEquals(0, picoMetal.durabilidad(), RANGO_BASE);
    }

    @Test
    public void test16PicoMetalGolpeaPiedra10VecesYDurabilidadEsCero() {
        Diamante bloque = new Diamante();
        Pico picoMetal = new Pico(new Metal());

        picoMetal.golpear(bloque);
        picoMetal.golpear(bloque);
        picoMetal.golpear(bloque);
        picoMetal.golpear(bloque);
        picoMetal.golpear(bloque);
        picoMetal.golpear(bloque);
        picoMetal.golpear(bloque);
        picoMetal.golpear(bloque);
        picoMetal.golpear(bloque);
        picoMetal.golpear(bloque);

        Assert.assertEquals(picoMetal.durabilidad(), 0, RANGO_BASE);
    }

    @Test
    public void test17PicoMetalGolpeaMetal10VecesYDurabilidadEsCero() {
        Metal bloqueMetal = new Metal();
        Pico picoMetal = new Pico(new Metal());

        picoMetal.golpear(bloqueMetal);
        picoMetal.golpear(bloqueMetal);
        picoMetal.golpear(bloqueMetal);
        picoMetal.golpear(bloqueMetal);
        picoMetal.golpear(bloqueMetal);
        picoMetal.golpear(bloqueMetal);
        picoMetal.golpear(bloqueMetal);
        picoMetal.golpear(bloqueMetal);
        picoMetal.golpear(bloqueMetal);
        picoMetal.golpear(bloqueMetal);

        Assert.assertEquals(0, picoMetal.durabilidad(), RANGO_BASE);
    }

    @Test
    public void test18PicoPiedraGolpeaMaderaYSeReduceSuDurabilidad() {

        Madera bloqueMadera = new Madera();
        Pico picoPiedra = new Pico(new Piedra());

        double durabilidadPico = picoPiedra.durabilidad();
        int fuerzaPicoPiedra = picoPiedra.fuerza();
        picoPiedra.golpear(bloqueMadera);

        Assert.assertEquals(picoPiedra.durabilidad(),durabilidadPico - fuerzaPicoPiedra / 1.5, RANGO_BASE);
    }

    @Test
    public void test19PicoPiedraGolpeaPiedraYSeReduceSuDurabilidad() {

        Piedra bloquePiedra = new Piedra();
        Pico picoPiedra = new Pico(new Piedra());

        double durabilidadPico = picoPiedra.durabilidad();
        int fuerzaPicoPiedra = picoPiedra.fuerza();
        picoPiedra.golpear(bloquePiedra);

        Assert.assertEquals(picoPiedra.durabilidad(),durabilidadPico - fuerzaPicoPiedra / 1.5, RANGO_BASE);
    }

    @Test
    public void test20PicoPiedraGolpeaMetalYSeReduceSuDurabilidad() {

        Metal bloqueMetal = new Metal();
        Pico picoPiedra = new Pico(new Piedra());

        double durabilidadPico = picoPiedra.durabilidad();
        int fuerzaPicoPiedra = picoPiedra.fuerza();
        picoPiedra.golpear(bloqueMetal);

        Assert.assertEquals(picoPiedra.durabilidad(),durabilidadPico - fuerzaPicoPiedra / 1.5, RANGO_BASE);
    }

    @Test(expected = HerramientaGastadaException.class)
    public void test21PicoDeMaderaGolpeaHastaGastarseYGolpeaDenuevo() {
        Pico pico = new Pico(new Madera());
        Diamante diamante = new Diamante();

        for (int i=0; i< 50; i++) {
            pico.golpear(diamante);
        }

        pico.golpear(diamante);
    }

    @Test(expected = HerramientaGastadaException.class)
    public void test22PicoDePiedraGolpeaHastaGastarseYGolpeaDenuevo() {
        Pico pico = new Pico(new Piedra());
        Diamante diamante = new Diamante();

        for (int i=0; i< 75; i++) {
            pico.golpear(diamante);
        }

        pico.golpear(diamante);
    }

    @Test(expected = HerramientaGastadaException.class)
    public void test23PicoDeMetalGolpeaHastaGastarseYGolpeaDenuevo() {
        Pico pico = new Pico(new Metal());
        Diamante diamante = new Diamante();

        for (int i=0; i< 10; i++) {
            pico.golpear(diamante);
        }

        pico.golpear(diamante);
    }

}
