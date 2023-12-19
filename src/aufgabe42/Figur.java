package aufgabe42;

/**
Repräsentiert eine beliebige Schachfigur. TODO: Klasse ggf. als "abstract" markieren.
**/
class Figur {
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
	
	// Diese Methode wird von den Unterklassen überschrieben.
    public boolean checkMove(int x, int y) {
        return false;
    }
	
	// Diese Methode prüft, ob auf dem Feld (x,y) bereits eine verbündete Figur derselben Farbe steht.
    public boolean alliedPieceExistsOnField(int x, int y) {
		// Wenn das Feld, zu dem wir uns bewegen wollen, leer ist, dann steht dort keine verbündete Figur.
		if (isEmptyField(x, y)) {
            return false;
        }
		
		// Anderenfalls prüfen wir, ob auf dem anderen Feld eine Figur derselben Farbe steht.
        if (black) {
            return Main.SPIELFELD[x][y].isBlack();
        } else {
            return !Main.SPIELFELD[x][y].isBlack();
        }
    }
	
	// Gemäß Spezifikation ist ein Feld auf dem zweidimensionalen Spielfeld-Array genau dann leer, wenn es den Wert null hat.
    public boolean isEmptyField(int x, int y) {
        return Main.SPIELFELD[x][y] == null;
    }
}
