package AdventOfCode;

import java.util.HashMap;

public class Day3AbramStyle {
    private final HashMap<Integer, HashMap<Integer, Integer>> neighborhood = new HashMap<>();

    public int visitHouses(String input) {
        int yIndex = 0;
        int xIndex = 0;

        deliverTo(xIndex, yIndex);

        for(char c : input.toCharArray()) {
            switch (c) {
                case '^' -> yIndex++;
                case '>' -> xIndex++;
                case 'v' -> yIndex--;
                case '<' -> xIndex--;
            }

            deliverTo(xIndex, yIndex);
        }

        return getHousesGifted();
    }

    private void deliverTo(int x, int y) {
        if(!neighborhood.containsKey(x)) {
            neighborhood.put(x, new HashMap<>());
        }

        if(!neighborhood.get(x).containsKey(y)) {
            neighborhood.get(x).put(y, 0);
        }

        neighborhood.get(x).put(y, neighborhood.get(x).get(y) + 1);
    }

    private int getHousesGifted() {
        int housesGifted = 0;

        for(var row : neighborhood.values()) {
            for(var num : row.values()) {
                if(num > 0) {
                    housesGifted++;
                }
            }
        }

        return housesGifted;
    }
}
