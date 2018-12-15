import java.util.Random;

public abstract class PrimeNumberGenerator {
    public static int getNumber(int min, int interval) {
        int num = 0;
        Random rand = new Random(); // generate a random number
        num = rand.nextInt(interval) + min;

        while (!isPrime(num)) {
            num = rand.nextInt(interval) + min;
        }
        return num;
    }

    /**
     * Checks to see if the requested value is prime.
     */
    private static boolean isPrime(int inputNum){
        if (inputNum <= 3 || inputNum % 2 == 0)
            return inputNum == 2 || inputNum == 3; //this returns false if number is <=1 & true if number = 2 or 3
        int divisor = 3;
        while ((divisor <= Math.sqrt(inputNum)) && (inputNum % divisor != 0))
            divisor += 2; //iterates through all possible divisors
        return inputNum % divisor != 0; //returns true/false
    }
}
