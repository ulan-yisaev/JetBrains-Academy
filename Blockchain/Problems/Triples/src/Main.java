import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] array = new int[size];
        int cnt = 0;

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 1; i < size - 1; i++) {
            if ((array[i + 1] - array[i] == 1) && (array[i] - array[i - 1] == 1)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}