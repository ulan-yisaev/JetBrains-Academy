public class Main {
    public static void main(String[] args) {

        int shift = 0;
        int i = 0;
        String whatToDo = "";
        String dataTxt = ""; //s.substring(s.indexOf("\"") + 1, s.lastIndexOf("\""));
//        String argString = s.substring(0, s.indexOf('"')) + s.substring(s.lastIndexOf('"') + 1, s.length());
//        String[] arguments = argString.split(" ");

        for (String arg : args) {
            switch (arg) {
                case "-mode":
                    whatToDo = args[i + 1];
                    break;
                case "-key":
                    shift = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    dataTxt = args[i + 1];
                    break;
                default:
            }
            i++;
        }

        if (whatToDo.contains("dec"))
            getDecryption(dataTxt, shift);
        else
            getEncryption(dataTxt, shift);
    }

    private static boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }

    public static void getEncryption(String toEncrypt, int shift) {
        for (char c : toEncrypt.toCharArray()) {
//                if ((int) c + shift < 122)
//                    System.out.print((char) ((int) c + shift));
//                else
            System.out.print((char) (shift + (int) c));
        }
    }

    public static void getDecryption(String toDecrypt, int shift) {
        for (char c : toDecrypt.toCharArray()) {
            System.out.print((char) ((int) c - shift));
        }
    }
}