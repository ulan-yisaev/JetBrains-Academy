package com.ulan;
/*
Multi-dimensional array -> The star figure
Given an odd number n, not exceeding 15. Create a two-dimensional array (matrix) from n×n elements, by filling it with "." symbols (each element of the matrix is a string containing a single symbol). Then fill the middle row of the matrix, the middle column, and the main and the secondary diagonals with the "*" symbols. As a result, all "*"s in the array must form the star figure. Output this matrix; elements of the array should be space separated.
Sample Input 1:
5
Sample Output 1:
* . * . *
. * * * .
* * * * *
. * * * .
* . * . *
 */

import java.util.Scanner;

public class TheStarFigure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[][] m = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = '.';
            }
        }

        int k = n / 2;
        int d = n - 1;
        for (int i = 0; i < n; i++) {
            m[i][k] = '*';
            m[k][i] = '*';
            m[i][i] = '*';
            m[i][d] = '*';
            d--;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*
Reference solution β
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int size = scanner.nextInt();
        final char[][] matrix = new char[size][size];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], '.');
        }

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = '*';
            matrix[i][matrix.length - 1 - i] = '*';
            matrix[i][matrix.length / 2] = '*';
            matrix[matrix.length / 2][i] = '*';
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
 */