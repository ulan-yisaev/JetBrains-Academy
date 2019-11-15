package com.ulan;

import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
//        double r = scanner.nextDouble();
        double posInf = Double.POSITIVE_INFINITY;  // +Infinity

        double anotherPosInf = +1 / 0.0;          // it's +Infinity, not an exception

        double posInfAgain = anotherPosInf + 100; // +Infinity again
        System.out.println( 0.0/0.0);

    }
}