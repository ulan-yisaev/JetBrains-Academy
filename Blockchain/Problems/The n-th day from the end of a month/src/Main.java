import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LocalDate date = LocalDate.of(sc.nextInt(), sc.nextInt(), 1);

        int offset = sc.nextInt() - 1;

        LocalDate lastDayofMonth = date.with(TemporalAdjusters.lastDayOfMonth());

        System.out.println(lastDayofMonth.minusDays(offset));
    }
}