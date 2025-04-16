package com.lljvmusicapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.lljvmusicapp.model.Lesson;
import com.lljvmusicapp.model.LessonList;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * Allows users to select a difficulty, choose a lesson, and answer MCQ questions
 * @author Victoria
 */
public class LessonController {

    @FXML private ComboBox<String> difficultyBox;
    @FXML private ComboBox<String> lessonBox;
    @FXML private Label questionLabel;
    @FXML private VBox choicesBox;
    @FXML private Label feedbackLabel;

    private Lesson currentLesson;
    private String correctAnswer;

    @FXML
    public void initialize() {
        // Populate difficulty levels
        difficultyBox.getItems().addAll("Beginner", "Intermediate", "Advanced");

        difficultyBox.setOnAction(e -> {
            String selected = difficultyBox.getValue();
            loadLessonsByDifficulty(selected);
        });

    }

    private void loadLessonsByDifficulty(String difficulty) {
        lessonBox.getItems().clear();
        List<Lesson> filtered = LessonList.getInstance().getLessons().stream()
                .filter(l -> l.getLevel().equalsIgnoreCase(difficulty))
                .collect(Collectors.toList());

        for (Lesson l : filtered) {
            lessonBox.getItems().add(l.getTitle());
        }
    }

    private void loadFirstQuestion(Lesson lesson) {
        if (lesson.getQuestions() == null || lesson.getQuestions().isEmpty()) {
            questionLabel.setText("No questions available for this lesson.");
            choicesBox.getChildren().clear();
            return;
        }

        // For now, load only the first question
        Lesson.Question q = lesson.getQuestions().get(0);
        questionLabel.setText(q.getPrompt());
        correctAnswer = q.getCorrectAnswer();

        choicesBox.getChildren().clear();
        ToggleGroup group = new ToggleGroup();

        for (String option : q.getOptions()) {
            RadioButton rb = new RadioButton(option);
            rb.setToggleGroup(group);
            choicesBox.getChildren().add(rb);
        }
    }

    @FXML
    private void handleSubmitAnswer() {
        for (javafx.scene.Node node : choicesBox.getChildren()) {
            if (node instanceof RadioButton) {
                RadioButton rb = (RadioButton) node;
                if (rb.isSelected()) {
                    String selected = rb.getText();
                    if (selected.equals(correctAnswer)) {
                        feedbackLabel.setText("Correct!");
                    } else {
                        feedbackLabel.setText("Incorrect. Try again.");
                    }
                    return;
                }
            }
        }
        feedbackLabel.setText("Please select an answer.");
    }
}