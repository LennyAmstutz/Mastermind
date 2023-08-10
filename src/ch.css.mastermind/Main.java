package ch.css.mastermind;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {


        boolean start = false;
        boolean beginn = false;

        if (beginn == false) {


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
                        System.out.println(start);
                    }
                } else if (key.equals("S") || key.equals("s")) {
                    start = true;
                    beginn = true;

                } else
                    System.out.println("Diese Taste hat keine Funktion");
            }

        }


        for (int i = 0; i < 4; i++) {

            String[] color = {"Rot", "Blau", "Grün", "Gelb", "Pink", "Weiss", "Schwarz", "Orange"};

            int myMin = 0;
            int myMax = 7;


            int random_int1 = (int) Math.floor(Math.random() * (myMax - myMin + 1) + myMin);


            System.out.println(color[random_int1]);



        }
        for (int n = 1; n <= 12; n++) {


            for (double d = 0; d < 4; d++) {

                Scanner fr = new Scanner(System.in);
                System.out.println("Farbe:");

                String key3 = fr.nextLine();

                System.out.println("Runde" + n );

            }
        }
    }
}