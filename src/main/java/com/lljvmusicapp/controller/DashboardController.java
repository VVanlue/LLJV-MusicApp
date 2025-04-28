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
    @FXML private ListView<String> completedLessonsList;
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
            favSongsList.getItems().clear();
            lessonsList.getItems().clear();
            completedLessonsList.getItems().clear();
            songsList.getItems().clear();
            favSongsList.getItems().add("Login to view favorite songs.");
        } else {
            welcomeLabel.setText("Welcome, " + user.getFirstName() + "!");

            favSongsList.getItems().clear();
            if (user.getFavSongs() != null) {
                for (String songId : user.getFavSongs()) {
                    Song song = SongList.getInstance().getSongs().stream()
                        .filter(s -> s.getId().toString().equals(songId))
                        .findFirst()
                        .orElse(null);
                    if (song != null) {
                        favSongsList.getItems().add(song.getTitle() + " - " + song.getGenre());
                    } else {
                        favSongsList.getItems().add("(Unknown Song)");
                    }
                }
            }

            lessonsList.getItems().clear();
            for (Lesson lesson : LessonList.getInstance().getLessons()) {
                lessonsList.getItems().add(lesson.getTitle());
            }

            completedLessonsList.getItems().clear();
            if (user.getCompletedLessons() != null) {
                for (String lessonId : user.getCompletedLessons()) {
                    Lesson lesson = LessonList.getInstance().getLessons().stream()
                        .filter(l -> l.getLessonId().toString().equals(lessonId))
                        .findFirst()
                        .orElse(null);
                    if (lesson != null) {
                        completedLessonsList.getItems().add(lesson.getTitle());
                    } else {
                        completedLessonsList.getItems().add("(Unknown Lesson)");
                    }
                }
            }
    
            songsList.getItems().clear();
            for (Song song : SongList.getInstance().getSongs()) {
                songsList.getItems().add(song.getTitle() + " - " + song.getGenre());
            }
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

    @FXML
    private void handleGoToPlayNotes(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/playnotes.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 640, 480));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}