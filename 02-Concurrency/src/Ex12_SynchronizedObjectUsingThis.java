public class Ex12_SynchronizedObjectUsingThis {
    public static int counter = 0;
    public static Object lock = new Object();

    private void incrementCounter()
    {
        synchronized (this) {
            int current = counter;
            System.out.printf("Before: %d Current thread: %d%n", counter, Thread.currentThread().getId());
            counter = current + 1;
            System.out.printf("After: %d Current thread: %d%n", counter, Thread.currentThread().getId());
        }
    }

    public static void main(String[] args)
    {
        Ex12_SynchronizedObjectUsingThis instance = new Ex12_SynchronizedObjectUsingThis();

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(instance::incrementCounter);
            t.start();
        }
    }
}
