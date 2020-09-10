import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        if (getI(s.charAt(0)) + getI(s.charAt(1)) + getI(s.charAt(2))
                == getI(s.charAt(3)) + getI(s.charAt(4)) + getI(s.charAt(5))) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }

    private static int getI(char c) {
        return Character.getNumericValue(c);
    }
}