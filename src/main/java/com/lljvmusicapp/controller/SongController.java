package com.lljvmusicapp.controller;

import java.io.IOException;

import org.jfugue.player.Player;
import org.jfugue.theory.Note;

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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * Controller so users can play a song chosen from a list
 * 
 * @author Laurin Johnson
 * @author Victoria
 */
public class SongController {

    @FXML private ListView<String> songListView;
    @FXML private Label nowPlayingLabel;
    @FXML private Button playSongButton;
    @FXML private Button stopSongButton;
    @FXML private Button returnButton;

    private Song currentlyPlayingSong = null;
    private boolean isPlaying = false;
    private Player player = new Player();

    @FXML
    public void initialize() {
        ObservableList<String> songTitles = FXCollections.observableArrayList();

        for (Song song : Facade.SongList())
        {
            songTitles.add(song.getTitle());
        }

        songListView.setItems(songTitles);

        songListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newSongName) -> {
            if (newSongName != null)
            {
            nowPlayingLabel.setText("Song: " + newSongName);
            }
        });
    }

    @FXML
    private void handlePlaySong() {
        String selectedTitle = songListView.getSelectionModel().getSelectedItem();
        if (selectedTitle != null && !isPlaying)
        {
            currentlyPlayingSong = Facade.SongList().stream()
                .filter(song -> song.getTitle().equalsIgnoreCase(selectedTitle))
                .findFirst()
                .orElse(null);

            if (currentlyPlayingSong != null)
            {
                isPlaying = true;
                new Thread(() -> {
                    for (Note note : currentlyPlayingSong.getNotes())
                    {
                        if (!isPlaying)
                        {
                            break;
                        }

                        System.out.println("Playing note: " + note.getToneString());
                        player.play(note);

                        try
                        {
                            Thread.sleep(60000 / currentlyPlayingSong.getTempo().getBPM()); // Timing based on BPM
                        }
                        
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }

                    isPlaying = false;
                }).start();
            }
        }
    }


    @FXML
    private void handleStopSong()
    {
        isPlaying = false;
    }

    @FXML
    private void handleReturnToDashboard(ActionEvent event)
    {
        isPlaying = false; // stop any playing song

        try
        {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/dashboard.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) returnButton.getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.show();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}