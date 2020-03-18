package model.materiales;

import JavaFX.AlgoCraft;
import model.herramientas.*;
import model.herramientas.Golpes.GolpeStrategy;
import model.herramientas.Golpes.GolpesHacha.GolpeHachaPiedra;
import model.herramientas.Golpes.GolpesPico.GolpePicoPiedra;
import model.herramientas.desgastes.Desgaste;
import model.herramientas.desgastes.DesgastePorDivision;
import model.herramientas.desgastes.DesgastePorFuerza;
import model.jugador.inventario.InventarioHerramientas;
import model.jugador.inventario.InventarioMateriales;

public class Piedra extends Material {

    public static final String TAG = "Piedra";

    public Piedra(){
        super(30, AlgoCraft.IMAGE_PATH + "mapaPiedra.png", "Sonidos/golpearPiedra.wav");
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
        return 200;
    }

    @Override
    public int fuerzaEn(Hacha hacha) {
        return 5;
    }

    @Override
    public int durabilidadEn(Pico pico) {
        return 200;
    }

    @Override
    public int fuerzaEn(Pico pico) {
        return 4;
    }

    @Override
    public GolpeStrategy fabricar(Pico pico) {
        return new GolpePicoPiedra();
    }

    @Override
    public GolpeStrategy fabricar(Hacha hacha) {
        return new GolpeHachaPiedra();
    }

    @Override
    public Desgaste tipoDeDesgaste(Pico pico) {
        return new DesgastePorDivision(durabilidadEn(pico),1.5f);
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
        inventario.agregarHachaPiedra(hacha);
    }

    @Override
    public void agregarse(InventarioHerramientas inventario, Pico pico) {
        inventario.agregarPicoPiedra(pico);
    }

    @Override
    public String getTag() {
        return TAG;
    }
}
