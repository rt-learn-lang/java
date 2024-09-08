import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * This example demonstrates the use of submit, although in this example we would see the getRandom gets executed one
 * after the other, this is because we are still using the single thread executor. See the next example to see what
 * happens when we use thread pools.
 */
public class Ex16_Submit {
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static Future<Double> getRandom(final int i)
    {
        return executorService.submit(() -> {
//            Thread.sleep(1000);
            System.out.println(i);
            return Math.random();
        });
    }

    public static void main(String[] args)
    {
        Future<Double> doubleFuture = getRandom(1);
        getRandom(2);
        getRandom(3);
        getRandom(4);

        while (!doubleFuture.isDone()) {
            if (doubleFuture.isCancelled()) {
                System.out.println("Your future was cancelled, we're sorry");
                break;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            System.out.println(doubleFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
