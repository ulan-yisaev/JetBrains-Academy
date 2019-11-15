package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int n = 3;
//        char[][] m = readState(n);
        String message = "";
        boolean gameEnd = false;
        char[][] m = new char[3][3];
        int[] colXOEmpty = printState(m);
        char XorO = 'X';
        while (!gameEnd) {
            readRecentMove(m, XorO);
            colXOEmpty = printState(m);
            int threeXinRow = compareRows(n, m)[0] + compareCols(n, m)[0] + compareDiagonals(n, m)[0];
            int threeOinRow = compareRows(n, m)[1] + compareCols(n, m)[1] + compareDiagonals(n, m)[1];
//        System.out.println("threeXinRow = " + threeXinRow + " | threeOinRow = " + threeOinRow + " | emptyCells = " + colXOEmpty[2]);
            if (threeXinRow > 0 || threeOinRow > 0 ) { //|| Math.abs(colXOEmpty[0] - colXOEmpty[1]) >= 2
                if (threeXinRow == threeOinRow) {
                    System.out.println("Impossible"); gameEnd = true;
                } else if (threeXinRow > 0) {
                    System.out.println("X wins"); gameEnd = true;
                } else if (threeOinRow > 0) {
                    System.out.println("O wins"); gameEnd = true;
                }
            } else if (threeXinRow == 0 && threeOinRow == 0 && colXOEmpty[2] == 0) {
                System.out.println("Draw"); gameEnd = true;
            } else if (threeXinRow == 0 && threeOinRow == 0 && colXOEmpty[2] > 0) {
//                System.out.println("Game not finished");
            }
            if (XorO == 'X') {
                XorO = 'O';
            } else XorO = 'X';
        }

/*
        System.out.println("printState(m)) {x, o, empty}: " + Arrays.toString(colXOEmpty));
        System.out.println("compare Rows, Cols & Diagonals ([X, O]):");
        System.out.println(Arrays.toString(compareRows(n, m)));
        System.out.println(Arrays.toString(compareCols(n, m)));
        System.out.println(Arrays.toString(compareDiagonals(n, m)));
*/


    }

/*    private static char[][] readState(int n) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toUpperCase();
        int k = 0;
        char[] chArr = str.toCharArray();
        char[][] m = new char[n][n];

        if (str.matches("^[ X_O]+$")) {
            for (int j = 2; j >= 0; j--) {
                for (int i = 0; i < 3; i++) {
                    m[i][j] = chArr[k];
                    k++;
                }
            }
        } else System.out.println("Possible characters are 'X', 'O', '_' and whitespace ' '");
        return m;
    }*/

    private static char[][] readRecentMove(char[][] m, char XorO) {
        Scanner scanner = new Scanner(System.in);

        int i = 0, j = 0;
        System.out.print("Enter the coordinates: ");

        while (scanner.hasNext()) {
            scanner.useDelimiter("\\R");

            if (!scanner.hasNext("\\d+ \\d+")) {
                String line = scanner.nextLine();   //
                System.out.println("You should enter numbers! --test: " + line);
                System.out.print("Enter the coordinates: ");
                continue;
            } else {
                scanner.useDelimiter("\\s+");       //
                i = scanner.nextInt();
                j = scanner.nextInt();
                if (i < 1 || j < 1 || i > 3 || j > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.print("Enter the coordinates: ");
                    continue;
                }
            }

            if (m[i - 1][j - 1] != 0) { //|| m[i-1][j-1] != ' '
                System.out.println("This cell is occupied! Choose another one!");
                System.out.print("Enter the coordinates: ");
                continue;
            } else {
                m[i - 1][j - 1] = XorO;
                break;
            }
        }
        return m;
    }

    private static int[] printState(char[][] m) {
        int x = 0, o = 0, empty = 0;
        System.out.println("---------");
        for (int j = 2; j >= 0; j--) {
            System.out.print("| ");
            for (int i = 0; i < 3; i++) {
//                System.out.print(i + "," + j + "] ");
                switch (m[i][j]) {
                    case 'X':
                        x++;
                        break;
                    case 'O':
                        o++;
                        break;
                    case 0:
                    case ' ':
                    case '_':
//                        m[i][j] = ' ';
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
