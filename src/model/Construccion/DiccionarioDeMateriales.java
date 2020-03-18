package model.Construccion;

import model.materiales.Madera;
import model.materiales.Material;
import model.materiales.Metal;
import model.materiales.Piedra;

import java.util.HashMap;

/**
 * Por la manera en como implementamos las herramientas, estamos necesitando un material para inicalizarla. Por lo que note, El elemento en la posicion 1 de la lista
 * es quien puede llegar a definir el material de la herramienta.
 * La idea es inicializar un material dependiendo lo que haya puesto en esa posicion.
 * +------+------+------+
 * | Wood | Wood |   _  |
 * +------+------+------+
 * | Wood | Wood |   _  |
 * +------+------+------+
 * |   _  | Wood |   _  |
 * +------+------+------+
 */
public class DiccionarioDeMateriales {

    private HashMap<String, Class<Material>> diccionario;

    public DiccionarioDeMateriales() {
        diccionario = new HashMap<>();
        agregarMaterial(Madera.TAG, Madera.class);
        agregarMaterial(Piedra.TAG, Piedra.class);
        agregarMaterial(Metal.TAG, Metal.class);
    }

    private void agregarMaterial(String key, Class material) {
        diccionario.put(key, material);
    }

    public Material construir(String key) throws InstantiationException, IllegalAccessException {
        return diccionario.get(key).newInstance();
    }
}
