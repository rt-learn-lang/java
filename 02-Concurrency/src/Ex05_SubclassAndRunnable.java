public class Ex05_SubclassAndRunnable
{
    public static void main(String[] args)
    {
        ThreadSubclass ts = new ThreadSubclass();
        Thread t = new Thread(() -> System.out.println("Runnable!"));

        ts.start();
        t.start();
    }
}
