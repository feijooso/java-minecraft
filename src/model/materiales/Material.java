package model.materiales;

import Excepciones.MaterialDestruidoException;
import JavaFX.AlgoCraft;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.herramientas.*;
import model.herramientas.Golpes.GolpeStrategy;
import model.herramientas.desgastes.Desgaste;
import model.jugador.inventario.InventarioHerramientas;
import model.jugador.inventario.InventarioMateriales;

import java.io.File;

public abstract class Material{

    protected int durabilidad;
    protected String rutaImagen;
    protected MediaPlayer sonidoGolpearMaterial;

    Material(int durabilidad, String rutaImagen, String rutaSonido) {
        this.durabilidad = durabilidad;
        this.rutaImagen = rutaImagen;
        Media mediaSonidoCaminar = new Media(new File(rutaSonido).toURI().toString());
        sonidoGolpearMaterial = new MediaPlayer(mediaSonidoCaminar);

    }

    public int durabilidad() {
        return durabilidad;
    }

    public String imagen(){
        return rutaImagen;
    }

    public MediaPlayer sonido(){
        return sonidoGolpearMaterial;
    }

    public void restarDurabilidad(int daño) {
        durabilidad -= daño;
        if (durabilidad <= 0)
            throw new MaterialDestruidoException(this);
    }

    public abstract void esGolpeadoPor(Herramienta herramienta);
    public abstract void esGolpeadoPor(Hacha hacha);
    public abstract void esGolpeadoPor(Pico pico);

    public void esGolpeadoPor(PicoFino picoFino) {
        restarDurabilidad(picoFino.fuerza());
    }

    //Abstractos
    public abstract int durabilidadEn(Hacha hacha);
    public abstract int fuerzaEn(Hacha hacha);
    public abstract int durabilidadEn(Pico pico);
    public abstract int fuerzaEn(Pico pico);
    public abstract GolpeStrategy fabricar(Pico pico);
    public abstract GolpeStrategy fabricar(Hacha hacha);
    public abstract Desgaste tipoDeDesgaste(Pico pico);
    public abstract Desgaste tipoDeDesgaste(Hacha hacha);
    public abstract void agregarse(InventarioMateriales inventario);
    public abstract void agregarse(InventarioHerramientas inventario, Hacha hacha);
    public abstract void agregarse(InventarioHerramientas inventario, Pico pico);

    public abstract String getTag();

    public String getImage() {
        return AlgoCraft.IMAGE_PATH + getClass().getSimpleName()+".png";
    }
}