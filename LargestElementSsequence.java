package com.ulan;

import java.util.Scanner;

/*3-5 The largest element of a sequence
        Given the sequence of integer numbers (which ends with the number 0). Find the largest element of the sequence.
        The number 0 itself is not included in the sequence but serves only as a sign of the sequence’s end.

        Sample Input 1:
        1
        7
        9
        0
        Sample Output 1:
        9*/
public class LargestElementSsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        int largestNum = 0;
        do {
            num = sc.nextInt();
            if (num > largestNum) {
                largestNum = num;
            }
        } while (num > 0);
        System.out.println(largestNum);

    }
}

    /*Reference solution β
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int max = number;

        while (number != 0) {
        if (max < number) {
        max = number;
        }
        number = scanner.nextInt();
        }

        System.out.println(max);*/