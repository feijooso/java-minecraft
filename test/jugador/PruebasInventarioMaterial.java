package jugador;

import Excepciones.NoHayMaterialEnInventarioException;
import model.jugador.inventario.Inventario;
import model.materiales.Diamante;
import model.materiales.Madera;
import model.materiales.Metal;
import model.materiales.Piedra;
import org.junit.Assert;
import org.junit.Test;

public class PruebasInventarioMaterial {

    @Test
    public void test01SeCreoEfectivamenteElInventarioVacio() {
        Inventario inventario = new Inventario();

        Assert.assertEquals(inventario.cantidadDeMateriales(), 0);
    }

    @Test(expected = NoHayMaterialEnInventarioException.class)
    public void test02NoSePuedeObtenerMaderaDeInventarioVacio() {
        Inventario inventario = new Inventario();
        inventario.obtenerMadera();
    }

    @Test(expected = NoHayMaterialEnInventarioException.class)
    public void test03NoSePuedeObtenerPiedraDeInventarioVacio() {
        Inventario inventario = new Inventario();
        inventario.obtenerPiedra();
    }

    @Test(expected = NoHayMaterialEnInventarioException.class)
    public void test04NoSePuedeObtenerMetalDeInventarioVacio() {
        Inventario inventario = new Inventario();
        inventario.obtenerMetal();
    }

    @Test(expected = NoHayMaterialEnInventarioException.class)
    public void test05NoSePuedeObtenerDiamanteDeInventarioVacio() {
        Inventario inventario = new Inventario();
        inventario.obtenerDiamante();
    }

    @Test
    public void test06AgregarMadera() {
        Inventario inventario = new Inventario();
        Madera material = new Madera();

        inventario.agregar(material);

        Assert.assertEquals(inventario.cantidadDeMadera(), 1);
    }

    @Test
    public void test07AgregarPiedra() {
        Inventario inventario = new Inventario();
        Piedra material = new Piedra();

        inventario.agregar(material);

        Assert.assertEquals(inventario.cantidadDePiedra(), 1);
    }

    @Test
    public void test06AgregarMetal() {
        Inventario inventario = new Inventario();
        Metal material = new Metal();

        inventario.agregar(material);

        Assert.assertEquals(inventario.cantidadDeMetal(), 1);
    }

    @Test
    public void test07AgregarDiamante() {
        Inventario inventario = new Inventario();
        Diamante diamante = new Diamante();

        inventario.agregar(diamante);

        Assert.assertEquals(inventario.cantidadDeDiamante(), 1);
    }

    @Test
    public void test08AgregarVariosMaterialesDiferentes() {
        Inventario inventario = new Inventario();

        inventario.agregar(new Piedra());
        inventario.agregar(new Madera());
        inventario.agregar(new Metal());
        inventario.agregar(new Diamante());

        Assert.assertEquals(inventario.cantidadDeMateriales(), 4);
    }

    @Test
    public void test09ObtenerMadera() {
        Inventario inventario = new Inventario();

        inventario.agregar(new Madera());

        Assert.assertNotNull(inventario.obtenerMadera());
        Assert.assertEquals(inventario.cantidadDeMadera(), 0);
    }

    @Test
    public void test10ObtenerPiedra() {
        Inventario inventario = new Inventario();

        inventario.agregar(new Piedra());

        Assert.assertNotNull(inventario.obtenerPiedra());
        Assert.assertEquals(inventario.cantidadDePiedra(), 0);
    }

    @Test
    public void test11ObtenerMetal() {
        Inventario inventario = new Inventario();

        inventario.agregar(new Metal());

        Assert.assertNotNull(inventario.obtenerMetal());
        Assert.assertEquals(inventario.cantidadDeMetal(), 0);
    }

    @Test
    public void test12ObtenerDiamante() {
        Inventario inventario = new Inventario();

        inventario.agregar(new Diamante());

        Assert.assertNotNull(inventario.obtenerDiamante());
        Assert.assertEquals(inventario.cantidadDeDiamante(), 0);
    }

    @Test(expected = NoHayMaterialEnInventarioException.class)
    public void test13ObtenerDosVecesMaderaYFalla() {
        Inventario inventario = new Inventario();

        inventario.agregar(new Madera());

        inventario.obtenerMadera();
        inventario.obtenerMadera();
    }

    @Test(expected = NoHayMaterialEnInventarioException.class)
    public void test14ObtenerDosVecesPiedraYFalla() {
        Inventario inventario = new Inventario();

        inventario.agregar(new Piedra());

        inventario.obtenerPiedra();
        inventario.obtenerPiedra();
    }

    @Test(expected = NoHayMaterialEnInventarioException.class)
    public void test15ObtenerDosVecesMetalYFalla() {
        Inventario inventario = new Inventario();

        inventario.agregar(new Metal());

        inventario.obtenerMetal();
        inventario.obtenerMetal();
    }

    @Test(expected = NoHayMaterialEnInventarioException.class)
    public void test16ObtenerDosVecesDiamanteYFalla() {
        Inventario inventario = new Inventario();

        inventario.agregar(new Metal());

        inventario.obtenerMetal();
        inventario.obtenerMetal();
    }
}
