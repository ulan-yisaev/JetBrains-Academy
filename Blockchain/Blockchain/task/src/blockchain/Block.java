package blockchain;

import java.util.Date;

public class Block {

    private int id;
    private long timestamp;
    private int nonce;      //an arbitrary number used in cryptography
    private String data;
    private String hash;
    private String prevHash;

// We represent a block by a hash value. Generating the hash value of a block is called “mining” the block.
// Mining a block is typically computationally expensive to do as it serves as the “proof of work”.

    public Block(int id, String prevHash, String data) {
        this.id = id;
        this.prevHash = prevHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        return StringUtil.applySha256(id
                + timestamp
                + prevHash
                + nonce);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPrevHash() {
        return prevHash;
    }

    public void setPrevHash(String prevHash) {
        this.prevHash = prevHash;
    }

    @Override
    public String toString() {
        return String.format("Block:%n"
                        + "Id: %d%n"
//                    + "\nData: " + blockchain.get(i).getData()
//                    + "\nNonce: " + blockchain.get(i).getNonce()
                        + "Timestamp: %d%n"
                        + "Hash of the previous block:%n"
                        + "%s%n"
                        + "Hash of the block:%n"
                        + "%s",
                this.id,
                this.timestamp,
                this.prevHash,
                this.hash);
    }
}

/*
Nonce stands for a Number Used Once in a cryptographic communication such that the block's hash meets a certain criterion. This criterion could be generated a hash that must have its leading four digits to be zero. Thus, the generated hash would look like 00001acbm010gfh1010xxx.

A nonce is basically a random number which figures out how you can actually make this specific block provide you with a valid hash. The way you can do this is by changing the nonce manually. Generally, the miner starts with a Nonce value of 1 and keeps on incrementing it until the generated hash meets the specified criterion. Thus, it may take several iterations until the desired hash with four leading zeros is generated. The expected time for generating a block in the bitcoin system is 10 minutes. Once the miner successfully mines the block, he releases that block in the system and making it the last block in the chain.
 */