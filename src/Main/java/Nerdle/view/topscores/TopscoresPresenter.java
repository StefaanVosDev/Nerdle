package Nerdle.view.topscores;

public class TopscoresPresenter {
    private final TopscoresView view;

    public TopscoresPresenter(TopscoresView view) {
        this.view = view;
        this.addEventhandlers();
        this.updateview();
    }

    private void addEventhandlers() {
        view.getBtnTerug().setOnAction(actionEvent -> view.getScene().getWindow().hide());
    }

    private void updateview() {

    }
}
