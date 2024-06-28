package Nerdle.view.game;


import Nerdle.model.*;
import Nerdle.view.winOrLoseScreen.WinOrLoseScreenPresenter;
import Nerdle.view.winOrLoseScreen.WinOrLoseScreenView;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class GamePresenter {
    private final ProgrammaModel model;
    private final GameView view;

    public GamePresenter(ProgrammaModel model, GameView view) {
        this.model = model;
        this.view = view;
        this.updateView();
        this.addEventHandlers();
    }

    private void addEventHandlers() {
        view.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            if (keyEvent.getCode() == KeyCode.NUMPAD0 || keyEvent.getCode() == KeyCode.DIGIT0) {
                if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                    model.getGame().getHuidigePogingInOpbouw().add(new Getal(0));
                    updateView();
                }
            } else if (keyEvent.getCode() == KeyCode.NUMPAD1 || keyEvent.getCode() == KeyCode.DIGIT1) {

                if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                    model.getGame().getHuidigePogingInOpbouw().add(new Getal(1));
                    updateView();
                }
            } else if (keyEvent.getCode() == KeyCode.NUMPAD2 || keyEvent.getCode() == KeyCode.DIGIT2) {
                if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                    model.getGame().getHuidigePogingInOpbouw().add(new Getal(2));
                    updateView();
                }
            } else if (keyEvent.getCode() == KeyCode.NUMPAD3 || keyEvent.getCode() == KeyCode.DIGIT3) {
                if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                    model.getGame().getHuidigePogingInOpbouw().add(new Getal(3));
                    updateView();
                }
            } else if (keyEvent.getCode() == KeyCode.NUMPAD4 || keyEvent.getCode() == KeyCode.DIGIT4) {
                if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                    model.getGame().getHuidigePogingInOpbouw().add(new Getal(4));
                    updateView();
                }
            } else if (keyEvent.getCode() == KeyCode.NUMPAD5 || keyEvent.getCode() == KeyCode.DIGIT5) {
                if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                    model.getGame().getHuidigePogingInOpbouw().add(new Getal(5));
                    updateView();
                }
            } else if (keyEvent.getCode() == KeyCode.NUMPAD6 || keyEvent.getCode() == KeyCode.DIGIT6) {
                if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                    model.getGame().getHuidigePogingInOpbouw().add(new Getal(6));
                    updateView();
                }
            } else if (keyEvent.getCode() == KeyCode.NUMPAD7 || keyEvent.getCode() == KeyCode.DIGIT7) {
                if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                    model.getGame().getHuidigePogingInOpbouw().add(new Getal(7));
                    updateView();
                }
            } else if (keyEvent.getCode() == KeyCode.NUMPAD8 || keyEvent.getCode() == KeyCode.DIGIT8) {
                if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                    model.getGame().getHuidigePogingInOpbouw().add(new Getal(8));
                    updateView();
                }
            } else if (keyEvent.getCode() == KeyCode.NUMPAD9 || keyEvent.getCode() == KeyCode.DIGIT9) {
                if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                    model.getGame().getHuidigePogingInOpbouw().add(new Getal(9));
                    updateView();
                }
            } else if (keyEvent.getCode() == KeyCode.PLUS || keyEvent.getCode() == KeyCode.ADD) {
                if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                    model.getGame().getHuidigePogingInOpbouw().add(new Plus());
                    updateView();
                }
            } else if (keyEvent.getCode() == KeyCode.MINUS || keyEvent.getCode() == KeyCode.SUBTRACT) {
                if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                    model.getGame().getHuidigePogingInOpbouw().add(new Min());
                    updateView();
                }
            } else if (keyEvent.getCode() == KeyCode.MULTIPLY) {
                if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                    model.getGame().getHuidigePogingInOpbouw().add(new Maal());
                    updateView();
                }
            } else if (keyEvent.getCode() == KeyCode.DIVIDE) {
                if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                    model.getGame().getHuidigePogingInOpbouw().add(new Deel());
                    updateView();
                }
            } else if (keyEvent.getCode() == KeyCode.EQUALS) {
                if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                    model.getGame().getHuidigePogingInOpbouw().add(new IsTeken());
                    updateView();
                }
            } else if (keyEvent.getCode() == KeyCode.DELETE || keyEvent.getCode() == KeyCode.BACK_SPACE) {
                if (!model.getGame().getHuidigePogingInOpbouw().isEmpty()) {
                    model.getGame().getHuidigePogingInOpbouw().remove(model.getGame().getHuidigePogingInOpbouw().size() - 1);
                    updateView();
                }
            }
        });

        view.getGetal0().setOnAction(actionEvent -> {
            if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                model.getGame().getHuidigePogingInOpbouw().add(new Getal(0));
                updateView();
            }
        });
        view.getGetal1().setOnAction(actionEvent -> {
            if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                model.getGame().getHuidigePogingInOpbouw().add(new Getal(1));
                updateView();
            }
        });
        view.getGetal2().setOnAction(actionEvent -> {
            if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                model.getGame().getHuidigePogingInOpbouw().add(new Getal(2));
                updateView();
            }
        });
        view.getGetal3().setOnAction(actionEvent -> {
            if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                model.getGame().getHuidigePogingInOpbouw().add(new Getal(3));
                updateView();
            }
        });
        view.getGetal4().setOnAction(actionEvent -> {
            if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                model.getGame().getHuidigePogingInOpbouw().add(new Getal(4));
                updateView();
            }
        });
        view.getGetal5().setOnAction(actionEvent -> {
            if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                model.getGame().getHuidigePogingInOpbouw().add(new Getal(5));
                updateView();
            }
        });
        view.getGetal6().setOnAction(actionEvent -> {
            if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                model.getGame().getHuidigePogingInOpbouw().add(new Getal(6));
                updateView();
            }
        });
        view.getGetal7().setOnAction(actionEvent -> {
            if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                model.getGame().getHuidigePogingInOpbouw().add(new Getal(7));
                updateView();
            }
        });
        view.getGetal8().setOnAction(actionEvent -> {
            if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                model.getGame().getHuidigePogingInOpbouw().add(new Getal(8));
                updateView();
            }
        });
        view.getGetal9().setOnAction(actionEvent -> {
            if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                model.getGame().getHuidigePogingInOpbouw().add(new Getal(9));
                updateView();
            }
        });

        view.getMaal().setOnAction(actionEvent -> {
            if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                model.getGame().getHuidigePogingInOpbouw().add(new Maal());
                updateView();
            }
        });
        view.getDeel().setOnAction(actionEvent -> {
            if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                model.getGame().getHuidigePogingInOpbouw().add(new Deel());
                updateView();
            }
        });
        view.getMin().setOnAction(actionEvent -> {
            if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                model.getGame().getHuidigePogingInOpbouw().add(new Min());
                updateView();
            }
        });
        view.getPlus().setOnAction(actionEvent -> {
            if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                model.getGame().getHuidigePogingInOpbouw().add(new Plus());
                updateView();
            }
        });
        view.getIsTeken().setOnAction(actionEvent -> {
            if (model.getGame().getHuidigePogingInOpbouw().size() < model.getGame().getLengteBewerking()) {
                model.getGame().getHuidigePogingInOpbouw().add(new IsTeken());
                updateView();
            }
        });

        view.getDelete().setOnAction(actionEvent -> {
            if (!model.getGame().getHuidigePogingInOpbouw().isEmpty()) {
                model.getGame().getHuidigePogingInOpbouw().remove(model.getGame().getHuidigePogingInOpbouw().size() - 1);
                updateView();
            }
        });

        view.getEnter().setOnAction(actionEvent -> {
            var huidigePoging = model.getGame().getHuidigePogingInOpbouw();
            if (huidigePoging.size() == model.getGame().getLengteBewerking()) {
                if (huidigePoging.checkIfCorrecteOplossing()) {

                    if (huidigePoging.equals(model.getGame().getOpgave())) {

                        model.schrijfPogingTopscoreInCsv(new PogingVoorTopscores(model.getGame().getSpeler().getNaam(), model.getGame().getSpeler().getAchternaam(), model.getGame().getLengteBewerking(), model.getGame().getMaxAantalPogingen(), (int) ChronoUnit.SECONDS.between(model.getGame().getStartTijdstip(), LocalDateTime.now())));
                        view.getScene().getRoot().setDisable(true);
                        toonAfbeeldingGewonnen(true);

                        PauseTransition pauze = new PauseTransition(Duration.seconds(10));

                        pauze.setOnFinished(actionEvent1 -> view.getScene().getWindow().hide());
                        pauze.playFromStart();
                    }
                    model.getGame().getLijstFormules().add((Formule) huidigePoging.clone());
                    huidigePoging.clear();

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Foutboodschap");
                    alert.setContentText("Deze formule is niet wiskundig correct!");
                    alert.setTitle("Deze formule is niet wiskundig correct");

                    PauseTransition pauze = new PauseTransition(Duration.seconds(3));

                    pauze.setOnFinished(actionEvent12 -> alert.hide());
                    pauze.playFromStart();

                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Foutboodschap");
                alert.setContentText("Deze formule is niet lang genoeg!");
                alert.setTitle("Deze formule is niet lang genoeg");

                PauseTransition pauze = new PauseTransition(Duration.seconds(3));

                pauze.setOnFinished(actionEvent13 -> alert.hide());
                pauze.playFromStart();

                alert.showAndWait();
            }
            updateView();
        });

    }

    private void updateView() {
        this.view.getChildren().clear();
        this.view.getChildren().add(view.getImgNerdle());
        VBox vBoxSpel;

        vBoxSpel = visualiseerGame();
        this.view.getChildren().add(vBoxSpel);
    }

    private VBox visualiseerGame() {

        VBox vboxGame = new VBox();

        Button nieuweButton;

        GridPane mijnGridPane = new GridPane();

        for (Formule formule : model.getGame().getLijstFormules()) {
            for (WiskundigeOnderdeel wiskundigeOnderdeel : formule) {
                nieuweButton = formule.vakjeStatus(model.getGame().getOpgave(), wiskundigeOnderdeel, formule.indexOf(wiskundigeOnderdeel));

                nieuweButton.setDisable(true);
                nieuweButton.setPrefSize(470.0/model.getGame().getLengteBewerking(), 300.0/model.getGame().getMaxAantalPogingen());

                nieuweButton.setOpacity(1);

                mijnGridPane.add(nieuweButton, formule.indexOf(wiskundigeOnderdeel), model.getGame().getLijstFormules().indexOf(formule));
                nieuweButton.setFont(new Font("Impact", 20));
            }
        }

        if (model.getGame().getLijstFormules().size()==model.getGame().getMaxAantalPogingen()) {
            view.getScene().getRoot().setDisable(true);
            toonAfbeeldingGewonnen(false);

            PauseTransition pauze = new PauseTransition(Duration.seconds(10));

            pauze.setOnFinished(actionEvent -> view.getScene().getWindow().hide());
            pauze.playFromStart();
        }

        for (int i = 0; i<model.getGame().getHuidigePogingInOpbouw().size(); i++) {
            WiskundigeOnderdeel wiskundigeOnderdeel = model.getGame().getHuidigePogingInOpbouw().get(i);

            if (wiskundigeOnderdeel!=null) {
                nieuweButton = new Button(wiskundigeOnderdeel.toString());
            }
            else {
                nieuweButton = new Button("I");
            }
            nieuweButton.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0), new Insets(1))));

            nieuweButton.setPrefSize(470.0/model.getGame().getLengteBewerking(), 300.0/model.getGame().getMaxAantalPogingen());

            nieuweButton.setContentDisplay(ContentDisplay.CENTER);
            nieuweButton.setFont(new Font("Impact", 20));


            mijnGridPane.add(nieuweButton, i, model.getGame().getLijstFormules().size());
        }

        for (int i = model.getGame().getHuidigePogingInOpbouw().size(); i < model.getGame().getLengteBewerking(); i++) {
            nieuweButton = new Button(".");


            nieuweButton.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0), new Insets(1))));

            nieuweButton.setPrefSize(470.0/model.getGame().getLengteBewerking(), 300.0/model.getGame().getMaxAantalPogingen());

            nieuweButton.setContentDisplay(ContentDisplay.CENTER);
            nieuweButton.setFont(new Font("Impact", 20));
            mijnGridPane.add(nieuweButton, i, model.getGame().getLijstFormules().size());
        }

        for (int zoveeldePoging = model.getGame().getLijstFormules().size() + 1; zoveeldePoging < model.getGame().getMaxAantalPogingen(); zoveeldePoging++) {
            for (int lengteBewerking = 0; lengteBewerking < model.getGame().getLengteBewerking(); lengteBewerking++) {
                nieuweButton = new Button(".");
                nieuweButton.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0), new Insets(1))));

                nieuweButton.setDisable(true);
                nieuweButton.setOpacity(0.4);

                nieuweButton.setPrefSize(470.0/model.getGame().getLengteBewerking(), 300.0/model.getGame().getMaxAantalPogingen());

                nieuweButton.setContentDisplay(ContentDisplay.CENTER);
                nieuweButton.setFont(new Font("Impact", 20));

                mijnGridPane.add(nieuweButton, lengteBewerking, zoveeldePoging);
            }
        }

        view.getHbxGetallen().getChildren().clear();
        view.getHbxGetallen().getChildren().add(view.getGetal1());
        view.getHbxGetallen().getChildren().add(view.getGetal2());
        view.getHbxGetallen().getChildren().add(view.getGetal3());
        view.getHbxGetallen().getChildren().add(view.getGetal4());
        view.getHbxGetallen().getChildren().add(view.getGetal5());
        view.getHbxGetallen().getChildren().add(view.getGetal6());
        view.getHbxGetallen().getChildren().add(view.getGetal7());
        view.getHbxGetallen().getChildren().add(view.getGetal8());
        view.getHbxGetallen().getChildren().add(view.getGetal9());
        view.getHbxGetallen().getChildren().add(view.getGetal0());

        view.getHbxBewerkingen().getChildren().clear();

        view.getGetal0().setPrefSize(40,40);
        view.getGetal1().setPrefSize(40,40);
        view.getGetal2().setPrefSize(40,40);
        view.getGetal3().setPrefSize(40,40);
        view.getGetal4().setPrefSize(40,40);
        view.getGetal5().setPrefSize(40,40);
        view.getGetal6().setPrefSize(40,40);
        view.getGetal7().setPrefSize(40,40);
        view.getGetal8().setPrefSize(40,40);
        view.getGetal9().setPrefSize(40,40);

        view.getPlus().setPrefSize(40,40);
        view.getMin().setPrefSize(40,40);
        view.getMaal().setPrefSize(40,40);
        view.getDeel().setPrefSize(40,40);
        view.getIsTeken().setPrefSize(40,40);

        view.getEnter().setPrefSize(70,40);
        view.getDelete().setPrefSize(70,40);


        view.getGetal0().setFont(new Font("Arial", 15));
        view.getGetal1().setFont(new Font("Arial", 15));
        view.getGetal2().setFont(new Font("Arial", 15));
        view.getGetal3().setFont(new Font("Arial", 15));
        view.getGetal4().setFont(new Font("Arial", 15));
        view.getGetal5().setFont(new Font("Arial", 15));
        view.getGetal6().setFont(new Font("Arial", 15));
        view.getGetal7().setFont(new Font("Arial", 15));
        view.getGetal8().setFont(new Font("Arial", 15));
        view.getGetal9().setFont(new Font("Arial", 15));

        view.getPlus().setFont(new Font("Arial", 15));
        view.getMin().setFont(new Font("Arial", 15));
        view.getMaal().setFont(new Font("Arial", 15));
        view.getDeel().setFont(new Font("Arial", 15));
        view.getIsTeken().setFont(new Font("Arial", 15));

        view.getDelete().setFont(new Font("Arial", 15));
        view.getEnter().setFont(new Font("Arial", 15));


        view.getGetal0().setBackground(new Background(new BackgroundFill(model.getGame().getHuidigePogingInOpbouw().vakjeStatusOnderstaandeButtons(model.getGame().getOpgave(), model.getGame().getLijstFormules(), new Getal(0)).getKleur(), new CornerRadii(0), new Insets(1))));
        view.getGetal1().setBackground(new Background(new BackgroundFill(model.getGame().getHuidigePogingInOpbouw().vakjeStatusOnderstaandeButtons(model.getGame().getOpgave(), model.getGame().getLijstFormules(), new Getal(1)).getKleur(), new CornerRadii(2), new Insets(1))));
        view.getGetal2().setBackground(new Background(new BackgroundFill(model.getGame().getHuidigePogingInOpbouw().vakjeStatusOnderstaandeButtons(model.getGame().getOpgave(), model.getGame().getLijstFormules(), new Getal(2)).getKleur(), new CornerRadii(0), new Insets(1))));
        view.getGetal3().setBackground(new Background(new BackgroundFill(model.getGame().getHuidigePogingInOpbouw().vakjeStatusOnderstaandeButtons(model.getGame().getOpgave(), model.getGame().getLijstFormules(), new Getal(3)).getKleur(), new CornerRadii(0), new Insets(1))));
        view.getGetal4().setBackground(new Background(new BackgroundFill(model.getGame().getHuidigePogingInOpbouw().vakjeStatusOnderstaandeButtons(model.getGame().getOpgave(), model.getGame().getLijstFormules(), new Getal(4)).getKleur(), new CornerRadii(0), new Insets(1))));
        view.getGetal5().setBackground(new Background(new BackgroundFill(model.getGame().getHuidigePogingInOpbouw().vakjeStatusOnderstaandeButtons(model.getGame().getOpgave(), model.getGame().getLijstFormules(), new Getal(5)).getKleur(), new CornerRadii(0), new Insets(1))));
        view.getGetal6().setBackground(new Background(new BackgroundFill(model.getGame().getHuidigePogingInOpbouw().vakjeStatusOnderstaandeButtons(model.getGame().getOpgave(), model.getGame().getLijstFormules(), new Getal(6)).getKleur(), new CornerRadii(0), new Insets(1))));
        view.getGetal7().setBackground(new Background(new BackgroundFill(model.getGame().getHuidigePogingInOpbouw().vakjeStatusOnderstaandeButtons(model.getGame().getOpgave(), model.getGame().getLijstFormules(), new Getal(7)).getKleur(), new CornerRadii(0), new Insets(1))));
        view.getGetal8().setBackground(new Background(new BackgroundFill(model.getGame().getHuidigePogingInOpbouw().vakjeStatusOnderstaandeButtons(model.getGame().getOpgave(), model.getGame().getLijstFormules(), new Getal(8)).getKleur(), new CornerRadii(0), new Insets(1))));
        view.getGetal9().setBackground(new Background(new BackgroundFill(model.getGame().getHuidigePogingInOpbouw().vakjeStatusOnderstaandeButtons(model.getGame().getOpgave(), model.getGame().getLijstFormules(), new Getal(9)).getKleur(), new CornerRadii(0), new Insets(1))));

        view.getPlus().setBackground(new Background(new BackgroundFill(model.getGame().getHuidigePogingInOpbouw().vakjeStatusOnderstaandeButtons(model.getGame().getOpgave(), model.getGame().getLijstFormules(), new Plus()).getKleur(), new CornerRadii(0), new Insets(1))));
        view.getMin().setBackground(new Background(new BackgroundFill(model.getGame().getHuidigePogingInOpbouw().vakjeStatusOnderstaandeButtons(model.getGame().getOpgave(), model.getGame().getLijstFormules(), new Min()).getKleur(), new CornerRadii(0), new Insets(1))));
        view.getMaal().setBackground(new Background(new BackgroundFill(model.getGame().getHuidigePogingInOpbouw().vakjeStatusOnderstaandeButtons(model.getGame().getOpgave(), model.getGame().getLijstFormules(), new Maal()).getKleur(), new CornerRadii(0), new Insets(1))));
        view.getDeel().setBackground(new Background(new BackgroundFill(model.getGame().getHuidigePogingInOpbouw().vakjeStatusOnderstaandeButtons(model.getGame().getOpgave(), model.getGame().getLijstFormules(), new Deel()).getKleur(), new CornerRadii(0), new Insets(1))));
        view.getIsTeken().setBackground(new Background(new BackgroundFill(model.getGame().getHuidigePogingInOpbouw().vakjeStatusOnderstaandeButtons(model.getGame().getOpgave(), model.getGame().getLijstFormules(), new IsTeken()).getKleur(), new CornerRadii(0), new Insets(1))));

        view.getDelete().setBackground(new Background(new BackgroundFill(VakjeStatus.GRAY.getKleur(), new CornerRadii(0), new Insets(1))));
        view.getEnter().setBackground(new Background(new BackgroundFill(VakjeStatus.GRAY.getKleur(), new CornerRadii(0), new Insets(1))));


        view.getHbxBewerkingen().getChildren().add(view.getPlus());
        view.getHbxBewerkingen().getChildren().add(view.getMin());
        view.getHbxBewerkingen().getChildren().add(view.getMaal());
        view.getHbxBewerkingen().getChildren().add(view.getDeel());
        view.getHbxBewerkingen().getChildren().add(view.getIsTeken());

        view.getHbxBewerkingen().getChildren().add(view.getDelete());
        view.getHbxBewerkingen().getChildren().add(view.getEnter());

        view.getHbxBewerkingen().setAlignment(Pos.CENTER);
        view.getHbxGetallen().setAlignment(Pos.CENTER);

        view.getVbxbewerkingOpties().getChildren().clear();
        view.getVbxbewerkingOpties().getChildren().add(view.getHbxGetallen());
        view.getVbxbewerkingOpties().getChildren().add(view.getHbxBewerkingen());

        mijnGridPane.setAlignment(Pos.CENTER);

        vboxGame.getChildren().add(mijnGridPane);
        vboxGame.getChildren().add(view.getVbxbewerkingOpties());
        vboxGame.setSpacing(10);

        return vboxGame;
    }

    private void toonAfbeeldingGewonnen(boolean gewonnen) {

        WinOrLoseScreenView winOrLoseView = new WinOrLoseScreenView(gewonnen);

        new WinOrLoseScreenPresenter(winOrLoseView);

        Stage winOrLoseStage = new Stage();
        winOrLoseStage.initOwner(view.getScene().getWindow());
        winOrLoseStage.initModality(Modality.APPLICATION_MODAL);
        winOrLoseStage.setScene(new Scene(winOrLoseView));
        winOrLoseStage.setX(view.getScene().getWindow().getX() + 100);
        winOrLoseStage.setWidth(350);
        winOrLoseStage.setHeight(300);


        winOrLoseStage.setY(view.getScene().getWindow().getY() + 200);
        winOrLoseStage.getIcons().add( new Image("/nerdleLogo.png"));
        winOrLoseStage.setResizable(false);

        winOrLoseStage.showAndWait();
    }
}