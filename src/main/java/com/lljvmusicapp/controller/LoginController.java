package com.lljvmusicapp.controller;

import com.lljvmusicapp.model.Facade;
import com.lljvmusicapp.model.User;
import com.lljvmusicapp.model.UserList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (Facade.UserLogin(username, password)) {
            User user = Facade.getCurrentUser();

            UserList.setCurrentUser(user);

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/dashboard.fxml"));
                Parent root = loader.load();

                DashboardController controller = loader.getController();
                controller.setUser(user);

                Stage stage = (Stage) usernameField.getScene().getWindow();
                stage.setScene(new Scene(root, 640, 480));
            } catch (Exception e) {
                e.printStackTrace();
                errorLabel.setText("Failed to load dashboard.");
            }
        } else {
            errorLabel.setText("Invalid username or password.");
        }
    }

    @FXML
private void handleSkipLogin() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/dashboard.fxml"));
        Parent root = loader.load();

        DashboardController controller = loader.getController();
        controller.setUser(null); // or you can create a guest user here

        Stage stage = (Stage) usernameField.getScene().getWindow();
        stage.setScene(new Scene(root, 640, 480));
    } catch (Exception e) {
        e.printStackTrace();
        errorLabel.setText("Failed to load dashboard.");
    }
}
}