import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdventDay3 {

    public int getHousesVisited(String input) {
        List<List<Integer>> houses = new ArrayList<>();

        int xIndex = 0;
        int yIndex = 0;
        int currentHouseXVal;
        int currentHouseYVal;
        int housesGifted = 0;
        int value;

        for(int i = 0; i < 1000; i++) {
            houses.add(new ArrayList<>());
            houses.get(i).add(0);
        }

        for(int i = 0; i < houses.size(); i++) {
            for(int j = 0; j < houses.size(); j++) {
                houses.get(i).add(j, 0);
            }
        }

        houses.get(0).add(0, 1);

        for(int i = 0; i < input.length(); i++) {

            switch (input.charAt(i)) {
                case '^' -> yIndex++;
                case '>' -> xIndex++;
                case 'v' -> yIndex--;
                case '<' -> xIndex--;
            }

            currentHouseXVal = xIndex;
            currentHouseYVal = yIndex;

            if(xIndex < 0) {
                currentHouseXVal = houses.size() - Math.abs(xIndex);
            }

            if(yIndex < 0) {
                currentHouseYVal = houses.size() - Math.abs(yIndex);
            }

            value = houses.get(currentHouseXVal).get(currentHouseYVal);
            houses.get(currentHouseXVal).set(currentHouseYVal, value + 1);
        }

        for(List<Integer> row : houses) {
            for(int num : row) {
                if(num > 0) {
                    housesGifted++;
                }
            }
        }

        return housesGifted;
    }


}
