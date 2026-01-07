package org.example;

import javafx.collections .FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LeaderboardController {

    @FXML private TableView<ScoreRecord> leaderboardTable;
    @FXML private TableColumn<ScoreRecord, String> nameColumn;
    @FXML private TableColumn<ScoreRecord, Integer> scoreColumn;
    @FXML private Button backBtn;

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        loadLeaderboard();
    }

    private void loadLeaderboard() {
        ObservableList<ScoreRecord> data = FXCollections.observableArrayList();
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT u.name, s.correct_score AS score " +
                            "FROM scores s JOIN users u ON s.user_email = u.email " +
                            "ORDER BY s.correct_score DESC"
            );
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                data.add(new ScoreRecord(rs.getString("name"), rs.getInt("score")));
            }
        } catch (Exception e) { e.printStackTrace(); }

        leaderboardTable.setItems(data);
    }

    @FXML
    public void handleBack() throws Exception {
        Main.loadLoginScreen();
    }

    public static class ScoreRecord {
        private String name;
        private int score;

        public ScoreRecord(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() { return name; }
        public int getScore() { return score; }
    }
}