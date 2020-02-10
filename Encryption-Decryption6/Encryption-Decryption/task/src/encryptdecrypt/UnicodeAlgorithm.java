package encryptdecrypt;

public class UnicodeAlgorithm extends Algorithm {

//    UnicodeAlgorithm(String mode) {
//        super(mode);
//    }

    @Override
    String getEncryption(String data, int key) {
        String a = "";
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            int x = ch;
            x = x + key;
            ch = (char)x;
            a = a + ch;
        }
        return a;
    }

    @Override
    String getDecryption(String data, int key) {
        return getEncryption(data, -key);
    }
}
