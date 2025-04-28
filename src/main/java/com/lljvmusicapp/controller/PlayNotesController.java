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

public class PlayNotesController {

    private List<String> recordedNotes = new ArrayList<>();

    @FXML private Button saveButton;
    @FXML private Button returnButton;
    @FXML private Label currentNoteLabel;

    @FXML
    private void handleKeyPress(KeyEvent event) {
        // Just let MusicPlaying do the playing and pressing
        MusicPlaying.getInstance().handleKeyInput(event);

        // But for displaying current note, we figure it out separately
        String note = detectNotePressed(event);

        if (note != null && event.getEventType() == KeyEvent.KEY_PRESSED) {
            recordedNotes.add(note);
            currentNoteLabel.setText("Playing: " + note);
        }
    }

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

            // Create a Song manually filling all 7 required fields
            Song newSong = new Song(
                UUID.randomUUID(),
                title,
                120,             // tempo
                "Unknown",       // genre
                "Piano",         // instrument
                joinedNotes,     // song string
                "EASY",           // difficulty
                "MyNewSong.mp3"
            );

            UserList.getCurrentUser().addPublishedSong(newSong.getId().toString());
            SongList.getInstance().addSong(newSong);
            DataWriter.saveSongs();
            DataWriter.saveUsers();
            System.out.println("Song saved: " + newSong.getTitle());
        });
    }

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
     * Helper method to detect note pressed, matching MusicPlaying logic.
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