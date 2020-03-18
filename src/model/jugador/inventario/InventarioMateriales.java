package model.jugador.inventario;

import Excepciones.NoHayMaterialEnInventarioException;
import model.materiales.*;

import java.util.ArrayList;
import java.util.List;

public class InventarioMateriales implements InterfazInventarioMateriales{
    private List<Madera> listaMadera;
    private List<Piedra> listaPiedra;
    private List<Metal> listaMetal;
    private List<Diamante> listaDiamante;

    public InventarioMateriales() {
        listaMadera = new ArrayList<>();
        listaPiedra = new ArrayList<>();
        listaMetal = new ArrayList<>();
        listaDiamante = new ArrayList<>();
    }

    @Override
    public int cantidadDeMateriales() {
        return listaMadera.size()
                + listaPiedra.size()
                + listaMetal.size()
                + listaDiamante.size();
    }

    public Madera obtenerMadera() {
        if (listaMadera.isEmpty())
            throw new NoHayMaterialEnInventarioException();
        Madera madera = listaMadera.get(listaMadera.size()-1);
        listaMadera.remove(madera);
        return madera;
    }

    public Piedra obtenerPiedra() {
        if (listaPiedra.isEmpty())
            throw new NoHayMaterialEnInventarioException();
        Piedra piedra = listaPiedra.get(listaPiedra.size()-1);
        listaPiedra.remove(piedra);
        return piedra;
    }

    public Metal obtenerMetal() {
        if (listaMetal.isEmpty())
            throw new NoHayMaterialEnInventarioException();
        Metal metal = listaMetal.get(listaMetal.size()-1);
        listaMetal.remove(metal);
        return metal;
    }

    public Diamante obtenerDiamante() {
        if (listaDiamante.isEmpty())
            throw new NoHayMaterialEnInventarioException();
        Diamante diamante = listaDiamante.get(listaDiamante.size()-1);
        listaDiamante.remove(diamante);
        return diamante;
    }

    public void agregar(Material material) {
        if (material == null) return;
        material.agregarse(this);
    }

    public void agregar(Madera madera) {
        listaMadera.add(madera);
    }

    public void agregar(Piedra piedra) {
        listaPiedra.add(piedra);
    }

    public void agregar(Metal metal) {
        listaMetal.add(metal);
    }

    public void agregar(Diamante diamante) {
        listaDiamante.add(diamante);
    }

    public int cantidadDeMadera() {
        return listaMadera.size();
    }

    public int cantidadDePiedra() {
        return listaPiedra.size();
    }

    public int cantidadDeMetal() {
        return listaMetal.size();
    }

    public int cantidadDeDiamante() {
        return listaDiamante.size();
    }


}
