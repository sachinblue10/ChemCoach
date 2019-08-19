package controller;

import database.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.AlertBox;
import model.SceneController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Class created by Sach
 */


public class SignUpController {

    private final String user_regex = "^(?=.{5,15}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
    private final String pass_regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{5,}$";

    private boolean found = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button signUpButton;

    @FXML
    private Button toLoginPage;

    @FXML
    void initialize() {
        signUpButton.setOnAction(event -> {
            try {
                ArrayList<String> usernames = Database.getUsernames();
                for (String user : usernames) {
                    if (username.getText().equals(user)) {
                        AlertBox.display("Error", "This username already exists");
                        clearFields();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    if (!username.getText().matches(user_regex)) {
                        AlertBox.display("Username Error", "Your username must be 5-15 characters long");
                        clearFields();
                    }
                    if (!password.getText().matches(pass_regex)) {
                        AlertBox.display("Password Error", "Your password must contain at least one letter and one number");
                        clearFields();
                    }
                    if (username.getText().matches(user_regex) && password.getText().matches(pass_regex)) {
                        Database.addUsername(username.getText());
                        Database.addPassword(password.getText());
                        new SceneController(anchorPane).activate("Menu");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        toLoginPage.setOnAction(event -> {
            try {
                new SceneController(anchorPane).switchScene("LogIn");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void clearFields() {
        username.setText("");
        username.positionCaret(0);
        password.setText("");
        password.positionCaret(0);
    }

}

