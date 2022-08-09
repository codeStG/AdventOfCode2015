import java.util.ArrayList;
import java.util.List;

public class AdventDay3Part2Refactored {
    private final List<List<Integer>> houses = new ArrayList<>();
    private int xIndex = 0;
    private int yIndex = 0;
    private int currentHouseXVal = 0;
    private int currentHouseYVal = 0;

    public int getHousesVisited(String input) {
        int value;

        initializeListOfHouses();
        deliverInitialGift();

        for(int i = 0; i < input.length(); i++) {
            setNewIndex(input.charAt(i));

            setCurrentHouseXVal(xIndex);
            setCurrentHouseYVal(yIndex);

            value = houses.get(currentHouseXVal).get(currentHouseYVal);
            houses.get(currentHouseXVal).set(currentHouseYVal, value + 1);
        }

        return calculateHousesGifted();
    }

    private int calculateHousesGifted() {
        int count = 0;

        for(List<Integer> row : houses) {
            for(int num : row) {
                if(num > 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private void initializeListOfHouses() {
        houses.clear();

        for(int i = 0; i < 1000; i++) {
            houses.add(new ArrayList<>());
            houses.get(i).add(0);
        }

        for(int i = 0; i < houses.size(); i++) {
            for(int j = 0; j < houses.size(); j++) {
                houses.get(i).add(j, 0);
            }
        }
    }

    private void deliverInitialGift() {
        houses.get(0).add(0, 1);
    }

    private void setNewIndex(char character) {
        switch (character) {
            case '^' -> yIndex++;
            case '>' -> xIndex++;
            case 'v' -> yIndex--;
            case '<' -> xIndex--;
        }
    }

    public void setCurrentHouseXVal(int currentHouseXVal) {
        if(currentHouseXVal < 0) {
            this.currentHouseXVal = houses.size() - Math.abs(currentHouseXVal);
        } else {
            this.currentHouseXVal = currentHouseXVal;
        }
    }

    public void setCurrentHouseYVal(int currentHouseYVal) {
        if(currentHouseYVal < 0) {
            this.currentHouseYVal = houses.size() - Math.abs(currentHouseYVal);
        } else {
            this.currentHouseYVal = currentHouseYVal;
        }
    }
}