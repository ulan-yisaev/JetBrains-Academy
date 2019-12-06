package com.ulan;

import java.util.Scanner;

public class Main {

    private static boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }

    public static void getEncryption (String toEncrypt, int shift) {
        for (char c : toEncrypt.toCharArray()) {
//                if ((int) c + shift < 122)
//                    System.out.print((char) ((int) c + shift));
//                else
                    System.out.print((char) (shift + (int) c));
        }
    }

    public static void getDecryption (String toDecrypt, int shift) {
        for (char c : toDecrypt.toCharArray()) {
            System.out.print((char)((int)c - shift));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String whatToDo = sc.nextLine();
        String toProcess = sc.nextLine();
        int shift = sc.nextInt();

        if (whatToDo.contains("enc"))
            getEncryption(toProcess, shift);
        else
            getDecryption(toProcess, shift);

/*        String toEncryptTest = "a b c x y z";
        for (char c : toEncryptTest.toCharArray()) {
            System.out.print(c + " - ");
            if (c >= 'a' && c <= 'z') {
                System.out.println((char)((int)c + 25 - ((int)c % 97) * 2));
            } else System.out.println(c);
        }*/
    }
}

/*
Reference solution β
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        char[] chars = scanner.nextLine().toCharArray();
        int shift = scanner.nextInt();
        switch (operation) {
            case "enc":
                getEncryption(chars, shift);
                break;
            case "dec":
                getDecryption(chars, shift);
                break;
            default:
                System.out.println("Unknown operation");
                break;
        }
    }

    public static void getDecryption(char[] chars, int shift) {
        for (char item : chars) {
            char shiftItem = (char) (item - shift);
            System.out.print(shiftItem);

        }
    }

    public static void getEncryption(char[] chars, int shift) {
        for (char item : chars) {
            char shiftItem = (char) (item + shift);
            System.out.print(shiftItem);
        }
    }
}
 */