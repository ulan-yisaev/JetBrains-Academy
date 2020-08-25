import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        char[] text = new char[50];
        int num = reader.read(text);
        reader.close();

        for (int i = num; i >= 0; i--) {
            if (Character.isLetterOrDigit(text[i])) System.out.print(text[i]);
        }
    }
}