import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int len = str.length();
        int x1 = scanner.nextInt();
        int x2 = scanner.nextInt();

        if ((x1 >= 0 && x2 >= 0) && (x1 < len && x2 < len) && x1 <= x2)
        {
            System.out.println(str.substring(x1, x2 + 1));
        }
        else
            {
                System.out.println("Please attempt again!");
            }
    }
}