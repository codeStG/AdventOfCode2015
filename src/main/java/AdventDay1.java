public class AdventDay1 {

    public int getFloor(String input) {
        int currentFloor = 0;
        StringBuilder sb = new StringBuilder(input);

        for(int i = 0; i < sb.length(); i++) {

            if(sb.charAt(i) == ')') {
                currentFloor--;
            } else if(sb.charAt(i) == '(') {
                currentFloor++;
            } else {
                break;
            }

            if(currentFloor == -1) {
                return i + 1;
            }
        }

        return currentFloor;
    }
}
