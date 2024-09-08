public class Ex07_RunningConcurrently {
    public static void main(String[] args)
    {
        Thread t1 = new Thread(new SleepLoopExample());
        Thread t2 = new Thread(new SleepLoopExample());

        t1.start();
        t2.start();
    }
}
