package blockchain;

import blockchain.block.Block;
import blockchain.block.Blockchain;
import blockchain.util.ChainUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

//    public static volatile Future taskResults = null;

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter how many zeros the hash must start with: ");
//        int zerosCnt = scanner.nextInt();
//        System.out.println();

        List<Callable<Block>> tasks = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(16);
        Blockchain blockchain = ChainUtils.initBlockchain();

        //invokeAny - Executes the given tasks, returning the result of one that has completed successfully (i.e., without throwing an exception), if any do before the given timeout elapses. Upon normal or exceptional return, tasks that have not completed are cancelled. The results of this method are undefined if the given collection is modified while this operation is in progress.
        for (int i = 1; i < 9; i++) {
            tasks.add(new Miner(i, blockchain));
        }

        for (int i = 0; i < 5; i++) {
            try {
                Block generatedBlock = executor.invokeAny(tasks);
                /*System.out.printf("%n ++++++++++++ from main loop, current i: %d | generatedBlock.getId(): %d " +
                                "| blockchain.getLastBlockId().orElse(): %d| blockchain.getZerosCnt(): %d | attempts made: %d ++++++++++%n"
                        , i, generatedBlock.getId(), blockchain.getLastBlockId().orElse(-9999999),
                        blockchain.getZerosCnt(), generatedBlock.getAttempts());
                System.out.println("\n---generatedBlock.toString():\n" + generatedBlock.toString() + "\n");*/
                if (ChainUtils.isBlockValid(blockchain, generatedBlock)) {
                    ChainUtils.saveBlockchain(blockchain, generatedBlock);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

//        executor.shutdown();

//        System.out.println("Forcing shutdown...");
        executor.shutdownNow();

//        ChainUtils.outputChain(blockchain, 0, 5);

        //print last 5 blocks to avoid error in test #2:
        ChainUtils.outputChain(blockchain, blockchain.getLastBlockId().orElse(5) - 5, 5);
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