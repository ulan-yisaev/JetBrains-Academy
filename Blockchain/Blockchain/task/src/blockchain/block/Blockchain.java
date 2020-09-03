package blockchain.block;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

public class Blockchain extends ArrayList<Block> implements Serializable {

    static final long serialVersionUID = 1L;

    private Blockchain chain;
    private Integer lastBlockId;
    private int zerosCnt;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Optional<Integer> getLastBlockId() {

        return Optional.ofNullable(lastBlockId);
    }

    public void setLastBlockId(Integer lastBlockId) {
        this.lastBlockId = lastBlockId;
    }

    public int getZerosCnt() {
        return zerosCnt;
    }

    public synchronized void setZerosCnt(int zerosCnt) {
        this.zerosCnt = zerosCnt;
    }
}
