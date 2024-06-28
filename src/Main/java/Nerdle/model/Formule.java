package Nerdle.model;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

import java.util.ArrayList;
import java.util.List;

public class Formule extends ArrayList<WiskundigeOnderdeel> {

    public Formule() {}

    public Formule(Formule formule) {
        this.addAll(formule);
    }

    public Button vakjeStatus(Formule genereerdeFormule, WiskundigeOnderdeel onderdeelWaarvoorLabelGemaaktMoetWorden, int indexOnderdeel) {
        Button nieuweButton = new Button(onderdeelWaarvoorLabelGemaaktMoetWorden.toString());
            VakjeStatus resultaat = VakjeStatus.ZWART;

            for (WiskundigeOnderdeel wiskundigeOnderdeel : genereerdeFormule) {
                if (wiskundigeOnderdeel.toString().equals(onderdeelWaarvoorLabelGemaaktMoetWorden.toString())) {
                    resultaat = VakjeStatus.PAARS;
                    break;
                }
            }
            if (genereerdeFormule.get(indexOnderdeel).toString().equals(onderdeelWaarvoorLabelGemaaktMoetWorden.toString())) {
                resultaat = VakjeStatus.GROEN;
            }
            nieuweButton.setBackground(new Background(new BackgroundFill(resultaat.getKleur(), new CornerRadii(1),new Insets(1))));
            return nieuweButton;
    }

    public VakjeStatus vakjeStatusOnderstaandeButtons(Formule genereerdeFormule, ArrayList<Formule> lijstFormules, WiskundigeOnderdeel wiskundigeOnderdeel) {
        VakjeStatus resultaat = VakjeStatus.GRAY;

        /*for (Formule formules:lijstFormules) {
            for (WiskundigeOnderdeel onderdeel:formules) {
                if (onderdeel.toString().equals(wiskundigeOnderdeel.toString())) {
                    resultaat=VakjeStatus.ZWART;
                    break;
                }
            }
        }

        for (Formule formules:lijstFormules) {
            for (WiskundigeOnderdeel onderdeel:formules) {
                if (onderdeel.toString().equals(wiskundigeOnderdeel.toString()) && genereerdeFormule.toString().contains(wiskundigeOnderdeel.toString())) {
                    resultaat=VakjeStatus.PAARS;
                    break;
                }
            }
        }

        for (Formule formules: lijstFormules) {
            for (WiskundigeOnderdeel onderdeel:formules) {
                if ((onderdeel.toString().equals(wiskundigeOnderdeel.toString()) && genereerdeFormule.toString().contains(wiskundigeOnderdeel.toString())) &&genereerdeFormule.toString().indexOf(wiskundigeOnderdeel.toString())==formules.toString().indexOf(onderdeel.toString())) {
                    resultaat=VakjeStatus.GROEN;
                    break;
                }
            }
        }*/
        String wiskundigeOnderdeelString = wiskundigeOnderdeel.toString();
        String genereerdeFormuleString = genereerdeFormule.toString();

        for (Formule formules : lijstFormules) {
            for (WiskundigeOnderdeel onderdeel : formules) {
                String onderdeelString = onderdeel.toString();
                if (onderdeelString.equals(wiskundigeOnderdeelString)) {
                    resultaat = VakjeStatus.ZWART;
                    if (genereerdeFormuleString.contains(wiskundigeOnderdeelString)) {
                        resultaat = VakjeStatus.PAARS;
                        if (genereerdeFormuleString.indexOf(wiskundigeOnderdeelString) == formules.toString().indexOf(onderdeelString)) {
                            resultaat = VakjeStatus.GROEN;
                            break;
                        }
                    }
                }
            }
        }
        return resultaat;
    }

    public int getPlaatsIsTeken() {
        int resultaat = 0;
        for (WiskundigeOnderdeel onderdeel:this) {
            if (onderdeel instanceof IsTeken) {
                resultaat=this.indexOf(onderdeel);
            }
        }
        return resultaat;
    }

