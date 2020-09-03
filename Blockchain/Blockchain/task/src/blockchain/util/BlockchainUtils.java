package blockchain.util;

import blockchain.block.Block;
import blockchain.block.Blockchain;

import java.io.IOException;

public class BlockchainUtils {
    private static final String fileName = "blockchain.dat";
    private static Blockchain chain;

    public static Blockchain initBlockchain() {
        try {
            chain = SerializationUtils.deserialize(fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Can't deserialize blockchain from the disk!\n so chain = new Blockchain();");
//            e.printStackTrace();
            chain = new Blockchain();
        }
        return chain;
    }

    public static Block generate(Blockchain chain, int id, String data, int minerId) {
//        System.out.println("chain.size(): " + chain.size() + "| chain.isEmpty()? : " + chain.isEmpty());
        String prevHash = chain.isEmpty() ? "0" : chain.get(id - 2).getHash();

        return new Block(id, prevHash, data, minerId, chain.getZerosCnt());

/*        if (savedId != generatedBlock.getId()) {  //if the block was already mined by another thread
            System.out.printf("%n ----void generate----from minerId: %d | -- if (savedId(%d) != " +
                    "generatedBlock.getId(%d)) %n", minerId, savedId, generatedBlock.getId());
        } else {
            System.out.printf("%n ----void generate----from minerId: %d | -- generatedBlock.getId(%d) = id(%d) %n",
                    minerId, generatedBlock.getId(), id);
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

    public static void outputChain(Blockchain chain, int idx, int n) {
        for (int i = idx; i < idx + n; i++) {
            System.out.println(chain.get(i).toString() + "\n");
        }
    }
}
