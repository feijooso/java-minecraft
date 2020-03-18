package model.herramientas.desgastes;

import Excepciones.HerramientaGastadaException;

public abstract class Desgaste {

    float durabilidad;

    public Desgaste(float durabilidad) {
        this.durabilidad = durabilidad;
    }

    public float durabilidad() {
        return durabilidad;
    }

    public void desgastar(int fuerza) {
        if (durabilidad <= 0)
            throw new HerramientaGastadaException();
    }
}
