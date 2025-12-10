package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {

    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private Button startQuizBtn;
    @FXML private Button rulesBtn;
    @FXML private Button leaderboardBtn;
    @FXML private Button backBtn;

    @FXML
    public void handleStartQuiz() throws Exception {
        String name = nameField.getText();
        String email = emailField.getText();
        if(name.isEmpty() || email.isEmpty()) return;

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            int userId;
            if(rs.next()) {
                userId = rs.getInt("id");
            } else {
                ps = conn.prepareStatement("INSERT INTO users(name,email) VALUES(?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, name);
                ps.setString(2, email);
                ps.executeUpdate();
                ResultSet keys = ps.getGeneratedKeys();
                keys.next();
                userId = keys.getInt(1);
            }
            Main.currentUser = new User(userId,name,email);
        }

        Main.loadQuizScreen();
    }

    @FXML
    public void handleRules() throws Exception {
        Main.loadRulesScreen();
    }

    @FXML
    public void handleLeaderboard() throws Exception {
        Main.loadLeaderboardScreen();
    }

    @FXML
    public void handleBack() throws Exception {
        Main.loadWelcomeScreen();
    }
}