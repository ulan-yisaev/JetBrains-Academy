package blockchain.block;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

public class Blockchain extends ArrayList<Block> implements Serializable {

    static final long serialVersionUID = 1L;

    private Blockchain chain;
    private Integer lastBlockId;
    private int zerosCnt;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setLastBlockId(Integer lastBlockId) {
        this.lastBlockId = lastBlockId;
    }

    public Optional<Integer> getLastBlockId() {

        return Optional.ofNullable(lastBlockId);
    }

    public int getZerosCnt() {
        return zerosCnt;
    }

    public synchronized void setZerosCnt(int zerosCnt) {
        this.zerosCnt = zerosCnt;
    }
}
