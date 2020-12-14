/*
 * Copyright (c) $today.year.Hasan Masum
 * Email : connectwithmasum@gmail.com
 *  Github: https://github.com/Hmasum18
 *  You can copy the code but please give due credit to the author
 * This code is under MIT LICENSE
 */

package github.hmasum18.intentFX;

import javafx.scene.Parent;
import javafx.scene.Scene;

import java.util.HashMap;

public class SceneManager {
    public static SceneManager instance;
    //fxml src address and its scene
    private final HashMap<String, Scene> sceneHashMap;
    private final HashMap<String, Parent> parentHashMap;
    private String currentSceneFxmlUrl;


    private SceneManager(){
        sceneHashMap = new HashMap<>();
        parentHashMap = new HashMap<>();
    }

    public static SceneManager getInstance() {
        if(instance == null)
            instance = new SceneManager();
        return instance;
    }

    public void addScene(String fxmlUrl, Scene scene){
        sceneHashMap.put(fxmlUrl,scene);
    }

    public void removeScene(String fxmlUrl){
        if(isSceneAlive(fxmlUrl))
            sceneHashMap.remove(fxmlUrl);
    }

    public Scene getScene(String fxmlUrl){
        return sceneHashMap.get(fxmlUrl);
    }

    public boolean isSceneAlive(String fxmlUrl){
        return sceneHashMap.get(fxmlUrl)!=null;
    }

    public String getCurrentSceneFxmlUrl() {
        return currentSceneFxmlUrl;
    }

    public void setCurrentSceneFxmlUrl(String currentSceneFxmlUrl) {
        this.currentSceneFxmlUrl = currentSceneFxmlUrl;
    }

    public Scene getCurrentScene(){
        return sceneHashMap.get(currentSceneFxmlUrl);
    }


    public void addParent(String fxmlUrl, Parent parent){
        parentHashMap.put(fxmlUrl,parent);
    }

    public void removeParent(String fxmlUrl){
        if(isSceneAlive(fxmlUrl))
            parentHashMap.remove(fxmlUrl);
    }

    public Parent getParent(String fxmlUrl){
        return parentHashMap.get(fxmlUrl);
    }

    public Parent getCurrentParent(){
        return parentHashMap.get(currentSceneFxmlUrl);
    }

}
