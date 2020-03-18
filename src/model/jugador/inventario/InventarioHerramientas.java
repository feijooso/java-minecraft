package model.jugador.inventario;

import Excepciones.NoHayHerramientaEnInventarioException;
import model.herramientas.Hacha;
import model.herramientas.Herramienta;
import model.herramientas.Pico;
import model.herramientas.PicoFino;

import java.util.ArrayList;
import java.util.List;

public class InventarioHerramientas implements InterfazInventariHerramientas {

    private List<Hacha> listaHachaMadera;
    private List<Hacha> listaHachaPiedra;
    private List<Hacha> listaHachaMetal;

    private List<Pico> listaPicoMadera;
    private List<Pico> listaPicoPiedra;
    private List<Pico> listaPicoMetal;

    private List<PicoFino> listaPicoFino;

    public InventarioHerramientas() {
        listaHachaMadera = new ArrayList<>();
        listaHachaPiedra = new ArrayList<>();
        listaHachaMetal = new ArrayList<>();
        listaPicoMadera = new ArrayList<>();
        listaPicoPiedra = new ArrayList<>();
        listaPicoMetal = new ArrayList<>();
        listaPicoFino = new ArrayList<>();
    }

    @Override
    public int cantidadDeHerramientas() {
        return listaHachaMadera.size()
                + listaHachaPiedra.size()
                + listaHachaMetal.size()
                + listaPicoMadera.size()
                + listaPicoPiedra.size()
                + listaPicoMetal.size()
                + listaPicoFino.size();
    }

    @Override
    public Hacha obtenerHachaMadera() {
        return obtenerHacha(listaHachaMadera);
    }

    @Override
    public Hacha obtenerHachaPiedra() {
        return obtenerHacha(listaHachaPiedra);
    }

    @Override
    public Hacha obtenerHachaMetal() {
        return obtenerHacha(listaHachaMetal);
    }

    @Override
    public Pico obtenerPicoMadera() {
        return obtenerPico(listaPicoMadera);
    }

    @Override
    public Pico obtenerPicoPiedra() {
        return obtenerPico(listaPicoPiedra);
    }

    @Override
    public Pico obtenerPicoMetal() {
        return obtenerPico(listaPicoMetal);
    }

    @Override
    public PicoFino obtenerPicoFino() {
        if (listaPicoFino.isEmpty())
            throw new NoHayHerramientaEnInventarioException();
        PicoFino picoFino = listaPicoFino.get(listaPicoFino.size()-1);
        listaPicoFino.remove(picoFino);
        return picoFino;
    }

    @Override
    public void agregar(Herramienta herramienta) {
        herramienta.agregarse(this);
    }

    @Override
    public void agregar(Hacha hacha) {
        hacha.material().agregarse(this, hacha);
    }

    @Override
    public void agregarHachaMadera(Hacha hacha) {
        listaHachaMadera.add(hacha);
    }

    @Override
    public void agregarHachaPiedra(Hacha hacha) {
        listaHachaPiedra.add(hacha);

    }

    @Override
    public void agregarHachaMetal(Hacha hacha) {
        listaHachaMetal.add(hacha);
    }

    @Override
    public void agregar(Pico pico) {
        pico.material().agregarse(this, pico);
    }

    @Override
    public void agregarPicoMadera(Pico pico) {
        listaPicoMadera.add(pico);

    }

    @Override
    public void agregarPicoPiedra(Pico pico) {
        listaPicoPiedra.add(pico);
    }

    @Override
    public void agregarPicoMetal(Pico pico) {
        listaPicoMetal.add(pico);
    }

    @Override
    public void agregarPicoFino(PicoFino picoFino) {
        listaPicoFino.add(picoFino);
    }

    @Override
    public int cantidadHachaMadera() {
        return listaHachaMadera.size();
    }

    @Override
    public int cantidadHachaPiedra() {
        return listaHachaPiedra.size();
    }

    @Override
    public int cantidadHachaMetal() {
        return listaHachaMetal.size();
    }

    @Override
    public int cantidadPicoMadera() {
        return listaPicoMadera.size();
    }

    @Override
    public int cantidadPicoPiedra() {
        return listaPicoPiedra.size();
    }

    @Override
    public int cantidadPicoMetal() {
        return listaPicoMetal.size();
    }

    @Override
    public int cantidadPicoFino() {
        return listaPicoFino.size();
    }

    private Hacha obtenerHacha(List<Hacha> listaHacha) {
        if (listaHacha.isEmpty())
            throw new NoHayHerramientaEnInventarioException();
        Hacha hacha = listaHacha.get(listaHacha.size()-1);
        listaHacha.remove(hacha);
        return hacha;
    }

    private Pico obtenerPico(List<Pico> listaPico) {
        if (listaPico.isEmpty())
            throw new NoHayHerramientaEnInventarioException();
        Pico pico = listaPico.get(listaPico.size()-1);
        listaPico.remove(pico);
        return pico;
    }
}
