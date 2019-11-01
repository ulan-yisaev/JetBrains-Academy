package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your input, which can contain only 'X', 'O' and '_' symbols:");
        String str = scanner.next().toUpperCase();
        char[] chArr = str.toCharArray();

        if (str.matches("^[X_O]+$")) {
            System.out.println("---------");
            System.out.println("| " + chArr[0] + " " + chArr[1] + " " + chArr[2] + " |");
            System.out.println("| " + chArr[3] + " " + chArr[4] + " " + chArr[5] + " |");
            System.out.println("| " + chArr[6] + " " + chArr[7] + " " + chArr[8] + " |");
            System.out.println("---------");
        } else {
            System.out.println("Please attempt again!");
        }
    }
}
