import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static LocalDateTime merge(LocalDateTime dt1, LocalDateTime dt2) {
        return LocalDateTime.of(Math.max(dt1.getYear(), dt2.getYear()),
                Math.max(dt1.getMonthValue(), dt2.getMonthValue()),
                Math.max(dt1.getDayOfMonth(), dt2.getDayOfMonth()),
                Math.max(dt1.getHour(), dt2.getHour()),
                Math.max(dt1.getMinute(), dt2.getMinute()),
                Math.max(dt1.getSecond(), dt2.getSecond()));
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final LocalDateTime firstDateTime = LocalDateTime.parse(scanner.nextLine());
        final LocalDateTime secondDateTime = LocalDateTime.parse(scanner.nextLine());
        System.out.println(merge(firstDateTime, secondDateTime));
    }
}