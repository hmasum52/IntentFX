package example.main;

import github.hmasum18.intentFX.Intent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FirstSreenController implements Initializable {

    public static final String TAG = "MainController->";
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
            Intent intent = new Intent(mChangeSceneBtn,"src\\example\\res\\fxml\\second_screen.fxml");
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
