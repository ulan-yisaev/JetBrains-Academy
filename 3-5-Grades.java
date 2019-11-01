/*3-5 Grades 
Find the number of "Ds", "Cs", "Bs" and "As" for the last test on informatics in a class consisting of n
students. The program gets number n as input, and then gets the grades themselves (one by one). The program should
output four numbers in a single line - the number of "D", the number of "C", the number of "B" and the number of "A"
grades.*/
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//Reference solution
		int n = scanner.nextInt();
        int[] grades = new int[4];
 
        for (int i = 0; i < n; i++) {
            grades[scanner.nextInt() - 2]++;	//Круто!!!
        }
 
        for (int i = 0; i < grades.length; i++) {
            System.out.print(grades[i] + " ");
        }
    }
    /*------------My solution:--------------
		int aGrade, bGrade, cGrade, dGrade;
		aGrade = bGrade = cGrade = dGrade = 0;

		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int score = scanner.nextInt();
			if (score == 2) {
				dGrade += 1;
			} else if (score == 3) {
				cGrade += 1;
			} else if (score == 4) {
				bGrade += 1;
			} else if (score == 5) {
				aGrade += 1;
			}
		}

		System.out.print(dGrade + " " + cGrade + " " + bGrade + " " + aGrade);
	}*/
}