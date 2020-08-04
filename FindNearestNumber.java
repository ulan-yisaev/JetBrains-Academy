package library.avenir.test.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list1 = readArrayList(scanner);
        ArrayList<Integer> result = new ArrayList<>();
        int num = scanner.nextInt();

        int minDiff = Math.abs(list1.get(0) - num);

        for (int i = 1; i < list1.size(); i++) {
            minDiff = Math.min(minDiff, Math.abs(list1.get(i) - num));
        }

        for (int i = 0; i < list1.size(); i++) {
            if (Math.abs(list1.get(i) - num) == minDiff) {
                result.add(list1.get(i));
            }
        }
//        System.out.println("result: " + result);
        result
                .stream()
                .sorted()
                .forEach(x -> System.out.print(x + " "));
    }

    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}

/*https://hyperskill.org/learn/step/3794
ArrayList → Find the nearest number
Failure rate is 83%
Hard

5 minutes
535 users solved this problem. Latest completion was about 5 hours ago.
Code Challenge — Write a program
Write a program that finds out the closest integer to a given one from an array. If you find several integers with the same distance to the N, you should output all of them in the ascending order. If the are several equal numbers, output them all.

Input: a set of integers and a number N.

Output: some number(s) from the given array.

Sample Input 1:

1 2 4 5
3
Sample Output 1:

2 4
Sample Input 2:

1 2 3 4
6
Sample Output 2:

4
Sample Input 3:

5 1 3 3 1 5
4
Sample Output 3:

3 3 5 5
*/


/*
Reference solution β
These solutions are generated semi-automatically and may sometimes look too complicated or even bizarre. Please use it as a source of inspiration, not as a best possible solution for this problem. We are still improving the generation algorithm.

import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        String[] items = scanner.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();
 
        for (String item : items) {
            numbers.add(Integer.parseInt(item));
        }
 
        int n = scanner.nextInt();
        ArrayList<Integer> result = new ArrayList<>();
 
        int delta = Integer.MAX_VALUE;
        for (int i : numbers) {
            if (Math.abs(i - n) < delta) {
                delta = Math.abs(i - n);
                result.clear();
                result.add(i);
            } else if (Math.abs(i - n) == delta) {
                result.add(i);
            }
        }
 
        Collections.sort(result);
        
        for (int item : result) {
            System.out.print(item + " ");
        }
    }
}
*/