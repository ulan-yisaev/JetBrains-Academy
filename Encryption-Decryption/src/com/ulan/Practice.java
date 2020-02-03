package com.ulan;

import java.util.Arrays;
import java.util.Scanner;

public class Practice {

    static int[] getFirstAndLast(int[] arr) {
        int[] newarr;
//        if (arr.length == 1) newarr = arr;
        newarr = new int[]{arr[0], arr[arr.length - 1]};
        return newarr;
    }
    /* Do not change code below */
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] result = getFirstAndLast(array);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }
}