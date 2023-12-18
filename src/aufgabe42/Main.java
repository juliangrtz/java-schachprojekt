package aufgabe42;

public class Main {
    static Figur[][] SPIELFELD = new Figur[][]{
            // Grundaufstellung
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
    };

    public static void main(String[] args) throws Exception {
        // Einfache und doppelte Züge nach vorne
        SPIELFELD = new Figur[][]{
                {null, null, null, null, null, null, null, new Bauer(0, 7, true)},
                {new Bauer(1, 0, true), null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {new Bauer(6, 0, false), null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, new Bauer(7, 7, false)},
        };

        System.out.println("Testsuite 1: Ein weißer Bauer auf Brett (gültige Züge)");
        assertTrue("Weißer Startbauer | Einfacher Zug nach vorne", SPIELFELD[6][0].checkMove(5, 0));
        assertTrue("Weißer Startbauer | Doppelter Zug nach vorne", SPIELFELD[6][0].checkMove(4, 0));
        assertTrue("Weißer Bauer | Einfacher Zug nach vorne", SPIELFELD[7][7].checkMove(6, 7));
        assertTrue("Schwarzer Startbauer | Einfacher Zug nach vorne", SPIELFELD[1][0].checkMove(2, 0));
        assertTrue("Schwarzer Startbauer | Doppelter Zug nach vorne", SPIELFELD[1][0].checkMove(3, 0));
        assertTrue("Schwarzer Bauer | Einfacher Zug nach vorne", SPIELFELD[0][7].checkMove(1, 7));

        System.out.println("Testsuite 1: Ein weißer Bauer auf Brett (ungültige Züge)");
        assertFalse("Weißer Startbauer | Kein Zug", SPIELFELD[6][0].checkMove(6, 0));
        assertFalse("Weißer Startbauer | Dreifacher Zug nach vorne", SPIELFELD[6][0].checkMove(3, 0));
        assertFalse("Weißer Startbauer | Zug rückwärts", SPIELFELD[6][0].checkMove(7, 0));
        assertFalse("Weißer Startbauer | Spielfeld verlassen (1)", SPIELFELD[6][0].checkMove(8, 0));
        assertFalse("Weißer Startbauer | Spielfeld verlassen (2)", SPIELFELD[6][0].checkMove(-1, 0));
        assertFalse("Weißer Bauer | Doppelter Zug nach vorne", SPIELFELD[7][7].checkMove(5, 7));
        assertFalse("Schwarzer Startbauer | Kein Zug", SPIELFELD[1][0].checkMove(1, 0));
        assertFalse("Schwarzer Startbauer | Dreifacher Zug nach vorne", SPIELFELD[1][0].checkMove(4, 0));
        assertFalse("Schwarzer Startbauer | Zug rückwärts", SPIELFELD[1][0].checkMove(0, 0));
        assertFalse("Schwarzer Startbauer | Spielfeld verlassen (1)", SPIELFELD[1][0].checkMove(8, 0));
        assertFalse("Schwarzer Startbauer | Spielfeld verlassen (2)", SPIELFELD[1][0].checkMove(-1, 0));
        assertFalse("Schwarzer Bauer | Doppelter Zug nach vorne", SPIELFELD[0][7].checkMove(2, 7));

        System.out.println();

        // Diagonale Züge, d.h. Schläge
        SPIELFELD = new Figur[][]{
                {null, null, null, null, null, null, null, null},
                {new Bauer(1, 0, true), null, new Bauer(1, 2, false), null, null, null, null, null},
                {null, new Bauer(2, 1, false), null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
        };

        System.out.println("Testsuite 2: Diagonale Züge, d.h. Schläge (gültige Züge)");
        assertTrue("Weißer Bauer schlägt schwarzen Bauern", SPIELFELD[1][0].checkMove(2, 1));
        assertTrue("Schwarzer Bauer schlägt weißen Bauern", SPIELFELD[2][1].checkMove(1, 0));

        System.out.println("Testsuite 2: Diagonale Züge, d.h. Schläge (gültige Züge)");
        assertFalse("Weißer Bauer versucht weißen Bauern zu schlagen", SPIELFELD[2][1].checkMove(1, 2));
        assertFalse("Weißer Bauer verhält sich wie Springer", SPIELFELD[2][1].checkMove(0, 0));
        assertFalse("Schwarzer Bauer verhält sich wie Springer", SPIELFELD[1][0].checkMove(0, 2));
    }

    private static void assertTrue(String title, boolean predicate) throws Exception {
        if (!predicate) {
            throw new Exception("Testfall nicht bestanden: " + title);
        } else {
            System.out.println("Testfall bestanden: " + title);
        }
    }

    private static void assertFalse(String title, boolean predicate) throws Exception {
        if (predicate) {
            throw new Exception("Testfall nicht bestanden: " + title);
        } else {
            System.out.println("Testfall bestanden: " + title);
        }
    }
}
