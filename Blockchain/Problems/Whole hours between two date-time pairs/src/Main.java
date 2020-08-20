import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LocalDateTime dt1 = LocalDateTime.parse(sc.nextLine());
        LocalDateTime dt2 = LocalDateTime.parse(sc.nextLine());
        dt1.

        System.out.println(dt1.until(dt2, ChronoUnit.HOURS));
    }
}