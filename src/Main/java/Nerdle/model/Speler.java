package Nerdle.model;

public class Speler {
    private String naam;
    private String achternaam;

    public Speler(String naam, String achternaam) {
        this.naam = naam;
        this.achternaam = achternaam;
    }

    public String getNaam() {
        return naam;
    }
    public String getAchternaam() {
        return achternaam;
    }
}
