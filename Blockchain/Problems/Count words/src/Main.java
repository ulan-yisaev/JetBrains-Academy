import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        String text = reader.readLine().trim();

        if (text.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(text.split("\\s+").length);
        }

        reader.close();
    }
}