    public boolean checkIfCorrecteOplossing() {
        Formule rekenSom = new Formule(this);


        boolean resultaat=true;
        //Kijk of er geen twee bewerkingen naast elkaar staan, //Niet delen door nul nakijken:
        for (int i =0; i<rekenSom.size()-1; i++) {
            if (((rekenSom.get(i) instanceof Bewerking || rekenSom.get(i) instanceof IsTeken) && (rekenSom.get(i + 1) instanceof Bewerking || rekenSom.get(i + 1) instanceof IsTeken)) || (rekenSom.get(i) instanceof Deel && Integer.parseInt(rekenSom.get(i+1).toString())==0) || (rekenSom.get(i) instanceof IsTeken && Integer.parseInt(rekenSom.get(i+1).toString())==0)) {
                resultaat = false;
                break;
            }
        }

        //Kijk of het wel zeker een bewerking bevat:
        if (resultaat) {
            resultaat=false;
            for (WiskundigeOnderdeel wiskundigeOnderdeel : rekenSom.subList(0, rekenSom.size())) {
                if (wiskundigeOnderdeel instanceof Bewerking) {
                    resultaat = true;
                    break;
                }
            }
        }

        //geen bewerking teken na = teken:
        if (resultaat) {
            ArrayList<WiskundigeOnderdeel> substring = new ArrayList<>(rekenSom.subList(rekenSom.getPlaatsIsTeken(), rekenSom.size()));
            for (WiskundigeOnderdeel onderdeel: substring) {
                if (onderdeel instanceof Bewerking) {
                    resultaat = false;
                    break;
                }
            }
        }
        //Het begint zeker niet met een teken
        if (resultaat) {
            if (rekenSom.get(0) instanceof Bewerking) {
                resultaat=false;
            }
        }

        //Klopt de bewerking
        if (resultaat) {
            boolean deelbewerkingGeeftDouble = false;
            for (int j = 1; j < 3; j++) {
                for (int i = 0; i < rekenSom.size(); i++) {
                    if (rekenSom.get(i) instanceof Bewerking huidigeBewerking) {
                        if (huidigeBewerking.getPriorety() == j) {
                            //zoek getal links en rechts van de bewerking en doe de bewerking erop

                            int k = rekenSom.indexOf(huidigeBewerking) - 1;
                            while (k > 0 && !(rekenSom.get(k - 1) instanceof Bewerking)) {
                                k--;
                            }

                            List<WiskundigeOnderdeel> subListGetallenErvoor;
                            subListGetallenErvoor = rekenSom.subList(k, rekenSom.indexOf(huidigeBewerking));
                            Getal getal = new Getal(0);
                            int getalErvoor = getal.getGetalVanListWiskundeOnderdeel(subListGetallenErvoor);

                            for (int x = rekenSom.indexOf(huidigeBewerking) - 1; k <= x; x--) {
                                rekenSom.remove(k);
                            }
                            k = rekenSom.indexOf(huidigeBewerking) + 1;
                            while (!(rekenSom.get(k) instanceof IsTeken) && !(rekenSom.get(k) instanceof Bewerking)) {
                                k++;
                            }
                            List<WiskundigeOnderdeel> subListGetallenErna;
                            subListGetallenErna = rekenSom.subList(rekenSom.indexOf(huidigeBewerking), k);
                            int getalErna = getal.getGetalVanListWiskundeOnderdeel(subListGetallenErna);

                            for (int x = rekenSom.indexOf(huidigeBewerking) + 1; k > x; k--) {
                                rekenSom.remove(x);
                            }

                            if (huidigeBewerking instanceof Maal) {
                                Maal maal = new Maal();
                                int maalBereking = maal.reken(getalErvoor, getalErna);
                                rekenSom.set(rekenSom.indexOf(huidigeBewerking), new Getal(maalBereking));
                                i = 0;

                            } else if (huidigeBewerking instanceof Deel) {

                                //Hier double teruggeven miss om te zien dat het niet is afgerond

                               /*todo: remove this
                                   if ((double)getalErvoor/getalErna!=(getalErvoor/getalErna)) {
                                    deelbewerkingGeeftDouble=true;
                                }*/
                                if (getalErvoor % getalErna != 0) {
                                    deelbewerkingGeeftDouble = true;
                                }

                                Deel deel = new Deel();
                                int deelBereking = deel.reken(getalErvoor, getalErna);
                                rekenSom.set(rekenSom.indexOf(huidigeBewerking), new Getal(deelBereking));
                                i = 0;

                            } else if (huidigeBewerking instanceof Plus) {
                                Plus plus = new Plus();
                                int plusBereking = plus.reken(getalErvoor, getalErna);
                                rekenSom.set(rekenSom.indexOf(huidigeBewerking), new Getal(plusBereking));
                                i = 0;

                            } else if (huidigeBewerking instanceof Min) {
                                Min min = new Min();
                                int minBereking = min.reken(getalErvoor, getalErna);
                                rekenSom.set(rekenSom.indexOf(huidigeBewerking), new Getal(minBereking));
                                i = 0;

                            }
                        }
                    }
                }
            }
            int getalVoorBerekening = Integer.parseInt(rekenSom.get(0).toString());
            Getal nieuwGetal = new Getal(0);
            int getalNaBewerking = nieuwGetal.getGetalVanListWiskundeOnderdeel(rekenSom.subList(1, rekenSom.size()));
            if (!(getalVoorBerekening==getalNaBewerking) || deelbewerkingGeeftDouble) {
                resultaat=false;

            }
        }
        return resultaat;
    }

    @Override
    public String toString() {
        StringBuilder resultaat = new StringBuilder();
        for (WiskundigeOnderdeel onderdeel: this) {
            resultaat.append(onderdeel);
        }
        return resultaat.toString();
    }

    @Override
    public boolean equals(Object o) {
        boolean resultaat = false;
        if (o instanceof Formule nieuweFormule) {
            if (nieuweFormule.size()==this.size()) {
                resultaat=true;
                for (int i = 0; i < this.size(); i++) {
                    WiskundigeOnderdeel onderdeelNieuwe = nieuweFormule.get(i);
                    WiskundigeOnderdeel onderdeelThis = this.get(i) ;
                    if (!(onderdeelThis.toString().equals(onderdeelNieuwe.toString()))) {
                        resultaat=false;
                        break;
                    }
                }
            }
            else {
                System.out.println("Andere lengte");
            }
        }
        return resultaat;
    }
}
