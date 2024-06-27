package Nerdle.model;

import java.util.List;

public class Getal extends WiskundigeOnderdeel {
    int getal;


    public Getal(int getal) {
        this.getal = getal;
    }

    public int getGetalVanListWiskundeOnderdeel(List<WiskundigeOnderdeel> lijstGetallen) {
        int resultaat=0;
        for (WiskundigeOnderdeel wiskundigeOnderdeel : lijstGetallen) {
            if (wiskundigeOnderdeel instanceof Getal) {
                int nieuwGetal = Integer.parseInt(wiskundigeOnderdeel.toString());
                resultaat = resultaat * 10 + nieuwGetal;
            }
        }
        return resultaat;
    }

    @Override
    public String toString() {
        return String.valueOf(getal);
    }

}