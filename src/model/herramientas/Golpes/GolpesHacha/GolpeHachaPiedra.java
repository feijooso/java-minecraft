package model.herramientas.Golpes.GolpesHacha;

import model.herramientas.Golpes.GolpeStrategy;
import model.materiales.Madera;
import model.materiales.Metal;
import model.materiales.Piedra;

public class GolpeHachaPiedra implements GolpeStrategy {

    @Override
    public void golpear(Madera madera, int fuerza) {
        madera.restarDurabilidad(fuerza);
    }

    @Override
    public void golpear(Piedra piedra, int fuerza) {
        //no hace nada
    }

    @Override
    public void golpear(Metal metal, int fuerza) {
        //no hace nada
    }

}
