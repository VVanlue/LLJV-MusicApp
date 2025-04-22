package com.lljvmusicapp.controller;

import java.io.IOException;

import com.lljvmusicapp.model.Facade;

import com.lljvmusicapp.model.Lesson;
import com.lljvmusicapp.model.LessonList;
import com.lljvmusicapp.model.Song;
import com.lljvmusicapp.model.SongList;
import com.lljvmusicapp.model.User;

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
    
    private Facade facade;

    public void setFacade(Facade facade) //BE SURE TO CALL THIS FIRST
    {
        this.facade = facade;
    }

    public void setWelcomeLabel()
    {
        String username = this.facade.getCurrentUser().getUsername();
        welcomeLabel.setText("Welcome, " + username + "!");
    }
}