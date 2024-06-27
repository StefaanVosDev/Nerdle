package Nerdle.view.keuze;

import Nerdle.model.Game;
import Nerdle.model.ProgrammaModel;
import Nerdle.view.game.GamePresenter;
import Nerdle.view.game.GameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.WindowEvent;

import java.util.regex.Pattern;

public class KeuzePresenter {
    private ProgrammaModel model;
    private KeuzeView view;

    public KeuzePresenter(ProgrammaModel model, KeuzeView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        view.getBtnStartSpel().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (Pattern.matches("^[A-Za-z\\s]+$", view.getTxtVoornaam().getText()) &&
                        Pattern.matches("^[A-Za-z\s]+$", view.getTxtAchternaam().getText()) &&
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


                    GamePresenter gamePresenter = new GamePresenter(model, gameView);

                    view.getScene().setRoot(gameView);

                } else {
                    view.getLblFoutBoodschap().setVisible(true);
                }

            }
        });
        view.getBtnAnnuleren().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                view.getScene().getWindow().hide();
            }
        });
        view.getTxtVoornaam().setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!Pattern.matches("^[A-Za-z\\s]+$", view.getTxtVoornaam().getText())) {
                    view.getTxtVoornaam().setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                } else {
                    view.getTxtVoornaam().setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                }
            }
        });
        view.getTxtAchternaam().setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!Pattern.matches("^[A-Za-z\\s]+$", view.getTxtAchternaam().getText())) {
                    view.getTxtAchternaam().setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                } else {
                    view.getTxtAchternaam().setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                }
            }
        });
        view.getTxtLengteBewerking().setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!Pattern.matches("[0-9]+", view.getTxtLengteBewerking().getText()) ||
                        Integer.parseInt(view.getTxtLengteBewerking().getText()) <= 5 ||
                        Integer.parseInt(view.getTxtLengteBewerking().getText()) >= 13) {
                    view.getTxtLengteBewerking().setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                } else {
                    view.getTxtLengteBewerking().setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                }
            }
        });
        view.getTxtAantalPogingen().setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!Pattern.matches("[0-9]+", view.getTxtAantalPogingen().getText()) ||
                        Integer.parseInt(view.getTxtAantalPogingen().getText()) < 4 ||
                        Integer.parseInt(view.getTxtAantalPogingen().getText()) > 10) {
                    view.getTxtAantalPogingen().setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                } else {
                    view.getTxtAantalPogingen().setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                }
            }
        });
    }
    private void updateView() {

    }

    public void addWindowEventHandlers() {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
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
            }
        });
    }

}
