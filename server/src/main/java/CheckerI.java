import com.zeroc.Ice.Current;

import java.util.UUID;

public class CheckerI implements Demo.Checker {

    @Override
    public int checkString(String str, int number, Current current) {
        try {
            UUID transformed = UUID.fromString(str);
        } catch (IllegalArgumentException e) {
            System.out.println(str+" INVALID REQUEST");
            return 1;
        }
        System.out.println("\033[0;32;40m"  +str+" VALID REQUEST" + "\033[0m");

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
