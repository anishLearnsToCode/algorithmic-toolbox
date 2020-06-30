import java.util.Scanner;

public class DifferentSummands {
    private static long maxChildrenPossible(long candies) {
        return (long) ((Math.sqrt(8 * candies + 1) - 1) / 2);
    }

    private static long summation(long n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long candies = scanner.nextLong();
        long children = maxChildrenPossible(candies);
        System.out.println(children);
        for (long i = 1 ; i < children ; i++) {
            System.out.print(i + " ");
        }
        System.out.print(candies - summation(children - 1));
    }
}

