/*
 * Copyright (c) 2020. Hasan Masum
 * Email : connectwithmasum@gmail.com
 * Github: https://github.com/Hmasum18
 * You can copy the code but please give due credit to the author
 * This code is under MIT LICENSE
 */

package github.hmasum18.intentFX;

import example.res.R;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

//import res.R;

public class IntentFX {
    public static final int NO_ANIMATION = 0;
    public static final int SLIDE_DOWN_TO_UP = 1;
    public static final int SLIDE_TOP_TO_DOWN = 2;
    public static final int SLIDE_RIGHT_TO_LEFT = 3;
    public static final int SLIDE_LEFT_TO_RIGHT = 4;
    public static final String TAG = "IntentFX->";

    //button or other that extends node which we use to change screen
    private final Stage stage;
    //this fxml location must be from src
    private final String newFXML;
    private int animation = 0;

    public IntentFX(Stage stage, String fxmlFileName) {
        this.stage = stage;
        this.newFXML = fxmlFileName;
    }

    public IntentFX(Stage stage, String fxmlFileName,int animation) {
        this.stage = stage;
        this.newFXML = fxmlFileName;
        this.animation = animation;
    }

    public IntentFX(Scene scene, String fxmlFileName) {
        this.stage = (Stage) scene.getWindow();
        this.newFXML = fxmlFileName;
    }

    public IntentFX(Scene scene, String fxmlFileName,int animation) {
        this.stage = (Stage) scene.getWindow();
        this.newFXML = fxmlFileName;
        this.animation = animation;
    }

    public IntentFX(Node node, String fxmlFileName) {
        this.stage = (Stage) node.getScene().getWindow();
        this.newFXML = fxmlFileName;
    }

    public IntentFX(Node node, String fxmlFileName, int animation) {
        this.stage = (Stage) node.getScene().getWindow();
        this.newFXML = fxmlFileName;
        this.animation = animation;
    }

    private Parent getParentFromNewFxml() throws IOException {
        URL url = R.fxml.getURLByName(newFXML);
        Parent parent = FXMLLoader.load(url);
        return parent;
    }

    /**
     * change the scene of the stage by replacing the previous one
     * remove the previous scene if exist from SceneManager Hash
     *
     * @throws IOException if the fxml is not found
     */
    public void startNewScene() throws IOException {
        Parent parent = getParentFromNewFxml();
        Scene scene = new Scene(parent);

        //remove the previous scene if exist
        if (SceneManager.getInstance().isSceneAlive(newFXML)){
            SceneManager.getInstance().removeScene(newFXML);
            SceneManager.getInstance().removeParent(newFXML);
        }
        //add the new parent and scene instead for the fxml file
        SceneManager.getInstance().addParent(newFXML,parent);
        SceneManager.getInstance().addScene(newFXML,scene);

        //if it is not the 1st screen and if user wants any animation
        //call the animate() which will set the scene of the stage
        //after completing the animation
        //and will also update the currentSceneFxml name
        if(SceneManager.getInstance().getCurrentSceneFxmlUrl()!=null && animation!=NO_ANIMATION){
            animate();

        }else {
            //if no animation is specified
            //then update the current fxml file name and update the stage.
            SceneManager.getInstance().setCurrentSceneFxmlUrl(newFXML);
            stage.setScene(scene);
        }
    }

    /**
     * start the previous scene if exist else start a new scene of the fxml file
     *
     * @throws IOException is the fxml file was not found
     */
    public void startScene() throws IOException {
        //if there is a instance of a scene of the new fxml file load it
        if (SceneManager.getInstance().isSceneAlive(newFXML)){
            if(animation!=NO_ANIMATION){
                //call the animate() which will set the scene of the stage
                //after completing the animation
                //and will also update the currentSceneFxml name
                animate();
            }
            else{
                System.out.println("wtf aikhane kn?");
                SceneManager.getInstance().setCurrentSceneFxmlUrl(newFXML);
                stage.setScene(SceneManager.getInstance().getScene(newFXML));
            }
        }
        else
            startNewScene();
    }

    /**
     * animate the scene changing.
     * every scene must have a pane to achieve the animation
     */
    private void animate() {
        System.out.println();
        //get the old current scene in the stage;
        Scene currentScene = SceneManager.getInstance().getCurrentScene();

        //get the fxml parent of new Scene
        Parent newRoot = SceneManager.getInstance().getParent(newFXML);
        Parent currentRoot = SceneManager.getInstance().getCurrentParent();
        System.out.println(TAG+"animate():current : "+currentRoot);
        System.out.println(TAG+"animate(): "+currentRoot.getStyleClass().size());
        if(currentRoot.getStyleClass().size()>1){
            for (int i = 0; i <currentRoot.getStyleClass().size() ; i++) {
                System.out.println("removing: "+currentRoot.getStyleClass().get(i));
                currentRoot.getStyleClass().remove(i);
            }
        }
        System.out.println(TAG+"animate():new: "+newRoot);

        //update the name of current fxml with new fxml file
        SceneManager.getInstance().setCurrentSceneFxmlUrl(newFXML);

        //every scene must have a rootPane to achieve the animation
        //get the current root Pane of the fxml file of current scene
        //add whole fxml files parent as a child of this pane
        Pane currentRootPane = (Pane) currentScene.getRoot();
        int idx = currentRootPane.getChildren().size();
        System.out.println("total child : "+idx);
        currentRootPane.getChildren().add(idx,newRoot);
        System.out.println("total child now : "+currentRootPane.getChildren().size());

        //determine from which direction this new parent of newFxml should animate
        newRoot.translateYProperty().set(currentScene.getHeight());
        System.out.println("translateY: "+newRoot.translateYProperty().get());

        //create timeline, keyValue, keyFrame to animate the newRoot
        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(newRoot.translateYProperty(), 0, Interpolator.EASE_BOTH);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.4), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        System.out.println(TAG+"animate(): Start of animation");
        timeline.setOnFinished(t -> {
            Platform.runLater(()->{
                //remove the animated fxml which was added as a child of current scene root(Parent)
                currentRootPane.getChildren().remove(idx/*newRoot.getStyleableNode()*/);
                System.out.println("translateY now: "+newRoot.translateYProperty().get());

                //update the scene with the newRoot replacing the old one
                System.out.println(TAG+"animate():newRoot styleClass: "+newRoot.getStyleClass().size());
                if(newRoot.getStyleClass().size()>=1){
                    for (int i = 0; i <currentRoot.getStyleClass().size() ; i++) {
                        System.out.println("removing: "+currentRoot.getStyleClass().get(i));
                        newRoot.getStyleClass().remove(i);
                    }
                }
                Scene scene = new Scene(newRoot);
                if(SceneManager.getInstance().isSceneAlive(newFXML)){
                    SceneManager.getInstance().removeScene(newFXML);
                }
                SceneManager.getInstance().addScene(newFXML,scene);
                stage.setScene(scene);
                System.out.println(TAG+"animate(): End of animation");
            });
        });
    }
}
