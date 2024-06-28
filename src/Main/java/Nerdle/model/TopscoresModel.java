package Nerdle.model;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TopscoresModel {
    private final ArrayList<PogingVoorTopscores> pogingVoorTopscoresLijst;

    public TopscoresModel() {
        this.pogingVoorTopscoresLijst = zetCsvFileOmTotArraylist();
    }

    public List<PogingVoorTopscores> getPogingVoorTopscoresLijst() {
        return pogingVoorTopscoresLijst;
    }

    private void zetOmTotCsv(ArrayList<PogingVoorTopscores> pogingVoorTopscoresLijst) {

        File file = new File("C:\\Users\\stefa\\OneDrive\\Documents\\AToegepase Informatica 2\\Projects\\NerdleModelView\\src\\Main\\resources\\Highscores.csv");
        try {
            FileWriter outputfile = new FileWriter(file, true);
            for (PogingVoorTopscores eenPoging : pogingVoorTopscoresLijst) {
                outputfile.write(String.format("\n%s;%s;%d;%d;%d", eenPoging.voornaam(), eenPoging.achternaam(), eenPoging.lengteBewerking(), eenPoging.aantalPoginen(), eenPoging.tijdGedaanOverPoging()));
            }
            outputfile.close();

        } catch (IOException ignored) {
        }
    }


    private ArrayList<PogingVoorTopscores> zetCsvFileOmTotArraylist() {

        ArrayList<PogingVoorTopscores> lijstPogingen = new ArrayList<>();
        Path pathToFile = Paths.get("C:\\Users\\stefa\\OneDrive\\Documents\\AToegepase Informatica 2\\Projects\\NerdleModelView\\src\\Main\\resources\\Highscores.csv");
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {

                String[] alleAttibuten = line.split(";");
                PogingVoorTopscores eenPoging = maakNieuwePoging(alleAttibuten);

                lijstPogingen.add(eenPoging);

                line = br.readLine();
            }
        } catch (IOException ignored) {
        }
        return lijstPogingen;
    }

    private PogingVoorTopscores maakNieuwePoging(String[] metadata) {
        String voornaam = metadata[0];
        String achternaam = metadata[1];

        int lengteBewerking = Integer.parseInt(metadata[2]);
        int maxAantalPogingen = Integer.parseInt(metadata[3]);

        int tijdNodigGetahd = Integer.parseInt(metadata[4]);

        return new PogingVoorTopscores(voornaam, achternaam, lengteBewerking, maxAantalPogingen, tijdNodigGetahd);
    }
}

