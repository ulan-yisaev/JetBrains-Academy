package library.avenir.test.controller;

import java.util.*;
import java.util.stream.Collectors;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        return Arrays
                .stream(str.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        set.removeIf(e -> e > 10);
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}
/*
Reference:


 */
/*
Java Collections Set
Set  Removing elements

Implement two methods.

The first method should create a set from a string of numbers separated by a space.

The second method should remove all numbers greater than 10 from the given set.

 Report a typo
Sample Input 1:

1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
Sample Output 1:

1 2 3 4 5 6 7 8 9 10
 */