package com.ulan;

import java.util.Scanner;

/*
3-5 Branching statements -> The sequence
Typical task for a job interview.
Write a program that prints a part of the sequence 1 2 2 3 3 3 4 4 4 4 5 5 5 5 5 ... (the number is repeated as many
times, to what it equals to). The input to the program is a positive integer n: the number of the elements of the sequence
 the program should print. Output the sequence of numbers, written in a single line, space-separated.

For example, if n = 7, then the program should output 1 2 2 3 3 3 4.
 */
public class TheSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = 0;
        boolean stopped = false;

        for (int i = 1; (i <= n) && !stopped; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
                m++;
                if (m == n) {
                    stopped = true;
                    break;
                }
            }
//            System.out.println("|m = " + m);
        }
    }
}
