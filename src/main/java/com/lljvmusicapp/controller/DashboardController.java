package com.lljvmusicapp.controller;

import java.io.IOException;

import com.lljvmusicapp.model.Lesson;
import com.lljvmusicapp.model.LessonList;
import com.lljvmusicapp.model.Song;
import com.lljvmusicapp.model.SongList;
import com.lljvmusicapp.model.User;
import com.lljvmusicapp.model.UserList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class DashboardController {

    @FXML private Label welcomeLabel;
    @FXML private ListView<String> favSongsList;
    @FXML private ListView<String> lessonsList;
    @FXML private ListView<String> songsList;
    @FXML private Button loginRedirectButton;

    @FXML
    public void initialize() {
        User currentUser = UserList.getCurrentUser();
        setUser(currentUser);
    }
    
    public void setUser(User user) {
        if (user == null) {
            welcomeLabel.setText("Welcome, Guest!");
            favSongsList.getItems().add("Login to view favorite songs.");
        } else {
            welcomeLabel.setText("Welcome, " + user.getFirstName());
            for (String songId : user.getFavSongs()) {
                favSongsList.getItems().add("Song ID: " + songId);
            }
        }

        for (Lesson lesson : LessonList.getInstance().getLessons()) {
            lessonsList.getItems().add(lesson.getTitle());
        }

        for (Song song : SongList.getInstance().getSongs()) {
            songsList.getItems().add(song.getTitle() + " - " + song.getGenre());
        }
    }

    @FXML
    private void handleReturnToLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) welcomeLabel.getScene().getWindow();
            stage.setScene(new Scene(root, 640, 480));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleStartLessonQuiz() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lesson.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) welcomeLabel.getScene().getWindow();
            stage.setScene(new Scene(root, 640, 480));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleGoToSongScreen(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/song.fxml"));
            Scene songScene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(songScene);
            stage.setTitle("Play Notes");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}