package Nerdle.view.start;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class StartView extends VBox {
    private Button btnNieuwspel;
    private Button btnTopscore;
    private Button btnSpelregels;
    private Button btnAfsluiten;

    private Image imgStartschermFoto;


    public StartView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        btnNieuwspel = new Button("Nieuw spel");
        btnTopscore = new Button("Topcores");
        btnSpelregels = new Button("Spelregels");
        btnAfsluiten = new Button("Afsluiten");
        imgStartschermFoto = new Image("nerdleStart.png");
    }

    private void layoutNodes() {
        btnNieuwspel.setFont(new Font("Impact", 25));
        btnTopscore.setFont(new Font("Impact", 25));
        btnSpelregels.setFont(new Font("Impact", 25));
        btnAfsluiten.setFont(new Font("Impact", 25));

        btnNieuwspel.setPrefSize(150, 50);
        btnTopscore.setPrefSize(150, 50);
        btnSpelregels.setPrefSize(150, 50);
        btnAfsluiten.setPrefSize(150, 50);

        btnNieuwspel.setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, new CornerRadii(15), new Insets(0))));
        btnTopscore.setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, new CornerRadii(15), new Insets(0))));
        btnSpelregels.setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, new CornerRadii(15), new Insets(0))));
        btnAfsluiten.setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, new CornerRadii(15), new Insets(0))));

        this.getChildren().add(btnNieuwspel);
        this.getChildren().add(btnTopscore);
        this.getChildren().add(btnSpelregels);
        this.getChildren().add(btnAfsluiten);

        this.setSpacing(20);

        this.setAlignment(Pos.CENTER);
        this.setBackground(new Background(new BackgroundImage(imgStartschermFoto, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true))));
    }

    public Button getBtnNieuwspel(){
        return btnNieuwspel;
    }

    public Button getBtnTopscore() {
        return btnTopscore;
    }

    public Button getBtnSpelregels() {
        return btnSpelregels;
    }

    public Button getBtnAfsluiten() {
        return btnAfsluiten;
    }
}
