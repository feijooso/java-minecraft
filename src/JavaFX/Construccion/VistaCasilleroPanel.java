package JavaFX.Construccion;

import JavaFX.AlgoCraft;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.jugador.inventario.InventarioMateriales;
import model.materiales.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class VistaCasilleroPanel extends ImageView {

    private List<String> listaMetodos;
    private int contador;
    private Listener listener;
    private int posicion;
    private InventarioMateriales inventarioMateriales;
    private Material materialActual;
    Image imagenCasilleroVacio;

    public VistaCasilleroPanel(Listener listener, int posicion, InventarioMateriales inventarioMateriales) throws FileNotFoundException {
        imagenCasilleroVacio = new Image(new FileInputStream(AlgoCraft.IMAGE_PATH + "cuadradoVacio.png"));
        this.setImage(imagenCasilleroVacio);
        this.setFitHeight(50);
        this.setFitWidth(50);
        contador = -1;
        listaMetodos = new ArrayList<>();
        listaMetodos.add("obtenerMadera");
        listaMetodos.add("obtenerPiedra");
        listaMetodos.add("obtenerMetal");
        listaMetodos.add("obtenerDiamante");

        this.listener = listener;
        this.posicion = posicion;
        this.inventarioMateriales = inventarioMateriales;

        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cambiarImagen();
            }
        });
    }

    private void cambiarImagen() {
        contador++;

        if (materialActual != null) {
            inventarioMateriales.agregar(materialActual);
            materialActual = null;
        }

        try {
            Method obtenerMaterial = inventarioMateriales.getClass().getMethod(listaMetodos.get(contador));
            Material materialObtenido = (Material) obtenerMaterial.invoke(inventarioMateriales, null);
            setImage(new Image(new FileInputStream(materialObtenido.imagen())));
            materialActual = materialObtenido;
            listener.materialAgregado(materialObtenido, posicion);
        } catch (InvocationTargetException e) {
            cambiarImagen();
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException | FileNotFoundException e) {
            contador = -1;
            setImage(imagenCasilleroVacio);
            listener.removerMaterial(posicion);
            materialActual = null;

        }
    }

    public interface Listener {
        void materialAgregado(Material material, int posicion);
        void removerMaterial(int posicion);
    }

    void limpiar() {
        materialActual = null;
        contador = -1;
        setImage(imagenCasilleroVacio);
        listener.removerMaterial(posicion);
    }

    Material obtenerMaterialActual() {
        return materialActual;
    }
}
