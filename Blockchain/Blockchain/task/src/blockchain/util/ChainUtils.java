package blockchain.util;

import blockchain.block.Block;
import blockchain.block.Blockchain;

import java.io.IOException;

public class ChainUtils {
    private static final String fileName = "blockchain.dat";
    private static Blockchain chain;

    public static Blockchain initBlockchain() {
        try {
            chain = SerializationUtils.deserialize(fileName);
        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("Can't deserialize blockchain from the disk!\n so chain = new Blockchain();");
//            e.printStackTrace();
            chain = new Blockchain();
        }
        return chain;
    }

    public static Block generate(Blockchain chain, int id, String data, int minerId) {
        String prevHash = chain.isEmpty() ? "0" : chain.get(id - 2).getHash();

        return new Block(id, prevHash, data, minerId, chain.getZerosCnt());
/*
            lastBlockId = id;
            zerosCnt = generatedBlock.getZerosCnt();
            chain.add(generatedBlock);
            saveBlockchain(id, this);
        }*/
    }

    public static void saveBlockchain(Blockchain chain, Block block) {
        chain.add(block);
        chain.setLastBlockId(block.getId());
        chain.setZerosCnt(block.getZerosCnt());
        try {
            // The default serialization mechanism for an object writes the class of the object, the class signature,
            // and the values of all non-transient and NON-STATIC fields.
            SerializationUtils.serialize(chain, fileName);
        } catch (IOException e) {
            System.out.println("Can't serialize this blockchain!\n");
            e.printStackTrace();
        }
    }

    public static boolean isBlockValid(Blockchain chain, Block newBlock) {

        if (chain.isEmpty()) return true;

        int zerosCnt = chain.getZerosCnt();
        String nZeros = new String(new char[zerosCnt]).replace('\0', '0');

        Block prevBlock = chain.get(chain.getLastBlockId().orElse(1) - 1);

        if (!prevBlock.getHash().equals(newBlock.getPrevHash())) {
            System.out.println("Previous Hashes are not equal!");
            return false;
        } else if (!newBlock.calculateHash().equals(newBlock.getHash())) {
            System.out.println("Hashes are not equal: \n"
                    + newBlock.calculateHash() + "\n"
                    + newBlock.getHash());
            return false;
        } else if (!newBlock.getHash().substring(0, zerosCnt).equals(nZeros)) {
            System.out.printf("The block #%d has not been mined: \n%s",
                    newBlock.getId(),
                    newBlock.getHash());
            return false;
        }
        return true;
    }

    public static boolean isChainValid(Blockchain chain, int zerosCnt) {
        String nZeros = new String(new char[zerosCnt]).replace('\0', '0');

        //The validation function should validate all the blocks of this blockchain.
        for (int i = 1; i < chain.size(); i++) {

            Block currBlock = chain.get(i);
            Block prevBlock = chain.get(i - 1);

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

    public static void outputChain(Blockchain chain, int idx, int n) {
        for (int i = idx; i < idx + n; i++) {
            System.out.println(chain.get(i).toString() + "\n");
        }
    }
}
