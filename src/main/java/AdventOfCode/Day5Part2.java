package AdventOfCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5Part2 {
    List<String> lines = new ArrayList<>();
    int numOfNiceStrings = 0;

    public int determineWhoIsNice(String input) {
        lines = Arrays.asList(input.split("\n"));

        for(String line : lines) {
            if(containsPairOfTwoLettersThatAppearTwiceWithoutOverlap(line) && containsOneLetterRepeatingWithOneLetterBetween(line)) {
                numOfNiceStrings++;
            }
        }

        return numOfNiceStrings;
    }

    private boolean containsPairOfTwoLettersThatAppearTwiceWithoutOverlap(String line) {
        char[] characters = line.toCharArray();

        //May need to add -1
        for(int i = 0; i < line.length(); i++) {
            String previousPair;

            if(i + 1 != line.length()) {
                previousPair = characters[i] + String.valueOf(characters[i + 1]);
            } else {
                previousPair = String.valueOf(characters[i]);
            }

            for(int j = i + 2; j < line.length() - 1; j++) {

                String currentPair = characters[j] + String.valueOf(characters[j + 1]);

                if(previousPair.equals(currentPair)) {
                    return true;
                }

            }
        }
        return false;
    }

    private boolean containsOneLetterRepeatingWithOneLetterBetween(String line) {
        char[] characters = line.toCharArray();
        String previousLetter = String.valueOf(characters[0]);

        for(int i = 1; i < line.length() - 1; i++) {
            String letterTwoIndexesUp = String.valueOf(characters[i + 1]);

            if(previousLetter.equals(letterTwoIndexesUp)) {
                return true;
            } else {
                previousLetter = String.valueOf(characters[i]);
            }
        }
        return false;
    }
}
