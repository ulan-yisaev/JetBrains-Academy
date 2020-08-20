import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LocalDate date = LocalDate.parse(scanner.nextLine());
        int offset = scanner.nextInt();

        for (LocalDate i = date; i.getYear() == date.getYear(); i = i.plusDays(offset)) {
            System.out.println(i.toString());
        }
    }
}