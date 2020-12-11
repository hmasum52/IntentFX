# IntentFX
This project is about how to achieve screen changing(multiple scene in a single stage). Intent class help us to achieve this goal.
# How to use:
Constructors:
```java
//here fxmlLocationFromSrc is the location of your fxml file from your src folder
public Intent(Stage stage, String fxmlLocationFromSrc)
public Intent(Scene scene, String fxmlLocationFromSrc)
//node can be anything which extends node. Button and ImageView for example
public Intent(Node node, String fxmlLocationFromSrc) 
```
#### Adding a new stage in your primary stage:
This code snippet add new scene related with the fxml.
startNewScene() method starts a brand-new scene deleting the previous scene if exist.
```java
Intent intent = new Intent(primaryStage,"src\\example\\res\\fxml\\main.fxml");
intent.startNewScene();
primaryStage.show();
```
#### Adding a new stage in a node(button here):
This code snippet add new scene related with the fxml.
startNewScene() method starts a brand-new scene deleting the previous scene if exist.
```java
 mChangeSceneBtn.setOnAction(event -> {
            Intent intent = new Intent(mChangeSceneBtn,"src\\example\\res\\fxml\\second_screen.fxml");
            try {
                intent.startNewScene();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
```
#### Demonstrating startScene() method: 
startScene() method add the old scene to the stage if exist.

In scene doesn't exist creates a new scene and add it to the stage.
```java
 mBackBtn.setOnAction(event -> {
            try {
                Intent intent = new Intent(mBackBtn,"src\\example\\res\\fxml\\main.fxml");
                intent.startScene();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
```

#### _see [example](src/example) for further understanding_

License
--------

    Copyright (c) 2020. Hasan Masum
    github: https://github.com/Hmasum18

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.