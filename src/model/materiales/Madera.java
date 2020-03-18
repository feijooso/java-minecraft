package model.materiales;

import JavaFX.AlgoCraft;
import model.herramientas.*;
import model.herramientas.Golpes.GolpeStrategy;
import model.herramientas.Golpes.GolpesHacha.GolpeHachaMadera;
import model.herramientas.Golpes.GolpesPico.GolpePicoMadera;
import model.herramientas.desgastes.Desgaste;
import model.herramientas.desgastes.DesgastePorFuerza;
import model.jugador.inventario.InventarioHerramientas;
import model.jugador.inventario.InventarioMateriales;

public class Madera extends Material {

    public static final String TAG = "Madera";

    public Madera() {
        super(10, AlgoCraft.IMAGE_PATH + "mapaMadera.png", "Sonidos/golpearMadera.wav");
    }

    @Override
    public void esGolpeadoPor(Herramienta herramienta) {
        herramienta.golpear(this);
    }

    @Override
    public void esGolpeadoPor(Hacha hacha) {
        hacha.golpear(this);
    }

    @Override
    public void esGolpeadoPor(Pico pico) {
        pico.golpear(this);
    }

    @Override
    public int durabilidadEn(Hacha hacha) {
        return 100;
    }

    @Override
    public int fuerzaEn(Hacha hacha) {
        return 2;
    }

    @Override
    public int durabilidadEn(Pico pico) {
        return 100;
    }

    @Override
    public int fuerzaEn(Pico pico) {
        return 2;
    }

    @Override
    public GolpeStrategy fabricar(Pico pico) {
        return new GolpePicoMadera();
    }

    @Override
    public GolpeStrategy fabricar(Hacha hacha) {
        return new GolpeHachaMadera();
    }

    @Override
    public Desgaste tipoDeDesgaste(Pico pico) {
        return new DesgastePorFuerza(durabilidadEn(pico));
    }

    @Override
    public Desgaste tipoDeDesgaste(Hacha hacha) {

        return new DesgastePorFuerza(durabilidadEn(hacha));
    }

    @Override
    public void agregarse(InventarioMateriales inventario) {
        inventario.agregar(this);
    }

    @Override
    public void agregarse(InventarioHerramientas inventario, Hacha hacha) {
        inventario.agregarHachaMadera(hacha);
    }

    @Override
    public void agregarse(InventarioHerramientas inventario, Pico pico) {
        inventario.agregarPicoMadera(pico);
    }

    @Override
    public String getTag() {
        return TAG;
    }

}
