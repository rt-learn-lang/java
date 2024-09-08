public class Ex06_InterruptExample {
    public static void main(String[] args)
    {
        Thread t = new Thread(new SleepLoopExample());
        t.start();
        t.interrupt();
    }
}
