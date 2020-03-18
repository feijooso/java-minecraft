package model.herramientas;

import JavaFX.AlgoCraft;
import model.jugador.inventario.InventarioHerramientas;
import model.materiales.Madera;
import model.materiales.Material;
import model.materiales.Metal;
import model.materiales.Piedra;

public class HerramientaRota extends Herramienta {

    @Override
    public float durabilidad() {
        return 0;
    }

    @Override
    public int fuerza() {
        return 0;
    }

    @Override
    public void restarDurabilidad() {

    }

    @Override
    public void golpear(Material material) {

    }

    @Override
    public void golpear(Madera madera) {

    }

    @Override
    public void golpear(Piedra piedra) {

    }

    @Override
    public void golpear(Metal metal) {

    }

    @Override
    public void agregarse(InventarioHerramientas inventario) {

    }

    @Override
    public String getClassName() {
        return null;
    }

    @Override
    public String getImage() {
        return AlgoCraft.IMAGE_PATH + "rota.png";
    }
}
