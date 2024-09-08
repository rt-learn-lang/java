public class Ex08_JoinExample {
    public static void main(String[] args)
    {
        Thread t1 = new Thread(new SleepLoopExample());
        Thread t2 = new Thread(new SleepLoopExample());
        t1.start();

        try {
            t1.join();  // This will wait for the first thread to finish before starting the 2nd thread.
//            t1.join(1500);  // This will wait for the 1.5 seconds before starting the 2nd thread.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
    }
}
