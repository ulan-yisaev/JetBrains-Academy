import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDateTime dt = LocalDateTime.parse(sc.nextLine());
        int h = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(dt.minusHours(h).plusMinutes(m));
    }
}