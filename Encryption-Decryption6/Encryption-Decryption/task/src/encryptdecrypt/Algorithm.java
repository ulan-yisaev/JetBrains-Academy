package encryptdecrypt;

public abstract class Algorithm {
    private String mode;

//    Algorithm(String mode) {
//        this.mode = mode;
//    }

    public String getMode() {
        return mode;
    }

    abstract String getEncryption(String data, int key);

    abstract String getDecryption(String data, int key);
}
