package blockchain;

import blockchain.block.Block;
import blockchain.block.Blockchain;
import blockchain.util.ChainUtils;

import java.util.concurrent.Callable;

public class Miner implements Callable<Block> {

    int minerId;
    Blockchain blockchain;

    public Miner(int minerId, Blockchain blockchain) {
        this.minerId = minerId;
        this.blockchain = blockchain;
    }

    @Override
    public Block call() throws Exception {

        int lastBlockId = blockchain.getLastBlockId().orElse(0);

        return ChainUtils.generate(blockchain, lastBlockId + 1, Thread.currentThread().getName(), minerId);
    }

    /*@Override
    public void run() {
        int lastBlockId = blockchain.getLastBlockId().orElse(0);
//        System.out.println("blockchain.getLastBlockId(): " + lastBlockId + "\n");
        blockchain.generate(lastBlockId + 1,
                "from thread: " + Thread.currentThread().getName(),
                minerId);
    }*/

    public int getMinerId() {
        return minerId;
    }

    public void setMinerId(int minerId) {
        this.minerId = minerId;
    }

    public Blockchain getBlockchain() {
        return blockchain;
    }

    public void setBlockchain(Blockchain blockchain) {
        this.blockchain = blockchain;
    }
}
