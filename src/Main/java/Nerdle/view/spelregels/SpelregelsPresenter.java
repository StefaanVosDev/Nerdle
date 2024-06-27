package Nerdle.view.spelregels;

import Nerdle.model.ProgrammaModel;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class SpelregelsPresenter {
    private ProgrammaModel model;
    private SpelregelsView view;

    public SpelregelsPresenter(ProgrammaModel model, SpelregelsView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateview();
    }

    private void addEventHandlers() {

        PauseTransition pause = new PauseTransition(Duration.ONE);
       pause.setOnFinished(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {
               view.getScene().getWindow().hide();
           }
       });

        view.getBtnTerug().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                view.getScene().getWindow().hide();
            }
        });

    }

    private void updateview() {
    }
}


