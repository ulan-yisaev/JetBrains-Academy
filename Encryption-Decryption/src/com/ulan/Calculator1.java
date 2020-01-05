package com.ulan;

import java.util.Date;

public class Calculator1 {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now);
        int c = 0;
        String operator = args[0];
        int a = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        switch (operator) {
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "*":
                c = a * b;
                break;
            default:
                System.out.println("Unknown operator");
                return;
        }
        System.out.println(c);

        int[] nnn = {1, 2, 3, 4, 5};
        int r = callBinarySearch(nnn, 2);
        System.out.println(r);
    }

    public static int callBinarySearch(int[] nums, int key) {
        return java.util.Arrays.binarySearch(nums, key);
    }
}

/*
Command-line arguments → Calculator - 1
Code Challenge — Write a program
Write a program that takes an operator ("+", "-", "*") and two values as the command-line arguments and then outputs the result of the operator in the standard output. If the passed operator is not from the list, it must output the string "Unknown operator" without quotes.

Reference solution β
These solutions are generated semi-automatically and may sometimes look too complicated or even bizarre. Please use it as a source of inspiration, not as a best possible solution for this problem. We are still improving the generation algorithm.

class Problem {

    public static void main(String args[]) {
        int result = 0;
        switch (args[0]) {
            case "+":
                result = Integer.parseInt(args[1]) + Integer.parseInt(args[2]);
                System.out.println(result);
                break;
            case "-":
                result = Integer.parseInt(args[1]) - Integer.parseInt(args[2]);
                System.out.println(result);
                break;
            case "*":
                result = Integer.parseInt(args[1]) * Integer.parseInt(args[2]);
                System.out.println(result);
                break;
            default:
                System.out.println("Unknown operator");
                break;
        }
    }

}
 */