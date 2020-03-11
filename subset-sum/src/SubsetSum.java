import java.util.LinkedList;

public class SubsetSum {
    boolean containsSumSubset(int[] numbers, int sum) {
        LinkedList<Integer> queue = new LinkedList<>();
        int currentSum = 0;
        for (int i = 0; i < numbers.length && currentSum != sum; i++) {
            queue.add(numbers[i]);
            currentSum += numbers[i];
            while (currentSum > sum) {
                Integer firstNumber = queue.poll();
                currentSum -= firstNumber;
            }
        }
        System.out.println("Sum: " + currentSum+", Expected: "+sum);
        System.out.println("Subset: " + queue.toString());
        return currentSum == sum;
    }
}

class TestCase {
    static void assertExpected(boolean expected, boolean actual) {
        if (expected != actual) throw new AssertionError("Expected answer didn't meet actual :(");
    }

    public static void main(String[] args) {
        SubsetSum subsetSum = new SubsetSum();
        assertExpected(true, subsetSum.containsSumSubset(new int[]{1, 5, 7, 9, 3}, 21));
        assertExpected(true, subsetSum.containsSumSubset(new int[]{1, 5, -7, 9, 3}, 8));
        assertExpected(true, subsetSum.containsSumSubset(new int[]{8, 5, -7, -7, 3}, 8));
        assertExpected(false, subsetSum.containsSumSubset(new int[]{14, -7, 5, -7, 3}, 8));
        assertExpected(false, subsetSum.containsSumSubset(new int[]{14, 5, -7, -7, 3}, 8));
        System.out.println("Problem solved.");
    }
}