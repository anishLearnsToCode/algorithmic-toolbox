import java.util.Scanner;

public class FibonacciPartialSum {
    private static long lastDigitFibonacciSum(long number) {
        long current = 0;
        for (long index = 2, first = 0, second = 1 ; index <= number ; index++) {
            current = (first + second) % 60;
            first = second;
            second = current;
        }
        return current - 1;
    }

    private static long lastDigitFibonacciSumDriver(long number) {
        if (number == -1) {
            return 0;
        } else if (number <= 1) {
            return number;
        }
        long remainder = number % 60;
        if (remainder == 0) {
            return 0;
        }
        return lastDigitFibonacciSum(remainder + 2) % 10;
    }

    private static long lastDigitSumRange(long start, long end) {
        long result = 10 + lastDigitFibonacciSumDriver(end) - lastDigitFibonacciSumDriver(start - 1);
        return result % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(lastDigitSumRange(from, to));
    }
}

