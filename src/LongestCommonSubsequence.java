import java.util.Scanner;

public class LongestCommonSubsequence {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] a = getArray(scanner.nextInt());
        int[] b = getArray(scanner.nextInt());
        System.out.println(lengthLongestCommonSubsequence(a, b));
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }

    private static int lengthLongestCommonSubsequence(int[] a, int[] b) {
        int[][] memory = new int[a.length][b.length];

        for (int row = 0, column = 0 ; column < b.length ; column++) {
            memory[row][column] = Math.max(column > 0 ? memory[row][column - 1] : 0,
                    a[row] == b[column] ? 1 : 0);
        }

        for (int row = 0, column = 0 ; row < a.length ; row++) {
            memory[row][column] = Math.max(row > 0 ? memory[row - 1][column] : 0,
                    a[row] == b[column] ? 1 : 0);
        }

        for (int row = 1 ; row < a.length ; row++) {
            for (int column = 1 ; column < b.length ; column++) {
                memory[row][column] = max(
                        memory[row - 1][column],
                        memory[row][column - 1],
                        a[row] == b[column] ? memory[row - 1][column - 1] + 1 : 0
                );
            }
        }

//        print(memory);

        return memory[a.length - 1][b.length - 1];
    }

    private static int max(int... numbers) {
        int result = 0;
        for (int number : numbers) {
            result = Math.max(number, result);
        }
        return result;
    }

    private static void print(int[][] matrix) {
        for (int[] row : matrix) {
            print(row);
        }
    }

    private static void print(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
