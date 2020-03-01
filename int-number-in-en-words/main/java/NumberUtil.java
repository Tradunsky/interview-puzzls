import java.util.HashMap;
import java.util.Map;

public final class NumberUtil {
    private NumberUtil() {
        throw new UnsupportedOperationException();
    }

    private static final Map<Integer, String> figures = new HashMap<>();

    static {
        figures.put(1, "one");
        figures.put(2, "two");
        figures.put(3, "three");
        figures.put(4, "four");
        figures.put(5, "five");
        figures.put(6, "six");
        figures.put(7, "seven");
        figures.put(8, "eight");
        figures.put(9, "nine");

        figures.put(10, "ten");
        figures.put(11, "eleven");
        figures.put(12, "twelve");
        figures.put(13, "thirteen");
        figures.put(14, "fourteen");
        figures.put(15, "fifteen");
        figures.put(16, "sixteen");
        figures.put(17, "seventeen");
        figures.put(18, "eighteen");
        figures.put(19, "nineteen");

        figures.put(20, "twenty");
        figures.put(30, "thirty");
        figures.put(40, "forty");
        figures.put(50, "fifty");
        figures.put(60, "sixty");
        figures.put(70, "seventy");
        figures.put(80, "eighty");
        figures.put(90, "ninety");
    }

    public static String hundredsToString(int number) {
        int hundreds = number / 100;
        return figures.get(hundreds) + " hundred ";
    }

    public static int hundredOf(int number) {
        int hundreds = number / 100;
        return hundreds * 100;
    }

    public static String xTiesToString(int number) {
        int countOfTies = number / 10;
        int xTy = countOfTies * 10;
        return figures.get(xTy);
    }

    public static int xTyOf(int number) {
        int countOfTies = number / 10;
        return countOfTies * 10;
    }

    public static String numberToString(int number) {
        return figures.get(number) + " ";
    }

    public static String representHundredsInWords(int number) {
        String numberInWords = "";
        if (number > 99 && number < 1000) {
            //hundred
            numberInWords += hundredsToString(number);
            number -= hundredOf(number);
        }
        if (number > 20 && number < 100) {
            //Xty
            numberInWords += xTiesToString(number);
            number -= xTyOf(number);
            numberInWords += number > 0 ? "-" : " ";
        }
        if (number > 0 && number < 21) {
            numberInWords += numberToString(number);
        }
        return numberInWords;
    }

    public static String representMillionsInWords(int number) {
        int millionPart = number / 1_000_000;
        return representHundredsInWords(millionPart) + "million ";
    }

    public static int millionOf(int number) {
        int millionPart = number / 1_000_000;
        return millionPart * 1_000_000;
    }

    public static String representThousandToString(int number) {
        int thousandPart = number / 1000;
        return representHundredsInWords(thousandPart) + "thousand ";
    }

    public static int thousandOf(int number) {
        int thousandPart = number / 1000;
        return thousandPart * 1000;
    }

    public static String representNumberInWords(int number) {
        String numberInWords = "";
        if (number == 1_000_000_000) {
            numberInWords = "one billion";
        } else {
            if (number > 999_999) {
                //million
                numberInWords += representMillionsInWords(number);
                number -= millionOf(number);
            }
            if (number > 999) {
                //thousand
                numberInWords += representThousandToString(number);
                number -= thousandOf(number);
            }
            numberInWords += representHundredsInWords(number);
        }
        return numberInWords;
    }
}
