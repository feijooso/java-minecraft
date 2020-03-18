package materiales;

import model.herramientas.Hacha;
import model.herramientas.Pico;
import model.herramientas.PicoFino;
import model.materiales.Madera;
import model.materiales.Metal;
import model.materiales.Piedra;
import model.materiales.Diamante;
import org.junit.Assert;
import org.junit.Test;

public class PruebasDiamante {

    @Test
    public void test01DurabilidadDiamanteEs100() {
        Diamante diamante = new Diamante();
        Assert.assertEquals(100, diamante.durabilidad());
    }

    @Test
    public void test02DiamanteSeGolpeaConHachaDeMaderaYSuDurabilidadNoCambia() {
        Diamante bloqueDiamante = new Diamante();
        Hacha hachaMadera = new Hacha(new Madera());

        int durabilidadBloqueMadera = bloqueDiamante.durabilidad();
        hachaMadera.golpear(bloqueDiamante);

        Assert.assertEquals(bloqueDiamante.durabilidad(), durabilidadBloqueMadera);
    }

    @Test
    public void test03DiamanteSeGolpeaConHachaDePiedraYSuDurabilidadNoCambia() {
        Diamante bloqueDiamante = new Diamante();
        Hacha hachaPiedra = new Hacha(new Piedra());

        int durabilidadBloqueMadera = bloqueDiamante.durabilidad();
        hachaPiedra.golpear(bloqueDiamante);

        Assert.assertEquals(bloqueDiamante.durabilidad(),durabilidadBloqueMadera);
    }

    @Test
    public void test04DiamanteSeGolpeaConHachaDeMetalYSuDurabilidadNoCambia() {
        Diamante bloqueDiamante = new Diamante();
        Hacha hachaMetal = new Hacha(new Metal());

        int durabilidadBloqueMadera = bloqueDiamante.durabilidad();
        hachaMetal.golpear(bloqueDiamante);

        Assert.assertEquals(bloqueDiamante.durabilidad(),durabilidadBloqueMadera);
    }

    @Test
    public void test05DiamanteSeGolpeaConPicoDeMaderaYSuDurabilidadNoCambia() {
        Diamante bloqueDiamante = new Diamante();
        Pico picoMadera = new Pico(new Madera());

        int durabilidadBloqueMadera = bloqueDiamante.durabilidad();
        picoMadera.golpear(bloqueDiamante);

        Assert.assertEquals(bloqueDiamante.durabilidad(), durabilidadBloqueMadera);
    }

    @Test
    public void test06DiamanteSeGolpeaConPicoDePiedraYSuDurabilidadNoCambia() {
        Diamante bloqueDiamante = new Diamante();
        Pico picoPiedra = new Pico(new Piedra());

        int durabilidadBloqueMadera = bloqueDiamante.durabilidad();
        picoPiedra.golpear(bloqueDiamante);

        Assert.assertEquals(bloqueDiamante.durabilidad(), durabilidadBloqueMadera);
    }

    @Test
    public void test07DiamanteSeGolpeaConPicoDeMetalYSuDurabilidadNoCambia() {
        Diamante bloqueDiamante = new Diamante();
        Pico picoMetal = new Pico(new Metal());

        int durabilidadBloqueMadera = bloqueDiamante.durabilidad();
        picoMetal.golpear(bloqueDiamante);

        Assert.assertEquals(bloqueDiamante.durabilidad(), durabilidadBloqueMadera);
    }

    @Test
    public void test08DiamanteSeGolpeaConPicoFinoYSeReduceSuDurabilidad(){
        Diamante bloqueDiamante = new Diamante();
        PicoFino picoFino = new PicoFino();

        int durabilidadBloqueMadera = bloqueDiamante.durabilidad();
        picoFino.golpear(bloqueDiamante);

        Assert.assertEquals(bloqueDiamante.durabilidad(),durabilidadBloqueMadera - picoFino.fuerza());
    }

    @Test
    public void test09TagDiamanteEsCorrecto() {
        Diamante bloqueDiamante = new Diamante();

        Assert.assertEquals(bloqueDiamante.getTag(), Diamante.TAG);
    }
}
