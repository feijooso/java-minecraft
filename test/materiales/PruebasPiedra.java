package materiales;

import model.herramientas.Hacha;
import model.herramientas.Pico;
import model.herramientas.PicoFino;
import model.materiales.Madera;
import model.materiales.Metal;
import model.materiales.Piedra;
import org.junit.Test;
import org.junit.Assert;

public class PruebasPiedra {

    @Test
    public void test01DurabilidadPiedraEs30() {
        Piedra bloquePiedra = new Piedra();
        Assert.assertEquals(30, bloquePiedra.durabilidad());
    }

    @Test
    public void test02PiedraSeGolpeaConHachaDeMaderaNoReduceSuDurabilidad() {
        Piedra bloquePiedra = new Piedra();
        Hacha hachaDeMadera = new Hacha(new Madera());

        int durabilidadBloquePiedra = bloquePiedra.durabilidad();
        hachaDeMadera.golpear(bloquePiedra);

        Assert.assertEquals(bloquePiedra.durabilidad(), durabilidadBloquePiedra);
    }

    @Test
    public void test03PiedraSeGolpeaConHachaDePiedraNoReduceSuDurabilidad() {
        Piedra bloquePiedra = new Piedra();
        Hacha hachaDePiedra = new Hacha(new Piedra());
        int durabilidadBloquePiedra = bloquePiedra.durabilidad();

        hachaDePiedra.golpear(bloquePiedra);

        Assert.assertEquals(bloquePiedra.durabilidad(), durabilidadBloquePiedra);
    }

    @Test
    public void test04PiedraSeGolpeaConHachaDeMetalNoReduceSuDurabilidad() {
        Piedra bloquePiedra = new Piedra();
        Hacha hachaDePiedra = new Hacha(new Metal());
        int durabilidadBloquePiedra = bloquePiedra.durabilidad();

        hachaDePiedra.golpear(bloquePiedra);

        Assert.assertEquals(bloquePiedra.durabilidad(), durabilidadBloquePiedra);
    }

    @Test
    public void test05PiedraEsGolpeadaPorPicoDeMaderaYSeReduceSuDurabilidad() {
        Piedra bloquePiedra = new Piedra();
        Pico picoMadera = new Pico(new Madera());
        int durabilidadBloquePiedra = bloquePiedra.durabilidad();

        picoMadera.golpear(bloquePiedra);

        Assert.assertEquals(bloquePiedra.durabilidad(), durabilidadBloquePiedra - picoMadera.fuerza());
    }

    @Test
    public void test06PiedraEsGolpeadaPorPicoDePiedraYSeReduceSuDurabilidad() {
        Piedra bloquePiedra = new Piedra();
        Pico picoPiedra = new Pico(new Piedra());
        int durabilidadBloquePiedra = bloquePiedra.durabilidad();

        picoPiedra.golpear(bloquePiedra);

        Assert.assertEquals(bloquePiedra.durabilidad(), durabilidadBloquePiedra - picoPiedra.fuerza());
    }

    @Test
    public void test07PiedraEsGolpeadaPorPicoDeMetalYSiSeReduceSuDurabilidad() {
        Piedra bloquePiedra = new Piedra();
        Pico picoMetal = new Pico(new Metal());
        int durabilidadBloquePiedra = bloquePiedra.durabilidad();

        picoMetal.golpear(bloquePiedra);

        Assert.assertEquals(bloquePiedra.durabilidad(), durabilidadBloquePiedra - picoMetal.fuerza());
    }

    @Test
    public void test08PiedraSeGolpeaConPicoFinoYSeReduceSuDurabilidad() {
        Piedra bloquePiedra = new Piedra();
        PicoFino picoFino = new PicoFino();

        int durabilidadBloqueMadera = bloquePiedra.durabilidad();
        picoFino.golpear(bloquePiedra);

        Assert.assertEquals(bloquePiedra.durabilidad(), durabilidadBloqueMadera - picoFino.fuerza());
    }

    @Test
    public void test09TagPiedraEsCorrecto() {
        Piedra bloque = new Piedra();

        Assert.assertEquals(bloque.getTag(), Piedra.TAG);
    }
}