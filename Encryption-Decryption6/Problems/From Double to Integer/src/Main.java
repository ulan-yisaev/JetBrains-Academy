import java.util.*;

public class Main {

    public static int convert(Double val) {
        int res;
        if (val.isNaN()) res = 0;
        else if (val.isInfinite()) res = Integer.MAX_VALUE;
        else if (val.equals(Double.NEGATIVE_INFINITY)) res = Integer.MIN_VALUE;
        res = val.intValue();
        return res;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double doubleVal = new Double(scanner.nextDouble() / scanner.nextDouble());
        System.out.println(convert(doubleVal));
    }
}