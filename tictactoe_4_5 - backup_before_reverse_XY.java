package com.ulan;

import java.util.Scanner;

public class tictactoe_4_5 {
    public static void main(String[] args) {

        int n = 3;
        String message = "";
        char[][] m = readState(n);
        int[] colXOEmpty = printState(m);
        System.out.print("Enter the coordinates: ");

/*
        System.out.println("printState(m)) {x, o, empty}: " + Arrays.toString(colXOEmpty));
        System.out.println("compare Rows, Cols & Diagonals ([X, O]):");
        System.out.println(Arrays.toString(compareRows(n, m)));
        System.out.println(Arrays.toString(compareCols(n, m)));
        System.out.println(Arrays.toString(compareDiagonals(n, m)));
*/
        int threeXinRow = compareRows(n, m)[0] + compareCols(n, m)[0] + compareDiagonals(n, m)[0];
        int threeOinRow = compareRows(n, m)[1] + compareCols(n, m)[1] + compareDiagonals(n, m)[1];
//        System.out.println("threeXinRow = " + threeXinRow + " | threeOinRow = " + threeOinRow + " | emptyCells = " + colXOEmpty[2]);

        if (threeXinRow > 0 || threeOinRow > 0 || Math.abs(colXOEmpty[0] - colXOEmpty[1]) >= 2) {
            if (threeXinRow == threeOinRow) {
                message = "Impossible";
            } else if (threeXinRow > 0) {
                message = "X wins";
            } else if (threeOinRow > 0) {
                message = "O wins";
            }
        } else if (threeXinRow == 0 && threeOinRow == 0 && colXOEmpty[2] > 0) {
            message = "Game not finished";
        } else if (threeXinRow == 0 && threeOinRow == 0 && colXOEmpty[2] == 0) {
            message = "Draw";
        }
        //commented out 13.11.2019
        //System.out.println(message);
    }

    private static char[][] readState(int n) {
        Scanner scanner = new Scanner(System.in);
        // System.out.println("Enter your input, which can contain only 'X', 'O' and '_' symbols:");
        String str = scanner.nextLine().toUpperCase();
        int k = 0;
        char[] chArr = str.toCharArray();
        char[][] m = new char[n][n];

        if (str.matches("^[ X_O]+$")) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    m[i][j] = chArr[k];
                    k++;
                }
            }
        } else System.out.println("Possible characters are 'X', 'O', '_' and whitespace ' '");
        return m;
    }

    private static int[] printState(char[][] m) {
        int x = 0, o = 0, empty = 0;
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
//                System.out.print(i + "," + j + "] ");
                switch (m[i][j]) {
                    case 'X':
                        x++;
                        break;
                    case 'O':
                        o++;
                        break;
                    case ' ':
                    case '_':
                        m[i][j] = ' ';
                        empty++;
                        break;
                    // no default really required here
                }
                System.out.print(m[i][j] + " "); // + ":[");
            }
            System.out.println("|");
        }
        System.out.println("---------");
//        System.out.println("X = " + x + " | O = " + o + " | empty = " + empty);
        return new int[]{x, o, empty};
    }

    private static int[] compareRows(int n, char[][] m) {
        int x3 = 0, o3 = 0;
        for (int i = 0; i < n; i++) {
            //m = minus, p = plus
            int im = (i + n - 1) % n;
            int ip = (i + n + 1) % n;
            if (m[i][i] == m[i][im] && m[i][i] == m[i][ip]) { //if (0,0 == 0,2 && 0,0 == 0,1)
                if (m[i][i] == 'X') {
//                            System.out.println("rows_X: m[" + i + "," + i + "] == m[" + i + "," + im + "] && m[" + i + "," + i + "] ==" + " m[" + i + "," + ip + "]");
                    x3++;
                } else if (m[i][i] == 'O') {
//                            System.out.println("rows_O: m[" + i + "," + i + "] == m[" + i + "," + im + "] && m[" + i + "," + i + "] ==" + " m[" + i + "," + ip + "]");
                    o3++;
                }
//                System.out.println("i = " + i + " | j = " + i);
            }
        }
        return new int[]{x3, o3};
    }

    private static int[] compareCols(int n, char[][] m) {
        int x3 = 0, o3 = 0;
        for (int i = 0; i < n; i++) {
            //m = minus, p = plus
            int im = (i + n - 1) % n;
            int ip = (i + n + 1) % n;
            if (m[i][i] == m[im][i] && m[i][i] == m[ip][i]) { //if (0,0 == 2,0 && 0,0 == 1,0)
                if (m[i][i] == 'X') {
//                        System.out.println("cols_X: m[" + i + "," + i + "] == m[" + im + "," + i + "] && m[" + i + "," + i + "] ==" + " m[" + ip + "," + i + "]");
                    x3++;
                } else if (m[i][i] == 'O') {
//                        System.out.println("cols_O: m[" + i + "," + i + "] == m[" + im + "," + i + "] && m[" + i + "," + i + "] ==" + " m[" + ip + "," + i + "]");
                    o3++;
                }
//                System.out.println("i = " + i + " | j = " + i);
            }
        }
        return new int[]{x3, o3};
    }

    private static int[] compareDiagonals(int n, char[][] m) {
        int i = 0, x3 = 0, o3 = 0;
        //m = minus, p = plus
        int im = (i + n - 1) % n;   // = 2
        int ip = (i + n + 1) % n;   // = 1
        if (m[i][i] == m[im][im] && m[i][i] == m[ip][ip]) {
            if (m[i][i] == 'X') {
//                        System.out.println("diag_X: m[" + i + "," + i + "] == m[" + im + "," + im + "] && m[" + i + "," + i + "] ==" + " m[" + ip + "," + ip + "]");
                x3++;
            } else if (m[i][i] == 'O') {
//                        System.out.println("diag_O: m[" + i + "," + i + "] == m[" + im + "," + im + "] && m[" + i + "," + i + "] ==" + " m[" + ip + "," + ip + "]");
                o3++;
            }
        }

        if (m[i][im] == m[ip][ip] && m[i][im] == m[im][i]) {
            if (m[i][im] == 'X') {
//                        System.out.println("reverse diag_X: m[" + i + "," + im + "] == m[" + ip + "," + ip + "] && m[" + i + "," + im + "] ==" + " m[" + im + "," + i + "]");
                x3++;
            } else if (m[i][im] == 'O') {
//                        System.out.println("reverse diag_O: m[" + i + "," + im + "] == m[" + ip + "," + ip + "] && m[" + i + "," + im + "] ==" + " m[" + im + "," + i + "]");
                o3++;
            }
        }
        return new int[]{x3, o3};
    }
}
