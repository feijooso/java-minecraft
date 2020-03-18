package model.herramientas;

import model.jugador.inventario.InventarioHerramientas;
import model.materiales.*;

public class Pico extends HerramientaConMaterial {

    public Pico(Material material) {
        super(material);
        fuerza = material.fuerzaEn(this);
        golpe = material.fabricar(this);
        desgaste = material.tipoDeDesgaste(this);
    }

    @Override
    public void golpear(Material material) {
        material.esGolpeadoPor(this);
    }

    @Override
    public void golpear(Madera madera) {
        restarDurabilidad();
        golpe.golpear(madera, fuerza);
    }

    @Override
    public void golpear(Piedra piedra) {
        restarDurabilidad();
        golpe.golpear(piedra, fuerza);
    }

    @Override
    public void golpear(Metal metal) {
        restarDurabilidad();
        golpe.golpear(metal, fuerza);
    }

    @Override
    public void agregarse(InventarioHerramientas inventario) {
        inventario.agregar(this);
    }

    @Override
    public String getClassName(){
        return this.getClass().getSimpleName()+this.material.getClass().getSimpleName();
    }
}
