package herramientas;

import Excepciones.HerramientaGastadaException;
import Excepciones.MaterialDestruidoException;
import model.herramientas.Hacha;
import model.materiales.Diamante;
import model.materiales.Madera;
import model.materiales.Metal;
import model.materiales.Piedra;
import org.junit.Assert;
import org.junit.Test;

public class PruebasHacha {

    private static final double RANGO_BASE = 0.1;

    @Test
    public void test01DurabilidadInicialHachaDeMaderaEs100() {
        Hacha hacha = new Hacha(new Madera());
        Assert.assertEquals(100, hacha.durabilidad(), RANGO_BASE);
    }

    @Test
    public void test02FuerzaHachaDeMaderaEs2() {
        Hacha hacha = new Hacha(new Madera());
        Assert.assertEquals(2, hacha.fuerza());
    }

    @Test
    public void test03DurabilidadInicialHachaDePiedraEs200() {
        Hacha hacha = new Hacha(new Piedra());
        Assert.assertEquals(200, hacha.durabilidad(), RANGO_BASE);
    }

    @Test
    public void test04FuerzaHachaDePiedraEs5() {
        Hacha hacha = new Hacha(new Piedra());
        Assert.assertEquals(5, hacha.fuerza());
    }

    @Test
    public void test05DurabilidadInicialHachaDeMetalEs400() {
        Hacha hacha = new Hacha(new Metal());
        Assert.assertEquals(400, hacha.durabilidad(), RANGO_BASE);
    }

    @Test
    public void test06FuerzaHachaDeMetalEs10() {
        Hacha hacha = new Hacha(new Metal());
        Assert.assertEquals(10, hacha.fuerza());
    }

    @Test
    public void test07HachaMaderaGolpeaMaderaYPierdeDurabilidad() {
        Madera bloqueMadera = new Madera();
        Hacha hachaMadera = new Hacha(new Madera());

        float durabilidadHacha = hachaMadera.durabilidad();
        int fuerzaHachaMadera = hachaMadera.fuerza();
        hachaMadera.golpear(bloqueMadera);

        Assert.assertEquals(hachaMadera.durabilidad(),durabilidadHacha - fuerzaHachaMadera, RANGO_BASE);
    }

    @Test
    public void test08HachaPiedraGolpeaMaderaYPierdeDurabilidad() {
        Madera bloqueMadera = new Madera();
        Hacha hachaPiedra = new Hacha(new Piedra());

        float durabilidadHacha = hachaPiedra.durabilidad();
        int fuerzaHachaMadera = hachaPiedra.fuerza();
        hachaPiedra.golpear(bloqueMadera);

        Assert.assertEquals(hachaPiedra.durabilidad(),durabilidadHacha - fuerzaHachaMadera, RANGO_BASE);
    }

    @Test
    public void test09HachaMetalGolpeaMaderaYPierdeDurabilidad() {
        Madera bloqueMadera = new Madera();
        Hacha hachaMetal = new Hacha(new Metal());

        float durabilidadHacha = hachaMetal.durabilidad();
        int fuerzaHachaMetal = hachaMetal.fuerza();
        try {
            hachaMetal.golpear(bloqueMadera);
        } catch (MaterialDestruidoException e) {
            //nothing to do.
        }

        Assert.assertEquals(hachaMetal.durabilidad(), durabilidadHacha - fuerzaHachaMetal / 2, RANGO_BASE);
    }

    @Test
    public void test10HachaMaderaGolpeaPiedraYPierdeDurabilidad() {
        Piedra bloquePiedra = new Piedra();
        Hacha hachaMadera = new Hacha(new Madera());

        float durabilidadHacha = hachaMadera.durabilidad();
        int fuerzaHachaMadera = hachaMadera.fuerza();
        hachaMadera.golpear(bloquePiedra);

        Assert.assertEquals(hachaMadera.durabilidad(),durabilidadHacha - fuerzaHachaMadera, RANGO_BASE);
    }

