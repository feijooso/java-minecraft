package materiales;

import model.herramientas.Hacha;
import model.herramientas.Pico;
import model.herramientas.PicoFino;
import model.materiales.Madera;
import model.materiales.Metal;
import model.materiales.Piedra;
import org.junit.Test;
import org.junit.Assert;

public class PruebasMetal {

    @Test
    public void test01DurabilidadMetalEs50() {
        Metal bloqueMetal = new Metal();
        Assert.assertEquals(50, bloqueMetal.durabilidad());
    }

    @Test
    public void test02MetalSeGolpeaConHachaDeMaderaYSuDurabilidadNoCambia() {
        Metal bloqueMetal = new Metal();
        Hacha hachaMadera = new Hacha(new Madera());

        int durabilidadBloqueMetal = bloqueMetal.durabilidad();
        hachaMadera.golpear(bloqueMetal);

        Assert.assertEquals(durabilidadBloqueMetal, bloqueMetal.durabilidad());
    }

    @Test
    public void test03MetalSeGolpeaConHachaDePiedraYSuDurabilidadNoCambia() {
        Metal bloqueMetal = new Metal();
        Hacha hachaPiedra = new Hacha(new Piedra());

        int durabilidadBloqueMetal = bloqueMetal.durabilidad();
        hachaPiedra.golpear(bloqueMetal);

        Assert.assertEquals(durabilidadBloqueMetal, bloqueMetal.durabilidad());
    }

    @Test
    public void test04MetalSeGolpeaConHachaDeMetalYSuDurabilidadNoCambia() {
        Metal bloqueMetal = new Metal();
        Hacha hachaMetal = new Hacha(new Metal());

        int durabilidadBloqueMetal = bloqueMetal.durabilidad();
        hachaMetal.golpear(bloqueMetal);

        Assert.assertEquals(durabilidadBloqueMetal, bloqueMetal.durabilidad());
    }

    @Test
    public void test05MetalSeGolpeaConPicoDeMaderaYSuDurabilidadNoCambia() {
        Metal bloqueMetal = new Metal();
        Pico picoMadera = new Pico(new Madera());

        int durabilidadBloqueMetal = bloqueMetal.durabilidad();
        picoMadera.golpear(bloqueMetal);

        Assert.assertEquals(durabilidadBloqueMetal, bloqueMetal.durabilidad());
    }

    @Test
    public void test06MetalSeGolpeaConPicoDeMetalYSuDurabilidadNoCambia() {
        Metal bloqueMetal = new Metal();
        Pico picoMetal = new Pico(new Metal());

        int durabilidadBloqueMetal = bloqueMetal.durabilidad();
        picoMetal.golpear(bloqueMetal);

        Assert.assertEquals(durabilidadBloqueMetal, bloqueMetal.durabilidad());
    }

    @Test
    public void test07MetalSeGolpeaConPicoDePiedraYSeReduceSuDurabilidad() {
        Metal bloqueMetal = new Metal();
        Pico picoPiedra = new Pico(new Piedra());

        int durabilidadBloqueMetal = bloqueMetal.durabilidad();
        picoPiedra.golpear(bloqueMetal);

        Assert.assertEquals(bloqueMetal.durabilidad(), durabilidadBloqueMetal - picoPiedra.fuerza());
    }

    @Test
    public void test08MetalSeGolpeaConPicoFinoYSeReduceSuDurabilidad() {
        Metal bloqueMetal= new Metal();
        PicoFino picoFino = new PicoFino();

        int durabilidadBloqueMadera = bloqueMetal.durabilidad();
        picoFino.golpear(bloqueMetal);

        Assert.assertEquals(bloqueMetal.durabilidad(), durabilidadBloqueMadera - picoFino.fuerza());
    }

    @Test
    public void test09TagMetalEsCorrecto() {
        Metal bloque = new Metal();

        Assert.assertEquals(bloque.getTag(), Metal.TAG);
    }

}
