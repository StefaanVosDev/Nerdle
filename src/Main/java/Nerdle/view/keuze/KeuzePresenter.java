package Nerdle.view.keuze;

import Nerdle.model.Game;
import Nerdle.model.ProgrammaModel;
import Nerdle.view.game.GamePresenter;
import Nerdle.view.game.GameView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.regex.Pattern;

public class KeuzePresenter {
    private final KeuzeView view;

    public KeuzePresenter(KeuzeView view) {
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        view.getBtnStartSpel().setOnAction(actionEvent -> {
            if (Pattern.matches("^[A-Za-z\\s]+$", view.getTxtVoornaam().getText()) &&
                    Pattern.matches("^[A-Za-z\\s]+$", view.getTxtAchternaam().getText()) &&
                    Pattern.matches("[0-9]+", view.getTxtLengteBewerking().getText()) &&
                    Pattern.matches("[0-9]+", view.getTxtAantalPogingen().getText()) &&
                    Integer.parseInt(view.getTxtLengteBewerking().getText()) > 5 &&
                    Integer.parseInt(view.getTxtLengteBewerking().getText()) < 13 &&
                    Integer.parseInt(view.getTxtAantalPogingen().getText()) >= 4 &&
                    Integer.parseInt(view.getTxtAantalPogingen().getText()) <= 10
            ) {
                GameView gameView = new GameView();
                ProgrammaModel model = new ProgrammaModel();
                model.setGame(new Game(view.getTxtVoornaam().getText(), view.getTxtAchternaam().getText(), Integer.parseInt(view.getTxtLengteBewerking().getText()), Integer.parseInt(view.getTxtAantalPogingen().getText())));

                gameView.setPrefSize(400, 500);
                view.getScene().getWindow().setX(view.getScene().getWindow().getX()-120);
                view.getScene().getWindow().setY(view.getScene().getWindow().getY() -200);

                view.getScene().getWindow().setWidth(530);
                view.getScene().getWindow().setHeight(700);


                new GamePresenter(model, gameView);

                view.getScene().setRoot(gameView);

            } else {
                view.getLblFoutBoodschap().setVisible(true);
            }

        });
        view.getBtnAnnuleren().setOnAction(actionEvent -> view.getScene().getWindow().hide());
        view.getTxtVoornaam().setOnKeyReleased(keyEvent -> {
            if (!Pattern.matches("^[A-Za-z\\s]+$", view.getTxtVoornaam().getText())) {
                view.getTxtVoornaam().setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            } else {
                view.getTxtVoornaam().setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            }
        });
        view.getTxtAchternaam().setOnKeyReleased(keyEvent -> {
            if (!Pattern.matches("^[A-Za-z\\s]+$", view.getTxtAchternaam().getText())) {
                view.getTxtAchternaam().setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            } else {
                view.getTxtAchternaam().setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            }
        });
        view.getTxtLengteBewerking().setOnKeyReleased(keyEvent -> {
            if (!Pattern.matches("[0-9]+", view.getTxtLengteBewerking().getText()) ||
                    Integer.parseInt(view.getTxtLengteBewerking().getText()) <= 5 ||
                    Integer.parseInt(view.getTxtLengteBewerking().getText()) >= 13) {
                view.getTxtLengteBewerking().setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            } else {
                view.getTxtLengteBewerking().setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            }
        });
        view.getTxtAantalPogingen().setOnKeyReleased(keyEvent -> {
            if (!Pattern.matches("[0-9]+", view.getTxtAantalPogingen().getText()) ||
                    Integer.parseInt(view.getTxtAantalPogingen().getText()) < 4 ||
                    Integer.parseInt(view.getTxtAantalPogingen().getText()) > 10) {
                view.getTxtAantalPogingen().setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            } else {
                view.getTxtAantalPogingen().setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            }
        });
    }
    private void updateView() {

    }

    public void addWindowEventHandlers() {
        view.getScene().getWindow().setOnCloseRequest(windowEvent -> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Hierdoor stopt de huidige game");
            alert.setContentText("Ben je zeker dat je de game wilt verlaten?");
            alert.setTitle("Afbreken game");
            alert.getButtonTypes().clear();

            ButtonType neen = new ButtonType("Neen");
            ButtonType ja = new ButtonType("Ja");
            alert.getButtonTypes().addAll(neen, ja);
            alert.showAndWait();
            if (alert.getResult() == null || alert.getResult().equals(neen)) {
                windowEvent.consume();
            }
        });
    }

}
