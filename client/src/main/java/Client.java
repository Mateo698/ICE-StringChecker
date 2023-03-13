

public class Client {
    public static void main(String[] args) {
        java.util.List<String> extraArgs = new java.util.ArrayList<>();

        try (com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args, "config.client", extraArgs)) {
            if (extraArgs.size() < 1) {
                System.out.println("The system requires atleast one positive integer");
            } else {
                if (extraArgs.size() > 1) {
                    int number = 0;
                    try {
                        number = Integer.parseInt(extraArgs.get(0));
                    } catch (NumberFormatException ignored) {
                    }
                    if (number == 0) {
                        try {
                            number = Integer.parseInt(extraArgs.get(1));
                        } catch (NumberFormatException ignored) {
                        }
                        if (number == 0) {
                            System.out.println("Invalid arguments");
                        } else {
                            //Aqui ira la lectura del archivo
                        }
                    } else {
                        //Aqui ira la lectura del archivo
                    }
                } else {
                    int number = 0;
                    try {
                        number = Integer.parseInt(extraArgs.get(0));
                    } catch (NumberFormatException ignored) {
                    }
                    if (number == 0) {
                        System.out.println("Invalid arguments");
                    } else {

                    }
                }


                //com.zeroc.Ice.ObjectPrx base = communicator.stringToProxy("SimplePrinter:default -p 10000");
                Demo.CheckerPrx twoway = Demo.CheckerPrx.checkedCast(
                        communicator.propertyToProxy("Checker.Proxy")).ice_twoway().ice_secure(false);
                //Demo.PrinterPrx printer = Demo.PrinterPrx.checkedCast(base);
                Demo.CheckerPrx checker = twoway.ice_twoway();

                if (checker == null) {
                    throw new Error("Invalid proxy");
                }
                checker.checkString("asd");
            }
        }
    }
}