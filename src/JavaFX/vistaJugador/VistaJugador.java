package JavaFX.vistaJugador;

import JavaFX.AlgoCraft;
import JavaFX.VistaMapa.VistaMapa;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.jugador.Jugador;
import model.mapa.Posicion;

import java.io.FileInputStream;
import java.util.HashMap;

public class VistaJugador extends ImageView {

    private final int TAMAÑO_EXTRA = 30;
    private Jugador jugador;
    private HashMap<String, Image> imagenHash;

    public VistaJugador(Jugador jugador) throws Exception{
        super(jugador.obtenerImagen());
        this.jugador = jugador;
        setFitWidth(VistaMapa.TAMAÑO_CASILLERO);
        setFitHeight(VistaMapa.TAMAÑO_CASILLERO);

        imagenHash = new HashMap<>();
        imagenHash.put("1+0", new Image(new FileInputStream(AlgoCraft.IMAGE_PATH + "jugador_mira_abajo.png")));
        imagenHash.put("0+1", new Image(new FileInputStream(AlgoCraft.IMAGE_PATH + "jugador_mira_este.png")));
        imagenHash.put("-1+0", new Image(new FileInputStream(AlgoCraft.IMAGE_PATH + "jugador_mira_arriba.png")));
        imagenHash.put("0+-1", new Image(new FileInputStream(AlgoCraft.IMAGE_PATH + "jugador_mira_oeste.png")));

        move();
    }

    public void move() {
        setX((jugador.obtenerPosicionActual().getDireccionColumna()-1) * VistaMapa.TAMAÑO_CASILLERO);
        setY((jugador.obtenerPosicionActual().getDireccionFila()-1) * VistaMapa.TAMAÑO_CASILLERO);
        setImage(obtenerImagen());
    }

    private Image obtenerImagen() {
        Posicion posicion = new Posicion(
                jugador.obtenerPosicionAtaque().getDireccionFila() - jugador.obtenerPosicionActual().getDireccionFila(),
                jugador.obtenerPosicionAtaque().getDireccionColumna() - jugador.obtenerPosicionActual().getDireccionColumna()
                );
        return imagenHash.get(posicion.toString());
    }

}
