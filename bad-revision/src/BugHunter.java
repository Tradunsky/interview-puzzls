import java.text.MessageFormat;

import static java.text.MessageFormat.format;

public class BugHunter {

    //let's assume this function is given
    private boolean isBad(int revision) {
        //this is totally imagine implementation, not given in real task
        return revision > 202;
    }

    //taking following method signature find a first bad revision from where it started
    int findBadRevision(int good, int bad) {
        if (bad < good) throw new IllegalArgumentException(String.format("Bad revision (%d) should be after good one (%d)", bad, good));
        if (!isBad(bad) || isBad(good)) throw new IllegalArgumentException("Given revisions should be good and bad");

        return binarySearch(good, bad);
    }

    /**
     * good = 197, bad 208
     * <p>
     * revision 197 - good
     * revision 198 - good
     * revision 199 - good
     * revision 200 - good 197+(204-197)/2
     * revision 201 - good
     * revision 202 - good 200+(204-200)/2 202+(203-202)/2 == lastGood
     * revision 203 - bad  202+(204-202)/2 return if 202+(203-202)/2 == lastBad or
     * revision 204 - bad  197+(211-197)/2
     * revision 205 - bad
     * revision 206 - bad
     * revision 207 - bad
     * revision 208 - bad
     * revision 209 - bad
     * revision 210 - bad
     * revision 211 - bad
     */
    //Time complexity O(logN), space O(1)
    private int binarySearch(int good, int bad) {
        int firstBad = bad;
        int lastGood = good;
        int middleRevision = lastGood + (firstBad - lastGood) / 2;

        while (middleRevision != lastGood) {
            if (isBad(middleRevision)) firstBad = middleRevision;
            else lastGood = middleRevision;

            middleRevision = lastGood + (firstBad - lastGood) / 2;
        }
        return firstBad;
    }
}

class TestCase {

    static void assertFromToExpected(BugHunter bugHunter, int from, int to, int expected) {
        int badRevision = bugHunter.findBadRevision(from, to);

        if (badRevision != expected) throw new AssertionError(String.format("Wrong answer: %d!=$d", badRevision, expected));
    }

    public static void main(String[] args) {
        BugHunter bugHunter = new BugHunter();

        assertFromToExpected(bugHunter, 197, 211, 203);
        assertFromToExpected(bugHunter, 197, 203, 203);
        assertFromToExpected(bugHunter, 202, 211, 203);
        assertFromToExpected(bugHunter, 202, 203, 203);
        System.out.println("Problem solved.");
    }
}
