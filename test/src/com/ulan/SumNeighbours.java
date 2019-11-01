package com.ulan;

import java.util.Arrays;
import java.util.Scanner;

/*
Multi-dimensional array -> Sum of neighbours
Write a program, which inputs the rectangular matrix from a sequence of lines, ending with a line, containing the only word "end" (without the quotation marks).
The program should output the matrix of the same size, where each element in the position (i, j) is equal to the sum of the elements from the first matrix on the positions (i-1, j)(i+1, j)(i, j-1), (i, j+1). Boundary elements have neighbours on the opposite side of the matrix. In the case of one row or column, the element itself may be its neighbour.
 */
public class SumNeighbours {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int columns = 0;
        int rows = 0;
        String str = "";

        while (true) {
            String input = sc.nextLine();
            if (input.length() > 2 && input.substring(input.length()-3).equals("end")) {
                str += input.substring(0, input.length()-3);
                if (!input.matches("^[a-zA-Z]*$")) rows += 1;
                break;
            }
            rows += 1;
            str += input + " ";
        }

        String[] strArray = str.split(" ");
        columns = strArray.length / rows;
        int[][] m = new int[rows][columns];

//        System.out.println("strArray.length = " + strArray.length + " | columns = " + columns + " | rows = " + rows);
//        System.out.println(Arrays.toString(strArray));

        int k = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                m[i][j] = Integer.parseInt(strArray[k]);
                k++;
            }
        }

        int[][] mm = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                //m = minus, p = plus
                int im = (i + rows - 1) % rows;
                int jm = (j + columns - 1) % columns;
                int ip = (i + rows + 1) % rows;
                int jp = (j + columns + 1) % columns;
                mm[i][j] = m[im][j] + m[ip][j] + m[i][jm] + m[i][jp];
                System.out.print(mm[i][j] + " ");
            }
            System.out.println();
        }

    }
}

/*
Reference solution β
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String temp = "";
        String finalString = "";
        int dim = -1;

        while (!"end".equals(temp)) {
            finalString = finalString + temp + " ";
            temp = scanner.nextLine();
            dim++;
        }

        scanner.close();
        scanner = new Scanner(finalString);
        int count = 0;

        while (scanner.hasNextInt()) {
            scanner.nextInt();
            count++;
        }

        scanner.close();
        int column = count / dim;
        int[][] inArray = new int[dim][column];
        scanner = new Scanner(finalString);

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < column; j++) {
                inArray[i][j] = scanner.nextInt();
            }
        }

        int[][] outArray = new int[dim][column];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < column; j++) {
                int left = j - 1;
                int top = i - 1;
                int right = j + 1;
                int bot = i + 1;
                if (i == 0) {
                    top = dim - 1;
                }
                if (i == dim - 1) {
                    bot = 0;
                }
                if (j == 0) {
                    left = column - 1;
                }
                if (j == column - 1) {
                    right = 0;
                }
                outArray[i][j] =
                        inArray[i][left] + inArray[i][right] + inArray[top][j] + inArray[bot][j];
            }
        }
        scanner.close();

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(outArray[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
 */