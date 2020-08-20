import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LocalTime time = LocalTime.ofSecondOfDay(sc.nextInt());

        System.out.println(time);
    }
}