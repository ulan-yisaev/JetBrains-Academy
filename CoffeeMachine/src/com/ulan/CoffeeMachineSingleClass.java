package com.ulan;

import java.util.Scanner;

public class CoffeeMachineSingleClass {

    static StateOfMachine stateOfMachine = StateOfMachine.MENU;
    static int[] m = {400, 540, 120, 9, 550};
    static int i;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String action = "";


//        CoffeeMachineSingleClass coffeeMachine = new CoffeeMachineSingleClass(m);
        System.out.println("beginning state: " + stateOfMachine);
        System.out.println("_1st_Write action (buy, fill, take, remaining, exit): ");

        while (true) {
            action = sc.nextLine();
            takeInput(action);
            System.out.println("current state in while loop: " + stateOfMachine + " | ");
        }
    }

//    public CoffeeMachineSingleClass(int[] m) {
//        this.m = m;
//    }

    public enum StateOfMachine {
        MENU("choosing an action"),
        BUYCOFFEE("choosing a variant of coffee"),
        FILL("filling up the ingredients"),
        OFF("Offline");

        private String title;

        StateOfMachine(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    public static void takeInput(String action) {
        switch (stateOfMachine) {
            case MENU:
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                switch (action) {
                    case "buy":
                        System.out.println();
                        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                        stateOfMachine = StateOfMachine.BUYCOFFEE;
                        System.out.println("current state: " + stateOfMachine);
                        break;
                    case "fill":
                        stateOfMachine = StateOfMachine.FILL;
                        System.out.println("Write how many ml of water do you want to add:");
                        break;
                    case "take":
                        takeMoney(m);
                        break;
                    case "remaining":
                        printState(m);
                        break;
                    case "exit":
                        stateOfMachine = StateOfMachine.OFF;
                        System.out.println("after case stateOfMachine = StateOfMachine.OFF = " + stateOfMachine);
                        break;
                    default:
                        System.out.println("reached default in case MENU:"); break;
                }
            case BUYCOFFEE: buyCoffee(m, action); break;
            case FILL: fillSupplies(m, action, i); if (i == 3) i = 0; else i++; break;
        }
    }

    private static void printState(int[] m) {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(m[0] + " of water");
        System.out.println(m[1] + " of milk");
        System.out.println(m[2] + " of coffee beans");
        System.out.println(m[3] + " of disposable cups");
        System.out.println(m[4] + " of money");
    }

    private static void calcPrintResources(int[] m, int water, int milk, int beans, int cups, int usd) {
        String resourcesAvailability = "";
        resourcesAvailability = checkIngredients(m, water, milk, beans, cups);
        if (resourcesAvailability.equals("I have enough resources, making you a coffee!")) {
            System.out.println(resourcesAvailability);
            m[0] -= water;
            m[1] -= milk;
            m[2] -= beans;
            m[3] -= cups;
            m[4] += usd;
        } else System.out.println(resourcesAvailability);
//            case 3:  ableAmount = Math.min(Math.min(m[0] / water, m[1] / milk), Math.min(m[2] / beans, m[3] - cups));
    }

    private static String checkIngredients(int[] m, int water, int milk, int beans, int cups) {
        if (m[3] - cups < 0) {
            return "Sorry, not enough disposable cups!";
        } else if (m[0] - water < 0) {
            return "Sorry, not enough water!";
        } else if (m[1] - milk < 0) {
            return "Sorry, not enough milk!";
        } else if (m[2] - beans < 0) {
            return "Sorry, not enough beans!";
        }
        return "I have enough resources, making you a coffee!";
    }

    private static void buyCoffee(int[] m, String action) /*throws IllegalStateException*/ {

        switch (action) {
            case "1":     //espresso, needs 250 ml water, 16 g coffee beans. It costs $4.
                calcPrintResources(m, 250, 0, 16, 1, 4);
                break;
            case "2":     //latte, needs 350 ml water, 75 ml milk, 20 g of coffee beans. $7
                calcPrintResources(m, 350, 75, 20, 1, 7);
                break;
            case "3":     //cappuccino, needs 200 ml water, 100 ml milk, 12 g of coffee. $6
                calcPrintResources(m, 200, 100, 12, 1, 6);
                break;
            case "back":
                stateOfMachine = StateOfMachine.MENU;
                return;
            /*default:
                throw new IllegalStateException("Unexpected value: " + action);*/
        }
        stateOfMachine = StateOfMachine.MENU;
        System.out.println();
    }

    private static void fillSupplies(int[] m, String action, int i) {
        switch (i) {
            case 0: m[0] += Integer.parseInt(action); System.out.println("Write how many ml of milk do you want to add:"); break;
            case 1: m[1] += Integer.parseInt(action); System.out.println("Write how many grams of coffee beans do you want to add:"); break;
            case 2: m[2] += Integer.parseInt(action); System.out.println("Write how many disposable cups of coffee do you want to add:"); break;
            case 3: m[3] += Integer.parseInt(action); printState(m); stateOfMachine = StateOfMachine.MENU; break;
        }
    }

    private static void takeMoney(int[] m) {
        System.out.println("I gave you $" + m[4]);
        m[4] = 0;
        System.out.println();
    }
}
