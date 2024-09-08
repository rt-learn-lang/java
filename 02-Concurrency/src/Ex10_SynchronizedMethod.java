public class Ex10_SynchronizedMethod {
    public static int counter = 0;

    private synchronized static void incrementCounter()
    {
        int current = counter;
        System.out.printf("Before: %d Current thread: %d%n", counter, Thread.currentThread().getId());
        counter = current + 1;
        System.out.printf("After: %d Current thread: %d%n", counter, Thread.currentThread().getId());
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> incrementCounter());
            t.start();
        }
    }

}
