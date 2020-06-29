import java.util.Scanner;

public class FibonacciHuge {

    private static long fibonacci(int number, long mod) {
        if (number <= 1) {
            return number;
        }
        long[] memory = new long[number + 1];
        memory[1] = 1;
        for (int index = 2 ; index <= number ; index++) {
            memory[index] = (memory[index - 1] + memory[index - 2]) % mod;
        }

        return memory[number] % mod;
    }

    private static long pisanoPeriod(long m) {
        for (long i = 0, a = 0, b = 1, c; i < m * m; i++) {
            c = (a + b) % m;
            a = b;
            b = c;
            if (a == 0 && b == 1) {
                return i + 1;
            }
        }
        return 0;
    }

    private static long fibonacciMod(long number, long mod) {
        long period = pisanoPeriod(mod);
        number = number % period;
        return fibonacci((int) number, mod);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        long mod = scanner.nextLong();
        System.out.println(fibonacciMod(number, mod));
    }
}

