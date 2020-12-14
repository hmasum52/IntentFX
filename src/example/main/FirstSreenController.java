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
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FirstSreenController implements Initializable {
    public static final String TAG = "FirstSreenController->";
    public Label mCounterLBL;
    public Button mPlusBtn;
    public Button mMinusBtn;
    public Button mChangeSceneBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(TAG + " initialize()");
        bindListeners();
    }

    private void bindListeners() {
        mPlusBtn.setOnAction(event -> {
            System.out.println("plus clicked");
            updateCounter(1);
        });
        mMinusBtn.setOnAction(event -> {
            System.out.println("minus button clicked.");
            updateCounter(-1);
        });
        mChangeSceneBtn.setOnAction(event -> {
            IntentFX intent = new IntentFX(mChangeSceneBtn,"second_screen.fxml",IntentFX.SLIDE_DOWN_TO_UP);
            try {
                intent.startNewScene();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void updateCounter(int change) {
        int cnt = Integer.parseInt(mCounterLBL.getText());
        cnt += change;
        mCounterLBL.setText(String.valueOf(cnt));
    }
}
