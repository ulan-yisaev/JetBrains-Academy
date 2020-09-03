import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.println(date.minusDays(10));

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (i % 2 == 0)
        }
    }
}