package mapa;

import Excepciones.NoSePuedeOcuparCasilleroException;
import model.materiales.Madera;
import model.materiales.Piedra;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import model.materiales.Metal;
import model.mapa.casilleromapa.CasilleroMapa;
import org.junit.rules.ExpectedException;

public class PruebasCasilleroMapa {

    @Test
    public void test01CasilleroSeInicializaDesocupado(){
        CasilleroMapa casillero = new CasilleroMapa();
        Assert.assertFalse(casillero.estaOcupado());

    }

    @Test
    public void test02CasilleroVacioSePuedeOcuparConMetal(){
        CasilleroMapa casillero = new CasilleroMapa();
        Metal metal = new Metal();
        casillero.guardar(metal);

        Assert.assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test03CasilleroVacioSePuedeOcuparConPiedra(){
        CasilleroMapa casillero = new CasilleroMapa();
        Piedra piedra = new Piedra();
        casillero.guardar(piedra);

        Assert.assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test04CasilleroVacioSePuedeOcuparConMadera(){
        CasilleroMapa casillero = new CasilleroMapa();
        Madera madera = new Madera();
        casillero.guardar(madera);

        Assert.assertTrue(casillero.estaOcupado());
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test05NoSePuedeOcuparCasilleroOcupado(){
        CasilleroMapa casillero = new CasilleroMapa();
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        casillero.guardar(madera);

        thrown.expect(NoSePuedeOcuparCasilleroException.class);
        casillero.guardar(piedra);
    }
}
