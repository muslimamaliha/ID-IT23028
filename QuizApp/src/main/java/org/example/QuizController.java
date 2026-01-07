package org.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class QuizController {

    @FXML private Text questionText;
    @FXML private RadioButton optionA, optionB, optionC, optionD;
    @FXML private ToggleGroup optionsGroup;
    @FXML private Button nextBtn, backBtn;
    @FXML private Label timerLabel;  // Timer display

    private List<Question> questions;
    private int currentIndex = 0;
    private List<String> selectedAnswers = new ArrayList<>();

    private Timeline timeline;
    private int timeLeft = 15;

    @FXML
    public void initialize() {
        // Assign ToggleGroup
        optionA.setToggleGroup(optionsGroup);
        optionB.setToggleGroup(optionsGroup);
        optionC.setToggleGroup(optionsGroup);
        optionD.setToggleGroup(optionsGroup);

        // Load Java Questions
        questions = generateQuestions();
        for(int i=0;i<questions.size();i++) selectedAnswers.add("");

        loadQuestion();
    }

    private List<Question> generateQuestions() {
        List<Question> list = new ArrayList<>();

        list.add(new Question("Which of these is the correct way to declare a variable in Java?",
                "int num;", "num int;", "integer num;", "num integer;", "int num;"));
        list.add(new Question("Which keyword is used to inherit a class in Java?",
                "this", "super", "extends", "implements", "extends"));
        list.add(new Question("What is the size of int in Java?",
                "4 bytes", "2 bytes", "8 bytes", "Depends on JVM", "4 bytes"));
        list.add(new Question("Which method is the entry point for a Java program?",
                "start()", "main()", "run()", "init()", "main()"));
        list.add(new Question("Which of these is not a Java access modifier?",
                "public", "private", "protected", "friendly", "friendly"));
        list.add(new Question("Which exception is thrown when an array index is out of bounds?",
                "NullPointerException", "ArrayIndexOutOfBoundsException", "ArithmeticException", "ClassNotFoundException",
                "ArrayIndexOutOfBoundsException"));
        list.add(new Question("Which of these is used to create a new object in Java?",
                "new", "create", "make", "instance", "new"));
        list.add(new Question("Which loop is guaranteed to execute at least once?",
                "for", "while", "do-while", "foreach", "do-while"));
        list.add(new Question("Which interface must be implemented to create a thread in Java?",
                "Runnable", "Serializable", "Cloneable", "Comparable", "Runnable"));
        list.add(new Question("Which keyword is used to prevent inheritance of a class?",
                "final", "static", "private", "abstract", "final"));

        return list;
    }

    private void loadQuestion() {
        Question q = questions.get(currentIndex);
        questionText.setText(q.getQuestion());
        optionA.setText(q.getOptionA());
        optionB.setText(q.getOptionB());
        optionC.setText(q.getOptionC());
        optionD.setText(q.getOptionD());

        // Restore previous selection
        String prev = selectedAnswers.get(currentIndex);
        optionsGroup.selectToggle(null);
        if(prev.equals(optionA.getText())) optionsGroup.selectToggle(optionA);
        else if(prev.equals(optionB.getText())) optionsGroup.selectToggle(optionB);
        else if(prev.equals(optionC.getText())) optionsGroup.selectToggle(optionC);
        else if(prev.equals(optionD.getText())) optionsGroup.selectToggle(optionD);

        if(currentIndex == questions.size()-1) nextBtn.setText("Submit");
        else nextBtn.setText("Next");

        startTimer();  // Start 15-sec timer for this question
    }

    private void startTimer() {
        timeLeft = 15;
        timerLabel.setText(timeLeft + " sec");
        if(timeline != null) timeline.stop();

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            timeLeft--;
            timerLabel.setText(timeLeft + " sec");
            if(timeLeft <= 0){
                timeline.stop();
                try { handleNext(); } catch(Exception ex){ ex.printStackTrace(); }
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @FXML
    public void handleNext() throws Exception {
        RadioButton selected = (RadioButton) optionsGroup.getSelectedToggle();
        if(selected != null){
            selectedAnswers.set(currentIndex, selected.getText());
        }

        if(currentIndex == questions.size()-1){
            // Submit quiz
            int score = 0;
            for(int i=0;i<questions.size();i++){
                if(questions.get(i).getCorrectOption().equals(selectedAnswers.get(i))) score++;
            }

            try(Connection conn = DBConnection.getConnection()){
                PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO scores(user_id, user_email, correct_score, wrong_score) VALUES(?,?,?,?)"
                );
                ps.setString(1, String.valueOf(Main.currentUser.getId()));
                ps.setString(2, Main.currentUser.getEmail());
                ps.setInt(3, score);
                ps.setInt(4, questions.size()-score);
                ps.executeUpdate();
            }

            Main.loadScoreScreen(score);
        } else {
            currentIndex++;
            loadQuestion();
        }
    }

    @FXML
    public void handleBack() {
        if(currentIndex > 0){
            currentIndex--;
            loadQuestion();
        } else {
            try { Main.loadLoginScreen(); } catch(Exception e){ e.printStackTrace(); }
        }
    }
}