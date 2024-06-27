package Nerdle.view.keuze;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class KeuzeView extends GridPane {

    private Label lblVoornaam;
    private Label lblAchternaam;
    private Label lblAantalPogingen;
    private Label lblLengteBewerking;

    private TextField txtVoornaam;
    private TextField txtAchternaam;
    private TextField txtAantalPogingen;
    private TextField txtLengteBewerking;

    private Button btnAnnuleren;
    private Button btnStartSpel;

    private Label lblFoutBoodschap;

    private Image imgKeuze;

    public KeuzeView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        lblVoornaam = new Label("Voornaam");
        lblAchternaam = new Label("Achternaam");
        lblAantalPogingen = new Label("Aantal pogingen");
        lblLengteBewerking = new Label("Lengte nerdle");

        lblVoornaam.setFont(new Font("Arial", 14));
        lblAchternaam.setFont(new Font("Arial", 14));
        lblAantalPogingen.setFont(new Font("Arial", 14));
        lblLengteBewerking.setFont(new Font("Arial", 14));

        txtVoornaam = new TextField();
        txtAchternaam = new TextField();
        txtAantalPogingen = new TextField();
        txtLengteBewerking = new TextField();

        btnAnnuleren = new Button("Annuleren");
        btnStartSpel = new Button("Start spel");

        txtVoornaam.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, new CornerRadii(0), new Insets(1))));
        txtAchternaam.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, new CornerRadii(0), new Insets(1))));
        txtLengteBewerking.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, new CornerRadii(0), new Insets(1))));
        txtAantalPogingen.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, new CornerRadii(0), new Insets(1))));

        btnAnnuleren.setBackground(new Background(new BackgroundFill(Color.PEACHPUFF, new CornerRadii(5), new Insets(2))));
        btnStartSpel.setBackground(new Background(new BackgroundFill(Color.PEACHPUFF, new CornerRadii(5), new Insets(2))));

        lblFoutBoodschap = new Label("Vul alle velden correct in!");

        imgKeuze= new Image("/achtergrondKeuze.jpeg");
    }

    private void layoutNodes() {
        this.setAlignment(Pos.CENTER);

        this.add(lblVoornaam, 0, 0);
        this.add(lblAchternaam, 0, 1);
        this.add(lblAantalPogingen, 0, 2);
        this.add(lblLengteBewerking, 0, 3);

        this.add(txtVoornaam, 1, 0);
        this.add(txtAchternaam, 1, 1);
        this.add(txtAantalPogingen, 1, 2);
        this.add(txtLengteBewerking, 1, 3);


        this.add(btnStartSpel, 1, 4);
        this.add(btnAnnuleren, 1, 5);

        lblFoutBoodschap.setTextFill(Color.RED);
        this.add(lblFoutBoodschap, 1, 6);
        this.lblFoutBoodschap.setVisible(false);


        this.setBackground(new Background(new BackgroundImage(imgKeuze, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true))));

    }

    public TextField getTxtVoornaam() {
        return txtVoornaam;
    }

    public TextField getTxtAchternaam() {
        return txtAchternaam;
    }

    public TextField getTxtAantalPogingen() {
        return txtAantalPogingen;
    }

    public TextField getTxtLengteBewerking() {
        return txtLengteBewerking;
    }

    public Button getBtnStartSpel() {
        return btnStartSpel;
    }

    public Button getBtnAnnuleren() {
        return btnAnnuleren;
    }

    public Label getLblFoutBoodschap() {
        return lblFoutBoodschap;
    }
}
