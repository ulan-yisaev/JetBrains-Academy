import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int poolSize = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);

        List<PrintIfPrimeTask> primeTasks = new ArrayList<>();

        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            primeTasks.add(new PrintIfPrimeTask(number));
//            executor.submit(new PrintIfPrimeTask(number));
        }

        primeTasks
                .forEach(e -> executor.submit(e));

        executor.shutdown();
    }
}

class PrintIfPrimeTask implements Runnable {
    private final int number;

    public PrintIfPrimeTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
//        System.out.println("\ncurrentThread(): " + Thread.currentThread().getName() + " | number: " + number);
        if (isPrime(number))
            System.out.println(number);
    }

    public boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i <= n / 2; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}
