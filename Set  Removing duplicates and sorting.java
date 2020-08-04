package library.avenir.test.controller;

import java.util.*;


/* Please, do not modify this I/O code */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SortedSet<String> sortedSet = new TreeSet<>();
        int size = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < size; i++) {
            sortedSet.add(scanner.nextLine());
        }

        sortedSet.forEach(System.out::println);

//        Set<String> nameSet = new TreeSet<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));

//        Collection<Integer> numbers = Arrays
//                .stream(scanner.nextLine().split("\\s+"))
//                .map(Integer::parseInt).collect(Collectors.toList());
//
//        Collection<Integer> result = CollectionUtils.pow2(numbers);
//
//        System.out.println(result.stream()
//                .map(Object::toString)
//                .collect(Collectors.joining(" ")));
//    }
    }
}
/*
Reference:
        final Scanner scanner = new Scanner(System.in);
        final int size = Integer.parseInt(scanner.nextLine());

        final Set<String> set = new TreeSet<>();
        for (int i = 0; i < size; i++) {
            set.add(scanner.nextLine());
        }

        for (String s : set) {
            System.out.println(s);
        }
 */
/*
https://hyperskill.org/learn/step/2771
Java Collections Set
Set  Removing duplicates and sorting

Write a program that reads a sequence of strings from the standard input and displays them in a lexicographic order without duplicates.

Try to write your solution using a set.

Input data format
The first line contains the size of a string sequence. Next lines contain strings.

Output data format
A sorted sequence of strings without duplicates. Each string must be in a new line.

Sample Input 1:

6
postgres
sqlite
oracle
mongodb
postgres
mssql
Sample Output 1:

mongodb
mssql
oracle
postgres
sqlite
Sample Input 2:

5
1
2
2
11
20
Sample Output 2:

1
11
2
20
 */