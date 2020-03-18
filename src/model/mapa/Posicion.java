package model.mapa;

public class Posicion {

    private int direccionFila;
    private int direccionColumna;

    public Posicion(int direccionFila, int direccionColumna) {
        this.direccionFila = direccionFila;
        this.direccionColumna = direccionColumna;
    }

    public String toString(){
        return direccionFila + "+" + direccionColumna;
    }

    public boolean equals(Posicion posicion) {
        return direccionFila == posicion.getDireccionFila()
                && direccionColumna == posicion.getDireccionColumna();
    }

    public int getDireccionFila() {
        return direccionFila;
    }

    public int getDireccionColumna() {
        return direccionColumna;
    }

}