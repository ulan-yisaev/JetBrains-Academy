package com.ulan;

/*3-5 Even or odd
Given a sequence of natural numbers. For each number of the sequence output "even" if the number is even, otherwise, "odd".
If the number is equal to 0, the program must stop reading and processing numbers.

        Input data
        A sequence of natural numbers, each number in a new line.

        Output data
        The sequence of words "even" and "odd". Each word in a new line.

        Sample Input 1:
        1
        2
        3
        4
        0
        Sample Output 1:
        odd
        even
        odd
        even*/
import java.util.Scanner;
public class EvenorOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }
            if ( num % 2 == 0) {
                System.out.println("even");
            } else System.out.println("odd");
        }
    }
}
