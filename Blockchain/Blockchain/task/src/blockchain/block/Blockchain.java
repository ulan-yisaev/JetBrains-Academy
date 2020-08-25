package blockchain.block;

import blockchain.util.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Blockchain implements Serializable {

    static final long serialVersionUID = 1L;

    private static final String fileName = "blockchain.dat";
    private final List<Block> chain;
    private int lastBlockId;

//    private static List<Block> chain;

    private Blockchain() {
        chain = new ArrayList<>();
    }

    public static Blockchain initBlockchain() {
        try {
            return SerializationUtils.deserialize(fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Can't deserialize blockchain from the disk!\n");
            e.printStackTrace();
        }
        return new Blockchain();
    }

    public List<Block> generate(int id, String data, int zerosCnt) {
        String prevHash = chain.isEmpty() ? "0" : chain.get(id - 2).getHash();
        Block block = new Block(id, prevHash, data, zerosCnt);
        chain.add(block);
        this.lastBlockId = block.getId();
        saveBlockchain();
        return chain;
    }

    private void saveBlockchain() {
        try {
            // The default serialization mechanism for an object writes the class of the object, the class signature,
            // and the values of all non-transient and NON-STATIC fields.
            SerializationUtils.serialize(this, fileName);
        } catch (IOException e) {
            System.out.println("Can't serialize this blockchain!\n");
            e.printStackTrace();
        }
    }

   /* public Block get(int index) {
        Objects.checkIndex(index, chain.size());
        return chain.get(index);
    }*/

    public boolean isChainValid(int zerosCnt) {
        Block currBlock;
        Block prevBlock;
        String nZeros = new String(new char[zerosCnt]).replace('\0', '0');

        //The validation function should validate all the blocks of this blockchain.
        for (int i = 1; i < chain.size(); i++) {

            currBlock = chain.get(i);
            prevBlock = chain.get(i - 1);

//            System.out.println("currBlock Id and currBlock.getHash().substring(0, zerosCnt): " + currBlock.getId() + " | " + currBlock.getHash().substring(0, zerosCnt));

            if (prevBlock.getId() + 1 != currBlock.getId()) {
                System.out.println("Invalid index!");
                return false;
            } else if (!prevBlock.getHash().equals(currBlock.getPrevHash())) {
                System.out.println("Previous Hashes are not equal!");
                return false;
            } else if (!currBlock.calculateHash().equals(currBlock.getHash())) {
                System.out.println("Hashes are not equal: \n"
                        + currBlock.calculateHash() + "\n"
                        + currBlock.getHash());
                return false;
            } else if (!currBlock.getHash().substring(0, zerosCnt).equals(nZeros)) {
                System.out.printf("The block #%d has not been mined: \n%s",
                        currBlock.getId(),
                        currBlock.getHash());
                return false;
            }
        }
        return true;
    }

    public void outputChain(int idx, int n) {
        for (int i = idx; i < idx + n; i++) {
            System.out.println(chain.get(i).toString() + "\n");
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getLastBlockId() {
        return lastBlockId;
    }
}
