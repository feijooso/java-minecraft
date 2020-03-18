package model.jugador;

import JavaFX.AlgoCraft;
import javafx.scene.image.Image;
import model.herramientas.Hacha;
import model.herramientas.Herramienta;
import model.herramientas.HerramientaRota;
import model.jugador.inventario.Inventario;
import model.materiales.Madera;
import model.materiales.Material;
import model.mapa.Posicion;

import java.io.FileInputStream;

public class Jugador {

    protected Herramienta herramientaEquipada;
    protected Posicion posicion;
    private Inventario inventario;
    protected Posicion posicionAtaque;

    public Jugador (Posicion pos) {
        this.herramientaEquipada = new Hacha (new Madera ());
        this.posicion = pos;
        inventario = new Inventario();
        this.posicionAtaque = new Posicion(pos.getDireccionFila(),pos.getDireccionColumna()+1); //mira al este
    }


    public Herramienta obtenerHerramientaEquipada() {
        return herramientaEquipada;
    }
    public void usarHerramientaEquipadaSobre(Material material) {
        herramientaEquipada.golpear(material);
    }

    public Posicion obtenerPosicionActual(){
        return posicion;
    }

    public Posicion obtenerPosicionAlNorte(){
        int fila = posicion.getDireccionFila();
        fila--;
        return new Posicion(fila, posicion.getDireccionColumna());
    }

    public Posicion obtenerPosicionAlSur(){
        int fila = posicion.getDireccionFila();
        fila++;
        return new Posicion(fila, posicion.getDireccionColumna());
    }

    public Posicion obtenerPosicionAlEste(){
        int columna = posicion.getDireccionColumna();
        columna++;
        return new Posicion(posicion.getDireccionFila(), columna);
    }

    public Posicion obtenerPosicionAlOeste(){
        int columna = posicion.getDireccionColumna();
        columna--;
        return new Posicion(posicion.getDireccionFila(),columna);
    }

    public void cambiarPosicion(Posicion pos){

        Posicion posAnterior = this.posicion;
        this.posicion = pos;

        Posicion posAtaqueAuxiliar = new Posicion(pos.getDireccionFila()-posAnterior.getDireccionFila(),pos.getDireccionColumna()-posAnterior.getDireccionColumna());
        this.posicionAtaque = new Posicion(posAtaqueAuxiliar.getDireccionFila()+pos.getDireccionFila(),posAtaqueAuxiliar.getDireccionColumna()+pos.getDireccionColumna());
    }

    public void cambiarPosicionAtaque(Posicion posicion) {
        posicionAtaque = posicion;
    }

    public Posicion obtenerPosicionAtaque(){
        return posicionAtaque;
    }

    public void golpear(Material material) {
        herramientaEquipada.golpear(material);
    }

    public void removerHerramientaEquipada() {
        herramientaEquipada = new HerramientaRota();
    }

    public void cambiarHerramientaEquipada(Herramienta herramienta) {
        inventario.agregar(herramientaEquipada);
        herramientaEquipada = herramienta;
    }

    public Inventario obtenerInventario() {
        return inventario;
    }

    public void agregarAlInventario(Material material) {
        inventario.agregar(material);
    }

    public void agregarAlInventario(Herramienta herramienta) {
        inventario.agregar(herramienta);
    }

    public Image obtenerImagen() throws Exception{
        return new Image(new FileInputStream(AlgoCraft.IMAGE_PATH + "steve.png"));
    }
}


