package jugador;

import model.mapa.Posicion;
import org.junit.Assert;
import org.junit.Test;
import model.herramientas.*;
import model.materiales.*;
import model.jugador.Jugador;

public class PruebasJugador {
    /*
    El objetivo de todas estas pruebas en su conjunto es probar que el jugador efectivamente comienza con un
    Hacha de madera equipada. Por ello se usa Herramienta en lugar de Hacha.
     */

    private static final double RANGO_BASE = 0.1;

    @Test
    public void test01JugadorComienzaConHerramientaCuyaDurabilidadDeberiaSerDeUnHachaDeMadera() {

        Posicion posicion = new Posicion(1,1);
        Jugador jugador = new Jugador(posicion);
        Herramienta herramienta = jugador.obtenerHerramientaEquipada();
        Hacha hachaMadera = new Hacha(new Madera());

        Assert.assertEquals(herramienta.durabilidad(), hachaMadera.durabilidad(), RANGO_BASE);
    }

    @Test
    public void test02JugadorComienzaConHerramientaCuyaFuerzaDeberiaSerDeUnHachaDeMadera() {

        Posicion posicion = new Posicion(1,1);
        Jugador jugador = new Jugador(posicion);
        Herramienta herramienta = jugador.obtenerHerramientaEquipada();
        Hacha hachaMadera = new Hacha(new Madera());

        Assert.assertEquals(herramienta.fuerza(), hachaMadera.fuerza());
    }

    @Test
    public void test03JugadorComienzaConHerramientaQueSeDesgastaComoUnHachaDeMaderaAlUsarseSobreMadera() {

        Posicion posicion = new Posicion(1,1);
        Jugador jugador = new Jugador(posicion);
        Madera bloqueMadera = new Madera();
        Herramienta herramienta = jugador.obtenerHerramientaEquipada();
        Hacha hachaMadera = new Hacha(new Madera());
        float durabilidadHerramienta = herramienta.durabilidad();

        jugador.usarHerramientaEquipadaSobre(bloqueMadera);

        Assert.assertEquals(herramienta.durabilidad(), durabilidadHerramienta - hachaMadera.fuerza(), RANGO_BASE);
    }

    @Test
    public void test04JugadorComienzaConHerramientaQueSeDesgastaComoUnHachaDeMaderaAlUsarseSobrePiedra() {

        Posicion posicion = new Posicion(1,1);
        Jugador jugador = new Jugador(posicion);
        Piedra bloquePiedra = new Piedra();
        Herramienta herramienta = jugador.obtenerHerramientaEquipada();
        Hacha hachaMadera = new Hacha(new Madera());
        float durabilidadHerramienta = herramienta.durabilidad();

        jugador.usarHerramientaEquipadaSobre(bloquePiedra);

        Assert.assertEquals(herramienta.durabilidad(), durabilidadHerramienta - hachaMadera.fuerza(), RANGO_BASE);
    }

    @Test
    public void test05JugadorComienzaConHerramientaQueSeDesgastaComoUnHachaDeMaderaAlUsarseSobreMetal() {

        Posicion posicion = new Posicion(1,1);
        Jugador jugador = new Jugador(posicion);
        Metal bloqueMetal = new Metal();
        Herramienta herramienta = jugador.obtenerHerramientaEquipada();
        Hacha hachaMadera = new Hacha(new Madera());
        float durabilidadHerramienta = herramienta.durabilidad();

        jugador.usarHerramientaEquipadaSobre(bloqueMetal);

        Assert.assertEquals(herramienta.durabilidad(), durabilidadHerramienta - hachaMadera.fuerza(), RANGO_BASE);
    }

    @Test
    public void test06JugadorComienzaConHerramientaQueAlUsarseSobreMaderaLaDesgastaComoSiFueraUnHachaDeMadera() {

        Posicion posicion = new Posicion(1,1);
        Jugador jugador = new Jugador(posicion);
        Madera bloqueMadera = new Madera();
        Hacha hachaMadera = new Hacha(new Madera());
        int durabilidadBloqueMadera = bloqueMadera.durabilidad();

        jugador.usarHerramientaEquipadaSobre(bloqueMadera);

        Assert.assertEquals(bloqueMadera.durabilidad(), durabilidadBloqueMadera - hachaMadera.fuerza());
    }

