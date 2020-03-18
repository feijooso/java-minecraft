package model.materiales;


import JavaFX.AlgoCraft;
import model.herramientas.*;
import model.herramientas.Golpes.GolpeStrategy;
import model.herramientas.desgastes.Desgaste;
import model.jugador.inventario.InventarioHerramientas;
import model.jugador.inventario.InventarioMateriales;

public class Diamante extends Material {

    public static final String TAG = "Diamante";

    public Diamante() {
        super(100, AlgoCraft.IMAGE_PATH + "mapaDiamante.jpg", "Sonidos/golpearDiamante.wav");
    }

    @Override
    public void esGolpeadoPor(Herramienta herramienta) {
        herramienta.golpear(this);
    }

    @Override
    public void esGolpeadoPor(Hacha hacha) {
        hacha.restarDurabilidad();
    }

    @Override
    public void esGolpeadoPor(Pico pico) {
        pico.restarDurabilidad();
    }

    @Override
    public void esGolpeadoPor(PicoFino picoFino) {
        picoFino.restarDurabilidad();
        super.esGolpeadoPor(picoFino);
    }

    @Override
    public int durabilidadEn(Hacha hacha) {
        return 0;
    }

    @Override
    public int fuerzaEn(Hacha hacha) {
        return 0;
    }

    @Override
    public int durabilidadEn(Pico pico) {
        return 0;
    }

    @Override
    public int fuerzaEn(Pico pico) {
        return 0;
    }

    @Override
    public GolpeStrategy fabricar(Pico pico) {
        return null;
    }

    @Override
    public GolpeStrategy fabricar(Hacha hacha) {
        return null;
    }

    @Override
    public Desgaste tipoDeDesgaste(Pico pico) {
        return null;
    }

    @Override
    public Desgaste tipoDeDesgaste(Hacha hacha) {
        return null;
    }

    @Override
    public void agregarse(InventarioMateriales inventario) {
        inventario.agregar(this);
    }

    @Override
    public void agregarse(InventarioHerramientas inventario, Hacha hacha) {
        //no hace nada
    }

    @Override
    public void agregarse(InventarioHerramientas inventario, Pico pico) {
        //no hace nada
    }

    @Override
    public String getTag() {
        return TAG;
    }

}
