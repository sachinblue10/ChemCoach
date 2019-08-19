package controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import model.SceneController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class created by Sach
 */

public class CalculatorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button stoichiometry;

    @FXML
    private Button atomicStructure;

    @FXML
    private Button energetics;

    @FXML
    private Button kinetics;

    @FXML
    private Button toMenuPage;

    @FXML
    void initialize() {
        toMenuPage.setOnAction(event -> {
            try {
                new SceneController(anchorPane).switchScene("Menu");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        stoichiometry.setOnAction(event -> {
            try {
                new SceneController(anchorPane).switchScene("Stoichiometry");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        toMenuPage.setOnAction(event -> {
            try {
                new SceneController(anchorPane).switchScene("Menu");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

//        atomicStructure.setOnAction(event -> new SceneController(anchorPane).activate("Atomic Structure"));
//        energetics.setOnAction(event -> new SceneController(anchorPane).activate("Energetics"));
//        kinetics.setOnAction(event -> new SceneController(anchorPane).activate("Kinematics"));

    }
}

