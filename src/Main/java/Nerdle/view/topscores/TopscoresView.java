package Nerdle.view.topscores;

import Nerdle.model.PogingVoorTopscores;
import Nerdle.model.TopscoresModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class TopscoresView extends BorderPane {
    private HBox hbxTerug;
    private Button btnTerug;
    private Label lblKleineWitRuimte;
    private GridPane gpTopscores;

    private Label lblNaam;
    private Label lblAantalPogingenNodigGehad;
    private Label lblLengteBewerkingGehad;
    private Label lblTijdGedaanOverBewerking;

    private Image imgAchtergrond;

    public TopscoresView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {

        hbxTerug = new HBox();
        btnTerug = new Button("Terug");

        lblKleineWitRuimte = new Label();

        gpTopscores = new GridPane();

        lblNaam = new Label(" Naam");
        lblAantalPogingenNodigGehad = new Label(" Pogingen");
        lblLengteBewerkingGehad = new Label(" Lengte");
        lblTijdGedaanOverBewerking = new Label(" Tijdsduur");

        imgAchtergrond = new Image("/rekensommen.jpg");

    }

    private void layoutNodes() {
        lblNaam.setFont(new Font("Rockwell Nova", 12));
        lblLengteBewerkingGehad.setFont(new Font("Rockwell Nova", 12));
        lblAantalPogingenNodigGehad.setFont(new Font("Rockwell Nova", 12));
        lblTijdGedaanOverBewerking.setFont(new Font("Rockwell Nova", 12));


        gpTopscores.add(lblNaam, 0, 0);
        gpTopscores.add(lblLengteBewerkingGehad, 1, 0);
        gpTopscores.add(lblAantalPogingenNodigGehad, 2, 0);
        gpTopscores.add(lblTijdGedaanOverBewerking, 3, 0);
        TopscoresModel nieuwModel = new TopscoresModel();
        gpTopscores.add(lblKleineWitRuimte, 0, 1);

        nieuwModel.getPogingVoorTopscoresLijst().sort((o1, o2) -> {
            if (o1.lengteBewerking() < o2.lengteBewerking()) {
                return 1;
            } else if (o1.lengteBewerking() == o2.lengteBewerking()) {
                if (o1.aantalPoginen() > o2.aantalPoginen()) {
                    return 1;
                } else if (o1.aantalPoginen() == o2.aantalPoginen()) {
                    if (o1.tijdGedaanOverPoging() > o2.tijdGedaanOverPoging()) {
                        return 1;
                    } else if (o1.tijdGedaanOverPoging() == o2.tijdGedaanOverPoging()) {
                        return 0;
                    }
                }
            }
            return -1;
        });

        for (int i=0; i<9; i++) {
            PogingVoorTopscores pogingen = nieuwModel.getPogingVoorTopscoresLijst().get(i);

            lblNaam = new Label(" "+pogingen.voornaam()+" "+pogingen.achternaam());
            lblLengteBewerkingGehad = new Label(Integer.toString(pogingen.lengteBewerking()));
            lblAantalPogingenNodigGehad = new Label(Integer.toString(pogingen.aantalPoginen()));
            lblTijdGedaanOverBewerking = new Label(pogingen.tijdGedaanOverPoging()+" sec");

            lblNaam.setPrefWidth(170);
            lblLengteBewerkingGehad.setPrefWidth(50);
            lblAantalPogingenNodigGehad.setPrefWidth(65);
            lblTijdGedaanOverBewerking.setPrefWidth(65);

            gpTopscores.add(lblNaam, 0, i+2);
            gpTopscores.add(lblLengteBewerkingGehad, 1, i+2);
            gpTopscores.add(lblAantalPogingenNodigGehad, 2, i+2);
            gpTopscores.add(lblTijdGedaanOverBewerking, 3, i+2);
        }

        gpTopscores.setGridLinesVisible(true);
        gpTopscores.setAlignment(Pos.CENTER);

        btnTerug.setAlignment(Pos.CENTER);

        btnTerug.setPrefSize(70, 30);
        btnTerug.setFont(new Font("Impact", 16));
        btnTerug.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(5), new Insets(0))));
        btnTerug.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));

        hbxTerug.getChildren().add(btnTerug);
        hbxTerug.setAlignment(Pos.CENTER);

        this.setCenter(gpTopscores);
        this.setBottom(hbxTerug);

        this.setBackground(new Background(new BackgroundImage(imgAchtergrond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true))));
    }

    public Button getBtnTerug() {
        return btnTerug;
    }

}
