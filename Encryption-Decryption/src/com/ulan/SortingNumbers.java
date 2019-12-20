package com.ulan;

import java.util.Arrays;
import java.util.Scanner;

public class SortingNumbers {
    public static void sort(int[] numbers) {
        int t;
        for (int i = 1; i < numbers.length; i++) {
            for (int j = i; j > 0; j--) {
                if (numbers[j] < numbers[j - 1]) {
                    t = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = t;
                }
            }
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split("\\s+");
        int[] numbers = Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .toArray();
        sort(numbers);
        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
    }
}
