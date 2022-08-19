package AdventOfCode;

public class Day8Part2 {
    private int totalChars = 0;

    public void calculateEscapeChars(String input) {
        char[] characters = input.toCharArray();
        boolean justFound = false;
        totalChars += 4;

        for(int i = 0; i < characters.length; i ++) {
            totalChars++;

            if(justFound) {
                justFound = false;
            } else {
                if (characters[i] == '\\' && (characters[i + 1] == '\\')) {
                    totalChars += 2;
                    justFound = true;
                } else if(characters[i] == '\\' && characters[i + 1] == '\"') {
                    totalChars += 2;
                } else if (characters[i] == '\\' && characters[i + 1] == 'x') {
                    totalChars++;
                }
            }
        }
    }

    public int getTotalChars() {
        return totalChars;
    }
}
