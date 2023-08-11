package ch.css.mastermind;

import java.util.Random;
import java.util.Scanner;

public class Main {


    private static Object Break;

    public static void main(String[] args) {


        boolean start = false;
        boolean beginn = false;
        boolean again = false;

        if (beginn == false || again == true) {


            while (!beginn) {
                System.out.println(" Drücke I für Informationen und S für Start");

                Scanner sc = new Scanner(System.in);
                String key = sc.next();
                if (key.equals("I") || key.equals("i")) {
                    System.out.println("""
                            Das Ziel des Spieles ist die Farbkombination, die der Computer sich überlegt hat in 12 Runden heraus zu finden.
                            Es gibt die Farben Grün, Blau, Rot, Gelb, Orange, Pink, Schwarz und Weiss.
                            Der Computer überlegt sich aus diesen Farben eine Kombination, diese Kombination ist vier Farben lang.
                            Es kann aber auch sein, dass eine Farbe zwei mal vorhanden ist. Es müssen die Farben stimmen und auch die Position der Farben.
                             Der Computer sagt dir jede Runde wie viele Farben das richtig sind und wie viele Positionen das richtig sind
                            """);
                    System.out.println("Drücke S für Start");
                    key = sc.next();
                    if (key.equals("S") || key.equals("s")) {
                        start = true;
                        beginn = true;

                    }
                } else if (key.equals("S") || key.equals("s")) {
                    start = true;
                    beginn = true;

                } else
                    System.out.println("Diese Taste hat keine Funktion");
            }

        }
        boolean win = false;

        int[] ergebnis1 = new int[4];
        for (int n = 0; n < 4; n++) {

            String[] color = {"Rot", "Blau", "Grün", "Gelb", "Pink", "Weiss", "Schwarz", "Orange"};

            Random random = new Random();
            int i = random.nextInt(8);
            System.out.println(color[i]);
            ergebnis1[n] = i;
        }

        int[] ergebnis2 = new int[4];

        for (int n = 1; n <= 12; n++) {
            int korektepositionen = 0;
            int korektefarben = 0;

            if (!win) {

                System.out.println("Runde" + n);

                for (int d = 0; d < 4; d++) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Farbe:");


                    int number = 0;
                    switch (sc.nextLine().toLowerCase()) {
                        case "blau" -> number = 1;
                        case "grün" -> number = 2;
                        case "gelb" -> number = 3;
                        case "pink" -> number = 4;
                        case "weiss" -> number = 5;
                        case "schwarz" -> number = 6;
                        case "orange" -> number = 7;

                    }

                    ergebnis2[d] = number;


                    if (ergebnis1[0] == ergebnis2[0]
                            && ergebnis1[1] == ergebnis2[1]
                            && ergebnis1[2] == ergebnis2[2] &&
                            ergebnis1[3] == ergebnis2[3]) {
                        System.out.println("Du hast Gewonnen");
                        win = true;
                    } else {
                        korektepositionen = 0;
                        korektefarben = 0;

                        if (ergebnis1[0] == ergebnis2[0]) {
                            korektepositionen++;
                        }
                        if (ergebnis1[1] == ergebnis2[1]) {
                            korektepositionen++;
                        }
                        if (ergebnis1[2] == ergebnis2[2]) {
                            korektepositionen++;
                        }
                        if (ergebnis1[3] == ergebnis2[3]) {
                            korektepositionen++;
                        }

                        if (ergebnis1[0] == ergebnis2[1] || ergebnis1[0] == ergebnis2[2] || ergebnis1[0] == ergebnis2[3]) {

                            korektefarben++;
                        }
                        if (ergebnis1[1] == ergebnis2[2] || ergebnis1[1] == ergebnis2[3] || ergebnis1[1] == ergebnis2[0]) {

                            korektefarben++;
                        }
                        if (ergebnis1[2] == ergebnis2[1] || ergebnis1[2] == ergebnis2[0] || ergebnis1[2] == ergebnis2[3]) {

                            korektefarben++;
                        }
                        if (ergebnis1[3] == ergebnis2[1] || ergebnis1[3] == ergebnis2[2] || ergebnis1[3] == ergebnis2[0]) {

                            korektefarben++;
                        }

                    }
                }
                if (!win) {
                    System.out.println("Du hast " + korektefarben + " Farben Richtig");
                    System.out.println("Du hast  " + korektepositionen + "  Positionen richtig");
                }
            }
        }
    }
}