package model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

/**
 * Class created by Sach
 */

public class SceneController {

    private static final String BASE_PATH = "/view/";

    private Pane pane;
    private HashMap<String, Pane> screenMap = new HashMap<>() {{
        try {
            put("LogIn", FXMLLoader.load(getClass().getResource(BASE_PATH + "LogIn.fxml")));
            put("SignUp", FXMLLoader.load(getClass().getResource(BASE_PATH + "SignUp.fxml")));
            put("Menu", FXMLLoader.load(getClass().getResource(BASE_PATH + "Menu.fxml")));
            put("Calculator", FXMLLoader.load(getClass().getResource(BASE_PATH + "Calculator.fxml")));
            put("Stoichimoetry", FXMLLoader.load(getClass().getResource(BASE_PATH + "Stoichiometry.fxml")));
//            put("Atomic Structure", FXMLLoader.load(getClass().getResource(BASE_PATH + "AtomicStructure.fxml")));
//            put("Energetics", FXMLLoader.load(getClass().getResource(BASE_PATH + "Energetics.fxml")));
//            put("Kinematics", FXMLLoader.load(getClass().getResource(BASE_PATH + "Kinematics.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }};

    public SceneController(Pane pane) {
        this.pane = pane;
    }

    public void addScreen(String name) throws IOException {
        screenMap.put(name, FXMLLoader.load(getClass().getResource(BASE_PATH + WordUtils.capitalize(name) + ".fxml")));
    }

    public void removeScreen(String name) {
        screenMap.remove(name);
    }

    public void activate(String name) {
        activate(name, 600, 400);
    }

    public void activate(String name, int width, int height) {
        Pane window = screenMap.get(name);
        pane.getChildren().setAll(window);
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setTitle(WordUtils.capitalize(name));
    }

    public void switchScene(String name) throws IOException {
        Stage oldStage = (Stage) pane.getScene().getWindow();
        oldStage.close();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(BASE_PATH + name + ".fxml"));
        loader.load();
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(WordUtils.capitalize(name));
        stage.show();
    }

}
