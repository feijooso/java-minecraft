package materiales;

import Excepciones.MaterialDestruidoException;
import model.herramientas.Hacha;
import model.herramientas.Pico;
import model.herramientas.PicoFino;
import model.materiales.Madera;
import model.materiales.Metal;
import model.materiales.Piedra;
import org.junit.Test;
import org.junit.Assert;

public class PruebasMadera {

    @Test
    public void test01DurabilidadMaderaEs10() {
        Madera madera = new Madera();
        Assert.assertEquals(10, madera.durabilidad());
    }

    @Test
    public void test02MaderaSeGolpeaConHachaDeMaderaYReduceSuDurabilidad() {
        Madera bloqueMadera = new Madera();
        Hacha hachaMadera = new Hacha(new Madera());

        int durabilidadBloqueMadera = bloqueMadera.durabilidad();
        hachaMadera.golpear(bloqueMadera);

        Assert.assertEquals(bloqueMadera.durabilidad(),durabilidadBloqueMadera - hachaMadera.fuerza());
    }

    @Test
    public void test03MaderaSeGolpeaConHachaDePiedraYReduceSuDurabilidad() {
        Madera bloqueMadera = new Madera();
        Hacha hachaPiedra = new Hacha(new Piedra());

        int durabilidadBloqueMadera = bloqueMadera.durabilidad();
        hachaPiedra.golpear(bloqueMadera);

        Assert.assertEquals(bloqueMadera.durabilidad(),durabilidadBloqueMadera -hachaPiedra.fuerza());
    }

    @Test
    public void test04MaderaSeGolpeaConHachaDeMetalYReduceSuDurabilidad() {
        Madera bloqueMadera = new Madera();
        Hacha hachaMetal = new Hacha(new Metal());

        int durabilidadBloqueMadera = bloqueMadera.durabilidad();
        try {
            hachaMetal.golpear(bloqueMadera);
        } catch (MaterialDestruidoException e) {
            //nada para hacer
        }

        Assert.assertEquals(bloqueMadera.durabilidad(),durabilidadBloqueMadera - hachaMetal.fuerza());
    }

    @Test
    public void test05MaderaSeGolpeaConPicoDeMaderaYSuDurabilidadNoCambia() {
        Madera bloqueMadera = new Madera();
        Pico picoMadera = new Pico(new Madera());

        int durabilidadBloqueMadera = bloqueMadera.durabilidad();
        picoMadera.golpear(bloqueMadera);

        Assert.assertEquals(bloqueMadera.durabilidad(), durabilidadBloqueMadera);
    }

    @Test
    public void test06MaderaSeGolpeaConPicoDePiedraYSuDurabilidadNoCambia() {
        Madera bloqueMadera = new Madera();
        Pico picoPiedra = new Pico(new Piedra());

        int durabilidadBloqueMadera = bloqueMadera.durabilidad();
        picoPiedra.golpear(bloqueMadera);

        Assert.assertEquals(bloqueMadera.durabilidad(), durabilidadBloqueMadera);
    }

    @Test
    public void test07MaderaSeGolpeaConPicoDeMetalYSuDurabilidadNoCambia() {
        Madera bloqueMadera = new Madera();
        Pico picoMetal = new Pico(new Metal());

        int durabilidadBloqueMadera = bloqueMadera.durabilidad();
        picoMetal.golpear(bloqueMadera);

        Assert.assertEquals(bloqueMadera.durabilidad(), durabilidadBloqueMadera);
    }

    @Test
    public void test08MaderaSeGolpeaConPicoFinoYSeReduceSuDurabilidad() {
        Madera bloqueMadera = new Madera();
        PicoFino picoFino = new PicoFino();

        int durabilidadBloqueMadera = bloqueMadera.durabilidad();
        try {
            picoFino.golpear(bloqueMadera);
        }catch (MaterialDestruidoException e) {
            //nada para hacer.
        }

        Assert.assertEquals(bloqueMadera.durabilidad(), durabilidadBloqueMadera - picoFino.fuerza());
    }

    @Test
    public void test09TagMaderaEsCorrecto() {
        Madera bloque = new Madera();

        Assert.assertEquals(bloque.getTag(), Madera.TAG);
    }
}