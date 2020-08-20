import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LocalTime time = LocalTime.parse(sc.nextLine());

        System.out.println(time.withSecond(0));
    }
}