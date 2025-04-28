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
 * Provides methods to load various FXML scenes easily from controllers.
 * 
 * Author: Victoria
 */
public class SceneManager {

    /**
     * Loads a new FXML scene.
     * 
     * @param event the ActionEvent triggering the scene change
     * @param fxmlPath the path to the FXML file (e.g., "/com/lljvmusicapp/view/quiz.fxml")
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
     * Loads the dashboard scene.
     * 
     * @param event the ActionEvent triggering the scene change
     */
    public static void loadDashboardScene(ActionEvent event) {
        loadScene(event, "/dashboard.fxml");
    }

    /**
     * Loads the quiz scene.
     * 
     * @param event the ActionEvent triggering the scene change
     */
    public static void loadQuizScene(ActionEvent event) {
        loadScene(event, "/quiz.fxml");
    }

    /**
     * Loads the lesson completion screen.
     * 
     * @param event the ActionEvent triggering the scene change
     */
    public static void loadLessonCompletedScene(ActionEvent event) {
        loadScene(event, "/lessonCompleted.fxml");
    }

    /**
     * Handles starting a lesson quiz manually.
     * 
     * @param event the ActionEvent triggered by a user action
     */
    @FXML
    private void handleStartLessonQuiz(ActionEvent event) {
        SceneManager.loadQuizScene(event);
    }

    /**
     * Handles navigation to the song screen manually.
     * 
     * @param event the ActionEvent triggered by a user action
     */
    @FXML
    private void handleGoToSongScreen(ActionEvent event) {
        SceneManager.loadScene(event, "/song.fxml");
    }

    /**
     * Handles returning to the login screen manually.
     * 
     * @param event the ActionEvent triggered by a user action
     */
    @FXML
    private void handleReturnToLogin(ActionEvent event) {
        SceneManager.loadScene(event, "/login.fxml");
    }

    /**
     * Loads the lesson selection scene.
     * 
     * @param event the ActionEvent triggering the scene change
     */
    public static void loadLessonScene(ActionEvent event) {
        loadScene(event, "/lesson.fxml");
    }
}