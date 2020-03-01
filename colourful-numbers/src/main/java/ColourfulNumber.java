import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ColourfulNumber {

    /*
     * Complete the 'isColourFul' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER number as parameter.
     */

    public static String isColourFul(int number) {
        int[] digits = split(number);
        
        List<List<Integer>> powersets = powerset(digits);        

        HashSet<Integer> colours = new HashSet<>();
        for(List<Integer> powerset: powersets) {
            if (powerset.isEmpty()) continue;
            
            Integer product = powerset.get(0);
            for(int i=1; i<powerset.size();i++) product *= powerset.get(i);
            
            if (!colours.add(product)) return "Not Colourful";
        }
        
        return "Colourful";
    }
    
    static int[] split(int number) {
        int[] digits = new int[String.valueOf(number).length()];
        
        for (int d = digits.length-1; d >= 0; d--) {
            digits[d] = number % 10;
            number = number / 10;
        }
        
        return digits;
    }
    
    /*
    [3, 2, 4, 5]
    [0][3]
    [1][2]
    [2][4]
    [3][5]
    [4][3,2]
    ...
    [5][2,4]
    ...
    [6][4,5]
    [7][3,2,4]
    [8][2,4,5]    
    */
    static List<List<Integer>> powerset(int[] digits) {
        List<List<Integer>> combinations = new ArrayList<>();
        boolean[] positions = new boolean[digits.length];
        
        pickup(positions, digits, combinations, 0);
        
        return combinations;
    }
    
    private static void pickup(boolean[] positions, int[] digits, List<List<Integer>> combinations, int index) {
        if (index == positions.length-1){            
            positions[index] = false;
            combinations.add(combination(positions, digits));            
            positions[index] = true;
            combinations.add(combination(positions, digits));
            return;
        }
        positions[index] = false;
        pickup(positions, digits, combinations, index+1);
        positions[index] = true;
        pickup(positions, digits, combinations, index+1);
    }
    
    private static List<Integer> combination(boolean[] positions, int[] digits) {
        List<Integer> combination = new ArrayList<>();
        for (int p = 0; p<positions.length; p++) {
            if (positions[p]) combination.add(digits[p]);
        }
        return combination;
    }
    
/*
    [3, 2, 4, 5]
    [_, _, _, _] 0 (56) call
    [f, _, _, _] 0 (67)
    [f, f, _, _] 1 (67)
    [f, f, _, _] 1 (68) call
    [f, f, f, _] 2 (67)
    [f, f, f, _] 2 (68) call
    [f, f, f, f] 3 (61) last    
    show           (62) -> {Empty}    
    [t, f, f, f] 3 (63) last
    show           (64) -> {3}
    
    [t, f, t, f] 2 (69)
    [t, f, t, f] 2 (70) call 
    [t, f, t, f] 3 (61) last
    show           (62) -> {3,4}
    [t, f, t, t] 3 (63) last
    show           (64) -> {3,4,5}
    
    [t, t, t, t] 1 (69)
    [t, t, t, t] 2 (70) call
    [t, t, f, t] 2 (67)
    [t, t, f, t] 3 (68) call
    [t, t, f, f] 3 (61) last
    show           (62) -> {3,2}
    [t, t, f, t] 3 (63) last
    show           (62) -> {3,2,5}
    
    [t, t, t, t] 2 (69)
    [t, t, t, t] 3 (70) call
    [t, t, t, f] 3 (61)
    show                -> {3,2,4}
    [t, t, t, t] 3 (63)
    show                -> {3,2,4,5}
    
    
*/

}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String result = ColourfulNumber.isColourFul(n);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
