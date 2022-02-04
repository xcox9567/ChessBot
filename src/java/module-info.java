module com.example.chess {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.game to javafx.fxml;
    exports com.game;
}