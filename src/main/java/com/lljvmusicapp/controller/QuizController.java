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

/**
 * Controller for the quiz screen where users answer multiple choice questions
 * from a selected lesson. Manages question loading, answer checking, and navigation.
 * 
 * @author Victoria
 */
public class QuizController {

    @FXML private Label questionLabel;
    @FXML private VBox choicesBox;
    @FXML private Label feedbackLabel;
    @FXML private Button nextButton;

    private Lesson lesson;
    private int currentQuestionIndex = 0;

    /**
     * Initializes the quiz by loading the current lesson and displaying the first question.
     */
    public void initialize() {
        lesson = LessonSession.getCurrentLesson();
        loadQuestion();
    }

    /**
     * Loads the current question and its answer choices into the view.
     * Handles user selection and provides immediate feedback.
     */
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

    /**
     * Handles progressing to the next question or completing the lesson
     * when all questions are answered.
     * 
     * @param e The action event triggered by pressing the next button.
     */
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