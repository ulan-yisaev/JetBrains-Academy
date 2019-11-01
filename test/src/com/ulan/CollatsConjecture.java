package com.ulan;

import java.util.Scanner;
/*Given natural number n. Generate a sequence of integers, described in the Collatz conjecture:
If n is an even number, divide it in half, if it is odd, multiply it by 3 and add 1. Repeat this operation until we
get the number 1 as a result.
        For example, if the number n = 17, then the sequence looks as the following:
        17 52 26 13 40 20 10 5 16 8 4 2 1
        Such a sequence will stop at number 1 for any primary natural number n.

        Output format:
        Sequence of integers in a single line, separated by spaces.*/
public class CollatsConjecture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        System.out.print(num + " ");

        while (num > 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num * 3 + 1;
            }
            System.out.print(num + " ");
        }

    }
}

   /* Reference solution β

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        while (n != 1) {
            System.out.print(n + " ");

            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3 + 1;
            }
        }

        System.out.print(n);
    }
}*/