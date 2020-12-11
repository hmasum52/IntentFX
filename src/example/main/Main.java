package example.main;

import github.hmasum18.intentFX.Intent;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.centerOnScreen();

        try {
            Intent intent = new Intent(primaryStage,"src\\example\\res\\fxml\\main.fxml");
            intent.startNewScene();
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //primaryStage.show();
    }
}
