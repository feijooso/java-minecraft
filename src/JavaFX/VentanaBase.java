package JavaFX;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public abstract class VentanaBase extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case ESCAPE:
                        stage.close();
                        break;
                }
            }
        });
    }

}
