/* https://hyperskill.org/learn/step/3331
Java → Design patterns → Strategy
Java → Max and Min
Code Challenge — Write a program
Use the strategy pattern to implement algorithms to find max and min values in a given array. The basic structure of the provided classes is described below: your job is to complete it.
The class Finder represents the general finding algorithm itself. It works according to the specified strategy.
The interface FindingStrategy provides two methods to write new concrete finding strategies: takeOne to get the next value and getDefaultValue to return a value if nothing was found (the given array is empty). Strategies define only the specific details of the finding algorithm.

Please, do not change the interface FindingStrategy, and do not rename the existing methods.
If the array is empty, the Finder should return Integer.MAX_VALUE in case of finding the min value and Integer.MIN_VALUE in case of finding the max value.
HINT: tests 1-5 check MinFindingStrategy, tests 6-10 check MaxFindingStrategy. Do not forget to check your solution when the passed array has the size 0 or 1.
 */

import java.util.Arrays;
import java.util.Scanner;

class Finder {

    private FindingStrategy strategy;

    public Finder(FindingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * It performs the search algorithm according to the given strategy
     */
    public int find(int[] numbers) {
        int length = numbers.length;
        switch (length) {
            case 0:
                return this.strategy.getDefaultValue();
            case 1:
                return numbers[0];
            default:
                Arrays.sort(numbers);
                return this.strategy.takeOne(numbers[0], numbers[length - 1]);
        }
    }
}

interface FindingStrategy {
    /**
     * Returns one of two values
     */
    int takeOne(int elem1, int elem2);

    /**
     * Returns the default value of a concrete implementation
     */
    int getDefaultValue();
}

class MaxFindingStrategy implements FindingStrategy {

    public int takeOne(int elem1, int elem2) {
        return elem2;
    }

    public int getDefaultValue() {
        return Integer.MIN_VALUE;
    }
}

class MinFindingStrategy implements FindingStrategy {

    public int takeOne(int elem1, int elem2) {
        return elem1;
    }

    public int getDefaultValue() {
        return Integer.MAX_VALUE;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String args[]) {

        final Scanner scanner = new Scanner(System.in);

        final String[] elements = scanner.nextLine().split("\\s+");
        int[] numbers = null;

        if (!elements[0].equals("EMPTY")) {
            numbers = new int[elements.length];
            for (int i = 0; i < elements.length; i++) {
                numbers[i] = Integer.parseInt(elements[i]);
            }
        } else {
            numbers = new int[0];
        }

        final String type = scanner.nextLine();

        Finder finder = null;

        switch (type) {
            case "MIN":
                finder = new Finder(new MinFindingStrategy());
                break;
            case "MAX":
                finder = new Finder(new MaxFindingStrategy());
                break;
            default:
                break;
        }

        if (finder == null) {
            throw new RuntimeException(
                    "Unknown strategy type passed. Please, write to the author of the problem.");
        }

        System.out.println(finder.find(numbers));
    }
}