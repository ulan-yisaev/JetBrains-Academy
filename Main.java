package com.ulan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int i = 0;
        while (i < 5) {
            System.out.println(i);
            i++;
        }



 /*       String str = " Inside Main";
        String subs = str.substring(0, 6);
        long n = subs.trim().length();
        System.out.println(n);
/*

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

    }
}
