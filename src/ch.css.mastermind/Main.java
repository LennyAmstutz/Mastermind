package ch.css.mastermind;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        boolean again = true;
        while (again) {
            boolean start = false;
            boolean beginn = false;


            if (beginn == false) {


                while (!beginn) {
                    System.out.println(" Drücke I für Informationen und S für Start");

                    Scanner sc = new Scanner(System.in);
                    String key = sc.nextLine().trim();
                    if (key.equals("I") || key.equals("i")) {
                        System.out.println("""
                                Das Ziel des Spieles ist die Farbkombination, die der Computer sich überlegt hat in 12 Runden heraus zu finden.
                                Es gibt die Farben Grün, Blau, Rot, Gelb, Orange, Pink, Schwarz und Weiss.
                                Der Computer überlegt sich aus diesen Farben eine Kombination, diese Kombination ist vier Farben lang.
                                Es kann aber auch sein, dass eine Farbe zwei mal vorhanden ist. Es müssen die Farben stimmen und auch die Position der Farben.
                                 Der Computer sagt dir jede Runde wie viele Farben das richtig sind und wie viele Positionen das richtig sind
                                """);
                        System.out.println("Drücke S für Start");
                        key = sc.nextLine();
                        if (key.equals("S") || key.equals("s")) {
                            start = true;
                            beginn = true;

                        }
                    } else if (key.equals("S") || key.equals("s")) {
                        start = true;
                        beginn = true;

                    } else System.out.println("Diese Taste hat keine Funktion");
                }


            }
            boolean win = false;

            int[] ergebnis1 = new int[4];
            for (int n = 0; n < 4; n++) {

                String[] color = {"Rot", "Blau", "Grün", "Gelb", "Pink", "Weiss", "Schwarz", "Orange"};

                Random random = new Random();
                int i = random.nextInt(8);
                if (Arrays.stream(ergebnis1).filter(number -> number == i).count() == 2) {
                    n--;
                    continue;


                }
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
                        boolean isColorCorect = false;
                        while (isColorCorect == false) {

                            Scanner sc = new Scanner(System.in);
                            System.out.println("Farbe:");


                            int number = 0;
                            switch (sc.nextLine().toLowerCase().trim()) {
                                case "rot" -> number = 0;
                                case "blau" -> number = 1;
                                case "grün" -> number = 2;
                                case "gelb" -> number = 3;
                                case "pink" -> number = 4;
                                case "weiss" -> number = 5;
                                case "schwarz" -> number = 6;
                                case "orange" -> number = 7;
                                default -> number = -1;
                            }

                            if (number == -1) {
                                isColorCorect = false;
                                System.out.println("Diese Farbe gibt es nicht.");
                            } else {
                                isColorCorect = true;
                            }



                            ergebnis2[d] = number;
                        }
                    }


                    if (ergebnis1[0] == ergebnis2[0] && ergebnis1[1] == ergebnis2[1] && ergebnis1[2] == ergebnis2[2] && ergebnis1[3] == ergebnis2[3]) {
                        System.out.println("Du hast Gewonnen");


                        System.out.println(" Willst du nochmal Spielen? Tippe nein, wenn du nicht willst und ja wen du willst");
                        Scanner scanner = new Scanner(System.in);
                        String key2 = scanner.next().trim();
                        win = true;
                        if (key2.equals("nein")) {
                            again = false;
                            break;
                        }else {
                            again = true;
                            System.out.println("Diese Taste hat keine Funktion");
                        }


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
                    System.out.println("Du hast " + ((korektefarben) - (korektepositionen)) + " Farben Richtig");
                    System.out.println("Du hast  " + korektepositionen + "  Positionen richtig");
                }

                if (n >= 12) {
                    System.out.println("DU HAST ES WIEDER EINMEL NICHT GESCHAFFT!!!");
                }

            }
        }
    }
}
