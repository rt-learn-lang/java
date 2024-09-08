import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This example demonstrates ReentrantLock class which is more flexible with
 * acquisition and release compared to synchronized.
 * It provides Condition objects for more sophisticated thread synchronization.
 * Under high contention, ReentrantLock can be more efficient and fairer (if
 * fairness is enabled) than synchronized
 */
public class Ex13_ReentrantLock {
    public static int counter = 0;
    public static Lock lock = new ReentrantLock();

    private static void incrementCounter() throws InterruptedException
    {
        if (lock.tryLock(6, TimeUnit.MILLISECONDS)) {
            try {
                int current = counter;
                System.out.printf("Before: %d Current thread: %d%n", counter, Thread.currentThread().getId());
                counter = current + 1;
                System.out.printf("After: %d Current thread: %d%n", counter, Thread.currentThread().getId());
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("The didn't get the lock and is looking for a new task.");
        }
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                try {
                    incrementCounter();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
    }
}
