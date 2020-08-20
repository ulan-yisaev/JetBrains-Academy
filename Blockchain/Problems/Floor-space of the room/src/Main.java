import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double a, b, c, r;

        switch (input) {
            case "triangle":
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                c = scanner.nextDouble();
                CalculateArea.triangle(a, b, c);
                break;
            case "rectangle":
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                CalculateArea.rectangle(a, b);
                break;
            case "circle":
                r = scanner.nextDouble();
                CalculateArea.circle(r);
                break;
        }
    }
}

class CalculateArea {

    static void triangle(double a, double b, double c) {
        double s = (a + b + c) * 0.5;
//        System.out.printf("%.1f", Math.sqrt(s * (s - a) * (s - b) * (s - c)));
        System.out.println(Math.sqrt(s * (s - a) * (s - b) * (s - c)));
    }

    static void rectangle(double a, double b) {
        System.out.printf("%.1f", a * b);
    }

    static void circle(double r) {
//        System.out.printf("%.2f", Math.PI * r * r);
        System.out.println(3.14 * r * r);
    }
}