import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        if (x1 != x2 && x2 != x3 && x3 != x1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}