/*
 * Copyright (c) $today.year.Hasan Masum
 * Email : connectwithmasum@gmail.com
 *  Github: https://github.com/Hmasum18
 *  You can copy the code but please give due credit to the author
 * This code is under MIT LICENSE
 */

package github.hmasum18.intentFX;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Intent {
    //button or other that extends node which we use to change screen
    private Stage stage;

    //this fxml location must be from src
    private String fxmlLocationFromSrc;

    public Intent(Stage stage, String fxmlLocationFromSrc) {
        this.stage = stage;
        this.fxmlLocationFromSrc = fxmlLocationFromSrc;
    }
    public Intent(Scene scene, String fxmlLocationFromSrc){
        this.stage = (Stage) scene.getWindow();
        this.fxmlLocationFromSrc = fxmlLocationFromSrc;
    }
    public Intent(Node node, String fxmlLocationFromSrc) {
        this.stage = (Stage) node.getScene().getWindow();
        this.fxmlLocationFromSrc = fxmlLocationFromSrc;
    }

    /**
     * change the scene of the stage by replacing the previous one
     * remove the previous scene if exist from SceneManager Hash
     * @throws IOException if the fxml is not found
     */
    public void startNewScene() throws IOException {
        Scene scene = getSceneFromFxml();
        stage.setScene(scene);
        if(SceneManager.getInstance().isSceneAlive(fxmlLocationFromSrc))
            SceneManager.getInstance().removeScene(fxmlLocationFromSrc);
        SceneManager.getInstance().addScene(fxmlLocationFromSrc,scene);
    }

    /**
     * start the previous scene if exist else start a new scene of the fxml file
     * @throws IOException is the fxml file was not found
     */
    public void startScene() throws IOException {
        if(SceneManager.getInstance().isSceneAlive(fxmlLocationFromSrc))
            stage.setScene(SceneManager.getInstance().getScene(fxmlLocationFromSrc));
        else
            startNewScene();
    }

    /**
     * creates a scene from the fxml file received in Constructor
     * @return Scene created from fxml
     * @throws IOException is the fxml is not found
     */
    private Scene getSceneFromFxml() throws IOException {
        File file = new File(fxmlLocationFromSrc);
        URL url = new URL("file:\\"+file.getAbsolutePath());
        Parent parent = FXMLLoader.load(url);
        return new Scene(parent);
    }
}
