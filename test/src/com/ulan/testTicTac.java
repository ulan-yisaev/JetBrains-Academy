package com.ulan;

import java.util.Scanner;

public class testTicTac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter your input, which can contain only 'X', 'O' and '_' symbols:");
        String str = scanner.nextLine().toUpperCase();

        char[] chArr = str.toCharArray();
        char[][] m = new char[3][3];
        int k = 0, x = 0, o = 0, empty = 0, x3 = 0, o3 = 0;
        String message = "";

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m[i][j] = chArr[k];
                k++;
            }
        }

        if (str.matches("^[ X_O]+$")) {
            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(m[i][j] + ":[");
                    System.out.print(i + "," + j + "] ");
                    switch (m[i][j]) {
                        case 'X':
                            x++;
                            break;
                        case 'O':
                            o++;
                            break;
                        case ' ':
                        case '_':
                            empty++;
                            break;
                        // no default really required here
                    }
                }
                System.out.println("|");
            }
            System.out.println("---------");
            System.out.println("X = " + x + " | O = " + o + " | empty = " + empty);
        } else {
            System.out.println("Possible characters are 'X', 'O', '_' and whitespace ' '");
        }

        System.out.println();

        int column = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = column; j < 3; j++) {
                //m = minus, p = plus
                int im = (i + 3 - 1) % 3;
                int jm = (j + 3 - 1) % 3;
                int ip = (i + 3 + 1) % 3;
                int jp = (j + 3 + 1) % 3;
                // first, compare rows (=i)
                if (m[i][j] == m[i][jm] && m[i][j] == m[i][jp]) { //if (0,0 == 0,2 && 0,0 == 0,1)
                    if (m[i][j] == 'X') {
                        System.out.println("rows_X: m[" + i + "," + j + "] == m[" + i + "," + jm + "] && m[" + i + "," + j + "] ==" + " m[" + i + "," + jp + "]");
                        x3++;
                    } else if (m[i][j] == 'O') {
                        System.out.println("rows_O: m[" + i + "," + j + "] == m[" + i + "," + jm + "] && m[" + i + "," + j + "] ==" + " m[" + i + "," + jp + "]");
                        o3++;
                    }
                    System.out.println("i = " + i + " | j = " + j );
                    break;
                  // then, compare columns (=j)
                } else if (m[i][j] == m[im][j] && m[i][j] == m[ip][j]) { //if (0,0 == 2,0 && 0,0 == 1,0)
                    if (m[i][j] == 'X') {
                        System.out.println("cols_X: m[" + i + "," + j + "] == m[" + im + "," + j + "] && m[" + i + "," + j + "] ==" + " m[" + ip + "," + j + "]");
                        x3++;
                        column++;
                    } else if (m[i][j] == 'O') {
                        System.out.println("cols_O: m[" + i + "," + j + "] == m[" + im + "," + j + "] && m[" + i + "," + j + "] ==" + " m[" + ip + "," + j + "]");
                        o3++;
                        column++;
                    }
                    System.out.println("i = " + i + " | j = " + j );
                    break;
                }
            }
        }

//        System.out.println("x3 = " + x3 + " | o3 = " + o3);
//        System.out.println(message);
    }
}
