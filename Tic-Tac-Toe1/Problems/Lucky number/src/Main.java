import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String stringNumber = sc.nextLine();
        int length = stringNumber.length();
        long leftNum = Long.parseLong(stringNumber.substring(0, length/2));
        long rightNum = Long.parseLong(stringNumber.substring(length/2, length));
//        System.out.println(leftNum + " :leftNum | rightNum: " + rightNum);
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < length / 2; i++) {
            long leftLastDigit = leftNum % 10;
            long rightLastDigit = rightNum % 10;
            leftSum = leftSum + (int) leftLastDigit;
            rightSum = rightSum + (int) rightLastDigit;
            leftNum = leftNum / 10;
            rightNum = rightNum / 10;
        }
//        System.out.println(leftSum + " :l|r: " + rightSum);

        if (leftSum == rightSum) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}