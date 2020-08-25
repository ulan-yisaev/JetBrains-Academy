package blockchain;

import blockchain.block.Blockchain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter how many zeros the hash must start with: ");

        int zerosCnt = scanner.nextInt();
        System.out.println();

//At the start of the program, you should check if a blockchain exists on the hard drive, load it, check if it is valid, and then continue to create blocks

        Blockchain blockchain = Blockchain.initBlockchain();

        /*if (!blockchain.isChainValid(zerosCnt)) {
            return;
        }*/

        int lastBlockId = blockchain.getLastBlockId();
//        System.out.println("blockchain.getLastBlockId(): " + lastBlockId + "\n");

        for (int i = lastBlockId + 1; i <= lastBlockId + 5; i++) {
            blockchain.generate(i, "Block #" + i, zerosCnt);
        }

        //blockchain.outputChain(0, 5);

        //print last 5 blocks to avoid error in test #2:
        blockchain.outputChain(blockchain.getLastBlockId() - 5, 5);
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