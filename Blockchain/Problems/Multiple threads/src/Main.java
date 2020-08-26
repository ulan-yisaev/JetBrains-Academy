public class Main {

    public static void main(String[] args) {

        // create instances and start threads here
    }
}

// Don't change the code below
class WorkerThread extends Thread {

    private static final int NUMBER_OF_LINES = 3;

    @Override
    public void run() {
        final String name = Thread.currentThread().getName();

        if (!name.startsWith("worker-")) {
            return;
        }

        for (int i = 0; i < NUMBER_OF_LINES; i++) {
            System.out.println("do something...");
        }
    }
}