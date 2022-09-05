package AdventOfCode;

import java.util.Arrays;

public class Day11 {

    String newPassword;
    char[] letters;

    public String getNextValidPassword(String currentPassword) {
        letters = currentPassword.toCharArray();

        do {
            newPassword = incrementPassword();
        } while(!passwordIsValid());

        return newPassword;
    }

    private String incrementPassword() {

        for(int i = letters.length - 1; i >= 0; i--) {
            if(letters[i] == 'z') {
                letters[i] = 'a';
            } else {
                letters[i]++;
                break;
            }
        }

        return Arrays.toString(letters);

    }

    public boolean passwordIsValid() {
        return containsThreeLetterIncreasingStraight() && !containsLettersIOL() && containsTwoDifferentNonOverlappingLetterPairs();
    }

    private boolean containsThreeLetterIncreasingStraight() {


        for(int i = 0; i < letters.length - 2; i++) {
            int currentLetter = Character.getNumericValue(letters[i]);
            int nextLetter = Character.getNumericValue(letters[i + 1]);
            int nextNextLetter = Character.getNumericValue(letters[i + 2]);

            if(currentLetter + 1 == nextLetter && nextLetter + 1 == nextNextLetter) {
                return true;
            }
        }

        return false;
    }

    private boolean containsLettersIOL() {

        for(Character letter : letters) {
            if(letter == 'i' || letter == 'o' || letter == 'l') {
                return true;
            }
        }

        return false;
    }

    private boolean containsTwoDifferentNonOverlappingLetterPairs() {
        char previousLetter = '#';
        char previousPairLetter = '#';
        char numOfPairs = 0;

        for(Character letter : letters) {
            if(letter == previousLetter && letter != previousPairLetter) {
                previousPairLetter = letter;
                numOfPairs++;
            }

            previousLetter = letter;
        }

        return numOfPairs >= 2;
    }
}
