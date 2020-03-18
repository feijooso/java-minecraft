package Excepciones;

import model.materiales.Material;

public class MaterialDestruidoException extends NullPointerException {

    private Material material;

    public MaterialDestruidoException(Material material) {
        this.material = material;
    }

    public Material obtenerMaterialDestruido() {
        return material;
    }

}
