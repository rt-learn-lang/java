import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * In this example, increasing the number of threads in the pool will result in faster execution.
 */
public class Ex17_ThreadPoolFixed {
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static Future<Double> getRandom(final int i)
    {
        return executorService.submit(() -> {
            Thread.sleep((int) (Math.random() * 200));
            System.out.printf("%d Thread id: %d%n", i, Thread.currentThread().getId());
            return Math.random();
        });
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 100; i++) {
            getRandom(i);
        }

        executorService.shutdown();
    }
}
