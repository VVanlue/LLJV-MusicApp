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
                    // Assuming you have a field like private MediaPlayer mediaPlayer;
                    if (mediaPlayer != null) {
                        mediaPlayer.stop(); // Stop previous
                    }
    
                    // Songs stored under /resources/songs/ (example)
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
                        loadingLabel.setText(""); // Clear when ready
                        mediaPlayer.play();
                        nowPlayingLabel.setText("Now Playing: " + currentlyPlayingSong.getTitle());
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    private void handleStopSong() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            nowPlayingLabel.setText("Stopped");
        }
    }

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