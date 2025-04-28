package com.lljvmusicapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.lljvmusicapp.App;
import com.lljvmusicapp.model.DataWriter;
import com.lljvmusicapp.model.MusicPlaying;
import com.lljvmusicapp.model.Song;
import com.lljvmusicapp.model.SongList;
import com.lljvmusicapp.model.UserList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * Controller for the Play Notes screen.
 * Allows users to play notes with their keyboard, record them, and save as new songs.
 * Also handles returning to the dashboard screen.
 * 
 * @author Victoria
 */
public class PlayNotesController {

    private List<String> recordedNotes = new ArrayList<>();

    @FXML private Button saveButton;
    @FXML private Button returnButton;
    @FXML private Label currentNoteLabel;

    /**
     * Handles keyboard input for playing and recording notes.
     * Updates the current note label when a key is pressed.
     * 
     * @param event The key event triggered by user input.
     */
    @FXML
    private void handleKeyPress(KeyEvent event) {
        MusicPlaying.getInstance().handleKeyInput(event);

        String note = detectNotePressed(event);

        if (note != null && event.getEventType() == KeyEvent.KEY_PRESSED) {
            recordedNotes.add(note);
            currentNoteLabel.setText("Playing: " + note);
        }
    }

    /**
     * Handles saving the recorded notes as a new song.
     * Prompts the user for a song title and saves the song data.
     * 
     * @param event The action event triggered by pressing the save button.
     */
    @FXML
    private void handleSaveSong(ActionEvent event) {
        if (recordedNotes.isEmpty()) {
            System.out.println("No notes recorded.");
            return;
        }

        TextInputDialog dialog = new TextInputDialog("My New Song");
        dialog.setTitle("Save Song");
        dialog.setHeaderText("Enter a title for your new song:");
        dialog.setContentText("Song title:");

        dialog.showAndWait().ifPresent(title -> {
            if (title.trim().isEmpty()) {
                title = "Untitled Song";
            }

            String joinedNotes = String.join(" ", recordedNotes);

            Song newSong = new Song(
                UUID.randomUUID(),
                title,
                120,             // tempo
                "Unknown",       // genre
                "Piano",         // instrument
                joinedNotes,     // song string
                "EASY",          // difficulty
                "MyNewSong.mp3"
            );

            UserList.getCurrentUser().addPublishedSong(newSong.getId().toString());
            SongList.getInstance().addSong(newSong);
            DataWriter.saveSongs();
            DataWriter.saveUsers();
            System.out.println("Song saved: " + newSong.getTitle());
        });
    }

    /**
     * Handles returning the user to the dashboard screen.
     * 
     * @param event The action event triggered by pressing the return button.
     */
    @FXML
    private void handleReturnToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/dashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) returnButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Detects which musical note was pressed based on keyboard input.
     * Supports shift for sharp notes.
     * 
     * @param event The key event triggered by user input.
     * @return The corresponding note name, or null if no note key was pressed.
     */
    private String detectNotePressed(KeyEvent event) {
        boolean shiftDown = event.isShiftDown();
        switch (event.getCode()) {
            case A:
                return shiftDown ? "A#" : "A";
            case B:
                return "B";
            case C:
                return shiftDown ? "C#" : "C";
            case D:
                return shiftDown ? "D#" : "D";
            case E:
                return "E";
            case F:
                return shiftDown ? "F#" : "F";
            case G:
                return shiftDown ? "G#" : "G";
            default:
                return null;
        }
    }
}