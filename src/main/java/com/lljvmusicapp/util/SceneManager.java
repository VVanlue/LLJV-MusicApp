package com.lljvmusicapp.util;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Utility class to manage scene transitions in the application.
 */
public class SceneManager {

    /**
     * Loads a new FXML scene.
     * 
     * @param event the action event triggering the scene change
     * @param fxmlPath the path to the FXML file (e.g., \"/com/lljvmusicapp/view/quiz.fxml\")
     */
    public static void loadScene(ActionEvent event, String fxmlPath) {
        try {
            Parent root = FXMLLoader.load(SceneManager.class.getResource(fxmlPath));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shortcut method to load the dashboard screen.
     */
    public static void loadDashboardScene(ActionEvent event) {
        loadScene(event, "/dashboard.fxml");
    }

    /**
     * Shortcut method to load the quiz screen.
     */
    public static void loadQuizScene(ActionEvent event) {
        loadScene(event, "/quiz.fxml");
    }

    /**
     * Shortcut method to load the lesson completion screen.
     */
    public static void loadLessonCompletedScene(ActionEvent event) {
        loadScene(event, "/lessonCompleted.fxml");
    }

    @FXML
    private void handleStartLessonQuiz(ActionEvent event)
    {
        SceneManager.loadQuizScene(event);
    }

    @FXML
    private void handleGoToSongScreen(ActionEvent event)
    {
        SceneManager.loadScene(event, "/song.fxml");
    }

    @FXML
    private void handleReturnToLogin(ActionEvent event)
    {
        SceneManager.loadScene(event, "/login.fxml");
    }

    public static void loadLessonScene(ActionEvent event)
    {
        loadScene(event, "/lesson.fxml");
    }
    
}