package encryptdecrypt;

public class AlgorithmFactory {

    Algorithm createAlgorithm(String alg) {
        switch (alg) {
            case "shift": return new ShiftAlgorithm();
            case "unicode": return new UnicodeAlgorithm();
            default:
                return null;
        }
    }
}
