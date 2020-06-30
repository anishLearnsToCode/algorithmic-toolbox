import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, List<Item> items) {
        items.sort(Comparator.reverseOrder());
        double knapsack = 0;
        for (int index = 0 ; index < items.size() && capacity > 0 ; index++) {
            Item item = items.get(index);
            knapsack += item.weight <= capacity ? item.value : item.ratio * capacity;
            capacity -= Math.min(item.weight, capacity);
        }
        return knapsack;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfItems = scanner.nextInt();
        int capacity = scanner.nextInt();
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < numberOfItems ; i++) {
            items.add(new Item(scanner.nextInt(),scanner.nextInt()));
        }
        System.out.println(getOptimalValue(capacity, items));
    }

    private static class Item implements Comparable<Item> {
        private final int weight;
        private final int value;
        private final double ratio;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }

        @Override
        public int compareTo(Item other) {
            return Double.compare(this.ratio, other.ratio);
        }
    }
} 
