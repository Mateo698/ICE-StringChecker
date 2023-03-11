import com.zeroc.Ice.Current;

public class CheckerI implements Demo.Checker{

    @Override
    public int checkString(String str, Current current) {
        return 0;
    }
}
