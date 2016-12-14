package me.aul12;

public class Main {

    public static void main(String[] args) {
        String s = args[0];
        System.out.println("Länge: " + s.length());
        /*
         * Hinweis: replace ist Case-Sensitive da Aufgabenstellung unklar
         *          ersetzten wir daher nur "great" und nicht "Great" etc.
         */
        System.out.println("Ersetzt:" + s.replaceFirst("great", "FUBAR"));

        /*
         * Hinweis: Aufgabenstellung ebenfalls unklar wir gehen vom ursprünglichen String aus,
         *          nicht vom bereits ersetzten String
         */
        System.out.println("Komplett groß: " + s.toUpperCase().equals(s));
    }
}
