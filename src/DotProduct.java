import java.util.Arrays;
import java.util.Scanner;

public class DotProduct {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static long maxDotProduct(long[] a, long[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long product = 0;
        for (int index = 0 ; index < a.length ; index++) {
            product += a[index] * b[index];
        }
        return product;
    }

    public static void main(String[] args) {
        int length = SCANNER.nextInt();
        long[] a = getArray(length);
        long[] b = getArray(length);
        System.out.println(maxDotProduct(a, b));
    }

    private static long[] getArray(int length) {
        long[] array = new long[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = SCANNER.nextLong();
        }
        return array;
    }
}

