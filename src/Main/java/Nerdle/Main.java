package Nerdle;

import Nerdle.model.ProgrammaModel;
import Nerdle.view.start.StartPresenter;
import Nerdle.view.start.StartView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        ProgrammaModel model = new ProgrammaModel();
        StartView view = new StartView();
        StartPresenter presenter = new StartPresenter(model, view);

        Scene scene = new Scene(view);
        stage.setScene(scene);
        presenter.addWindowEventHandlers();

        stage.setHeight(450);
        stage.setWidth(715);

        stage.getIcons().add( new Image("/nerdleLogo.png"));
        stage.setResizable(false);
        stage.show();
    }
}