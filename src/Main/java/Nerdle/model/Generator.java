package Nerdle.model;

import java.util.Random;

public class Generator extends WiskundigeOnderdeel {
    Formule oplossing = new Formule();
    Random rndGetal = new Random();




    public Formule maakOplossing(int lengteOplossing) {
        lengteOplossing=lengteOplossing-1;
        while (!oplossing.checkIfCorrecteOplossing()) {
            oplossing = new Formule();
            int plaatsIsTeken = rndGetal.nextInt(lengteOplossing - 3) + 2;
            Maal maal = new Maal();
            Deel deel = new Deel();
            Plus plus = new Plus();
            Min min = new Min();
            IsTeken isteken = new IsTeken();

            Getal eersteGetal = new Getal(rndGetal.nextInt(9) + 1);
            oplossing.add(eersteGetal);
            for (int i = 0; i < lengteOplossing; i++) {

                if (i == plaatsIsTeken) {
                    oplossing.add(isteken);
                } else if (rndGetal.nextInt(2) == 1 || oplossing.contains(isteken)) {
                    Getal nieuwGetal;
                    if (oplossing.get(oplossing.size() - 1) instanceof Bewerking) {
                        nieuwGetal = new Getal(rndGetal.nextInt(9) + 1);
                    } else {
                        nieuwGetal = new Getal(rndGetal.nextInt(10));
                    }
                    oplossing.add(nieuwGetal);
                } else {
                    int keuzeTeken = rndGetal.nextInt(4);

                    if (keuzeTeken == 0) {
                        oplossing.add(deel);
                    } else if (keuzeTeken == 1) {
                        oplossing.add(maal);
                    } else if (keuzeTeken == 2) {
                        oplossing.add(plus);
                    } else {
                        oplossing.add(min);
                    }
                }
            }
        }
        System.out.println("Oplossing: " + oplossing);
        return oplossing;
    }

    /*public Formule getOplossing() {
        return oplossing;
    }*/
}