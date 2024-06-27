package Nerdle.view.winOrLoseScreen;

import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class WinOrLoseScreenView extends BorderPane {
    private ImageView imgWinOrLose;

    public WinOrLoseScreenView(boolean win) {
        if (win) {
            this.imgWinOrLose = new ImageView("/youWinCongr.png");
        } else {
            this.imgWinOrLose = new ImageView("/youLoseSnoozer.png");
        }
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        imgWinOrLose.setFitWidth(350);
        imgWinOrLose.setFitHeight(250);
    }

    private void layoutNodes() {
        this.getChildren().add(imgWinOrLose);
    }
}
