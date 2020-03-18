package herramientas;

import Excepciones.HerramientaGastadaException;
import Excepciones.MaterialDestruidoException;
import model.herramientas.PicoFino;
import model.materiales.Diamante;
import model.materiales.Madera;
import model.materiales.Piedra;
import model.materiales.Metal;
import org.junit.Assert;
import org.junit.Test;

public class PruebasPicoFino {

    private static final double RANGO_BASE = 0.1;

    @Test
    public void test01DurabilidadInicialEs1000() {
        PicoFino picoFino = new PicoFino();
        Assert.assertEquals(1000, picoFino.durabilidad(), RANGO_BASE);
    }


    @Test
    public void test02FuerzaInicialEs20() {
        PicoFino picoFino = new PicoFino();
        Assert.assertEquals(20, picoFino.fuerza());
    }

    @Test
    public void test03SeUsaContraDiamanteYSeDesgasta() {
        PicoFino picoFino = new PicoFino();
        Diamante diamante = new Diamante();
        picoFino.golpear(diamante);
        Assert.assertEquals(900, picoFino.durabilidad(), RANGO_BASE);
    }

    @Test
    public void test04DurabilidadNoSeReduceConMadera() {
        PicoFino picoFino = new PicoFino();
        Madera madera = new Madera();

        try {
            picoFino.golpear(madera);
        } catch (MaterialDestruidoException e) {
            //nada para hacer.
        }

        Assert.assertEquals(1000, picoFino.durabilidad(), RANGO_BASE);
    }

    @Test
    public void test05DurabilidadNoSeReduceConMetal() {
        PicoFino picoFino = new PicoFino();
        Metal metal = new Metal();
        picoFino.golpear(metal);
        Assert.assertEquals(1000, picoFino.durabilidad(), RANGO_BASE);

    }

    @Test
    public void test06DurabilidadNoSeReduceConPiedra() {
        PicoFino picoFino = new PicoFino();
        Piedra piedra = new Piedra();
        picoFino.golpear(piedra);
        Assert.assertEquals(1000, picoFino.durabilidad(), RANGO_BASE);
    }

}
