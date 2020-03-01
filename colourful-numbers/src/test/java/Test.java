public class Test {

    public void colourful() {
        int number = 3245;
        String expectedResult = "Colourful";

        String actualResult = ColourfulNumber.isColourFul(number);

        if (!actualResult.equals(expectedResult)) throw new AssertionError(String.format("Wrong answer: %s, expected: %s", actualResult, expectedResult));
    }

    public void notColourful() {
        int number = 326;
        String expectedResult = "Not Colourful";

        String actualResult = ColourfulNumber.isColourFul(number);

        if (!actualResult.equals(expectedResult)) throw new AssertionError(String.format("Wrong answer: %s, expected: %s", actualResult, expectedResult));
    }

    public static void main(String[] args) {
        Test test = new Test();

        test.colourful();
        test.notColourful();
        System.out.println("Problem solved.");
    }
}
