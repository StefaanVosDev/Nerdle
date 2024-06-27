package Nerdle.view.topscores;

import Nerdle.model.ProgrammaModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class TopscoresPresenter {
    private ProgrammaModel model;
    private TopscoresView view;

    public TopscoresPresenter(ProgrammaModel model, TopscoresView view) {
        this.model = model;
        this.view = view;
        this.addEventhandlers();
        this.updateview();
    }

    private void addEventhandlers() {
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
