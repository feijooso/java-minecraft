package model.herramientas.Golpes;

import model.materiales.Madera;
import model.materiales.Metal;
import model.materiales.Piedra;
//TODO, probablemente sea este tambien quien se encague de darle el tipo de desgaste a la herramienta en lugar del mismo material.
//TODO, agregar golpear diamante
public interface GolpeStrategy {
    void golpear(Madera madera, int fuerza);
    void golpear(Piedra piedra, int fuerza);
    void golpear(Metal metal, int fuerza);
}
