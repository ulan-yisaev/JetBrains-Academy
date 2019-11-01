/*3-5, Arithmetic average 
Write a program that reads two numbers aa and bb from the keyboard and calculates and outputs
to the console the arithmetic average of all numbers from the interval [a; b], which are divisible by 3.
In the example below, the arithmetic average is calculated for the numbers on the interval [-5; 12]. Total
numbers divisible by 3 on this interval 6: -3, 0, 3, 6, 9, 12. Their arithmetic average equals to 4.5

The program input contains intervals, which always contain at least one number, which is divisible by 3.

Sample Input 1:
-5 12 
Sample Output 1:
4.5*/

// ------------- Reference solution β ----------------
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int sum = 0;
        int cnt = 0;
        
        for (int i = a; i <= b; i++) {
            if (i % 3 == 0) {
                sum += i;
                cnt++;
            }
        }
        
        double avg = (double) sum / cnt;
        
        System.out.println(avg);
    }
}
/*import java.util.Scanner;
import java.util.Arrays;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int begin = scanner.nextInt();
		int end = scanner.nextInt();
        int[] arrNumbers = new int[end-begin+1];
        int totalNumbers = 0;
        float arithmeticAvg = 0;
        arrNumbers[0] = begin;

         for (int i = 0; i < arrNumbers.length; i++) {         	
        	 if (arrNumbers[i] % 3 == 0) {
        		totalNumbers++;
        		arithmeticAvg = arithmeticAvg + arrNumbers[i];
        		// 
        		if (i < arrNumbers.length - 1) {arrNumbers[i+1] = arrNumbers[i] + 1;}
        			else {}
        	} else {
        		if (i < arrNumbers.length - 1) {arrNumbers[i+1] = arrNumbers[i] + 1;}
        			else {}; 
        	}
        	
        }
        String arrayAsString = Arrays.toString(arrNumbers);
		System.out.println(arrayAsString);

        System.out.println("totalNumbers = " + totalNumbers + " | arithmeticAvg = " + arithmeticAvg / totalNumbers);
 
    }
*/    