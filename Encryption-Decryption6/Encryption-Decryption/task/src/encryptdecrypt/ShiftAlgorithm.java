package encryptdecrypt;

public class ShiftAlgorithm extends Algorithm {
//    ShiftAlgorithm(String name) {
//        super(name);
//    }

    @Override
    String getEncryption(String data, int key) {
        String a = "";
        int size = 26;
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if (Character.isLetter(ch)) {
                char t = (char) (ch + key);
                if ((Character.isLowerCase(ch) && t > 'z') || (Character.isUpperCase(ch) && t > 'Z')) {
                    t -= size;
                }
                if ((Character.isLowerCase(ch) && t < 'a') || (Character.isUpperCase(ch) && t < 'A')) {
                    t += size;
                }
                a = a + t;
            } else {
                a = a + ch;
            }
        }
        return a;
    }

    @Override
    String getDecryption(String data, int key) {
        return getEncryption(data, -key);
    }
}