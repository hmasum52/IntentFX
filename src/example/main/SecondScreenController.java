/*
 * Copyright (c) $today.year.Hasan Masum
 * Email : connectwithmasum@gmail.com
 *  Github: https://github.com/Hmasum18
 *  You can copy the code but please give due credit to the author
 * This code is under MIT LICENSE
 */

package example.main;

import github.hmasum18.intentFX.Intent;
import github.hmasum18.intentFX.IntentFX;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SecondScreenController implements Initializable {
    public Button mBackBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mBackBtn.setOnAction(event -> {
            try {
                IntentFX intent = new IntentFX(mBackBtn,"first_screen.fxml",IntentFX.SLIDE_DOWN_TO_UP);
                intent.startScene();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
