import java.util.UUID;

public class Client {
    public static void main(String[] args) {
        java.util.List<String> extraArgs = new java.util.ArrayList<>();

        try (com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args, "config.client", extraArgs)) {



                //com.zeroc.Ice.ObjectPrx base = communicator.stringToProxy("SimplePrinter:default -p 10000");
                Demo.CheckerPrx twoway = Demo.CheckerPrx.checkedCast(
                        communicator.propertyToProxy("Checker.Proxy")).ice_twoway().ice_secure(false);
                //Demo.PrinterPrx printer = Demo.PrinterPrx.checkedCast(base);
                Demo.CheckerPrx checker = twoway.ice_twoway();

                if (checker == null) {
                    throw new Error("Invalid proxy");
                }
                if (extraArgs.size() < 1) {
                    System.out.println("The system requires at least one positive integer");
                    System.out.println("Mateo Rada Arias A00368693");
                    System.out.println("Santiago Arevalo ");
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
                                //Aqui es el caso donde el segundo argumento es un numero y el
                                //primero es un archivo
                            }
                        } else {
                            //Aqui es el caso donde el primer argumento es un numero y el
                            //segundo es un archivo
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
                            //Este es el caso donde solo se ingresa un numero, generando el UUID de manera aleatoria
                            String id = UUID.randomUUID().toString();
                            System.out.println(checker.checkString(id, number));
                        }
                    }
            }
        }
    }
}