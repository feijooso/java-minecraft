package model.herramientas;

import model.herramientas.desgastes.DesgastePorMultiplicacion;
import model.jugador.inventario.InventarioHerramientas;
import model.materiales.*;

public class PicoFino extends Herramienta {

    public PicoFino(){
        fuerza = 20;
        desgaste = new DesgastePorMultiplicacion(1000,0.1f);
    }

    @Override
    public void golpear(Madera madera) {
        madera.restarDurabilidad(fuerza);
    }

    @Override
    public void golpear(Piedra piedra) {
        piedra.restarDurabilidad(fuerza);
    }

    @Override
    public void golpear(Metal metal) {
        metal.restarDurabilidad(fuerza);
    }

    @Override
    public void golpear(Material material) {
        material.esGolpeadoPor(this);
    }

    @Override
    public void agregarse(InventarioHerramientas inventario) {
        inventario.agregarPicoFino(this);
    }

    @Override
    public String getClassName(){
        return this.getClass().getSimpleName();
    }
}
