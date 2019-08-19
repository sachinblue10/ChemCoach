package animation;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * Class created by Sach
 */

public class Shaker {

    private TranslateTransition transition;

    public Shaker(Node node) {
        transition = new TranslateTransition(Duration.millis(50), node);
        transition.setFromX(0f);
        transition.setByX(10f);
        transition.setCycleCount(4);
        transition.setAutoReverse(true);
    }

    public void shake() {
        transition.playFromStart();
    }

}