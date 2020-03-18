package model.jugador.inventario;

import model.herramientas.Hacha;
import model.herramientas.Herramienta;
import model.herramientas.Pico;
import model.herramientas.PicoFino;
import model.materiales.*;

public class Inventario implements InterfazInventarioMateriales, InterfazInventariHerramientas {

    private InventarioMateriales inventarioMateriales;
    private InventarioHerramientas inventarioHerramientas;

    public Inventario() {
        inventarioHerramientas = new InventarioHerramientas();
        inventarioMateriales = new InventarioMateriales();
    }

    public InventarioHerramientas obtenerInventarioHerramientas() {
        return inventarioHerramientas;
    }

    public InventarioMateriales obtenerInventarioMateriales() {
        return inventarioMateriales;
    }

    @Override
    public int cantidadDeHerramientas() {
        return inventarioHerramientas.cantidadDeHerramientas();
    }

    @Override
    public Hacha obtenerHachaMadera() {
        return inventarioHerramientas.obtenerHachaMadera();
    }

    @Override
    public Hacha obtenerHachaPiedra() {
        return inventarioHerramientas.obtenerHachaPiedra();
    }

    @Override
    public Hacha obtenerHachaMetal() {
        return inventarioHerramientas.obtenerHachaMetal();
    }

    @Override
    public Pico obtenerPicoMadera() {
        return inventarioHerramientas.obtenerPicoMadera();
    }

    @Override
    public Pico obtenerPicoPiedra() {
        return inventarioHerramientas.obtenerPicoPiedra();
    }

    @Override
    public Pico obtenerPicoMetal() {
        return inventarioHerramientas.obtenerPicoMetal();
    }

    @Override
    public PicoFino obtenerPicoFino() {
        return inventarioHerramientas.obtenerPicoFino();
    }

    @Override
    public void agregar(Herramienta herramienta) {
        inventarioHerramientas.agregar(herramienta);
    }

    @Override
    public void agregar(Hacha hacha) {
        inventarioHerramientas.agregar(hacha);
    }

    @Override
    public void agregarHachaMadera(Hacha hacha) {
        inventarioHerramientas.agregarHachaMadera(hacha);
    }

    @Override
    public void agregarHachaPiedra(Hacha hacha) {
        inventarioHerramientas.agregarHachaPiedra(hacha);
    }

    @Override
    public void agregarHachaMetal(Hacha hacha) {
        inventarioHerramientas.agregarHachaMetal(hacha);
    }

    @Override
    public void agregar(Pico pico) {
        inventarioHerramientas.agregar(pico);
    }

    @Override
    public void agregarPicoMadera(Pico pico) {
        inventarioHerramientas.agregarPicoMadera(pico);
    }

    @Override
    public void agregarPicoPiedra(Pico pico) {
        inventarioHerramientas.agregarPicoPiedra(pico);
    }

    @Override
    public void agregarPicoMetal(Pico pico) {
        inventarioHerramientas.agregarPicoMetal(pico);
    }

    @Override
    public void agregarPicoFino(PicoFino picoFino) {
        inventarioHerramientas.agregarPicoFino(picoFino);
    }

    @Override
    public int cantidadHachaMadera() {
        return inventarioHerramientas.cantidadHachaMadera();
    }

    @Override
    public int cantidadHachaPiedra() {
        return inventarioHerramientas.cantidadHachaPiedra();
    }

    @Override
    public int cantidadHachaMetal() {
        return inventarioHerramientas.cantidadHachaMetal();
    }

    @Override
    public int cantidadPicoMadera() {
        return inventarioHerramientas.cantidadPicoMadera();
    }

    @Override
    public int cantidadPicoPiedra() {
        return inventarioHerramientas.cantidadPicoPiedra();
    }

    @Override
    public int cantidadPicoMetal() {
        return inventarioHerramientas.cantidadPicoMetal();
    }

    @Override
    public int cantidadPicoFino() {
        return inventarioHerramientas.cantidadPicoFino();
    }

    /******
     * Inventario Materiales
     */

    public int cantidadDeMateriales() {
        return inventarioMateriales.cantidadDeMateriales();
    }

    @Override
    public Madera obtenerMadera() {
        return inventarioMateriales.obtenerMadera();
    }

    @Override
    public Piedra obtenerPiedra() {
        return inventarioMateriales.obtenerPiedra();
    }

    @Override
    public Metal obtenerMetal() {
        return inventarioMateriales.obtenerMetal();
    }

    @Override
    public Diamante obtenerDiamante() {
        return inventarioMateriales.obtenerDiamante();
    }

    @Override
    public void agregar(Material material) {
        inventarioMateriales.agregar(material);
    }

    @Override
    public void agregar(Madera madera) {
        inventarioMateriales.agregar(madera);
    }

    @Override
    public void agregar(Piedra piedra) {
        inventarioMateriales.agregar(piedra);
    }

    @Override
    public void agregar(Metal metal) {
        inventarioMateriales.agregar(metal);
    }

    @Override
    public void agregar(Diamante diamante) {
        inventarioMateriales.agregar(diamante);
    }

    @Override
    public int cantidadDeMadera() {
        return inventarioMateriales.cantidadDeMadera();
    }

    @Override
    public int cantidadDePiedra() {
        return inventarioMateriales.cantidadDePiedra();
    }

    @Override
    public int cantidadDeMetal() {
        return inventarioMateriales.cantidadDeMetal();
    }

    @Override
    public int cantidadDeDiamante() {
        return inventarioMateriales.cantidadDeDiamante();
    }
}
