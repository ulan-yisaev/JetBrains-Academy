package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter your input, which can contain only 'X', 'O' and '_' symbols:");
        String str = scanner.next().toUpperCase();
        char[] chArr = str.toCharArray();
        scanner.close();

        char[][] chArray = new char[3][3];
        int k = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                chArray[i][j] = chArr[k];
                k++;
            }
        }

        if (str.matches("^[ X_O]+$")) {
            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                System.out.println("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(chArray[i][j] + " ");
                }
                System.out.println(" |");
                System.out.println();
            }
            System.out.println("---------");
        } else {
            System.out.println("Please attempt again!");
        }
    }
}
