package model.herramientas;

import JavaFX.AlgoCraft;
import model.herramientas.desgastes.Desgaste;
import model.jugador.inventario.InventarioHerramientas;
import model.materiales.Madera;
import model.materiales.Material;
import model.materiales.Metal;
import model.materiales.Piedra;

public abstract class Herramienta {

    protected int fuerza;
    protected Desgaste desgaste;

    public int fuerza() {
        return fuerza;
    }

    public float durabilidad() {
        return desgaste.durabilidad();
    }

    public void golpear(Material material) {
        material.esGolpeadoPor(this);
    }

    public void restarDurabilidad() {
        desgaste.desgastar(fuerza);
    }

    public abstract void golpear(Madera madera);
    public abstract void golpear(Piedra piedra);
    public abstract void golpear(Metal metal);

    public abstract void agregarse(InventarioHerramientas inventario);

    public String getImage() {
        return AlgoCraft.IMAGE_PATH + getClassName() + ".png";
    }

    public abstract String getClassName();

}
