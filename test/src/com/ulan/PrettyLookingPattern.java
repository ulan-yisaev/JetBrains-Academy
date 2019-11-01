package com.ulan;
/*
Multi-dimensional array -> Pretty looking pattern
In some design style, a 4x4 matrix pattern is considered looking pretty if it doesn't consist of a 2x2 matrix of the same color. Your task is to write the program
that outputs "YES" if the 4x4 matrix is looking pretty, otherwise output "NO".
Input contains 4 lines, each line contains 4 symbols, different symbols represent different colors: W stands for white color, B - black, R - red, G - green, Y - yellow.
 */
import java.util.Scanner;

public class PrettyLookingPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] matrix = new char[4][4];

        for (int i = 0; i < 4; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        boolean isPretty = true;
//        boolean stopped = false;
// rewritten with "return" by myself:
        for (int i = 0; i < 3; i++) {
//      for (int i = 0; i < 3 && !stopped; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == matrix[i][j+1] && matrix[i][j] == matrix[i+1][j] && matrix[i+1][j] == matrix[i+1][j+1]) {
//                    System.out.print(matrix[i][j] +" "+ matrix[i][j+1]  +" "+  matrix[i+1][j]  +" "+  matrix[i+1][j+1]);
                    System.out.println("NO");
                    isPretty = false;
//                    stopped = true;
//                    break;
// The return statement exits from the current method, and control flow returns to where the method was invoked:
                    return;
                }
            }
        }
            System.out.println("YES");
    }
}

/*
Reference solution β
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = new String[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = scanner.next();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i].charAt(j) == arr[i + 1].charAt(j) && arr[i].charAt(j) == arr[i].charAt(j + 1)
                        && arr[i].charAt(j) == arr[i + 1].charAt(j + 1)) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
    }
}
 */