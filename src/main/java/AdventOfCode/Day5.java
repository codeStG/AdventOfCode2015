package AdventOfCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5 {
    String[] forbiddenStrings = {"ab", "cd", "pq", "xy"};
    List<String> lines = new ArrayList<>();
    int numOfNiceStrings = 0;

    public int determineWhoIsNice(String input) {
        lines = Arrays.asList(input.split("\n"));

        for(String line : lines) {
            if(containsAtLeastThreeVowels(line) && containsOneLetterAppearingTwiceInARow(line) && !containsForbiddenString(line, forbiddenStrings)) {
                numOfNiceStrings++;
            }
        }

        return numOfNiceStrings;
    }

    private boolean containsAtLeastThreeVowels(String line) {
        int vowels = 0;
        char[] characters = line.toCharArray();

        for(char character : line.toCharArray()) {
            switch (character) {
                case 'a', 'e', 'i', 'o', 'u' -> vowels++;
            }
        }

        return vowels >= 3;
    }

    private boolean containsOneLetterAppearingTwiceInARow(String line) {
        char previousLetter = line.charAt(0);
        boolean containsTwoLettersInARow = false;

        for(int i = 1; i < line.length(); i++) {
            if(line.charAt(i) == previousLetter) {
                containsTwoLettersInARow = true;
                break;
            } else {
                previousLetter = line.charAt(i);
            }
        }
        return containsTwoLettersInARow;
    }

    private boolean containsForbiddenString(String line, String[] forbiddenStrings) {
        char previousLetter = line.charAt(0);
        boolean containsForbiddenString = false;

        for(int i = 1; i < line.length(); i++) {
            for (String forbiddenString : forbiddenStrings) {
                String letterPair = String.valueOf(previousLetter) + String.valueOf(line.charAt(i));

                if (letterPair.equals(forbiddenString)) {
                    containsForbiddenString = true;
                    break;
                }
            }
            previousLetter = line.charAt(i);
        }

        return containsForbiddenString;
    }
}
