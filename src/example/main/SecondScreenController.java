package example.main;

import github.hmasum18.intentFX.Intent;
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
                Intent intent = new Intent(mBackBtn,"src\\example\\res\\fxml\\main.fxml");
                intent.startScene();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
