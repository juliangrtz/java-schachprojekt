package de.uni_luebeck.hackathon.aufgabe4;


import de.uni_luebeck.hackathon.Main;

public class Bauer extends Figur {

    // Öffentlicher Konstruktor
    public Bauer(int x, int y, boolean black) {
        super(x, y, black);

    }

    /**
     * Überprüft, ob der Bauer sich auf seiner Startposition befindet. Die Startposition hängt von der Farbe des Bauern ab.
     */
    private boolean isAtStartPosition() {
        if (isBlack()) { // Schwarze Figur
            return getX() == 1;
        } else { // Weiße Figur
            return getX() == 6;
        }
    }

    /**
     * Überprüft, ob der Bauer auf die angegebene Position (x,y) ziehen kann.
     */
    @Override
    public boolean checkMove(int x, int y) {
        // Bewegen wir uns innerhalb des Spielfeldes?
        if (x > 7 || x < 0 || y > 7 || y < 0) {
            return false;
        }

        int deltaX = x - getX(); // x-Schrittweite
        int deltaY = y - getY(); // y-Schrittweite

        if (Main.SPIELFELD[x][y] == null && y == getY()) { // Prüfung auf Vorwärtszug auf leeres Feld
            // Stimmt die Laufrichtung, d.h. wird sich nur vorwärts bewegt?
            if ((isBlack() && deltaX < 0) || (!isBlack() && deltaX > 0))
                return false;

            // Stimmt die Schrittweite?
            int abs = Math.abs(deltaX);
            if (abs == 1) {
                return true;
            } else if (abs == 2) {
                // Prüfen, ob Figur dazwischen steht
                int middleX = isBlack() ? getX() + 1 : getX() - 1;
                return isAtStartPosition() && Main.SPIELFELD[middleX][y] == null;
            } else {
                return false;
            }
        } else if (Main.SPIELFELD[x][y] != null && Main.SPIELFELD[x][y].isBlack() != isBlack()) {
            return Math.abs(deltaY) == 1 && (isBlack() ? deltaX == 1 : deltaX == -1);
        }

        return false;
    }
}
