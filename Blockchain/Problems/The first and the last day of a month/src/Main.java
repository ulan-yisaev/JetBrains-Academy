import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDate date = LocalDate.of(scanner.nextInt(), scanner.nextInt(), 1);

        System.out.println(date + " " + date.plusMonths(1).minusDays(1));
    }
}