package com.ulan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][][] cubic = new int[3][4][7]; // an three-dimensiona array (cube)

        int current = 1; // it stores a value to fill elements

        for (int i = 0; i < 3; i++) { // iterating through each 2D array ("table" or "matrix")
            for (int j = 0; j < 4; j++) { // iterating through each 1D array ("vector") array of a "matrix"
                for (int k = 0; k < 7; k++) { // iterating through each element of a vector
                    cubic[i][j][k] = current; // assign a value to an element
                }
            }
            current++; // get the next value to the next "matrix"
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 7; k++) {
                    System.out.print(cubic[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

    /*    int x1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int x3 = scanner.nextInt();

        if ((x1 >= x2 && x2 >= x3) || (x1 <= x2 && x2 <= x3) )  {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
*/
/*        while (x1 != 0) {
            x1 = scanner.nextInt();
            System.out.println(x1 + " % 5 = " + (x1 % 5));
            i++;
        }
        System.out.println(i);
/*
        if (x1 != x2 && x2 != x3 && x3 != x1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
*/

 /*       String str = " Inside Main";
        String subs = str.substring(0, 6);
        long n = subs.trim().length();
        System.out.println(n);
/*

        String str = scanner.nextLine();
        System.out.println(str.endsWith("burg"));
*/
      // -- It's all equals this short form:
//  +++ hypreskill solution:
//      System.out.println(new Scanner(System.in).nextLine().endsWith("burg"));

        /*String str = scanner.nextLine();
        int len = str.length();
        int x1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        if ((x1 >= 0 && x2 >= 0) && (x1 < len && x2 < len) && x1 <= x2)
        {
            System.out.println(str.substring(x1, x2 + 1));
        }
        else { System.out.println("Please attempt again!");}*/
//  +++ hypreskill solution:
//      System.out.println(scanner.next().substring(scanner.nextInt(), scanner.nextInt() + 1));

    }
}
