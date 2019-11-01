/*Given three natural numbers A, B, C. Determine if a triangle with these sides can exist.
If the triangle exists - output the YES string, otherwise - output NO.
Note, a triangle is formed by three connected points that are not located on a single straight line.*/
/*Чтобы проверить, могут ли заданные три отрезка a, b и c образовать треугольник, 
достаточно проверить будет ли самый длинный отрезок меньше суммы длин двух других отрезков.*/
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (a + b > c && a + c > b && b + c > a) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
    }
}

// Мой рабочий пример, но сайт его не принял:();

/*import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[3];

        for (int i = 0; i < arr.length; i++) {
        	arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);

        if (arr[0] > 0 && arr[arr.length-1] <= arr[0] + arr[arr.length-2]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
    }
}*/