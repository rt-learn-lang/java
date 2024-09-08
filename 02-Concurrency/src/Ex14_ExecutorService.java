import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Ex14_ExecutorService {
    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> System.out.printf("1: %f Thread id: %d%n", Math.random(), Thread.currentThread().getId()));
        executorService.execute(() -> System.out.printf("2: %f Thread id: %d%n", Math.random(), Thread.currentThread().getId()));
        executorService.execute(() -> System.out.printf("3: %f Thread id: %d%n", Math.random(), Thread.currentThread().getId()));
        executorService.execute(() -> System.out.printf("4: %f Thread id: %d%n", Math.random(), Thread.currentThread().getId()));
        executorService.shutdown();
    }
}
