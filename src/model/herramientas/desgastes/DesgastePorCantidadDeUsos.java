package model.herramientas.desgastes;


public class DesgastePorCantidadDeUsos extends Desgaste {

    private int contador;

    public DesgastePorCantidadDeUsos(float durabilidad, int contador) {
        super(durabilidad);
        this.contador = contador;
    }

    @Override
    public void desgastar(int fuerza) {
        super.desgastar(fuerza);
        contador--;
        if (contador <= 0) {
            durabilidad = 0;
        }
    }
}