    @Test
    public void test07JugadorComienzaConHerramientaQueAlUsarseSobrePiedraNoLaDesgastaComoSiFueraUnHachaDeMadera() {

        Posicion posicion = new Posicion(1,1);
        Jugador jugador = new Jugador(posicion);
        Piedra bloquePiedra = new Piedra();
        int durabilidadBloquePiedra = bloquePiedra.durabilidad();

        jugador.usarHerramientaEquipadaSobre(bloquePiedra);

        Assert.assertEquals(bloquePiedra.durabilidad(), durabilidadBloquePiedra);
    }

    @Test
    public void test08JugadorComienzaConHerramientaQueAlUsarseSobreMetalNoLaDesgastaComoSiFueraUnHachaDeMadera() {

        Posicion posicion = new Posicion(1,1);
        Jugador jugador = new Jugador(posicion);
        Metal bloqueMetal = new Metal();
        int durabilidadBloqueMetal = bloqueMetal.durabilidad();

        jugador.usarHerramientaEquipadaSobre(bloqueMetal);

        Assert.assertEquals(bloqueMetal.durabilidad(), durabilidadBloqueMetal);
    }

    @Test
    public void test09JugadorComienzaEnFilaCorrecta(){

        Posicion posicion = new Posicion(1,1);
        Jugador jugador = new Jugador(posicion);
        Posicion posActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicion.getDireccionFila(), posActual.getDireccionFila());

    }

    @Test
    public void test10JugadorComienzaEnColumnaCorrecta(){

        Posicion posicion = new Posicion(1,1);
        Jugador jugador = new Jugador(posicion);
        Posicion posActual = jugador.obtenerPosicionActual();

        Assert.assertEquals(posicion.getDireccionColumna(), posActual.getDireccionColumna());

    }

    @Test
    public void test11JugadorCambiaFila(){

        Posicion posicion = new Posicion(1,1);
        Jugador jugador = new Jugador(posicion);
        jugador.cambiarPosicion(new Posicion(2,2));
        Posicion posNueva = jugador.obtenerPosicionActual();

        Assert.assertEquals(2, posNueva.getDireccionFila());

    }

    @Test
    public void test12JugadorCambiaColumna(){

        Posicion posicion = new Posicion(1,1);
        Jugador jugador = new Jugador(posicion);
        jugador.cambiarPosicion(new Posicion(2,2));
        Posicion posNueva = jugador.obtenerPosicionActual();

        Assert.assertEquals(2, posNueva.getDireccionColumna());

    }

    @Test
    public void test13JugadorDevuelvePosicionAlNorte(){

        Jugador jugador = new Jugador (new Posicion(2,2));

        Posicion posNorte = jugador.obtenerPosicionAlNorte();

        Assert.assertEquals(1, posNorte.getDireccionFila());

    }

    @Test
    public void test14JugadorDevuelvePosicionAlSur(){

        Jugador jugador = new Jugador (new Posicion(2,2));

        Posicion posSur = jugador.obtenerPosicionAlSur();

        Assert.assertEquals(3, posSur.getDireccionFila());

    }

    @Test
    public void test15JugadorDevuelvePosicionAlEste(){

        Jugador jugador = new Jugador (new Posicion(2,2));

        Posicion posEste = jugador.obtenerPosicionAlEste();

        Assert.assertEquals(3, posEste.getDireccionColumna());

    }

    @Test
    public void test16JugadorDevuelvePosicionAlOeste(){

        Jugador jugador = new Jugador (new Posicion(2,2));

        Posicion posOeste = jugador.obtenerPosicionAlOeste();

        Assert.assertEquals(1, posOeste.getDireccionColumna());

    }

    @Test
    public void test17JugadorComienzaConPosicionDeAtaqueEnFilaCorrecta(){

        Jugador jugador = new Jugador(new Posicion(1,1));

        Assert.assertEquals(1, jugador.obtenerPosicionAtaque().getDireccionFila());

    }

    @Test
    public void test18JugadorComienzaConPosicionDeAtaqueEnColumnaCorrecta(){

        Jugador jugador = new Jugador(new Posicion(1,1));

        Assert.assertEquals(2, jugador.obtenerPosicionAtaque().getDireccionColumna());

    }

    @Test
    public void test19JugadorSeMueveYCambiaPosicionDeAtaque(){

        Jugador jugador = new Jugador(new Posicion(1,1));

        jugador.cambiarPosicion(new Posicion(1,2));

        Assert.assertEquals(3,jugador.obtenerPosicionAtaque().getDireccionColumna());

    }
}
