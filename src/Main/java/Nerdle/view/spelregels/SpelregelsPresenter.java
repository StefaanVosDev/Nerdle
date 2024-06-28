package Nerdle.view.spelregels;

import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class SpelregelsPresenter {
    private final SpelregelsView view;

    public SpelregelsPresenter(SpelregelsView view) {
        this.view = view;
        this.addEventHandlers();
        this.updateview();
    }

    private void addEventHandlers() {

        PauseTransition pause = new PauseTransition(Duration.ONE);
       pause.setOnFinished(actionEvent -> view.getScene().getWindow().hide());

        view.getBtnTerug().setOnAction(actionEvent -> view.getScene().getWindow().hide());

    }

    private void updateview() {
    }
}


