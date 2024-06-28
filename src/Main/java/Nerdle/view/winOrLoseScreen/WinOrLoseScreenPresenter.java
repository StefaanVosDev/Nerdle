package Nerdle.view.winOrLoseScreen;

import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class WinOrLoseScreenPresenter {
    private final WinOrLoseScreenView view;

    public WinOrLoseScreenPresenter(WinOrLoseScreenView view) {
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        PauseTransition pauze = new PauseTransition(Duration.seconds(3));

        pauze.setOnFinished(actionEvent -> view.getScene().getWindow().hide());
        pauze.playFromStart();
    }

    private void updateView() {

    }
}
