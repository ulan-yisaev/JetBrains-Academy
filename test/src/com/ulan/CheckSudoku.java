package com.ulan;
/*
Multi-dimensional array -> Check sudoku
N-size sudoku is a game with a square table of N2 width and height divided into N2 smaller squares of N width and height. In a solved state, each of this smaller squares,
as well as each row and column of a full square, contains all numbers from 1 to N2 without repetition.
Given a number N on the first line and a full sudoku table on the next N2 lines. Every line contains N2 integers.
Your task is to determine whether this sudoku is solved or not. Output "YES" if this sudoku table is solved, otherwise "NO".
N can be from 1 to 10.
 */
import java.util.Scanner;

public class CheckSudoku {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] m = new int[n * n][n * n];

        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n * n; j++) {
                m[i][j] = sc.nextInt();
            }
        }
/*
        // just print to test
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n * n; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
*/
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n * n; j++) {
                // 1st, let's check whether each ROW of a full square contains all numbers from 1 to n*n without repetition:
                for (int jj = 0; jj < n * n; jj++) {
                    if (jj != j && m[i][jj] == m[i][j] || m[i][j] > n*n) {
                        System.out.println("NO");
                        return;
                    }
                }
                // 2nd, let's check whether each COL of a full square contains all numbers from 1 to n*n without repetition:
                for (int ii = 0; ii < n * n; ii++) {
                    if (ii != i && m[ii][j] == m[i][j]) {
                        System.out.println("NO");
                        return;
                    }
                }
                // Finally, let's check whether SMALLER SQUARES contains all numbers from 1 to n*n without repetition:
                for (int ii = (i / n) * n; ii < (i / n) * n + n; ii++) {
                    for (int jj = (j / n) * n; jj < (j / n) * n + n; jj++) {
                        if (!(ii == i && jj == j) && m[ii][jj] == m[i][j]) {
                            System.out.println("NO");
                            return;
                        }
                    }
                }
            }
        }
        // if all checks are false
        System.out.println("YES");
    }
}

/*
30.10.2019:
Failed test #4. Wrong answer
1
2   <-- Nado dobavit proverku na n2
 */

/*
Reference solution β
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int maxNum = n * n;

        int[][] table = new int[maxNum][maxNum];
        boolean solved = true;

        for (int row = 0; row < maxNum; row++) {
            for (int col = 0; col < maxNum; col++) {
                table[row][col] = scanner.nextInt();
            }
        }

        for (int row = 0; row < maxNum; row++) {
            for (int col = 0; col < maxNum; col++) {
                if (table[row][col] <= 0 || table[row][col] > maxNum) {
                    solved = false;
                }

                for (int i = 0; i < maxNum; i++) {
                    if (row != i && table[row][col] == table[i][col]) {
                        solved = false;
                    }

                    if (col != i && table[row][col] == table[row][i]) {
                        solved = false;
                    }
                }

                int startRow = row - (row % n);
                int startCol = col - (col % n);

                for (int r = startRow; r < startRow + n; r++) {
                    for (int c = startCol; c < startCol + n; c++) {
                        if ((row != r || col != c) && table[row][col] == table[r][c]) {
                            solved = false;
                        }
                    }
                }
            }
        }

        System.out.println(solved ? "YES" : "NO");
/*                                ^
This is called the ternary operator. It consists of a boolean expression, followed by ?, followed by an expression, followed by :,
and finally another expression. If the boolean expression before the question mark evaluates to true, the operator returns
the expression after the question mark. Otherwise, it returns the expression after the colon.
   }
}
 */