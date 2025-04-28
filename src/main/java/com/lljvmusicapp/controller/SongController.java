package com.lljvmusicapp.controller;

import java.io.IOException;
import java.net.URL;

import org.jfugue.player.Player;

import com.lljvmusicapp.App;
import com.lljvmusicapp.model.Facade;
import com.lljvmusicapp.model.Song;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * Controller for the song screen where users can select and play songs.
 * Handles song selection, playback, stopping music, and returning to the dashboard.
 * 
 * @author Victoria
 */
public class SongController {

    @FXML private ListView<String> songListView;
    @FXML private Label nowPlayingLabel;
    @FXML private Button playSongButton;
    @FXML private Button stopSongButton;
    @FXML private Button returnButton;
    @FXML private Label loadingLabel;

    private Song currentlyPlayingSong = null;
    private boolean isPlaying = false;
    private Player player = new Player();
    private MediaPlayer mediaPlayer;

    /**
     * Initializes the song list view by loading available song titles.
     * Sets up a listener to update the current selection label.
     */
    @FXML
    public void initialize() {
        ObservableList<String> songTitles = FXCollections.observableArrayList();

        for (Song song : Facade.SongList()) {
            songTitles.add(song.getTitle());
        }

        songListView.setItems(songTitles);

        songListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newSongName) -> {
            if (newSongName != null) {
                nowPlayingLabel.setText("Song: " + newSongName);
            }
        });
    }

    /**
     * Handles playing the selected song from the list.
     * Loads the song file and plays it through the MediaPlayer.
     */
    @FXML
    private void handlePlaySong() {
        String selectedTitle = songListView.getSelectionModel().getSelectedItem();
        if (selectedTitle != null) {
            currentlyPlayingSong = Facade.SongList().stream()
                .filter(song -> song.getTitle().equalsIgnoreCase(selectedTitle))
                .findFirst()
                .orElse(null);

            if (currentlyPlayingSong != null) {
                try {
                    if (mediaPlayer != null) {
                        mediaPlayer.stop(); // Stop previous song if playing
                    }
    
                    String songFileName = currentlyPlayingSong.getSongFileName();
                    URL resource = getClass().getResource("/songs/" + songFileName);
    
                    if (resource == null) {
                        System.out.println("Could not find song file: " + songFileName);
                        return;
                    }

                    loadingLabel.setText("Loading...");
    
                    Media media = new Media(resource.toString());
                    mediaPlayer = new MediaPlayer(media);
                    
                    mediaPlayer.setOnReady(() -> {
                        loadingLabel.setText(""); // Clear loading message
                        mediaPlayer.play();
                        nowPlayingLabel.setText("Now Playing: " + currentlyPlayingSong.getTitle());
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Stops the currently playing song.
     * Updates the label to show that playback has stopped.
     */
    @FXML
    private void handleStopSong() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            nowPlayingLabel.setText("Stopped");
        }
    }

    /**
     * Handles returning the user to the dashboard screen.
     * Stops any music that is playing before navigating.
     * 
     * @param event The action event triggered by clicking the return button.
     */
    @FXML
    private void handleReturnToDashboard(ActionEvent event) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
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
}