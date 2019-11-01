package com.ulan;

import java.util.Scanner;

/*
3-5 Does an array contain N
Write a program that reads an array of integers and an integer number n. The program must check that array contains n.
Input data format
The first line contains the size of an array.
The second line contains elements of the array separated by the space.
The third line contains one integer number n.
Output data format
Only a single value: true or false.
 */
public class DoesArrayContainN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int aLen = sc.nextInt();
        int[] numArr = new int[aLen];
        boolean containsN = false;

        for (int i = 0; i < aLen; i++) {
            numArr[i] = sc.nextInt();
        }

        int n = sc.nextInt();
// ----- reference solution is better than my:
        for (int i = 0; i < numArr.length && !containsN; i++) {
            if (numArr[i] == n) {
                containsN = true;
            }
        }
// my solution is less optimal:
/*
        for (int i : numArr) {
            if (i == n) {
                containsN = true;
            }
        }
*/
        System.out.println(containsN);
    }
}

/*
Reference solution β
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        int num = scanner.nextInt();
        boolean contains = false;

        for (int i = 0; i < numbers.length && !contains; i++) {
            if (numbers[i] == num) {
                contains = true;
            }
        }

        System.out.println(contains);
    }
}
 */