package com.lljvmusicapp;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"), 900, 600);
        
        File cssFile = new File("src/main/resources/styles.css");
        scene.getStylesheets().add(cssFile.toURI().toString());
        
        stage.setTitle("Victoria's Music App");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));

        File cssFile = new File("src/main/resources/styles.css");
        scene.getStylesheets().clear(); 
        scene.getStylesheets().add(cssFile.toURI().toString());
     }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

    

}