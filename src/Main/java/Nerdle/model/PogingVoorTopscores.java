package Nerdle.model;

public record PogingVoorTopscores(String voornaam, String achternaam, int lengteBewerking, int aantalPoginen,
                                  int tijdGedaanOverPoging) {

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
