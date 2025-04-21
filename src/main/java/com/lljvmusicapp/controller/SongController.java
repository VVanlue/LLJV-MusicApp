package com.lljvmusicapp.controller;

import com.lljvmusicapp.model.Keyboard;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Controller for the Song Playing screen where users press keys to hear notes.
 * 
 * @author Victoria
 */
public class SongController {

    /**
     * Handles key presses on the song screen and forwards to the Keyboard logic.
     * 
     * @param event The key event from the user.
     */
    @FXML
    public void handleKeyPress(KeyEvent event) {
        String key = event.getText().toUpperCase();
        boolean isShift = event.isShiftDown();
        boolean isSpace = event.getCode() == KeyCode.SPACE;

        // Only handle letter keys A–G
        if ("ABCDEFG".contains(key)) {
            Keyboard.handleKeyPress(key, isShift, isSpace);
        }
    }
}