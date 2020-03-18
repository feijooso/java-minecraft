package model.Construccion;

import Excepciones.NoSePudoContruirHerramientaException;
import model.herramientas.Hacha;
import model.herramientas.Herramienta;
import model.herramientas.Pico;
import model.herramientas.PicoFino;
import model.materiales.Madera;
import model.materiales.Material;
import model.materiales.Metal;
import model.materiales.Piedra;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/******************
 * +------+------+------+
 * | Wood | Wood |   _  |
 * +------+------+------+
 * | Wood | Wood |   _  |
 * +------+------+------+
 * |   _  | Wood |   _  |
 * +------+------+------+
 *
 * +------+------+------+
 * |  0   |  1   |  2   |
 * +------+------+------+
 * |  3   |  4   |  5   |
 * +------+------+------+
 * |  6   |  7   |  8   |
 * +------+------+------+
 *
 *****************/

public class DiccionarioDeHerramientas {

    private final String HACHA_MADERA =
            Madera.TAG + Madera.TAG + SEP
            + Madera.TAG + Madera.TAG + SEP
            + SEP + Madera.TAG + SEP;
    private final String HACHA_PIEDRA =
            Piedra.TAG + Piedra.TAG + SEP
            + Piedra.TAG + Madera.TAG + SEP
            + SEP + Madera.TAG + SEP;
    private final String HACHA_METAL =
            Metal.TAG + Metal.TAG + SEP
            + Metal.TAG + Madera.TAG + SEP
            + SEP + Madera.TAG + SEP;

    private final String HACHA_MADERA_2 =
            SEP + Madera.TAG + Madera.TAG
            + SEP + Madera.TAG + Madera.TAG
            + SEP + SEP + Madera.TAG;
    private final String HACHA_PIEDRA_2 =
            SEP + Piedra.TAG + Piedra.TAG
            + SEP + Piedra.TAG + Madera.TAG
            + SEP + SEP + Madera.TAG;
    private final String HACHA_METAL_2 =
            SEP + Metal.TAG + Metal.TAG
            + SEP + Metal.TAG + Madera.TAG
            + SEP + SEP + Madera.TAG;

    private final String PICO_MADERA =
            Madera.TAG + Madera.TAG + Madera.TAG
            + SEP + Madera.TAG + SEP
            + SEP + Madera.TAG + SEP;
    private final String PICO_PIEDRA =
            Piedra.TAG + Piedra.TAG + Piedra.TAG
            + SEP + Madera.TAG + SEP
            + SEP + Madera.TAG + SEP;
    private final String PICO_METAL =
            Metal.TAG + Metal.TAG + Metal.TAG
            + SEP + Madera.TAG + SEP
            + SEP + Madera.TAG + SEP;

    private final String PICO_FINO =
            Metal.TAG + Metal.TAG + Metal.TAG
            + Piedra.TAG + Madera.TAG + SEP
            + SEP + Madera.TAG + SEP;

    public static final String SEP = "_";

    private HashMap<String, Class<Herramienta>> diccionario;
    private DiccionarioDeMateriales diccionarioDeMateriales;

    public DiccionarioDeHerramientas() {
        diccionario = new HashMap<>();

        agregarHerramienta(HACHA_MADERA, Hacha.class);
        agregarHerramienta(HACHA_PIEDRA, Hacha.class);
        agregarHerramienta(HACHA_METAL, Hacha.class);
        agregarHerramienta(HACHA_MADERA_2, Hacha.class);
        agregarHerramienta(HACHA_PIEDRA_2, Hacha.class);
        agregarHerramienta(HACHA_METAL_2, Hacha.class);
        agregarHerramienta(PICO_MADERA, Pico.class);
        agregarHerramienta(PICO_PIEDRA, Pico.class);
        agregarHerramienta(PICO_METAL, Pico.class);
        agregarHerramienta(PICO_FINO, PicoFino.class);

        diccionarioDeMateriales = new DiccionarioDeMateriales();
    }

    //Por algun motivo no me permite agregar hacer diccionario.put(key, Hacha.class) asi que cree este metodo para no tener que estar casteando
    private void agregarHerramienta(String key, Class herramienta) {
        diccionario.put(key, herramienta);
    }

    public Herramienta construir(String herramientaKey, String materialKey) {
        try {
            return diccionario.get(herramientaKey).getDeclaredConstructor(Material.class).newInstance(diccionarioDeMateriales.construir(materialKey));
        } catch (NoSuchMethodException e) {
            try {
                return diccionario.get(herramientaKey).newInstance();   //pruebo que sea el pico fino.
            } catch (IllegalAccessException | InstantiationException f) {
                throw new NoSePudoContruirHerramientaException();
            }
        } catch (NullPointerException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new NoSePudoContruirHerramientaException();
        }
    }

}
