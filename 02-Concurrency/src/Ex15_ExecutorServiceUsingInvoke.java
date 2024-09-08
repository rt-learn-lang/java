import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Ex15_ExecutorServiceUsingInvoke {
    public static void main(String[] args)
    {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();  // Always results in 1, because it executes in the order that tasks are received.
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Callable<Integer>> callables = new ArrayList<>();
        callables.add(() -> 1);
        callables.add(() -> 2);

        try {
            System.out.println(executorService.invokeAny(callables));
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }
}