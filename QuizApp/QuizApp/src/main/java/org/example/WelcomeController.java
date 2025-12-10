package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class WelcomeController {

    @FXML
    private Button startBtn;

    @FXML
    private Button exitBtn;

    @FXML
    public void handleStart() throws Exception {
        Main.loadLoginScreen();
    }

    @FXML
    public void handleExit() {
        System.exit(0);
    }
}