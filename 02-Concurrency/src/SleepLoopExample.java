public class SleepLoopExample implements Runnable {
    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++) {
            System.out.printf("Current thread ID: %d i: %d%n", Thread.currentThread().getId(), i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();  // This is when we don't want the interrupted flag to remain true.
                break;
            }
        }
    }
}
