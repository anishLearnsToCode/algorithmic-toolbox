import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MajorityElement {
    private static final FastScanner scanner = new FastScanner(System.in);

    private static boolean hasMajorityElement(int[] array) {
        Map<Integer, Integer> frequencies = getFrequency(array);
        for (int frequency : frequencies.values()) {
            if (frequency > array.length / 2) {
                return true;
            }
        }
        return false;
    }

    private static Map<Integer, Integer> getFrequency(int[] array) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int element : array) {
            frequencies.put(element, frequencies.getOrDefault(element, 0) + 1);
        }
        return frequencies;
    }

    public static void main(String[] args) {
        int[] array = getArray(scanner.nextInt());
        System.out.println(hasMajorityElement(array) ? 1 : 0);
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int i = 0 ; i < length ; i++) {
            array[i] = scanner.nextInt();
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

