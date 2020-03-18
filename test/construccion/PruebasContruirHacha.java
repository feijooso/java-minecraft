package construccion;

import Excepciones.NoSePudoContruirHerramientaException;
import model.Construccion.TablaDeContruccion;
import model.herramientas.Hacha;
import model.herramientas.Herramienta;
import model.materiales.Madera;
import model.materiales.Material;
import model.materiales.Metal;
import model.materiales.Piedra;
import org.junit.Assert;
import org.junit.Test;

public class PruebasContruirHacha {

    private static final double RANGO_BASE = 0.1;

    private void insertarMaterialesEnTabla(TablaDeContruccion tablaDeContruccion, Material material) {
        Madera madera = new Madera();
        tablaDeContruccion.insertar(material, 0);
        tablaDeContruccion.insertar(material, 1);
        tablaDeContruccion.insertar(material, 3);
        tablaDeContruccion.insertar(madera, 4);
        tablaDeContruccion.insertar(madera, 7);
    }

    @Test
    public void test01ContruirHachaDeMaderaExistosa() {
        TablaDeContruccion tablaDeContruccion = new TablaDeContruccion();
        Madera madera = new Madera();

        insertarMaterialesEnTabla(tablaDeContruccion, madera);
        Herramienta herramientaConstruida = tablaDeContruccion.construir();
        Hacha hacha = new Hacha(madera);

        Assert.assertEquals(herramientaConstruida.durabilidad(), madera.durabilidadEn(hacha), RANGO_BASE);
        Assert.assertEquals(herramientaConstruida.fuerza(), madera.fuerzaEn(hacha), RANGO_BASE);
    }

    @Test
    public void test02ContruirHachaDePiedraExistosa() {
        TablaDeContruccion tablaDeContruccion = new TablaDeContruccion();
        Piedra piedra = new Piedra();

        insertarMaterialesEnTabla(tablaDeContruccion, piedra);
        Herramienta herramientaConstruida = tablaDeContruccion.construir();
        Hacha hacha = new Hacha(piedra);

        Assert.assertEquals(herramientaConstruida.durabilidad(), piedra.durabilidadEn(hacha), RANGO_BASE);
        Assert.assertEquals(herramientaConstruida.fuerza(), piedra.fuerzaEn(hacha), RANGO_BASE);
    }

    @Test
    public void test03ContruirHachaDeMetalExistosa() {
        TablaDeContruccion tablaDeContruccion = new TablaDeContruccion();
        Metal metal = new Metal();

        insertarMaterialesEnTabla(tablaDeContruccion, metal);
        Herramienta herramientaConstruida = tablaDeContruccion.construir();
        Hacha hacha = new Hacha(metal);

        Assert.assertEquals(herramientaConstruida.durabilidad(), metal.durabilidadEn(hacha), RANGO_BASE);
        Assert.assertEquals(herramientaConstruida.fuerza(), metal.fuerzaEn(hacha), RANGO_BASE);
    }

    @Test
    public void test04ContruirDosHachasDeMaderaUsarLaPrimeraYLaDurabilidadDeLaSegundaNoEsAfectada() {
        TablaDeContruccion tablaDeContruccion = new TablaDeContruccion();
        Madera madera = new Madera();
        tablaDeContruccion.insertar(madera, 0);
        tablaDeContruccion.insertar(madera, 1);
        tablaDeContruccion.insertar(madera, 3);
        tablaDeContruccion.insertar(madera, 4);
        tablaDeContruccion.insertar(madera, 7);

        Herramienta hacha1 = tablaDeContruccion.construir();
        Herramienta hacha2 = tablaDeContruccion.construir();
        float durabilidadHacha2 = hacha2.durabilidad();

        hacha1.golpear(madera);

        Assert.assertEquals(hacha2.durabilidad(), durabilidadHacha2, RANGO_BASE);
    }

    @Test(expected = NoSePudoContruirHerramientaException.class)
    public void test05ContruirUnHachaDeMaderaUtilizandoUnaPiedraEnLaPosicionUnoYFalla() {
        TablaDeContruccion tablaDeContruccion = new TablaDeContruccion();
        Madera madera = new Madera();

        tablaDeContruccion.insertar(madera, 0);
        tablaDeContruccion.insertar(new Piedra(), 1);
        tablaDeContruccion.insertar(madera, 3);
        tablaDeContruccion.insertar(madera, 4);
        tablaDeContruccion.insertar(madera, 7);

        tablaDeContruccion.construir();
    }

    @Test
    public void test06ContruirHachaDeMadera_2_Existosa() {
        TablaDeContruccion tablaDeContruccion = new TablaDeContruccion();
        Madera madera = new Madera();
        Hacha hacha = null;

        tablaDeContruccion.insertar(madera, 1);
        tablaDeContruccion.insertar(madera, 2);
        tablaDeContruccion.insertar(madera, 4);
        tablaDeContruccion.insertar(madera, 5);
        tablaDeContruccion.insertar(madera, 8);

        Herramienta elementoContruido = tablaDeContruccion.construir();
        Assert.assertTrue(elementoContruido instanceof Hacha);
        hacha = (Hacha) elementoContruido;
        Assert.assertTrue(hacha.material() instanceof Madera);
    }

    @Test
    public void test07ContruirHachaDePiedra_2_Existosa() {
        TablaDeContruccion tablaDeContruccion = new TablaDeContruccion();
        Piedra piedra = new Piedra();
        Madera madera = new Madera();
        Hacha hacha = null;

        tablaDeContruccion.insertar(piedra, 1);
        tablaDeContruccion.insertar(piedra, 2);
        tablaDeContruccion.insertar(piedra, 4);
        tablaDeContruccion.insertar(madera, 5);
        tablaDeContruccion.insertar(madera, 8);

        Herramienta elementoContruido = tablaDeContruccion.construir();
        Assert.assertTrue(elementoContruido instanceof Hacha);
        hacha = (Hacha) elementoContruido;
        Assert.assertTrue(hacha.material() instanceof Piedra);
    }

    @Test
    public void test08ContruirHachaDeMetal_2_Existosa() {
        TablaDeContruccion tablaDeContruccion = new TablaDeContruccion();
        Metal metal = new Metal();
        Madera madera = new Madera();
        Hacha hacha = null;

        tablaDeContruccion.insertar(metal, 1);
        tablaDeContruccion.insertar(metal, 2);
        tablaDeContruccion.insertar(metal, 4);
        tablaDeContruccion.insertar(madera, 5);
        tablaDeContruccion.insertar(madera, 8);

        Herramienta elementoContruido = tablaDeContruccion.construir();
        Assert.assertTrue(elementoContruido instanceof Hacha);
        hacha = (Hacha) elementoContruido;
        Assert.assertTrue(hacha.material() instanceof Metal);
    }

    @Test(expected = NoSePudoContruirHerramientaException.class)
    public void test09NoSePuedeContruirHachaMaderaUnoYDos() {
        TablaDeContruccion tablaDeContruccion = new TablaDeContruccion();
        Madera madera = new Madera();

        tablaDeContruccion.insertar(madera, 0);
        tablaDeContruccion.insertar(madera, 1);
        tablaDeContruccion.insertar(madera, 2);
        tablaDeContruccion.insertar(madera, 3);
        tablaDeContruccion.insertar(madera, 4);
        tablaDeContruccion.insertar(madera, 5);
        tablaDeContruccion.insertar(madera, 8);

        tablaDeContruccion.construir();
    }
}
