package com.ulan;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysAsParameters {

    public static void addValueByIndex(long[] arrLong, int ind, long addVal){
        arrLong[ind] = arrLong[ind] + addVal;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        long[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        int index = scanner.nextInt();
        long value = scanner.nextLong();
        addValueByIndex(array, index, value);
        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
    }
}

/*
Arrays as parameters → Adding values
Code Challenge — Write a program
1044 users solved this problem. Latest completion was about 2 hours ago.
Write a method named addValueByIndex.

The method should take an array of longs and add a value to the specified element by its index.

Here are description of the parameters:

an array of longs;
the index of an element (int);
a value for adding (long).
The method must return nothing.

The following invocation should work correctly:

addValueByIndex(array, index, value);
Where array is an array of longs, index is an integer variable, value is a long value for adding.

Sample Input 1:

1 1 1 1 1
2 100
Sample Output 1:

1 1 101 1 1
 */