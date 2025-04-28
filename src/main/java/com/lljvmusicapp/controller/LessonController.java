package com.lljvmusicapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.lljvmusicapp.model.Lesson;
import com.lljvmusicapp.model.LessonList;
import com.lljvmusicapp.model.Question;
import com.lljvmusicapp.util.SceneManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * Allows users to select a level, choose a lesson, and answer MCQ questions.
 * Handles lesson loading, question navigation, and user feedback.
 * 
 * @author Victoria
 */
public class LessonController {

    @FXML private ComboBox<String> levelBox;
    @FXML private ComboBox<String> lessonBox;
    @FXML private Label questionLabel;
    @FXML private VBox choicesBox;
    @FXML private Label feedbackLabel;
    @FXML private Button continueButton;

    private Lesson currentLesson;
    private int currentQuestionIndex;

    /**
     * Initializes the lesson controller by setting up the difficulty selection
     * and disabling buttons until a lesson is selected.
     */
    @FXML
    public void initialize() {
        levelBox.getItems().addAll("EASY", "MEDIUM", "HARD");

        levelBox.setOnAction(e -> {
            String selectedLevel = levelBox.getValue();
            loadLessonsByLevel(selectedLevel);
        });

        continueButton.setDisable(true);
        lessonBox.setDisable(true);
    }

    /**
     * Loads lessons based on the selected difficulty level into the lesson selection box.
     * 
     * @param level The selected difficulty level.
     */
    private void loadLessonsByLevel(String level) {
        lessonBox.getItems().clear();
        List<Lesson> filtered = LessonList.getInstance().getLessons().stream()
                .filter(l -> l.getLevel() != null && l.getLevel().equalsIgnoreCase(level))
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            lessonBox.setDisable(true);
            continueButton.setDisable(true);
            lessonBox.getItems().add("No lessons found");
        } else {
            lessonBox.setDisable(false);
            continueButton.setDisable(false);
            for (Lesson l : filtered) {
                lessonBox.getItems().add(l.getTitle());
            }
        }
    }

    /**
     * Handles user clicking the "Continue" button after selecting a lesson.
     * Loads the selected lesson's first question.
     * 
     * @param event The action event triggered by the button press.
     */
    @FXML
    private void handleContinue(ActionEvent event) {
        String lessonTitle = lessonBox.getValue();
        currentLesson = LessonList.getInstance().getLessons().stream()
                .filter(l -> l.getTitle().equals(lessonTitle))
                .findFirst().orElse(null);

        if (currentLesson != null) {
            currentQuestionIndex = 0;
            loadQuestion();
        }
    }

    /**
     * Loads the current question onto the screen with its answer choices.
     * If all questions are completed, shows a completion message.
     */
    private void loadQuestion() {
        if (currentQuestionIndex >= currentLesson.getQuestions().size()) {
            questionLabel.setText("You've completed the lesson!");
            choicesBox.getChildren().clear();
            feedbackLabel.setText("Lesson added to your completed lessons.");
            continueButton.setText("Return to Dashboard");
            continueButton.setOnAction(e -> SceneManager.loadDashboardScene(e));
            return;
        }

        Question question = currentLesson.getQuestions().get(currentQuestionIndex);
        questionLabel.setText(question.getPrompt());
        choicesBox.getChildren().clear();
        feedbackLabel.setText("");

        ToggleGroup group = new ToggleGroup();
        for (String option : question.getOptions()) {
            RadioButton rb = new RadioButton(option);
            rb.setToggleGroup(group);
            choicesBox.getChildren().add(rb);
        }

        continueButton.setText("Submit Answer");
        continueButton.setDisable(false);
        continueButton.setOnAction(e -> handleSubmitAnswer(group));
    }

    /**
     * Handles the user submitting an answer to the current question.
     * Provides feedback and loads the next question if correct.
     * 
     * @param group The ToggleGroup containing the answer choices.
     */
    private void handleSubmitAnswer(ToggleGroup group) {
        RadioButton selected = (RadioButton) group.getSelectedToggle();
        if (selected == null) {
            feedbackLabel.setText("Please select an answer.");
            return;
        }

        Question question = currentLesson.getQuestions().get(currentQuestionIndex);

        if (selected.getText().equals(question.getCorrectAnswer())) {
            feedbackLabel.setText("Correct!");
            currentQuestionIndex++;
            continueButton.setText("Next");
            continueButton.setOnAction(e -> loadQuestion());
        } else {
            feedbackLabel.setText("Incorrect. Try again.");
        }
    }
}