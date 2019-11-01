package com.ulan;
/*
Iterating over arrays -> The longest ascending sequence
Write a program that reads an array of ints and outputs the length of the longest sequence in ascending order. Elements of the sequence must go one after another.
Input data format
The first line contains the size of an array.
The second line contains elements of the array separated by spaces.
Example
The input array is 1 2 4 1 2 3 5 7 4 3. In this case, the length of the longest sequence in ascending order is 5. It includes the following elements: 1 2 3 5 7.
 */
import java.util.Scanner;

public class LongestAscendingSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] m = new int[n];

        for (int i = 0; i < n ; i++) {
                m[i] = sc.nextInt();
            }

        int length = 1;
        int len = 1;

        for (int i = 1; i < n ; i++) {
            if (m[i] > m[i-1]) {
                len++;
//                System.out.println(m[i] + " len:" + len);
            } else {
                if (length < len) {
                    length = len;
                    len = 1;
                }
                continue;
            }
        }

        if (length < len) {
            length = len;
        }
        System.out.println(length);
    }
}

/*
Reference solution β
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int max = 1;
        for (int i = 1; i < n; i++) {
            int best = 1;
            while (i < n && arr[i] > arr[i - 1]) {
//              System.out.println("m[i]= " + m[i] + " | best: " + best + " | i: " + i);
                best++;
                i++;
            }
            max = Math.max(max, best);
        }

        System.out.println(max);
    }
}
 */