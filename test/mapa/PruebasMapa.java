package mapa;

import Excepciones.FueraDeMapaException;
import Excepciones.NoSePuedeOcuparCasilleroException;
import model.jugador.Jugador;
import model.mapa.Posicion;
import model.materiales.Madera;
import model.materiales.Metal;
import model.materiales.Piedra;
import model.mapa.Mapa;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PruebasMapa {

    @Test
    public void test01DimensionDelMapaEs4(){
        Mapa mapa = new Mapa(4);
        Assert.assertEquals(4, mapa.dimension());
    }

    @Test
    public void test02DimensionDelMapaEs50(){
        Mapa mapa = new Mapa(50);
        Assert.assertEquals(50, mapa.dimension());
    }

    @Test
    public void test03DimensionDelMapaEs1700(){
        Mapa mapa = new Mapa(1700);
        Assert.assertEquals(1700, mapa.dimension());
    }

    @Test
    public void test04PosicionDeMapaEmpiezaVacia(){
        Mapa mapa = new Mapa(4);
        Posicion posicion = new Posicion(1, 3);
        Assert.assertFalse(mapa.posicionEstaOcupada(posicion));
    }

    @Test
    public void test05PosicionDeMapaVaciaSePuedeOcuparConMetal(){
        Mapa mapa = new Mapa(4);
        Posicion posicion = new Posicion(1, 2);
        Metal metal = new Metal();
        mapa.guardar(metal, posicion);

        Assert.assertTrue(mapa.posicionEstaOcupada(posicion));
    }

    @Test
    public void test06PosicionDeMapaVaciaSePuedeOcuparConPiedra(){
        Mapa mapa = new Mapa(4);
        Posicion posicion = new Posicion(1, 2);
        Piedra piedra = new Piedra();
        mapa.guardar(piedra, posicion);

        Assert.assertTrue(mapa.posicionEstaOcupada(posicion));
    }

    @Test
    public void test07PosicionDeMapaVaciaSePuedeOcuparConMadera(){
        Mapa mapa = new Mapa(4);
        Posicion posicion = new Posicion(1, 2);
        Madera madera = new Madera();
        mapa.guardar(madera, posicion);

        Assert.assertTrue(mapa.posicionEstaOcupada(posicion));
    }

    @Test
    public void test05MapaPuedeMoverJugadorAUnaPosicionDesocupada(){
        Mapa mapa = new Mapa(4);
        Jugador jugador = new Jugador(new Posicion(2, 2));
        Posicion posicion = new Posicion(1,1);
        mapa.mover(jugador, posicion);

        Assert.assertEquals(posicion.toString(), jugador.obtenerPosicionActual().toString());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test08PosicionDeMapaOcupadaNoSePuedeOcupar(){
        Mapa mapa = new Mapa(4);
        Piedra piedra = new Piedra();
        Metal metal = new Metal();
        Posicion posicion = new Posicion(1, 2);
        mapa.guardar(piedra, posicion);

        thrown.expect(NoSePuedeOcuparCasilleroException.class);
        mapa.guardar(metal, posicion);
    }

    @Test (expected = FueraDeMapaException.class)
    public void test09MoverJugadorFueraDelMapaDaError() {
        Mapa mapa = new Mapa(4);
        Jugador jugador = new Jugador(new Posicion(2, 2));
        Posicion posicion = new Posicion(5,4);
        mapa.mover(jugador, posicion);
    }
}
