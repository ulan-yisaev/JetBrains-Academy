import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        int largestNum = 0;
        do {
            num = sc.nextInt();
            if (num > largestNum) {
                largestNum = num;
            }
        } while (num > 0);
        System.out.println(largestNum);
    }
}