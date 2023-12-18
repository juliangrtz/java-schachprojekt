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
        // Ein weißer Bauer auf Spielfeld
        SPIELFELD = new Figur[][]{
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {new Bauer(6, 0, false), null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
        };

        System.out.println("Testsuite 1: Ein weißer Bauer auf Brett (gültige Züge)");
        assertTrue("Weißer Bauer | Einfacher Zug nach vorne", SPIELFELD[6][0].checkMove(5, 0));
        assertTrue("Weißer Bauer | Doppelter Zug nach vorne", SPIELFELD[6][0].checkMove(4, 0));

        System.out.println("Testsuite 1: Ein weißer Bauer auf Brett (ungültige Züge)");
        assertFalse("Weißer Bauer | Dreifacher Zug nach vorne", SPIELFELD[6][0].checkMove(3, 0));
        assertFalse("Weißer Bauer | Zug rückwärts", SPIELFELD[6][0].checkMove(7, 0));
        assertFalse("Weißer Bauer | Spielfeld verlassen", SPIELFELD[6][0].checkMove(8, 0));

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
