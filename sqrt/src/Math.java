import static java.text.MessageFormat.format;

public class Math {
    int sqrt(int x) {
        if (x < 0) throw new IllegalArgumentException("Number cannot be negative");
        if (x == 1) return 1;

        return search(x, 0, x);
    }

    private int search(int x, int left, int right) {
        if (left >= right) return right;
        int middle = (left + right) / 2;
        int doubleMiddle = middle * middle;

        if (middle == left || middle == right) return middle;

        if (doubleMiddle == x) return middle;
        if (doubleMiddle > x) return search(x, left, middle);
        else return search(x, middle, right);
    }

    public static void main(String[] args) {
        int[][] testCases = new int[][] {
                {0, 0},
                {1, 1},
                {4, 2},
                {6, 2},
                {7, 2},
        };

        Math math = new Math();
        for (int[] testCase: testCases) {
            int sqrt = math.sqrt(testCase[0]);
            if (sqrt != testCase[1])
                throw new AssertionError(format("Test case failed.\n Expected: sqrt({0})=={1},\nActual: sqrt({0})=={2}", testCase[0], testCase[1], sqrt));
        }

        System.out.println("Problem solved");
    }
}
