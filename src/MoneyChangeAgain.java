import java.util.Scanner;

public class MoneyChangeAgain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coins = {1, 3, 4};
        int money = scanner.nextInt();
        System.out.println(minimumCoins(money, coins));
    }

    private static int minimumCoins(int money, int[] coins) {
        int rows = coins.length, columns = money + 1;
        int[][] memory = new int[rows][columns];
        for (int row = 0, column = 1 ; column < columns ; column++) {
            memory[row][column] = column;
        }

        for (int row = 1 ; row < rows ; row++) {
            for (int column = 1 ; column < columns ; column++) {
                memory[row][column] = Math.min(
                        memory[row - 1][column],
                        column >= money ?
                                Math.min(memory[row][column - money], memory[row - 1][column - money]) + 1
                                : Integer.MAX_VALUE
                );
            }
        }

        return memory[rows - 1][columns - 1];
    }
}
