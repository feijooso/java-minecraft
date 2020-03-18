package JavaFX.VistaMapa;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;


public class BarraDurabilidad extends StackPane {

    private float durabilidadMaxima;
    private float longitudMaxima = 60;
    private float height = 20;
    private Label durabilidadView;

    public BarraDurabilidad(float durabilidadMaxima){
        super();
        this.durabilidadMaxima = durabilidadMaxima;
        setWidth(longitudMaxima);
        setHeight(height);
        setPadding(new Insets(0,0,0,0));

        durabilidadView = new Label("");
        durabilidadView.setMinSize(durabilidadMaxima, getHeight());
        durabilidadView.setStyle("-fx-background-color: #a59971");
        getChildren().add(durabilidadView);
    }

    public void actualizar(float durabilidadActual) {
        int longitud = Math.round(durabilidadActual * 100 / durabilidadMaxima);
        durabilidadView.setMinWidth(longitud);
    }

}

