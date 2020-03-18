package model.herramientas.desgastes;


public class DesgastePorDivision extends Desgaste {

    private float divisor;

    public DesgastePorDivision(float durabilidad, float divisor) {

        super(durabilidad);
        this.divisor = divisor;
    }

    @Override
    public void desgastar(int fuerza) {
        super.desgastar(fuerza);
        durabilidad -= fuerza / divisor;
    }
}
