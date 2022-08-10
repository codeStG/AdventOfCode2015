package AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class Day3Part2 {

    public int getHousesVisited(String input) {
        List<List<Integer>> houses = new ArrayList<>();
        int xSantaIndex = 0;
        int ySantaIndex = 0;
        int xRoboIndex = 0;
        int yRoboIndex = 0;
        int santaHouseXVal = 0;
        int santaHouseYVal = 0;
        int roboHouseXVal = 0;
        int roboHouseYVal = 0;
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

            if(i % 2 == 0) {
                switch (input.charAt(i)) {
                    case '^' -> ySantaIndex++;
                    case '>' -> xSantaIndex++;
                    case 'v' -> ySantaIndex--;
                    case '<' -> xSantaIndex--;
                }

                santaHouseXVal = xSantaIndex;
                santaHouseYVal = ySantaIndex;

                if(xSantaIndex < 0) {
                    santaHouseXVal = houses.size() - Math.abs(xSantaIndex);
                }

                if(ySantaIndex < 0) {
                    santaHouseYVal = houses.size() - Math.abs(ySantaIndex);
                }

                value = houses.get(santaHouseXVal).get(santaHouseYVal);
                houses.get(santaHouseXVal).set(santaHouseYVal, value + 1);
            } else {
                switch (input.charAt(i)) {
                    case '^' -> yRoboIndex++;
                    case '>' -> xRoboIndex++;
                    case 'v' -> yRoboIndex--;
                    case '<' -> xRoboIndex--;
                }

                roboHouseXVal = xRoboIndex;
                roboHouseYVal = yRoboIndex;

                if(xRoboIndex < 0) {
                    roboHouseXVal = houses.size() - Math.abs(xRoboIndex);
                }

                if(yRoboIndex < 0) {
                    roboHouseYVal = houses.size() - Math.abs(yRoboIndex);
                }

                value = houses.get(roboHouseXVal).get(roboHouseYVal);
                houses.get(roboHouseXVal).set(roboHouseYVal, value + 1);
            }
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
