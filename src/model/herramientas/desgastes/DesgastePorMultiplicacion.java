package model.herramientas.desgastes;


public class DesgastePorMultiplicacion extends Desgaste {

    private float multiplicante;

    public DesgastePorMultiplicacion(float durabilidad, float multiplicante) {

        super(durabilidad);
        this.multiplicante = multiplicante;
    }

    @Override
    public void desgastar(int fuerza) {
        super.desgastar(fuerza);
        durabilidad -= durabilidad * multiplicante;
    }

}
