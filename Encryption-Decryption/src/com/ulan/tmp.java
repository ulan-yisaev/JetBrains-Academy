package com.ulan;

public class tmp {
    public static void main(String[] args) {
        for (int i = 97; i < 123; i++) {
            System.out.println(i + " % 97 = " + (i % 97) + " | "  + (i - 96 + 26) + " % 26 = " + (i - 96 + 26) % 26);
        }
    }
}
