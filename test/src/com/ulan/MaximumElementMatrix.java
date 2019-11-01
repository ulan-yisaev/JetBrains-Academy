package com.ulan;
/*
Multi-dimensional array -> Maximum element in a matrix
Find the indexes of the initial appearance of the maximum element in a matrix.

Input data format
On the input, the program receives the size of matrix n and m, and then n lines having m integer numbers in each. n and m do not exceed 100.

Output data format
Output two numbers: the row number and the column number, in which the greatest item in the two-dimensional array (matrix) is located. If there are several such elements, output the one, which has the smaller row number; and if row numbers are the same - the one having the smaller column number.
 */
import java.util.Scanner;

public class MaximumElementMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];

        // Reference solution β is better:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int iMax = 0;
        int jMax = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[iMax][jMax] < matrix[i][j]) {
                    iMax = i;
                    jMax = j;
                }
            }
        }

        System.out.println(iMax + " " + jMax);
// my solution is worse:
        /*int[] max = new int[3];
        max[0] = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
                if (matrix[i][j] > max[0]) {
                    max[0] = matrix[i][j];
                    max[1] = i;
                    max[2] = j;
                }
                }
            }

//        System.out.print(Arrays.toString(max));
        System.out.println(max[1] + " " + max[2]);*/
    }
}