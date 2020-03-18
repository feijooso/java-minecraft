package model.materiales;

import JavaFX.AlgoCraft;
import model.herramientas.*;
import model.herramientas.Golpes.GolpeStrategy;
import model.herramientas.Golpes.GolpesHacha.GolpeHachaMetal;
import model.herramientas.Golpes.GolpesPico.GolpePicoMetal;
import model.herramientas.desgastes.Desgaste;
import model.herramientas.desgastes.DesgastePorCantidadDeUsos;
import model.herramientas.desgastes.DesgastePorDivision;
import model.jugador.inventario.InventarioHerramientas;
import model.jugador.inventario.InventarioMateriales;

public class Metal extends Material {

    public static final String TAG = "Metal";

    public Metal() {
        super(50, AlgoCraft.IMAGE_PATH + "mapaMetal.jpg", "Sonidos/golpearMetal.wav");
    }

    @Override
    public void esGolpeadoPor(Herramienta herramienta) {
        herramienta.golpear(this);
    }

    @Override
    public void esGolpeadoPor(Pico pico) {
        pico.golpear(this);
    }

    @Override
    public void esGolpeadoPor(Hacha hacha) {
        hacha.golpear(this);
    }

    @Override
    public int durabilidadEn(Hacha hacha) {
        return 400;
    }

    @Override
    public int fuerzaEn(Hacha hacha) {
        return 10;
    }

    @Override
    public int durabilidadEn(Pico pico) {
        return 400;
    }

    @Override
    public int fuerzaEn(Pico pico) {
        return 12;
    }

    @Override
    public GolpeStrategy fabricar(Pico pico) {
        return new GolpePicoMetal();
    }

    @Override
    public GolpeStrategy fabricar(Hacha hacha) {
        return new GolpeHachaMetal();
    }

    @Override
    public Desgaste tipoDeDesgaste(Pico pico) {

        return new DesgastePorCantidadDeUsos(durabilidadEn(pico), 10);
    }

    @Override
    public Desgaste tipoDeDesgaste(Hacha hacha) {
        return new DesgastePorDivision(durabilidadEn(hacha), 2);
    }

    @Override
    public void agregarse(InventarioMateriales inventario) {
        inventario.agregar(this);
    }

    @Override
    public void agregarse(InventarioHerramientas inventario, Hacha hacha) {
        inventario.agregarHachaMetal(hacha);
    }

    @Override
    public void agregarse(InventarioHerramientas inventario, Pico pico) {
        inventario.agregarPicoMetal(pico);
    }

    @Override
    public String getTag() {
        return TAG;
    }

}
