package model.Construccion;

import Excepciones.NoSePudoContruirHerramientaException;
import model.herramientas.Herramienta;
import model.materiales.Material;

import java.util.ArrayList;
import java.util.List;

public class TablaDeContruccion {

    private List<String> listaMateriales;
    private DiccionarioDeHerramientas diccionarioDeHerramientas;

    public TablaDeContruccion() {
        diccionarioDeHerramientas = new DiccionarioDeHerramientas();
        this.listaMateriales = new ArrayList<>();
        for (int i=0; i<9; i++) {
            listaMateriales.add(DiccionarioDeHerramientas.SEP);
        }
    }

    public void insertar(Material material, int posicion) {
        listaMateriales.set(posicion, material.getTag());
    }

    public void remover(int posicion) {
        listaMateriales.set(posicion, DiccionarioDeHerramientas.SEP);
    }

    public Herramienta construir() {
        String hashKey = armarHashKey();
        System.out.println(hashKey);
        Herramienta herramienta = diccionarioDeHerramientas.construir(hashKey, listaMateriales.get(1));
        if (herramienta == null)
            throw new NoSePudoContruirHerramientaException();
        return herramienta;
    }

    private String armarHashKey() {
        StringBuilder hashKey = new StringBuilder();
        for(String str : listaMateriales) {
            hashKey.append(str);
        }
        return hashKey.toString();
    }
}
