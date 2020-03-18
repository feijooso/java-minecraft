package construccion;

import Excepciones.NoSePudoContruirHerramientaException;
import model.Construccion.TablaDeContruccion;
import model.herramientas.Herramienta;
import model.herramientas.Pico;
import model.materiales.Madera;
import model.materiales.Material;
import model.materiales.Metal;
import model.materiales.Piedra;
import org.junit.Assert;
import org.junit.Test;

public class PruebasConstruirPico {

    private static final double RANGO_BASE = 0.1;

    private void insertarMaterialesEnTabla(TablaDeContruccion tablaDeContruccion, Material material) {
        Madera madera = new Madera();
        tablaDeContruccion.insertar(material, 0);
        tablaDeContruccion.insertar(material, 1);
        tablaDeContruccion.insertar(material, 2);
        tablaDeContruccion.insertar(madera, 4);
        tablaDeContruccion.insertar(madera, 7);
    }

    @Test
    public void test01ContruirPicoDeMaderaExistosa() {
        TablaDeContruccion tablaDeContruccion = new TablaDeContruccion();
        Madera madera = new Madera();
        insertarMaterialesEnTabla(tablaDeContruccion, madera);

        Herramienta herramienta = tablaDeContruccion.construir();
        Pico pico = new Pico(madera);

        Assert.assertEquals(herramienta.durabilidad(), madera.durabilidadEn(pico), RANGO_BASE);
        Assert.assertEquals(herramienta.fuerza(), madera.fuerzaEn(pico), RANGO_BASE);

    }

    @Test
    public void test02ContruirHachaDePiedraExistosa() {
        TablaDeContruccion tablaDeContruccion = new TablaDeContruccion();
        Piedra piedra = new Piedra();
        Pico pico = new Pico(piedra);
        insertarMaterialesEnTabla(tablaDeContruccion, piedra);
        Herramienta herramientaConstruida = tablaDeContruccion.construir();

        Assert.assertEquals(herramientaConstruida.durabilidad(), piedra.durabilidadEn(pico), RANGO_BASE);
        Assert.assertEquals(herramientaConstruida.fuerza(), piedra.fuerzaEn(pico), RANGO_BASE);
    }

    @Test
    public void test03ContruirHachaDeMetalExistosa() {
        TablaDeContruccion tablaDeContruccion = new TablaDeContruccion();
        Metal metal = new Metal();
        Pico pico = new Pico(metal);

        insertarMaterialesEnTabla(tablaDeContruccion, metal);
        Herramienta herramientaConstruida = tablaDeContruccion.construir();

        Assert.assertEquals(herramientaConstruida.durabilidad(), metal.durabilidadEn(pico), RANGO_BASE);
        Assert.assertEquals(herramientaConstruida.fuerza(), metal.fuerzaEn(pico), RANGO_BASE);
    }

    @Test
    public void test04ContruirDosHachasDeMaderaUsarLaPrimeraYLaDurabilidadDeLaSegundaNoEsAfectada() {
        TablaDeContruccion tablaDeContruccion = new TablaDeContruccion();
        Madera madera = new Madera();
        tablaDeContruccion.insertar(madera, 0);
        tablaDeContruccion.insertar(madera, 1);
        tablaDeContruccion.insertar(madera, 2);
        tablaDeContruccion.insertar(madera, 4);
        tablaDeContruccion.insertar(madera, 7);

        Herramienta pico1 = tablaDeContruccion.construir();
        Herramienta pico2 = tablaDeContruccion.construir();
        float durabilidadPico2 = pico2.durabilidad();

        pico1.golpear(madera);

        Assert.assertEquals(pico2.durabilidad(), durabilidadPico2, RANGO_BASE);
    }

    @Test(expected = NoSePudoContruirHerramientaException.class)
    public void test05ContruirUnHachaDeMaderaUtilizandoUnaPiedraEnLaPosicionUnoYFalla() {
        TablaDeContruccion tablaDeContruccion = new TablaDeContruccion();
        Madera madera = new Madera();

        tablaDeContruccion.insertar(madera, 0);
        tablaDeContruccion.insertar(new Piedra(), 1);
        tablaDeContruccion.insertar(madera, 2);
        tablaDeContruccion.insertar(madera, 4);
        tablaDeContruccion.insertar(madera, 7);

        tablaDeContruccion.construir();
    }

}
