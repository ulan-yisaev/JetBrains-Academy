package com.ulan;
/*3-5 Bus tour
Typical task for a job interview.
A bus tour of Europe has been very successful. Due to an increase in the number of people that want to go on a tour,
the tour company decided to increase the height of the bus. The new height of the bus is exactly N centimeters.
But the tour’s route runs under a lot of bridges, and there is a chance that the bus will crash into one of these bridges.
Can you find out if this will happen?
The first line of the input contains the height of the bus and number of bridges under which the bus passes. The second
line contains heights of these bridges.
You should output "Will not crash" if everything will be all right; otherwise, output "Will crash on bridge i" (where i
is a number of a bridge) into which the bus will crash. If the height of a bridge equals the height of the bus, the bus
 will crash.
 */

import java.util.Scanner;

public class Bustour {
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

/*    Reference solution β
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int height = 0;
        int n = 0;
        int bridge = 0;
        boolean crash = false;

        if (sc.hasNextInt()) {
            height = sc.nextInt();
        }

        if (sc.hasNextInt()) {
            n = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (sc.hasNextInt()) {
                bridge = sc.nextInt();
            }
            if (bridge <= height) {
                i++;
                System.out.print("Will crash on bridge " + i);
                crash = true;
                break;
            }
        }

        if (!crash) {
            System.out.print("Will not crash");
        }
    }
}
 */