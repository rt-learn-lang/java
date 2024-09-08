import java.util.concurrent.Callable;

public class CallableExample implements Callable<Object> {

    @Override
    public Object call() throws Exception
    {
        System.out.println("call() of a Callable object");
        return null;
    }
}
