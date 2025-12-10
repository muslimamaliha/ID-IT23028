package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RulesController {

    @FXML private Button backBtn;

    @FXML
    public void handleBack() throws Exception {
        Main.loadLoginScreen();
    }
}