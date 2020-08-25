import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        boolean order = true;

        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");

        for (int i = 0; i < array.length - 1; i++) {
//            System.out.println(array[i] + ".compareTo(" + array[i + 1] + ") = " + array[i].compareTo(array[i + 1]));
            if (array[i].compareTo(array[i + 1]) > 0) {
                order = false;
                break;
            }
        }

        System.out.println(order);
    }
}