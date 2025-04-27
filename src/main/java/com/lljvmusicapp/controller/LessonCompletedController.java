package com.lljvmusicapp.controller;

import com.lljvmusicapp.util.SceneManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Controller for the Lesson Completed screen.
 * Handles returning to the dashboard after a lesson is completed.
 * @author Victoria
 */
public class LessonCompletedController {

    /**
     * Returns the user to the dashboard screen.
     * @param event the action event triggered by clicking the button
     */
    @FXML
    private void returnToDashboard(ActionEvent event) {
        SceneManager.loadDashboardScene(event);
    }
}