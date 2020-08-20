package blockchain;

public class Main {
    public static void main(String[] args) {

        Blockchain blockchain = new Blockchain();

        //task description: The chain starts with a block whose id = 1
        for (int i = 1; i <= 10; i++) {
            blockchain.generate(i, "Block #" + i);
        }

        blockchain.outputChain(5);

        /*for (int i = 0; i < 5; i++) {
            System.out.println("Block:"
                    + "\nId: " + blockchain.get(i).getId()
//                    + "\nData: " + blockchain.get(i).getData()
//                    + "\nNonce: " + blockchain.get(i).getNonce()
                    + "\nTimestamp: " + blockchain.get(i).getTimestamp()
                    + "\nHash of the previous block:\n" + blockchain.get(i).getPrevHash()
                    + "\nHash of the block:\n" + blockchain.get(i).getHash() + "\n"
            );
        }*/

//        System.out.println(blockchain.isChainValid());
    }
}

/* A blockchain is a constantly growing ledger which keeps a permanent record of all the transactions that have taken place in a secure, chronological, and immutable way.

Let's breakdown the definition,

Ledger: It is a file that is constantly growing.
Permanent: It means once the transaction goes inside a blockchain, you can put up it permanently in the ledger.
Secure: Blockchain placed information in a secure way. It uses very advanced cryptography to make sure that the information is locked inside the blockchain.
Chronological: Chronological means every transaction happens after the previous one.
Immutable: It means as you build all the transaction onto the blockchain, this ledger can never be changed.
A blockchain is a chain of blocks which contain information. Each block records all of the recent transactions, and once completed goes into the blockchain as a permanent database. Each time a block gets completed, a new block is generated.

 */