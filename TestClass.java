import java.util.Scanner;
import java.util.Arrays;

public class TestClass{
      public static void main(String[] args) throws Exception{
		  Scanner sc = new Scanner(System.in);
		  
            /*int a = Integer.MIN_VALUE;
            int b = Integer.MAX_VALUE;
            System.out.println( a+ "   "+b);*/
			int[] a = new int[] {2, 3, 1};
			
			System.out.println(Arrays.toString(a));
			Arrays.sort(a);
			System.out.println(Arrays.toString(a));
			
			/*for (int i = 0; i < 3; i++) {
            a[i] = sc.nextInt();
			}*/
		
			
      }
}