package com.aldrin.salam;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PrimaryController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Add your authentication logic here
        if (authenticate(username, password)) {
            try {
                Parent secondaryRoot = FXMLLoader.load(getClass().getResource("secondary.fxml"));
                Scene secondaryScene = new Scene(secondaryRoot);
                Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                primaryStage.setScene(secondaryScene);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error loading the secondary.fxml file");
            }
        } else {
            // Handle failed login attempt
            System.out.println("Login failed!");
        }
    }

    private boolean authenticate(String username, String password) {
        // Replace with your actual authentication logic
        return username.equals("admin") && password.equals("123");
    }
}