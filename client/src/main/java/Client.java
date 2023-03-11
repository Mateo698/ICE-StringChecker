

public class Client {
    public static void main(String[] args)
    {
        java.util.List<String> extraArgs = new java.util.ArrayList<>();

        try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args,"config.client",extraArgs))
        {
            //com.zeroc.Ice.ObjectPrx base = communicator.stringToProxy("SimplePrinter:default -p 10000");
            Demo.CheckerPrx twoway = Demo.CheckerPrx.checkedCast(
                    communicator.propertyToProxy("Checker.Proxy")).ice_twoway().ice_secure(false);
            //Demo.PrinterPrx printer = Demo.PrinterPrx.checkedCast(base);
            Demo.CheckerPrx checker = twoway.ice_twoway();

            if(checker == null)
            {
                throw new Error("Invalid proxy");
            }
            checker.checkString("asd");
        }
    }
}