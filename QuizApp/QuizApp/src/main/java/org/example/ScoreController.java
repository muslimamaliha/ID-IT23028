package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class ScoreController {

    @FXML private Text scoreText;
    @FXML private Button playAgainBtn;
    @FXML private Button backBtn;
    @FXML private Button exitBtn;

    public void setScore(int score) {
        scoreText.setText("Your Score: "+score);
    }

    @FXML
    public void handlePlayAgain() throws Exception {
        Main.loadQuizScreen();
    }

    @FXML
    public void handleBack() throws Exception {
        Main.loadLoginScreen();
    }

    @FXML
    public void handleExit() {
        System.exit(0);
    }
}