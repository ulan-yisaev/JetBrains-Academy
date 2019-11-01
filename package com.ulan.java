package com.ulan;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       /* int numbers[] = { 1, 2, 3, 4, 5 };
        Arrays.fill(numbers, 1, 4, 10);
        System.out.println(Arrays.toString(numbers));*/
        /*int[] numbers; // initialize the array
        numbers = new int[]{12, 17, 8, 101, 33};
        System.out.println(Arrays.toString(numbers));*/
/*        char[] characters = new char[]{'a', 'z', 'e', 'd'};
        System.out.println(Arrays.toString(characters));*/

/*        long[] longNumbers = {100000000001L, 100000000002L, 100000000003L};
        System.out.println(Arrays.toString(longNumbers));*/

//        String s = scanner.nextLine();

/*        int x1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int x4 = scanner.nextInt();

        System.out.println(--x1 + " " + x1-- + " " + x1-- + " " + --x1);*/
        /*int n = 0;
        System.out.print(++n);
        System.out.print(n++);
        System.out.print(n++);*/

        /*char c = 'A';
        System.out.println(Character.isLetterOrDigit(c));
        System.out.println(Character.isLetter(c));
        System.out.println(Character.isDigit(c));
        System.out.println(Character.isLowerCase(c));*/

/*        int z = 'z';
        char mystery = (char) (z - 10);
        System.out.println(mystery);*/

/*        String str = " Inside Main";
        String subs = str.substring(0, 6);
        long n = subs.trim().length();
        System.out.println(n);*/
/*
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(str.endsWith("burg"));
*/
      // -- It's all equals this short form:
//  +++ hypreskill solution:
//      System.out.println(new Scanner(System.in).nextLine().endsWith("burg"));

        /*String str = scanner.nextLine();
        int len = str.length();
        int x1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        if ((x1 >= 0 && x2 >= 0) && (x1 < len && x2 < len) && x1 <= x2)
        {
            System.out.println(str.substring(x1, x2 + 1));
        }
        else { System.out.println("Please attempt again!");}*/
//  +++ hypreskill solution:
//      System.out.println(scanner.next().substring(scanner.nextInt(), scanner.nextInt() + 1));
        System.out.println("Enter your input, which can contain only 'X', 'O' and '_' symbols:");
        Scanner scanner = new Scanner(System.in);
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
