package Nerdle.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Game {

    private final Speler speler;
    private final Formule opgave;
    private final LocalDateTime startTijdstip;
    private final int lengteBewerking;
    private final int maxAantalPogingen;

    private final Formule huidigePogingInOpbouw = new Formule();

   private final ArrayList<Formule> lijstFormules = new ArrayList<>();

    public Game(String voornaam, String achternaam, int lengteBewerking, int maxAantalPogingen) {
        this.speler=new Speler(voornaam, achternaam);
        Generator formule = new Generator();
        this.opgave = formule.maakOplossing(lengteBewerking);
        this.lengteBewerking = lengteBewerking;
        this.maxAantalPogingen = maxAantalPogingen;

        this.startTijdstip = LocalDateTime.now();
    }

    public int getLengteBewerking() {
        return lengteBewerking;
    }

    public int getMaxAantalPogingen() {
        return maxAantalPogingen;
    }


    public Speler getSpeler() {
        return speler;
    }

    public Formule getOpgave() {
        return opgave;
    }

    public LocalDateTime getStartTijdstip() {
        return startTijdstip;
    }

    public ArrayList<Formule> getLijstFormules() {
        return lijstFormules;
    }

    public Formule getHuidigePogingInOpbouw() {
        return huidigePogingInOpbouw;
    }
}