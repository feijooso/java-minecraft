package model.jugador.inventario;

import model.herramientas.Hacha;
import model.herramientas.Herramienta;
import model.herramientas.Pico;
import model.herramientas.PicoFino;

public interface InterfazInventariHerramientas {
    int cantidadDeHerramientas();

    Hacha obtenerHachaMadera();
    Hacha obtenerHachaPiedra();
    Hacha obtenerHachaMetal();

    Pico obtenerPicoMadera();
    Pico obtenerPicoPiedra();
    Pico obtenerPicoMetal();

    PicoFino obtenerPicoFino();

    void agregar(Herramienta herramienta);

    void agregar(Hacha hacha);
    void agregarHachaMadera(Hacha hacha);
    void agregarHachaPiedra(Hacha hacha);
    void agregarHachaMetal(Hacha hacha);

    void agregar(Pico pico);
    void agregarPicoMadera(Pico pico);
    void agregarPicoPiedra(Pico pico);
    void agregarPicoMetal(Pico pico);

    void agregarPicoFino(PicoFino picoFino);

    int cantidadHachaMadera();
    int cantidadHachaPiedra();
    int cantidadHachaMetal();

    int cantidadPicoMadera();
    int cantidadPicoPiedra();
    int cantidadPicoMetal();

    int cantidadPicoFino();
}
