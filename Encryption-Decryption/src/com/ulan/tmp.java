package com.ulan;

public class tmp {
    public static void main(String[] args) {
        String operator = args[0];
        int[] arr = new int[args.length-1];

        for (int i = 0; i < args.length-1; i++) {
            arr[i] = Integer.parseInt(args[i+1]);
        }
        switch (operator) {
            case "MAX":
                System.out.println(findMax(arr));
                break;
            case "MIN":
                System.out.println(findMin(arr));
                break;
            case "SUM":
                System.out.println(findSum(arr));
                break;
        }
    }

    static int findMax(int[] array) {
        int m = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > m) m = array[i];
        }
        return m;
    }

    static int findMin(int[] array) {
        int m = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < m) m = array[i];
        }
        return m;
    }

    static int findSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}

/*
Reference solution β

class Problem {
    public static void main(String[] args) {
        int result = -1;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("test")) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
 */