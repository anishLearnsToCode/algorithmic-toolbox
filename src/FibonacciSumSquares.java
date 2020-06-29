import java.util.Scanner;

public class FibonacciSumSquares {
    private static final long PISANO_PERIOD_10 = 60;

    private static long lastDigitFibonacci(long number) {
        long lastDigit = number;
        for (long index = 2, first = 0, second = 1 ; index <= number ; index++) {
            lastDigit = (first + second) % 10;
            first = second;
            second = lastDigit;
        }
        return lastDigit;
    }

    private static long lastDigitSumSquares(long number) {
        long smaller = number % PISANO_PERIOD_10;
        long larger = (number + 1) % PISANO_PERIOD_10;
        return (lastDigitFibonacci(smaller) * lastDigitFibonacci(larger)) % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        System.out.println(lastDigitSumSquares(number));
    }
}

