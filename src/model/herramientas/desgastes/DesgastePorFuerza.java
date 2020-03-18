package model.herramientas.desgastes;

public class DesgastePorFuerza extends Desgaste {

    public DesgastePorFuerza(float durabilidad) {
        super(durabilidad);
    }

    @Override
    public void desgastar(int fuerza) {
        super.desgastar(fuerza);
        durabilidad -= fuerza;
    }
}
