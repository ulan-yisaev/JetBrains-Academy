import java.util.Scanner;
/*Write a program that reads three integer numbers and prints true if the first number is between the second and the third one (inclusive). Otherwise, it must print false.
The sorting order of two last arguments can be any.*/
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int h1 = scanner.nextInt();
        int h2 = scanner.nextInt();
        int h3 = scanner.nextInt();
        
        System.out.println((h1 >= h2 && h1 <= h3) || (h1 >= h3 && h1 <= h2)) ;
        
    }
}