package com.ulan;

import java.util.Scanner;

public class ICommandYou {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String dataTxt = s.substring(s.indexOf("\"")+1, s.lastIndexOf("\""));
        String argString = s.substring(0, s.indexOf('"')) + s.substring(s.lastIndexOf('"')+1, s.length());
        String[] arguments = argString.split(" ");
        String whatToDo = "";
        int shift = 0;
        System.out.println("dataTxt: " + dataTxt);
        System.out.println("argString: " + argString);
        int i = 0;

        for (String arg: arguments) {
            System.out.print(i + " | ");
            System.out.print(arg + " | ");
            switch (arg) {
                case "-mode": whatToDo = arguments[i+1]; System.out.println("whatToDo: " + whatToDo);  break;
                case "-key": shift = Integer.parseInt(arguments[i+1]); System.out.println("shift: " + shift);  break;
                default: System.out.println();
            }
            i++;
        }

        if (whatToDo.contains("dec"))
            getDecryption(dataTxt, shift);
        else
            getEncryption(dataTxt, shift);
    }

    private static boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }

    public static void getEncryption(String toEncrypt, int shift) {
        for (char c : toEncrypt.toCharArray()) {
//                if ((int) c + shift < 122)
//                    System.out.print((char) ((int) c + shift));
//                else
            System.out.print((char) (shift + (int) c));
        }
    }

    public static void getDecryption(String toDecrypt, int shift) {
        for (char c : toDecrypt.toCharArray()) {
            System.out.print((char) ((int) c - shift));
        }
    }
}

/*
Reference solution β
These solutions are generated semi-automatically and may sometimes look too complicated or even bizarre. Please use it as a source of inspiration, not as a best possible solution for this problem. We are still improving the generation algorithm.

package encryptdecrypt;

public class Main {

    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";

        for (int i = 0; i < args.length; i += 2) {
            if (args[i].equals("-mode")) {
                mode = args[i+1];

            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i+1]);

            } else if (args[i].equals("-data")) {
                data = args[i+1];
            }
        }

        switch (mode) {
            case "enc":
                getEncryption(data, key);
                break;
            case "dec":
                getDecryption(data, key);
                break;
            default:
                System.out.println("Unknown operation");
                break;
        }
    }

    public static void getDecryption(String data, int key) {
        for (char item : data.toCharArray()) {
            char shiftItem = (char) (item - key);
            System.out.print(shiftItem);
        }
    }

    public static void getEncryption(String data, int key) {
        for (char item : data.toCharArray()) {
            char shiftItem = (char) (item + key);
            System.out.print(shiftItem);
        }
    }
}
 */