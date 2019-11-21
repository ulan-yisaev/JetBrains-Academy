package com.ulan;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class test {

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

    public static void main(String[] args) throws InterruptedException {
        DangerLevel high = DangerLevel.HIGH;
        DangerLevel medium = DangerLevel.MEDIUM;

        System.out.println(high.getLevel() > medium.getLevel()); // true
        System.out.println(high.getLevel());
        System.out.println(Arrays.toString(DangerLevel.values()));

        //Iterating over Enum Values:
        for (DangerLevel dl : DangerLevel.values()) {
            System.out.println(dl.ordinal());
        }

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