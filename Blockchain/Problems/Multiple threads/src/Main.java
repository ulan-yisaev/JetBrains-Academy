public class Main {

    public static void main(String[] args) {

        Thread t1 = new WorkerThread();
        t1.setName("worker-1");

        Thread t2 = new WorkerThread();
        t2.setName("worker-2");

        t1.start();
        t2.start();
    }
}

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