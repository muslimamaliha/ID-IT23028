package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    public static Stage primaryStage;
    public static User currentUser;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        loadWelcomeScreen();
        primaryStage.setTitle("Quiz App");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        primaryStage.setX(100);
        primaryStage.setY(150);
       // Image icon = new Image(getClass().getResourceAsStream("/images/icon.png"));
      //  primaryStage.getIcons().add(icon);


        primaryStage.show();
    }

    public static void loadWelcomeScreen() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/welcome.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
    }

    public static void loadLoginScreen() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/login.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
    }

    public static void loadRulesScreen() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/rules.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
    }

    public static void loadLeaderboardScreen() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/leaderboard.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
    }

    public static void loadQuizScreen() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/quiz.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
    }

    public static void loadScoreScreen(int score) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/score.fxml"));
        Scene scene = new Scene(loader.load());
        ScoreController controller = loader.getController();
        controller.setScore(score);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}