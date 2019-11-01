package com.ulan;
/*
3-5 Check if an array contains two numbers
Write a program that reads an unsorted array of integers and two numbers n and m. The program must check if n and m occur next to each other in the array (in any order).

Input data format
The first line contains the size of an array.
The second line contains elements of the array.
The third line contains two integer numbers n and m.
All numbers in the same line are separated by the space character.

Output data format
Only a single value: true or false.
 */

import java.util.Arrays;
import java.util.Scanner;

public class ifArrayContains2numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int aLen = sc.nextInt();
        int[] numArr = new int[aLen];

        for (int i = 0; i < aLen; i++) {
            numArr[i] = sc.nextInt();
        }

        int n = sc.nextInt();
        int m = sc.nextInt();

// Reference solution is better:
        boolean found = false;
        for (int i = 0; i < numArr.length - 1; i++) {
            if (numArr[i] == n && numArr[i + 1] == m) {
                found = true;
                break;
            }
            if (numArr[i] == m && numArr[i + 1] == n) {
                found = true;
                break;
            }
        }
        System.out.println(found);

// My solution is worse:
/*        boolean isN = false;
        boolean isM = false;

        for (int i = 1; i < aLen && !isN && !isM; i++) {
            if (numArr[i] == n && numArr[i-1] == m) {
                isN = true;
                System.out.println(isN);
            } else if (numArr[i] == m && numArr[i-1] == n) {
                isM = true;
                System.out.println(isM);
            }
 //           System.out.println("i = " + i + " | cnt = " + cnt + " | isN:" + isN + " | isM: " + isM);
        }

        if (!isN && !isM) {
            System.out.println("false");
        }*/
        }
    }
/*
Reference solution β
public class Main {
    public static void main(String args[]) {
        final Scanner scanner = new Scanner(System.in);
        final int len = scanner.nextInt();

        final int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        final int n = scanner.nextInt();
        final int m = scanner.nextInt();

        boolean found = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == n && array[i + 1] == m) {
                found = true;
                break;
            }
            if (array[i] == m && array[i + 1] == n) {
                found = true;
                break;
            }
        }

        System.out.println(found);
    }
}
 */