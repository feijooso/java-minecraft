package construccion;

import Excepciones.NoSePudoContruirHerramientaException;
import model.Construccion.TablaDeContruccion;
import model.herramientas.Herramienta;
import model.herramientas.PicoFino;
import model.materiales.Diamante;
import model.materiales.Madera;
import model.materiales.Metal;
import model.materiales.Piedra;
import org.junit.Assert;
import org.junit.Test;

public class PruebasConstruirPicoFino {

    private static final double RANGO_BASE = 0.1;

    private void insertarMaterialesEnTabla(TablaDeContruccion tablaDeContruccion) {
        Madera madera = new Madera();
        Metal metal = new Metal();
        Piedra piedra = new Piedra();

        tablaDeContruccion.insertar(metal, 0);
        tablaDeContruccion.insertar(metal, 1);
        tablaDeContruccion.insertar(metal, 2);
        tablaDeContruccion.insertar(piedra, 3);
        tablaDeContruccion.insertar(madera, 4);
        tablaDeContruccion.insertar(madera, 7);
    }

    @Test
    public void test01ContruirPicoFinoEsExitoso() {
        TablaDeContruccion tablaDeContruccion = new TablaDeContruccion();
        insertarMaterialesEnTabla(tablaDeContruccion);

        Herramienta herramientaConstruida = tablaDeContruccion.construir();
        PicoFino picoFino = new PicoFino();

        Assert.assertEquals(herramientaConstruida.durabilidad(), picoFino.durabilidad(), RANGO_BASE);
        Assert.assertEquals(herramientaConstruida.fuerza(), picoFino.fuerza(), RANGO_BASE);
    }

    @Test
    public void test02ContruirDosPicosFinosUsarLaPrimeraYLaDurabilidadDeLaSegundaNoEsAfectada() {
        TablaDeContruccion tablaDeContruccion = new TablaDeContruccion();
        Diamante diamante = new Diamante();
        insertarMaterialesEnTabla(tablaDeContruccion);

        Herramienta picoFino1 = tablaDeContruccion.construir();
        Herramienta picoFino2 = tablaDeContruccion.construir();
        float durabilidadPicoFino2 = picoFino2.durabilidad();

        picoFino1.golpear(diamante);

        Assert.assertEquals(picoFino2.durabilidad(), durabilidadPicoFino2, RANGO_BASE);
    }

    @Test(expected = NoSePudoContruirHerramientaException.class)
    public void test03ContruirPicoFinoUtilizandoUnaPiedraEnLaPosicionUnoYFalla() {
        TablaDeContruccion tablaDeContruccion = new TablaDeContruccion();
        Madera madera = new Madera();
        Metal metal = new Metal();
        Piedra piedra = new Piedra();

        tablaDeContruccion.insertar(metal, 0);
        tablaDeContruccion.insertar(piedra, 1);
        tablaDeContruccion.insertar(metal, 2);
        tablaDeContruccion.insertar(piedra, 3);
        tablaDeContruccion.insertar(madera, 4);
        tablaDeContruccion.insertar(madera, 7);

        tablaDeContruccion.construir();
    }

    @Test(expected = NoSePudoContruirHerramientaException.class)
    public void test04ConstruirCualquierCosa() {
        TablaDeContruccion tablaDeContruccion = new TablaDeContruccion();
        Madera madera = new Madera();
        Metal metal = new Metal();
        Piedra piedra = new Piedra();

        tablaDeContruccion.insertar(metal, 0);
        tablaDeContruccion.insertar(piedra, 1);
        tablaDeContruccion.insertar(metal, 2);
        tablaDeContruccion.insertar(piedra, 4);
        tablaDeContruccion.insertar(madera, 6);
        tablaDeContruccion.insertar(madera, 7);

        tablaDeContruccion.construir();
    }

}
