package blockchain.util;

import blockchain.block.Block;
import blockchain.block.Blockchain;

import java.io.*;
import java.util.List;

public class SerializationUtils {

    public static void serialize(Blockchain obj, String fileName) throws IOException {
        try (   //Multiple resources can be declared in a try-with-resources block by separating them with a semicolon:
                FileOutputStream fos = new FileOutputStream(fileName);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos);
        ) {
            oos.writeObject(obj);
        }
    }

    public static Blockchain deserialize(String fileName) throws IOException, ClassNotFoundException {
        try (
                FileInputStream fis = new FileInputStream(fileName);
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);
        ) {
            //            ois.close();
            return (Blockchain) ois.readObject();
        }
    }
}