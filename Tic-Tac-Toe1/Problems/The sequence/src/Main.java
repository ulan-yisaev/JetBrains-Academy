import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = 0;
        boolean stopped = false;

        for (int i = 1; (i <= n) && !stopped; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
                m++;
                if (m == n) {
                    stopped = true;
                    break;
                }
            }
//            System.out.println("|m = " + m);
        }
    }
}