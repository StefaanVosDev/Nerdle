package Nerdle.model;

public class Deel extends Bewerking {
    @Override
    int reken(int getal1, int getal2) {
        return getal1/getal2;
    }

    @Override
    int getPriorety() {
        return 1;
    }

    @Override
    public String toString() {
        return "/";
    }
}
