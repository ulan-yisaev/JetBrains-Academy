package blockchain.util;

import java.security.MessageDigest;

public class StringUtil {
    /* Applies Sha256 to a string and returns a hash.
    *  A hash function maps input data of arbitrary size to output data of fixed size. */
    public static String applySha256(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            /* Applies sha256 to our input */
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte elem: hash) {
//                String hex = Integer.toHexString(0xff & elem);    see https://rules.sonarsource.com/java/RSPEC-4425
                String hex = String.format("%02X", elem);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}

/*
The hash is quite sensitive to any change in the input data, however small that may be.
Moreover, it's impossible to get the input data back just from its hash.
These properties make the hash function quite useful in cryptography.
 */