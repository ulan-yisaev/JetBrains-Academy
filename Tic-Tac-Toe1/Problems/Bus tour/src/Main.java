import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int heightOfBus = sc.nextInt();
        int numOfBridges = sc.nextInt();
        boolean willCrash = false;
        int[] heightsOfBridges = new int[numOfBridges];

        for (int i = 0; i < numOfBridges; i++) {
            heightsOfBridges[i] = sc.nextInt();
            if (heightsOfBridges[i] <= heightOfBus) {
                System.out.println("Will crash on bridge " + (i + 1));
                willCrash = true;
                break;
            } else {
                continue;
            }
        }

        if (!willCrash) {
            System.out.println("Will not crash");
        }
    }
}