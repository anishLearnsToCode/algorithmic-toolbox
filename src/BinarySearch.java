import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch {
    private static final FastScanner scanner = new FastScanner(System.in);

    private static int position(int[] array, int element) {
        for (int start = 0, end = array.length, middle = (start + end) / 2 ; start <= end && middle < array.length
                ; middle = (start + end) / 2) {

            if (array[middle] == element) {
                return middle;
            } else if (array[middle] < element) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = getArray(scanner.nextInt());
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            int element = scanner.nextInt();
            System.out.println(position(array, element));
        }
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
