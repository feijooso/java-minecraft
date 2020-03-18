package model.jugador.inventario;

import model.materiales.*;

public interface InterfazInventarioMateriales {
    int cantidadDeMateriales();

    Madera obtenerMadera();
    Piedra obtenerPiedra();
    Metal obtenerMetal();
    Diamante obtenerDiamante();

    void agregar(Material material);
    void agregar(Madera madera);
    void agregar(Piedra piedra);
    void agregar(Metal metal);
    void agregar(Diamante diamante);

    int cantidadDeMadera();
    int cantidadDePiedra();
    int cantidadDeMetal();
    int cantidadDeDiamante();
}
