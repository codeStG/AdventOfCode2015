package AdventOfCode;

public class Day10 {

    public String getSpokenValue(String input, int numOfTimesToRun) {
        char[] characters = input.toCharArray();
        StringBuilder spokenValue = new StringBuilder();

        for(int j = 0; j < numOfTimesToRun; j++) {
            int count = 1;
            char previousChar = '0';
            spokenValue = new StringBuilder();

            for(int i = 0; i < characters.length; i++) {
                if (characters[i] == previousChar) {
                    count++;
                } else {
                    if (previousChar != '0') {
                        spokenValue.append(count).append(previousChar);
                    }
                    previousChar = characters[i];
                    count = 1;

                    if (i == characters.length - 1 && characters[i] != characters[i - 1]) {
                        spokenValue.append(count).append(previousChar);
                    }
                }
            }

            characters = spokenValue.toString().toCharArray();
        }

        return String.valueOf(spokenValue.length());
    }
}
