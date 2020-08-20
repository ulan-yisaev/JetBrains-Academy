package blockchain;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {

    private List<Block> chain;

    public Blockchain() {
        chain = new ArrayList<>();
    }

    public List<Block> generate(int id, String data) {
        String prevHash = chain.isEmpty() ? "0" : chain.get(id - 2).getHash();
        Block block = new Block(id, prevHash, data);
        chain.add(block);
        return chain;
    }

   /* public Block get(int index) {
        Objects.checkIndex(index, chain.size());
        return chain.get(index);
    }*/

    public boolean isChainValid() {
        Block currBlock;
        Block prevBlock;

        //The validation function should validate all the blocks of this blockchain.
        for (int i = 1; i < chain.size(); i++) {

            currBlock = chain.get(i);
            prevBlock = chain.get(i - 1);

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
            }
        }
        return true;
    }

    public void outputChain(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(chain.get(i).toString() + "\n");
        }
    }
}
