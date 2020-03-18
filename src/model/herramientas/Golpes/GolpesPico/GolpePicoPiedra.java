package model.herramientas.Golpes.GolpesPico;

import model.herramientas.Golpes.GolpeStrategy;
import model.materiales.Madera;
import model.materiales.Metal;
import model.materiales.Piedra;

public class GolpePicoPiedra implements GolpeStrategy {

    @Override
    public void golpear(Madera madera, int fuerza) {
        //nada para hacer
    }

    @Override
    public void golpear(Piedra piedra, int fuerza) {
        piedra.restarDurabilidad(fuerza);
    }

    @Override
    public void golpear(Metal metal, int fuerza) {
        metal.restarDurabilidad(fuerza);
    }
}