    @Test
    public void test11HachaPiedraGolpeaPiedraYPierdeDurabilidad() {
        Piedra bloquePiedra = new Piedra();
        Hacha hachaPiedra = new Hacha(new Piedra());

        float durabilidadHacha = hachaPiedra.durabilidad();
        int fuerzaHachaPiedra = hachaPiedra.fuerza();
        hachaPiedra.golpear(bloquePiedra);

        Assert.assertEquals(hachaPiedra.durabilidad(),durabilidadHacha - fuerzaHachaPiedra, RANGO_BASE);
    }

    @Test
    public void test12HachaMetalGolpeaPiedraYPierdeDurabilidad() {
        Piedra bloquePiedra = new Piedra();
        Hacha hachaMetal = new Hacha(new Metal());

        float durabilidadHacha = hachaMetal.durabilidad();
        int fuerzaHachaMadera = hachaMetal.fuerza();
        hachaMetal.golpear(bloquePiedra);

        Assert.assertEquals(hachaMetal.durabilidad(),durabilidadHacha - fuerzaHachaMadera / 2, RANGO_BASE);
    }

    @Test
    public void test13HachaMaderaGolpeaMetalYPierdeDurabilidad() {
        Metal bloqueMetal = new Metal();
        Hacha hachaMadera = new Hacha(new Madera());

        float durabilidadHacha = hachaMadera.durabilidad();
        int fuerzaHachaMadera = hachaMadera.fuerza();
        hachaMadera.golpear(bloqueMetal);

        Assert.assertEquals(hachaMadera.durabilidad(),durabilidadHacha - fuerzaHachaMadera, RANGO_BASE);
    }

    @Test
    public void test14HachaPiedraGolpeaMetalYPierdeDurabilidad() {
        Metal bloqueMetal = new Metal();
        Hacha hachaPiedra = new Hacha(new Piedra());

        float durabilidadHacha = hachaPiedra.durabilidad();
        int fuerzaHachaPiedra = hachaPiedra.fuerza();
        hachaPiedra.golpear(bloqueMetal);

        Assert.assertEquals(hachaPiedra.durabilidad(),durabilidadHacha - fuerzaHachaPiedra, RANGO_BASE);
    }

    @Test
    public void test15HachaMetalGolpeaMetalYPierdeDurabilidad() {
        Metal bloqueMetal = new Metal();
        Hacha hachaMetal = new Hacha(new Metal());

        float durabilidadHacha = hachaMetal.durabilidad();
        int fuerzaHachaMadera = hachaMetal.fuerza();
        hachaMetal.golpear(bloqueMetal);

        Assert.assertEquals(hachaMetal.durabilidad(),durabilidadHacha - fuerzaHachaMadera / 2, RANGO_BASE);
    }

    @Test(expected = HerramientaGastadaException.class)
    public void test16UtilizarHachaDeMaderaHastaGastarlaYVolverAUtilizarla() {
        Diamante diamante = new Diamante();
        Hacha hacha = new Hacha(new Madera());

        for (int i=0; i<50; i++) {
            hacha.golpear(diamante);
        }

        hacha.golpear(diamante);
    }

    @Test(expected = HerramientaGastadaException.class)
    public void test17UtilizarHachaDePiedraHastaGastarlaYVolverAUtilizarla() {
        Diamante diamante = new Diamante();
        Hacha hacha = new Hacha(new Piedra());

        for (int i=0; i<40; i++) {
            hacha.golpear(diamante);
        }

        hacha.golpear(diamante);
    }

    @Test(expected = HerramientaGastadaException.class)
    public void test18UtilizarHachaDeMetalHastaGastarlaYVolverAUtilizarla() {
        Diamante diamante = new Diamante();
        Hacha hacha = new Hacha(new Metal());

        for (int i=0; i<80; i++) {
            hacha.golpear(diamante);
        }

        hacha.golpear(diamante);
    }

}
