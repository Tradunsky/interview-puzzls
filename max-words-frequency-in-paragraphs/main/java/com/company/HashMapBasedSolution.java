package com.company;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HashMapBasedSolution {
    public static void printWordsInMaxParagragphs(String text) {
        Map<String, Map.Entry<Integer, Integer>> wordsFrequency = new HashMap<>();
        Pattern wordPattern = Pattern.compile(" ");

        try (Scanner textScanner = new Scanner(text)) {
            for (int paragraphNumber = 1; textScanner.hasNextLine(); paragraphNumber++) {
                String line = textScanner.nextLine();
                String[] wordsInParagraph = wordPattern.split(line);
                for (String word : wordsInParagraph) {
                    Map.Entry<Integer, Integer> paragraphWordFrequency = wordsFrequency.get(word);
                    if (paragraphWordFrequency == null)
                        wordsFrequency.put(word, new AbstractMap.SimpleEntry<>(paragraphNumber, 1));
                    else if (paragraphNumber != paragraphWordFrequency.getKey())
                        wordsFrequency.put(word, new AbstractMap.SimpleEntry<>(paragraphNumber, paragraphWordFrequency.getValue() + 1));
                }
            }
        }

        wordsFrequency.forEach((word, paragraphFrequency) ->
                System.out.printf("\"%s\" exists in %d paragraphs\n", word, paragraphFrequency.getValue()));
    }
}
