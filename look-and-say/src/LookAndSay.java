import java.math.BigInteger;

public class LookAndSay {
    String lookAndSay(String symbols) {
        char[] chars = symbols.toCharArray();
        StringBuilder sb = new StringBuilder(symbols.length() * 2 + 1);

        BigInteger counter = BigInteger.ONE;//limited by this number...
        char currentSymbol = chars[0];
        for (int index = 1; index < chars.length; index++) {
            char anotherChar = chars[index];
            if (currentSymbol == anotherChar) counter = counter.add(BigInteger.ONE);
            else {
                sb.append(counter).append(currentSymbol);
                counter = BigInteger.ONE;
                currentSymbol = anotherChar;
            }
        }
        sb.append(counter).append(currentSymbol); // last symbol in sequence
        return sb.toString();
    }

    String loopTo(int n) {
        StringBuilder sb = new StringBuilder();

        LookAndSay las = new LookAndSay();
        String sequence = "1";
        sb.append(sequence).append("\n");
        for (int i = 1; i < n; i++) {
            sequence = las.lookAndSay(sequence);
            sb.append(sequence).append("\n");
        }

        return sb.toString();
    }
}

class LookAndSayTestCase {

    static void input10() {
        String expected =
                "1\n" +
                "11\n" +
                "21\n" +
                "1211\n" +
                "111221\n" +
                "312211\n" +
                "13112221\n" +
                "1113213211\n" +
                "31131211131221\n" +
                "13211311123113112211\n";
        String las10 = new LookAndSay().loopTo(10);
        if (!expected.equals(las10)) throw new AssertionError("Wrong result on n==10:\n"+las10);
    }

    public static void main(String[] args) {
        input10();
        System.out.println("Problem solved.");
    }
}