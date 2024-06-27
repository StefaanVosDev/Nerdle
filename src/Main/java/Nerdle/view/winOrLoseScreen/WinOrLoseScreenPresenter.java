package Nerdle.view.winOrLoseScreen;

import Nerdle.model.ProgrammaModel;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class WinOrLoseScreenPresenter {
    private ProgrammaModel model;
    private WinOrLoseScreenView view;

    public WinOrLoseScreenPresenter(ProgrammaModel model, WinOrLoseScreenView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        PauseTransition pauze = new PauseTransition(Duration.seconds(3));

        pauze.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                view.getScene().getWindow().hide();
            }
        });
        pauze.playFromStart();
    }

    private void updateView() {

    }
}
