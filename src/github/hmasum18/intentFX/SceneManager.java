/*
 * Copyright (c) 2020. Hasan Masum
 * github: https://github.com/Hmasum18
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package github.hmasum18.intentFX;

import javafx.scene.Scene;

import java.util.HashMap;

public class SceneManager {
    public static SceneManager instance;
    //fxml src address and its scene
    private HashMap<String,Scene> sceneHashMap;
    private String lastSceneFxmlUrl;
    private String currentSceneFxmlUrl;


    private SceneManager(){
        sceneHashMap = new HashMap<>();
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

    public String getLastSceneFxmlUrl() {
        return lastSceneFxmlUrl;
    }

    public void setLastSceneFxmlUrl(String lastSceneFxmlUrl) {
        this.lastSceneFxmlUrl = lastSceneFxmlUrl;
    }

    public String getCurrentSceneFxmlUrl() {
        return currentSceneFxmlUrl;
    }

    public void setCurrentSceneFxmlUrl(String currentSceneFxmlUrl) {
        this.currentSceneFxmlUrl = currentSceneFxmlUrl;
    }
}
