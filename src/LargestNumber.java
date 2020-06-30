import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargestNumber {
    private static final Scanner scanner = new Scanner(System.in);

    private static List<String> largestNumber(List<String> numbers) {
        numbers.sort((o1, o2) -> {
            for (int index = 0 ; index < o1.length() && index < o2.length() ; index++) {
                if (o1.charAt(index) < o2.charAt(index)) {
                    return 1;
                } else if (o1.charAt(index) > o2.charAt(index)) {
                    return -1;
                }
            }
            String larger = o1.length() > o2.length() ? o1 : o2;
            String smaller = o1.length() > o2.length() ? o2 : o1;
            return o1.length() == o2.length()
                    ? 0
                    : Integer.compare(larger.charAt(smaller.length()), smaller.charAt(0))
                        * Integer.compare(o2.length(), o1.length());
        });

        return numbers;
    }

    public static void main(String[] args) {
        List<String> numbers = getArray(scanner.nextInt());
        print(largestNumber(numbers));
    }

    private static void print(List<String> list) {
        for (String string : list) {
            System.out.print(string);
        }
    }

    private static List<String> getArray(int length) {
        List<String> numbers = new ArrayList<>(length);
        for (int i = 0 ; i < length ; i++) {
            numbers.add(scanner.next());
        }
        return numbers;
    }
}

