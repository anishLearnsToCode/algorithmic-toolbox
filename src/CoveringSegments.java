import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoveringSegments {

    private static List<Integer> optimalPoints(List<Segment> segments) {
        segments.sort(Segment::compareTo);
        List<Integer> points = new ArrayList<>();
        points.add(segments.get(0).end);
        for (int index = 1, lastPoint = points.get(0) ; index < segments.size() ; index++) {
            Segment segment = segments.get(index);
            if (segment.start > lastPoint) {
                points.add(segment.end);
                lastPoint = segment.end;
            }
        }
        return points;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Segment> segments = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            segments.add(new Segment(scanner.nextInt(), scanner.nextInt()));
        }
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        print(points);
    }

    private static void print(List<Integer> array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
    }

    private static class Segment implements Comparable<Segment> {
        private final int start;
        private final int end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Segment other) {
            return Integer.compare(this.end, other.end);
        }
    }
}
 
