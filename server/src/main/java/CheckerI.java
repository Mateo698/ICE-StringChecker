import com.zeroc.Ice.Current;

import java.util.UUID;

public class CheckerI implements Demo.Checker {

    @Override
    public int checkString(String str, int number, Current current) {
        try {
            UUID transformed = UUID.fromString(str);
        } catch (IllegalArgumentException e) {
            System.out.print("\u001B[31m");
            System.out.print("\u001B[1m");
            System.out.println(str+" INVALID REQUEST");
            System.out.print("\u001B[0m");

            return 1;
        }
        System.out.print("\u001B[32m");

        // Imprime la cadena en negrita
        System.out.print("\u001B[1m");
        System.out.println(str+" VALID REQUEST");
        System.out.print("\u001B[0m");


        if(number <= 1){
            return 2;
        }

        int nextPrime = 0;
        while(nextPrime == 0){
            number++;
            boolean isPrime = true;
            for(int i = 2; i < number; i++){
                if(number % i == 0){
                    isPrime = false;
                }
            }
            if(isPrime){
                nextPrime = number;
            }
        }

        return nextPrime;
    }
}
