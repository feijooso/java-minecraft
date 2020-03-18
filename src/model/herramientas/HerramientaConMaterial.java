package model.herramientas;

import model.herramientas.Golpes.GolpeStrategy;
import model.materiales.*;

public abstract class HerramientaConMaterial extends Herramienta {

    protected Material material;
    protected GolpeStrategy golpe;

    HerramientaConMaterial(Material material) {
        this.material = material;
    }

    public Material material() {
        return material;
    }

}
