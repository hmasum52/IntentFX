
/*
 * Copyright (c) $today.year.Hasan Masum
 * Email : connectwithmasum@gmail.com
 *  Github: https://github.com/Hmasum18
 *  You can copy the code but please give due credit to the author
 * This code is under MIT LICENSE
 */

package example.main;

import github.hmasum18.intentFX.IntentFX;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        try {
             //this constructor add a new scene to the stage from the fxml file
            //there will be no animation as it is the 1st screen
            IntentFX intent = new IntentFX(primaryStage,"first_screen.fxml");
            //start a brand new scene
            intent.startNewScene();
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
