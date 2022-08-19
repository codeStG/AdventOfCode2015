package AdventOfCode;

public class Day8 {
    private int escapeChars = 0;
    private int totalChars = 0;

    public void calculateEscapeChars(String input) {
        char[] characters = input.toCharArray();
        boolean justFound = false;
        escapeChars += 2;

        for(int i = 0; i < characters.length; i ++) {
            totalChars++;
            if(justFound) {
                justFound = false;
            } else {
                if (characters[i] == '\\' && (characters[i + 1] == '\\')) {
                    escapeChars++;
                    justFound = true;
                } else if(characters[i] == '\\' && characters[i + 1] == '\"') {
                    escapeChars++;
                } else if (characters[i] == '\\' && characters[i + 1] == 'x') {
                    escapeChars += 3;
                }
            }
        }
    }

    public int getEscapeChars() {
        return escapeChars;
    }

    public int getTotalChars() {
        return totalChars;
    }
}
