package Nerdle.model;

public class PogingVoorTopscores {
    private String voornaam;
    private String achternaam;
    private int lengteBewerking;
    private int aantalPoginen;
    private int tijdGedaanOverPoging;


    public PogingVoorTopscores(String voornaam, String achternaam, int lengteBewerking, int aantalPoginen, int tijdGedaanOverPoging) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.lengteBewerking = lengteBewerking;
        this.aantalPoginen = aantalPoginen;
        this.tijdGedaanOverPoging=tijdGedaanOverPoging;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public int getLengteBewerking() {
        return lengteBewerking;
    }

    public int getAantalPoginen() {
        return aantalPoginen;
    }

    public int getTijdGedaanOverPoging() {
        return tijdGedaanOverPoging;
    }

    @Override
    public String toString() {
        return "PogingVoorTopscores{" +
                "voornaam='" + voornaam + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", lengteBewerking=" + lengteBewerking +
                ", aantalPoginen=" + aantalPoginen +
                '}';
    }

}
