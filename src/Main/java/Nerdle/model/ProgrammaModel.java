package Nerdle.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProgrammaModel {
    private Game game;

    public ProgrammaModel() {
        this.game = null;
    }

    public void schrijfPogingTopscoreInCsv(PogingVoorTopscores eenPoging) {
        File file = new File("C:\\Users\\stefa\\OneDrive\\Documents\\AToegepase Informatica 2\\Projects\\NerdleModelView\\src\\Main\\resources\\Highscores.csv");

//        File file = new File("C:\\JavaProjecten\\JavaFx\\Week4\\NerdleModelView\\resources\\Highscores.csv");
        try {
            FileWriter outputfile = new FileWriter(file, true);
            outputfile.write(String.format("\n%s;%s;%d;%d;%d", eenPoging.voornaam(), eenPoging.achternaam(), eenPoging.lengteBewerking(), eenPoging.aantalPoginen(), eenPoging.tijdGedaanOverPoging()));
            outputfile.close();

        } catch (IOException ignored) {
        }
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
