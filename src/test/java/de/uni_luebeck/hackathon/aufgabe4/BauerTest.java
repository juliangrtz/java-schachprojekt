package de.uni_luebeck.hackathon.aufgabe4;

import de.uni_luebeck.hackathon.Main;
import org.testng.annotations.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class BauerTest {
    @Test
    void EINFACHE_UND_DOPPELTE_ZUEGE_NACH_VORNE() {
        Main.SPIELFELD = new Figur[][]{
                {null, null, null, null, null, null, null, new Bauer(0, 7, true)},
                {new Bauer(1, 0, true), null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {new Bauer(6, 0, false), null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, new Bauer(7, 7, false)},
        };

        // Positivtests (Gültige Züge)
        assertTrue("Weißer Startbauer | Einfacher Zug nach vorne", Main.SPIELFELD[6][0].checkMove(5, 0));
        assertTrue("Weißer Startbauer | Doppelter Zug nach vorne", Main.SPIELFELD[6][0].checkMove(4, 0));
        assertTrue("Weißer Bauer | Einfacher Zug nach vorne", Main.SPIELFELD[7][7].checkMove(6, 7));
        assertTrue("Schwarzer Startbauer | Einfacher Zug nach vorne", Main.SPIELFELD[1][0].checkMove(2, 0));
        assertTrue("Schwarzer Startbauer | Doppelter Zug nach vorne", Main.SPIELFELD[1][0].checkMove(3, 0));
        assertTrue("Schwarzer Bauer | Einfacher Zug nach vorne", Main.SPIELFELD[0][7].checkMove(1, 7));

        // Negativtests (Ungültige Züge)
        assertFalse("Weißer Startbauer | Kein Zug", Main.SPIELFELD[6][0].checkMove(6, 0));
        assertFalse("Weißer Startbauer | Dreifacher Zug nach vorne", Main.SPIELFELD[6][0].checkMove(3, 0));
        assertFalse("Weißer Startbauer | Zug rückwärts", Main.SPIELFELD[6][0].checkMove(7, 0));
        assertFalse("Weißer Startbauer | Spielfeld verlassen (1)", Main.SPIELFELD[6][0].checkMove(8, 0));
        assertFalse("Weißer Startbauer | Spielfeld verlassen (2)", Main.SPIELFELD[6][0].checkMove(-1, 0));
        assertFalse("Weißer Bauer | Doppelter Zug nach vorne nicht von Startposition", Main.SPIELFELD[7][7].checkMove(5, 7));
        assertFalse("Schwarzer Startbauer | Kein Zug", Main.SPIELFELD[1][0].checkMove(1, 0));
        assertFalse("Schwarzer Startbauer | Dreifacher Zug nach vorne", Main.SPIELFELD[1][0].checkMove(4, 0));
        assertFalse("Schwarzer Startbauer | Zug rückwärts", Main.SPIELFELD[1][0].checkMove(0, 0));
        assertFalse("Schwarzer Startbauer | Spielfeld verlassen (1)", Main.SPIELFELD[1][0].checkMove(8, 0));
        assertFalse("Schwarzer Startbauer | Spielfeld verlassen (2)", Main.SPIELFELD[1][0].checkMove(-1, 0));
        assertFalse("Schwarzer Bauer | Doppelter Zug nach vorne nicht von Startposition", Main.SPIELFELD[0][7].checkMove(2, 7));
    }

    @Test
    void DIAGONALE_ZUEGE() {
        Main.SPIELFELD = new Figur[][]{
                {null, new Bauer(0, 1, false), null, null, null, null, null, null},
                {new Bauer(1, 0, true), null, new Bauer(1, 2, false), null, null, null, null, null},
                {null, new Bauer(2, 1, false), null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, new Bauer(4, 2, true), null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {new Bauer(6, 0, false), null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
        };

        // Positivtests (Gültige Züge)
        assertTrue("Weißer Bauer schlägt schwarzen Bauern", Main.SPIELFELD[1][0].checkMove(2, 1));
        assertTrue("Schwarzer Bauer schlägt weißen Bauern", Main.SPIELFELD[2][1].checkMove(1, 0));

        // Negativtests (Ungültige Züge)
        assertFalse("Weißer Bauer versucht weißen Bauern zu schlagen", Main.SPIELFELD[2][1].checkMove(1, 2));
        assertFalse("Weißer Bauer versucht schwarzen Bauern zwei Felder diagonal entfernt zu schlagen", Main.SPIELFELD[6][0].checkMove(4, 2));
        assertFalse("Weißer Bauer verhält sich wie Springer", Main.SPIELFELD[2][1].checkMove(0, 0));
        assertFalse("Schwarzer Bauer verhält sich wie Springer", Main.SPIELFELD[1][0].checkMove(0, 2));
        assertFalse("Schwarzer Bauer schlägt auf falsches Feld", Main.SPIELFELD[1][0].checkMove(1, 2));
        assertFalse("Schwarzer Bauer schlägt rückwärts auf richtiges Feld", Main.SPIELFELD[1][0].checkMove(0, 1));
    }

    @Test
    void SONDERFAELLE() {
        Main.SPIELFELD = new Figur[][]{
                {new Bauer(0, 0, false), null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, new Bauer(4, 7, false)},
                {new Figur(5, 0, false), null, null, null, null, null, null, null},
                {new Bauer(6, 0, false), null, null, null, null, null, null, new Bauer(6, 7, false)},
                {null, null, null, null, null, null, null, new Bauer(7, 7, true)},
        };

        // Positivtests (Gültige Züge)
        // TODO

        // Negativtests (Ungültige Züge)
        assertFalse("Bauer überspringt Figur beim Doppelzug", Main.SPIELFELD[6][0].checkMove(4, 0));
        assertFalse("Bauer versucht Doppelzug auf besetztes Feld", Main.SPIELFELD[6][7].checkMove(4, 7));
        assertFalse("Weißer Bauer versucht Schachbrett zu verlassen", Main.SPIELFELD[0][0].checkMove(-1, 0));
        assertFalse("Schwarzer Bauer versucht Schachbrett zu verlassen", Main.SPIELFELD[7][7].checkMove(8, 7));
    }
}