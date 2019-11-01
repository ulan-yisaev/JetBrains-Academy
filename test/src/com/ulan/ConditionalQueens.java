package com.ulan;
/*
Conditional statement -> Queens
You are given coordinates of two queens on a chess board. Find out whether or not they hit each other.
Input data format
Four integer numbers x_1, y_1, x_2, y_2x
Output data format
Type "YES" (uppercase) if they hit each other or "NO" if they don't.

You may need a method that calculates the absolute value of the number, so here it is:
Math.abs(n)
 */
import java.util.Scanner;

public class ConditionalQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        if (Math.abs(x1 - x2) - Math.abs(y1 - y2) == 0 || x1 == x2 || y1 == y2) {
// Reference Solution : //  else if (Math.abs(num1 - num3) == Math.abs(num2 - num4))
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
