package controller;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import animation.Shaker;
import database.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.AlertBox;
import model.SceneController;

/**
 * Class created by Sach
 */

public class LogInController {

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
    private Button logInButton;

    @FXML
    private Button signUpButton;

    @FXML
    void initialize() {
        logInButton.setOnAction(event -> {
            try {
                int index = 0;
                ArrayList<String> usernames = Database.getUsernames();
                ArrayList<String> passwords = Database.getPasswords();
                for (String user : usernames) {
                    if (username.getText().equals(user)) {
                        found = true;
                        break;
                    }
                    index++;
                }
                if (!found) {
                    AlertBox.display("Error", "Username doesn't exist");
                    Shaker shaker = new Shaker(username);
                    shaker.shake();
                    username.setText("");
                    username.positionCaret(0);
                } else {
                    if (password.getText().equals(passwords.get(index))) {
                        new SceneController(anchorPane).activate("Menu");
                    } else {
                        Shaker shaker = new Shaker(password);
                        shaker.shake();
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        signUpButton.setOnAction(event -> new SceneController(anchorPane).activate("SignUp"));
    }

}

