/*https://hyperskill.org/learn/step/3482
Code Challenge — Write a program
Implement a method to concatenate all positive numbers of two input ArrayLists to a single resulting list.

At first, elements from the first ArrayList shoud go, and then the elements from the second ArrayList.

Sample Input 1:

8 11 -2 -3 14 15
-1 33 12 -3 -5
Sample Output 1:

8 11 14 15 33 12
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class ConcatPositiveNumbersProblem {

    public static ArrayList<Integer> concatPositiveNumbers(ArrayList<Integer> l1, ArrayList<Integer> l2) {

        ArrayList<Integer> list = new ArrayList<>();

        for (Integer i: l1) {
            if (i > 0) list.add(i);
        }

        for (Integer i: l2) {
            if (i > 0) list.add(i);
        }

        return list;
    }

    /* Do not modify this method */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list1 = readArrayList(scanner);
        ArrayList<Integer> list2 = readArrayList(scanner);

        ArrayList<Integer> result = concatPositiveNumbers(list1, list2);

        result.forEach((n) -> System.out.print(n + " "));
    }

    /* Do not modify this method */
    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}