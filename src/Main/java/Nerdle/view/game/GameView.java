package Nerdle.view.game;


import javafx.geometry.Pos;
import javafx.scene.control.Button;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameView extends VBox{
    private ImageView imgNerdle;
    private GridPane gpSpel;

    private VBox vbxbewerkingOpties;
    private HBox hbxGetallen;
    private HBox hbxBewerkingen;

    private Button getal1;
    private Button getal2;
    private Button getal3;
    private Button getal4;
    private Button getal5;
    private Button getal6;
    private Button getal7;
    private Button getal8;
    private Button getal9;
    private Button getal0;



    private Button plus;
    private Button min;
    private Button maal;
    private Button deel;
    private Button isTeken;

    private Button delete;
    private Button enter;


    public GameView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        imgNerdle = new ImageView("/fotoBovenGridSpel.png");
        gpSpel = new GridPane();


        vbxbewerkingOpties = new VBox();
        hbxGetallen = new HBox();
        hbxBewerkingen = new HBox();
        getal1 = new Button("1");
        getal2 = new Button("2");
        getal3 = new Button("3");
        getal4 = new Button("4");
        getal5 = new Button("5");
        getal6 = new Button("6");
        getal7 = new Button("7");
        getal8 = new Button("8");
        getal9 = new Button("9");
        getal0 = new Button("0");

        plus = new Button("+");
        min = new Button("-");
        maal = new Button("*");
        deel = new Button("/");
        isTeken = new Button("=");

        delete = new Button("delete");
        enter = new Button("enter");


    }

    private void layoutNodes() {
        this.imgNerdle.setFitHeight(200);
        this.imgNerdle.setFitWidth(500);

        this.getChildren().add(imgNerdle);

        this.getChildren().add(gpSpel);
        this.setSpacing(10);

        this.setAlignment(Pos.CENTER);
    }


    public ImageView getImgNerdle() {
        return imgNerdle;
    }

    public VBox getVbxbewerkingOpties() {
        return vbxbewerkingOpties;
    }

    public HBox getHbxGetallen() {
        return hbxGetallen;
    }

    public HBox getHbxBewerkingen() {
        return hbxBewerkingen;
    }

    public Button getGetal1() {
        return getal1;
    }

    public Button getGetal2() {
        return getal2;
    }

    public Button getGetal3() {
        return getal3;
    }

    public Button getGetal4() {
        return getal4;
    }

    public Button getGetal5() {
        return getal5;
    }

    public Button getGetal6() {
        return getal6;
    }

    public Button getGetal7() {
        return getal7;
    }

    public Button getGetal8() {
        return getal8;
    }

    public Button getGetal9() {
        return getal9;
    }

    public Button getGetal0() {
        return getal0;
    }

    public Button getPlus() {
        return plus;
    }

    public Button getMin() {
        return min;
    }

    public Button getMaal() {
        return maal;
    }

    public Button getDeel() {
        return deel;
    }

    public Button getIsTeken() {
        return isTeken;
    }

    public Button getDelete() {
        return delete;
    }

    public Button getEnter() {
        return enter;
    }
}
