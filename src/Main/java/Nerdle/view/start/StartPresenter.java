package Nerdle.view.start;

import Nerdle.model.ProgrammaModel;
import Nerdle.view.keuze.KeuzePresenter;
import Nerdle.view.keuze.KeuzeView;
import Nerdle.view.spelregels.SpelregelsPresenter;
import Nerdle.view.spelregels.SpelregelsView;
import Nerdle.view.topscores.TopscoresPresenter;
import Nerdle.view.topscores.TopscoresView;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StartPresenter {
    private final ProgrammaModel model;
    private final StartView view;

    public StartPresenter(ProgrammaModel model, StartView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        view.getBtnNieuwspel().setOnMouseEntered(mouseEvent -> view.getBtnNieuwspel().setUnderline(true));
        view.getBtnTopscore().setOnMouseEntered(mouseEvent -> view.getBtnTopscore().setUnderline(true));
        view.getBtnSpelregels().setOnMouseEntered(mouseEvent -> view.getBtnSpelregels().setUnderline(true));
        view.getBtnAfsluiten().setOnMouseEntered(mouseEvent -> view.getBtnAfsluiten().setUnderline(true));
        view.getBtnNieuwspel().setOnMouseExited(mouseEvent -> view.getBtnNieuwspel().setUnderline(false));
        view.getBtnTopscore().setOnMouseExited(mouseEvent -> view.getBtnTopscore().setUnderline(false));
        view.getBtnSpelregels().setOnMouseExited(mouseEvent -> view.getBtnSpelregels().setUnderline(false));
        view.getBtnAfsluiten().setOnMouseExited(mouseEvent -> view.getBtnAfsluiten().setUnderline(false));


        view.getBtnNieuwspel().setOnAction(actionEvent -> {

            KeuzeView keuzeView = new KeuzeView();
            KeuzePresenter keuzePresenter = new KeuzePresenter(keuzeView);
            Stage keuzeStage = new Stage();
            keuzeStage.initOwner(view.getScene().getWindow());
            keuzeStage.initModality(Modality.APPLICATION_MODAL);

            keuzeStage.setScene(new Scene(keuzeView));

            keuzeStage.setX(view.getScene().getWindow().getX() + 220);
            keuzeStage.setWidth(275);
            keuzeStage.setHeight(275);

            keuzeStage.getIcons().add( new Image("/nerdleLogo.png"));
            keuzeStage.setResizable(false);

            keuzePresenter.addWindowEventHandlers();
            addWindowEventHandlers();

            keuzeStage.setY(view.getScene().getWindow().getY() + 100);
            keuzeStage.showAndWait();
        });

        view.getBtnTopscore().setOnAction(actionEvent -> {
            TopscoresView topscoresView = new TopscoresView();

            new TopscoresPresenter(topscoresView);

            Stage topscoresStage = new Stage();
            topscoresStage.initOwner(view.getScene().getWindow());
            topscoresStage.initModality(Modality.APPLICATION_MODAL);

            topscoresStage.setScene(new Scene(topscoresView));
            topscoresStage.setX(view.getScene().getWindow().getX() + 180);
            topscoresStage.setWidth(370);
            topscoresStage.setHeight(275);
            addWindowEventHandlers();

            topscoresStage.getIcons().add( new Image("/nerdleLogo.png"));

            topscoresStage.setResizable(false);
            topscoresStage.setY(view.getScene().getWindow().getY() + 100);
            topscoresStage.showAndWait();
        });

        view.getBtnSpelregels().setOnAction(actionEvent -> {
            SpelregelsView spelregelsView = new SpelregelsView();

            new SpelregelsPresenter(spelregelsView);

            Stage spelregelsStage = new Stage();
            spelregelsStage.initOwner(view.getScene().getWindow());
            spelregelsStage.initModality(Modality.APPLICATION_MODAL);
            spelregelsStage.setScene(new Scene(spelregelsView));
            spelregelsStage.setX(view.getScene().getWindow().getX() + 100);
            spelregelsStage.setWidth(530);
            spelregelsStage.setHeight(490);
            addWindowEventHandlers();

            spelregelsStage.getIcons().add( new Image("/nerdleLogo.png"));
            spelregelsStage.setResizable(false);

            spelregelsStage.setY(view.getScene().getWindow().getY() -10);
            spelregelsStage.showAndWait();
        });

        view.getBtnAfsluiten().setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Hierdoor stopt het spel");
            alert.setContentText("Ben je zeker dat je het spel wilt verlaten?");
            alert.setTitle("Afbreken spel");
            alert.getButtonTypes().clear();

            ButtonType neen = new ButtonType("Neen");
            ButtonType ja = new ButtonType("Ja");
            alert.getButtonTypes().addAll(neen, ja);
            alert.showAndWait();
            if (alert.getResult() ==null || alert.getResult().equals(ja)) {
                view.getScene().getWindow().hide();
            }
        });
    }

    private void updateView() {

    }

    public void addWindowEventHandlers() {
        view.getScene().getWindow().setOnCloseRequest(windowEvent -> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Hierdoor stopt het spel");
            alert.setContentText("Ben je zeker dat je het spel wilt verlaten?");
            alert.setTitle("Afbreken spel");
            alert.getButtonTypes().clear();

            ButtonType neen = new ButtonType("Neen");
            ButtonType ja = new ButtonType("Ja");
            alert.getButtonTypes().addAll(neen, ja);
            alert.showAndWait();
            if (alert.getResult() ==null || alert.getResult().equals(neen)) {
                windowEvent.consume();
            }
        });
    }
}
