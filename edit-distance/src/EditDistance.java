class EditDistance {
    boolean oneEditApart(String s1, String s2) {
        //keep bigger string on right side
        if (s1.length() > s2.length()) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }

        //if size difference is more than 1 - more than one edit required
        int sizeDiff = s2.length() - s1.length();
        if (sizeDiff > 1) return false;

        //for each next char compare in shorter sequence
        // if different 2 time - false
        // if different 1 time and strings different size
        //   step back for shorter sequence

        //one difference or there is last char left to insert
        boolean hasDifference = false;
        for(int i=0, j=0; i < s1.length(); ++i, ++j) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (hasDifference) return false;

                hasDifference = true;
                if (sizeDiff > 0) --i;
            }
        }


        return hasDifference || sizeDiff != 0;
    }
}

class Solution {
    static void catSample() {
        EditDistance editDistance = new EditDistance();
        String[][] words = new String[][]{
                {"cat", "dog"},
                {"cat", "cats"},
                {"cat", "cut"},
                {"cat", "cast"},
                {"cat", "at"}, //"at", "cat"
                {"cat", "act"},
                {"cat", "acting"},
        };
        boolean[] expectedResults = new boolean[]{
                false,
                true,
                true,
                true,
                true,
                false,
                false
        };

        for (int i = 0; i < expectedResults.length; i++) {
            String oneWord = words[i][0], anotherWord = words[i][1];
            boolean actualResult = editDistance.oneEditApart(oneWord, anotherWord);
            if (actualResult != expectedResults[i]) throw new AssertionError(
                    String.format("Wrong result on: \noneEditApart(%s, %s)=%b, but given =%b", oneWord, anotherWord, expectedResults[i], actualResult)
            );
        }
    }

    public static void main(String[] args) {
        catSample();
        System.out.println("Problem solved");
    }
}
