package com.ulan;
/*
Conditional statement -> Chocolate
Typical task for a job interview.
A chocolate bar has the shape of a rectangle, divided into NxM segments. You can break down this chocolate bar into two parts by a single straight line (only once). Find whether you can break off exactly K segments from the chocolate. Each segment is 1x1.
Input data format
The program gets an input of three integers: N, M, K
Output data format
The program must output one of the two words: YES or NO.
 */
import java.util.Scanner;

public class ConditionalChocolate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        if ((k % n == 0 && k / n < m) || (k % m == 0 && k / m < n)) {
// Reference Solution : if (k % n == 0 && m >= k / n || k % m == 0 && n >= k / m)
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
