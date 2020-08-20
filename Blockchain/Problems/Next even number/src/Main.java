import java.util.function.LongUnaryOperator;

class Operator {

    public static LongUnaryOperator unaryOperator = (long x) ->
            x % 2 == 0 ? x + 2 : x + 1;
}

/*
Next even number Open on JetBrains Academy

Write a lambda expression that accepts a long value and returns a next even number.
It is guaranteed an input number is non-negative.

Solution format. Submit your lambda expression in any valid format with ; on the end.

Examples: x -> x; (x) -> x; (x) -> { return x; };

Sample Input:
2
Sample Output:
4

Sample Input:
317
Sample Output:
318
 */