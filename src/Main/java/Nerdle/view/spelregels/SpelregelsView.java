package Nerdle.view.spelregels;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SpelregelsView extends BorderPane {
    private Label lblSpelRegels;

    private VBox vBoxRegels;
    private HBox hbxTerug;
    private ImageView imgGroen;
    private Label lblGroen;

    private ImageView imgPaars;
    private Label lblPaars;

    private ImageView imgZwart;
    private Label lblZwart;

    private Button btnTerug;

    private Image imgAchtergrond;

    public SpelregelsView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        hbxTerug = new HBox();
        vBoxRegels = new VBox();

        lblSpelRegels = new Label("""
                Gok de NERDLE in een zelf gekozen aantal poginen. Na elke poging, de kleur van de vakjes zal\s
                veranderen en je laten zien hoe dicht je was tot de oplossing\s
                  • Er zijn een zelf gekozen aantal "letters"\s
                  • Een "letter" is één van"0123456789+-*/="
                  • En een woord moet een calculatie zijn die mathematisch correct is\s
                  • Dus het moet een "=" bevatten
                  • Ook, het nummer rechts van de "=" is een normaal nummer (geen andere bewerking)
                  • Standaard volgorde van bewerkingen wordt toegepast, dus reken * en / voor + en -""");
//                + "  • Volgorde is ook belanrijk, Bijvoorbeeld als het antwoord 10+20=30, dan is 20+10=30 niet juist");

        imgGroen = new ImageView("/groene9.JPG");
        imgPaars = new ImageView("/paarse2.JPG");
        imgZwart = new ImageView("/zwarte1.JPG");

        lblGroen = new Label("Het getal 9 is groen en is daarom in de bewerking en op de juiste plaats");
        lblPaars = new Label("Het getal 2 is paars en is daarom in de bewrking maar in de foute plaats");
        lblZwart = new Label("Het getal 2 is zwart en is daarom niet in de bewerking");

        btnTerug = new Button("Terug");

        imgAchtergrond = new Image("/rekensommen.jpg");
    }

    private void layoutNodes() {
        vBoxRegels.getChildren().add(lblSpelRegels);
        vBoxRegels.getChildren().add(imgGroen);
        vBoxRegels.getChildren().add(lblGroen);
        vBoxRegels.getChildren().add(imgPaars);
        vBoxRegels.getChildren().add(lblPaars);
        vBoxRegels.getChildren().add(imgZwart);
        vBoxRegels.getChildren().add(lblZwart);

        btnTerug.setAlignment(Pos.CENTER);

        btnTerug.setPrefSize(70, 30);
        btnTerug.setFont(new Font("Impact", 16));
        btnTerug.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(5), new Insets(0))));
        btnTerug.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));

        hbxTerug.getChildren().add(btnTerug);
        hbxTerug.setAlignment(Pos.CENTER);

        this.setCenter(vBoxRegels);
        this.setBottom(hbxTerug);

        this.setBackground(new Background(new BackgroundImage(imgAchtergrond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true))));
    }

    public Button getBtnTerug() {
        return btnTerug;
    }
}
