package Nerdle.model;

import javafx.scene.paint.Color;

public enum VakjeStatus {
    GRAY(Color.LIGHTGRAY),
    GROEN(Color.GREEN),
    PAARS(Color.MEDIUMPURPLE),
    ZWART(Color.BLACK);

    private final Color kleur;
    VakjeStatus(Color kleur) {
        this.kleur=kleur;
    }

    public Color getKleur() {
        return this.kleur;
    }
}
