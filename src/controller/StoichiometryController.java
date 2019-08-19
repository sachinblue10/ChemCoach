package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import model.SceneController;

/**
 * Class created by Sach
 */


public class StoichiometryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button one;

    @FXML
    private Button two;

    @FXML
    private Button toCalculatorPage;

    @FXML
    private Button menu;

    @FXML
    void initialize() {
        toCalculatorPage.setOnAction(event -> {
            try {
                new SceneController(anchorPane).switchScene("Calculator");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        menu.setOnAction(event -> {
            try {
                new SceneController(anchorPane).switchScene("Menu");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
