package de.uni_luebeck.hackathon.aufgabe4;

import de.uni_luebeck.hackathon.Main;

public class Figur {
	// Eine Schachfigur wird eindeutig durch ihre x- und y-Koordinate sowie Farbe identifiziert.
    private int x;
    private int y;
    private boolean black;

	// Öffentlicher Konstruktor
    public Figur(int x, int y, boolean black) {
        this.x = x;
        this.y = y;
        this.black = black;
    }

	// Getter-Methoden
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isBlack() {
        return black;
    }
	
	// Diese Methode wird von den Figur-Unterklassen überschrieben.
    public boolean checkMove(int x, int y) {
        return false;
    }

	// Gemäß Spezifikation ist ein Feld auf dem zweidimensionalen Spielfeld-Array genau dann leer, wenn es den Wert null hat.
    public boolean isEmptyField(int x, int y) {
        return Main.SPIELFELD[x][y] == null;
    }
}
