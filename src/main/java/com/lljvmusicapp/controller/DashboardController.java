package com.lljvmusicapp.controller;

import com.lljvmusicapp.model.Lesson;
import com.lljvmusicapp.model.LessonList;
import com.lljvmusicapp.model.Song;
import com.lljvmusicapp.model.SongList;
import com.lljvmusicapp.model.User;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class DashboardController {

    @FXML private Label welcomeLabel;
    @FXML private ListView<String> favSongsList;
    @FXML private ListView<String> lessonsList;
    @FXML private ListView<String> songsList;

    public void setUser(User user) {
        welcomeLabel.setText("Welcome, " + user.getFirstName());

        for (String songId : user.getFavSongs()) {
            favSongsList.getItems().add("Song ID: " + songId);
        }

        for (Lesson lesson : LessonList.getInstance().getLessons()) {
            lessonsList.getItems().add(lesson.getTitle());
        }

        for (Song song : SongList.getInstance().getSongs()) {
            songsList.getItems().add(song.getTitle() + " - " + song.getGenre());
        }
    }
}