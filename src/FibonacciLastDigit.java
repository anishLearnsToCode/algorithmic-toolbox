import java.util.Scanner;

public class FibonacciLastDigit {
    private static int fibonacciLastDigit(int number) {
        if (number <= 1) {
            return number;
        }

        int[] memory = new int[number + 1];
        memory[0] = 0; memory[1] = 1;
        for (int index = 2 ; index <= number ; index++) {
            memory[index] = (memory[index - 1] + memory[index - 2]) % 10;
        }
        return memory[number];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(fibonacciLastDigit(number));
    }
}

