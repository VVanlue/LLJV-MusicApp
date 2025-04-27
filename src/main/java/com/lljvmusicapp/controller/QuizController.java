package com.lljvmusicapp.controller;

import com.lljvmusicapp.model.Lesson;
import com.lljvmusicapp.model.LessonSession;
import com.lljvmusicapp.model.Question;
import com.lljvmusicapp.util.SceneManager;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class QuizController {

    @FXML private Label questionLabel;
    @FXML private VBox choicesBox;
    @FXML private Label feedbackLabel;
    @FXML private Button nextButton;

    private Lesson lesson;
    private int currentQuestionIndex = 0;

    public void initialize() {
        lesson = LessonSession.getCurrentLesson();
        loadQuestion();
    }

    private void loadQuestion() {
        Question currentQuestion = lesson.getQuestions().get(currentQuestionIndex);
        questionLabel.setText(currentQuestion.getPrompt());

        choicesBox.getChildren().clear();
        ToggleGroup group = new ToggleGroup();

        for (String option : currentQuestion.getOptions()) {
            RadioButton rb = new RadioButton(option);
            rb.setToggleGroup(group);
            choicesBox.getChildren().add(rb);
        }

        feedbackLabel.setText("");
        nextButton.setDisable(true);

        group.selectedToggleProperty().addListener((obs, oldVal, newVal) -> {
            RadioButton selected = (RadioButton) newVal;
            boolean correct = selected.getText().equals(currentQuestion.getCorrectAnswer());
            feedbackLabel.setText(correct ? "Correct!" : "Incorrect, try again.");
            nextButton.setDisable(!correct);
        });
    }

    @FXML
    private void handleNextQuestion(javafx.event.ActionEvent e) {
        currentQuestionIndex++;
        if (currentQuestionIndex < lesson.getQuestions().size()) {
            loadQuestion();
        } else {
            LessonSession.completeCurrentLesson();
            SceneManager.loadLessonCompletedScene(e);
        }
    }
}