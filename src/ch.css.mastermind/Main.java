package ch.css.mastermind;

import java.util.ArrayList;
import java.util.Random;

public class Main {


    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {

            String[] color = {"Rot", "Blau", "Grün", "Gelb", "Pink", "Weiss", "Schwarz", "Orange"};

            int myMin = 0;
            int myMax = 7;


            int random_int = (int)Math.floor(Math.random() * (myMax - myMin + 1) + myMin);

            System.out.println(color[random_int]);

        }


    }


}
