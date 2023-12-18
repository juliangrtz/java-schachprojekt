package aufgabe42;

/**
 * Repräsentiert einen Bauern, der sich am Anfang zwei Felder und danach ein Feld nach vorne bewegen kann.
 * En passant wird unterstützt.
 */
public class Bauer extends Figur {

    // Öffentlicher Konstruktor
    public Bauer(int x, int y, boolean black) {
        super(x, y, black);

    }

    /**
     * Überprüft, ob der Bauer sich auf seiner Startposition befindet.
     * Die Startposition hängt von der Farbe des Bauern ab.
     */
    private boolean isAtStartPosition() {
        if (isBlack()) { // Schwarze Figur
            return getX() == 1;
        } else { // Weiße Figur
            return getX() == 6;
        }
    }

    /**
     * Überprüft, ob der Bauer auf die angegebene Position ziehen kann.
     * Der Bauer kann vorwärts auf ein leeres Feld ziehen.
     * Speziell für den Bauern muss auch die Möglichkeit des Doppelschritts und En Passant berücksichtigt werden.
     */
    @Override
    public boolean checkMove(int x, int y) {
        // Bewegen wir uns innerhalb des Spielfeldes?
        if (x > 7 || x < 0) {
            return false;
        }
        if (y > 7 || y < 0) {
            return false;
        }

        if (Main.SPIELFELD[x][y] == null && y == getY()) { // Prüfung auf Vorwärtszug auf leeres Feld
            int deltaX = x - getX(); // Schrittweite

            // Stimmt die Laufrichtung, d.h. wird sich nur vorwärts bewegt?
            if ((isBlack() && deltaX < 0) || (!isBlack() && deltaX > 0))
                return false;

            // Stimmt die Schrittweite?
            if (Math.abs(deltaX) == 1) {
                return true;
            } else if (Math.abs(deltaX) == 2) {
                // TODO: Prüfen, ob Figur dazwischen steht!
                return isAtStartPosition();
            } else {
                return false;
            }
        } else if (y != getY()) { // Diagonaler Schlag
            if (isAllyPiece(x, y)) {
                return false; // Versuch, verbündete Figur zu schlagen
            } else {
                return Math.abs(getX() - x) == 1 && (Math.abs(getY() - y) == 1); // Diagonaler Schlag
            }
        } else {
            return false;
        }
    }
}