import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] m = {400, 540, 120, 9, 550};
        boolean machineOn;

        CoffeeMachineSimulator coffeeMachine = new CoffeeMachineSimulator(m);
        do {
            if (coffeeMachine.stateOfMachine.name().equals("MENU")) {
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
            }
            machineOn = coffeeMachine.takeInput(sc.nextLine());
//        } while (machineOn);
        } while (!coffeeMachine.stateOfMachine.name().equals("OFF"));
    }
}

class CoffeeMachineSimulator {
    private int[] m;
    StateOfMachine stateOfMachine;
    private int i;

    CoffeeMachineSimulator(int[] m) {
        this.m = m;
        stateOfMachine = StateOfMachine.MENU;
    }

    public enum StateOfMachine {
        MENU, BUYCOFFEE, FILL, OFF;
    }

    boolean takeInput(String action) {
        switch (stateOfMachine) {
            case MENU:
                switch (action) {
                    case "buy":
                        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                        stateOfMachine = StateOfMachine.BUYCOFFEE;
//                        return;
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
//                        return;
                    case "exit":
                        stateOfMachine = StateOfMachine.OFF;
                        return false;
                }
                break;  //ppz, zabyl etot break i poteryal huevu tuchu vremeni!!!
            case BUYCOFFEE:
                buyCoffee(m, action);
                break;
            case FILL:
                fillSupplies(m, action, i);
                if (i == 3) i = 0;
                else i++;
                break;
        }
        System.out.println();
        return true;
    }

    private void printState(int[] m) {
        System.out.println("The coffee machine has:");
        System.out.println(m[0] + " of water");
        System.out.println(m[1] + " of milk");
        System.out.println(m[2] + " of coffee beans");
        System.out.println(m[3] + " of disposable cups");
        System.out.println(m[4] + " of money");
    }

    private void calcPrintResources(int[] m, int water, int milk, int beans, int cups, int usd) {
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

    private String checkIngredients(int[] m, int water, int milk, int beans, int cups) {
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

    private void buyCoffee(int[] m, String action) throws IllegalStateException {

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
            default:
                throw new IllegalStateException(action + " <- Unexpected value in the buyCoffee method");
        }
        stateOfMachine = StateOfMachine.MENU;
    }

    private void fillSupplies(int[] m, String action, int i) {
        switch (i) {
            case 0:
                m[0] += Integer.parseInt(action);
                System.out.println("Write how many ml of milk do you want to add:");
                break;
            case 1:
                m[1] += Integer.parseInt(action);
                System.out.println("Write how many grams of coffee beans do you want to add:");
                break;
            case 2:
                m[2] += Integer.parseInt(action);
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                break;
            case 3:
                m[3] += Integer.parseInt(action);
                printState(m);
                stateOfMachine = StateOfMachine.MENU;
                break;
        }
    }

    private void takeMoney(int[] m) {
        System.out.println("I gave you $" + m[4]);
        m[4] = 0;
    }
}

/*
Reference solution β
public class CoffeeMachine {

    public static void printAmount(int water, int milk, int beans, int cups, int money){
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action;

        int water = 1200;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;

        printAmount(water, milk, beans, cups, money);

        System.out.println("Write action (buy, fill, take): ");
        action = scanner.next();

        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino");
                int buyOption = scanner.nextInt();

                switch (buyOption){
                    case 1: // espresso
                        water -= 250;
                        beans -= 16;
                        cups --;
                        money += 4;
                        break;
                    case 2: // latte
                        water -= 350;
                        milk -= 75;
                        beans -= 20;
                        cups --;
                        money += 7;
                        break;
                    case 3: // cappuccino
                        water -= 200;
                        milk -= 100;
                        beans -= 12;
                        cups --;
                        money += 6;
                        break;
                    default:
                        break;
                }
                break;
            case "fill":
                System.out.println("Write how many ml of water do you want to add: ");
                water += scanner.nextInt();
                System.out.println("Write how many ml of milk do you want to add: ");
                milk += scanner.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                beans += scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add: ");
                cups += scanner.nextInt();
                break;
            case "take":
                System.out.println("I gave you $" + money);
                money = 0;
                break;
            default:
                break;
        }
        printAmount(water, milk, beans, cups, money);
    }
}
 */