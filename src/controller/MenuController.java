package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import model.SceneController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class created by Sach
 */

public class MenuController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button quiz;

    @FXML
    private Button calculator;

    @FXML
    void initialize() {
        calculator.setOnAction(event -> new SceneController(anchorPane).activate("Calculator"));
    }

}



