import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] word = scanner.nextLine().toLowerCase().toCharArray();
        final String CONSONANTS = "bcdfghjklmnpqrstvwxz";
        final String VOWELS = "aeiouy";
        int counter = 0;

        for (int i = 0; i < word.length; i++) {
            if (CONSONANTS.indexOf(word[i]) != -1) {
                word[i] = '0';
            } else if (VOWELS.indexOf(word[i]) != -1) {
                word[i] = '1';
            }
        }
// bIi iiig
// b iIi iig
// bi iIi ig
// bii iIi g
// biii iIg

        for (int i = 1; i < word.length - 1; i++) {
            if (word[i - 1] == word[i] && word[i] == word[i + 1]) {
                word[i] = 'X';
                counter++;
            }
        }

        System.out.println(counter);
//        System.out.print(Arrays.toString(word));
    }
}