module IntentFX {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;

    exports github.hmasum18.intentFX;
    opens example.main;
}