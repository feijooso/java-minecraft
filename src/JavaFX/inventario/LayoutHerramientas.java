package JavaFX.inventario;

import javafx.scene.layout.HBox;
import model.herramientas.Hacha;
import model.herramientas.Herramienta;
import model.herramientas.Pico;
import model.herramientas.PicoFino;
import model.jugador.inventario.InventarioHerramientas;
import model.materiales.Madera;
import model.materiales.Metal;
import model.materiales.Piedra;

public class LayoutHerramientas extends HBox implements VistaHerramienta.Listener{

    private Listener listener;
    private InventarioHerramientas inventarioHerramientas;
    private VistaHerramienta vistaHachaMadera;
    private VistaHerramienta vistaHachaMetal;
    private VistaHerramienta vistaHachaPiedra;
    private VistaHerramienta vistaPicoMadera;
    private VistaHerramienta vistaPicoPiedra;
    private VistaHerramienta vistaPicoMetal;
    private VistaHerramienta vistaPicoFino;

    public LayoutHerramientas(InventarioHerramientas inventarioHerramientas) throws Exception{
        this.inventarioHerramientas = inventarioHerramientas;
        vistaHachaMadera = new VistaHerramienta(new Hacha(new Madera()), new HerramientaSeleccionada() {
            @Override
            public void seleccionar() {
                listener.heramientaClickeada(inventarioHerramientas.obtenerHachaMadera());
            }
        });
        vistaHachaMetal = new VistaHerramienta(new Hacha(new Metal()), new HerramientaSeleccionada() {
            @Override
            public void seleccionar() {
                listener.heramientaClickeada(inventarioHerramientas.obtenerHachaMadera());
            }
        });
        vistaHachaPiedra = new VistaHerramienta(new Hacha(new Piedra()), new HerramientaSeleccionada() {
            @Override
            public void seleccionar() {
                listener.heramientaClickeada(inventarioHerramientas.obtenerHachaPiedra());
            }
        });
        vistaPicoMadera = new VistaHerramienta(new Pico(new Madera()), new HerramientaSeleccionada() {
            @Override
            public void seleccionar() {
                listener.heramientaClickeada(inventarioHerramientas.obtenerPicoMadera());
            }
        });
        vistaPicoMetal = new VistaHerramienta(new Pico(new Metal()), new HerramientaSeleccionada() {
            @Override
            public void seleccionar() {
                listener.heramientaClickeada(inventarioHerramientas.obtenerPicoMetal());
            }
        });
        vistaPicoPiedra = new VistaHerramienta(new Pico(new Piedra()),  new HerramientaSeleccionada() {
            @Override
            public void seleccionar() {
                listener.heramientaClickeada(inventarioHerramientas.obtenerPicoPiedra());
            }
        });
        vistaPicoFino = new VistaHerramienta(new PicoFino(), new HerramientaSeleccionada() {
            @Override
            public void seleccionar() {
                listener.heramientaClickeada(inventarioHerramientas.obtenerPicoFino());
            }
        });
        actualizar();
    }

    public void setListener (Listener listener) {
        this.listener = listener;
    }

    public void actualizar() {
        getChildren().removeAll(vistaHachaMadera, vistaHachaMetal, vistaHachaPiedra, vistaPicoMadera, vistaPicoMetal, vistaPicoPiedra, vistaPicoFino);
        vistaHachaMadera.agregarseEnLayout(this, inventarioHerramientas.cantidadHachaMadera());
        vistaHachaMetal.agregarseEnLayout(this, inventarioHerramientas.cantidadHachaMetal());
        vistaHachaPiedra.agregarseEnLayout(this, inventarioHerramientas.cantidadHachaPiedra());
        vistaPicoMadera.agregarseEnLayout(this, inventarioHerramientas.cantidadPicoMadera());
        vistaPicoMetal.agregarseEnLayout(this, inventarioHerramientas.cantidadPicoMetal());
        vistaPicoPiedra.agregarseEnLayout(this, inventarioHerramientas.cantidadPicoPiedra());
        vistaPicoFino.agregarseEnLayout(this, inventarioHerramientas.cantidadPicoFino());
    }

    /***************
     * VistaHerramienta.listener
     **************/
    @Override
    public void onClick(VistaHerramienta vistaHerramienta) {
        actualizar();
        listener.heramientaClickeada(vistaHerramienta.obtenerHerramienta());
    }

    public interface Listener {
        void heramientaClickeada(Herramienta herramienta);
    }

    public interface HerramientaSeleccionada {
        void seleccionar();
    }

}
