class Starter {

    public static void startRunnables(Runnable[] runnables) {
        // implement the method
        for (int i = 0; i < runnables.length; i++) {
            Thread t = new Thread(runnables[i]);
            t.start();
        }
    }
}