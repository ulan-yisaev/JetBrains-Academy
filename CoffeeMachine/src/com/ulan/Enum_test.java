package com.ulan;

import java.util.Arrays;

public class Enum_test {

    enum DangerLevel {
        HIGH (3),
        MEDIUM (2),
        LOW (1);

        private int i;

        DangerLevel(int i) {
            this.i = i;
        }

        public int getLevel() {
            return i;
        }
    }

    public enum StateOfMachine {
        CHOOSACT ("choosing an action"),
        CHOOSCOF ("choosing a variant of coffee"),
        FILL ("filling up the ingredients");

        private String title;

        StateOfMachine(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DangerLevel high = DangerLevel.HIGH;
        DangerLevel medium = DangerLevel.MEDIUM;

        /* System.out.println(high.getLevel() > medium.getLevel()); // true
        System.out.println(high.getLevel());
        System.out.println(Arrays.toString(DangerLevel.values())); */
        StateOfMachine currState = StateOfMachine.CHOOSACT;
        System.out.println(currState);
        System.out.println(currState.getTitle());
        //Iterating over Enum Values:
        /*int ordIndex;
        for (DangerLevel dl : DangerLevel.values()) {
            System.out.print(dl.ordinal());
            ordIndex = dl.ordinal();
            System.out.println(" | Get Enum By Ordinal: " + DangerLevel.values()[ordIndex]);
            System.out.println(dl.name());
        } */

    }
}

class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        if (minutes + 1 == 60) {
            minutes = 0;
            if (hours + 1 == 13) {
                hours = 1;
            } else this.hours++;
        } else this.minutes++;
    }
}

class Circle {

    double radius;

    double getLength() {
        return 2 * Math.PI * radius;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }
}