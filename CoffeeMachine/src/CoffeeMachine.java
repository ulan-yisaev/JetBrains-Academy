import java.util.Scanner;

public class CoffeeMachine {

    private static void printState(int[] m) {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(m[0] + " of water");
        System.out.println(m[1] + " of milk");
        System.out.println(m[2] + " of coffee beans");
        System.out.println(m[3] + " of disposable cups");
        System.out.println(m[4] + " of money");
        System.out.println();
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

    private static void buyCoffee(int[] m) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String variety = sc.nextLine();
        String resourcesAvailability = "";
        switch (variety) {
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
                return;
        }
        System.out.println();
    }

    private static void fillSupplies(int[] m) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Write how many ml of water do you want to add:");
        m[0] += sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        m[1] += sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        m[2] += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        m[3] += sc.nextInt();
        System.out.println();
        printState(m);
    }

    private static void takeMoney(int[] m) {
        System.out.println("I gave you $" + m[4]);
        m[4] = 0;
        System.out.println();
//        printState(m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String action;
        boolean on = true;

        int[] m = {400, 540, 120, 9, 550};

        while (on) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = sc.nextLine();

            switch (action) {
                case "buy":
                    buyCoffee(m);
                    break;
                case "fill":
                    fillSupplies(m);
                    break;
                case "take":
                    takeMoney(m);
                    break;
                case "remaining":
                    printState(m);
                    break;
                case "exit":
                    on = false;
                    break;
                default:
                    break;
            }
        }
//        System.out.println(Arrays.toString(m));

//        int ableAmount = calcPrintResources(m);
/*        System.out.println("Write how many cups of coffee you will need:");
        int n = sc.nextInt();

        if (ableAmount == n) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (ableAmount > n) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (ableAmount - n) + " more than that)");
        } else {
            System.out.println("No, I can make only " + ableAmount +" cup(s) of coffee");
        }
*/
/*        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!"); */
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