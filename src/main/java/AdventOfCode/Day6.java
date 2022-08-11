package AdventOfCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Day6 {
    private List<String> lines;
    private List<String> words;
    private final HashMap<Integer, HashMap<Integer, Boolean>> grid = new HashMap<>();
    private int xStart = 0;
    private int yStart = 0;
    private int xEnd = 0;
    private int yEnd = 0;

    public int getNumberOfLightsLit(String input) {
        lines = new ArrayList<>(List.of(input.split("\n")));

        splitLinesIntoWords();

        words.removeIf(word -> word.equals("turn") || word.equals("through"));

        createGridOfLights();

        for(int i = 0; i < words.size(); i += 3) {
            setCoordinates(i);

            if(words.get(i).contains("toggle")) {
                toggleLights();
            }

            if(words.get(i).contains("on")) {
                turnOnLight();
            }

            if(words.get(i).contains("off")) {
                turnOffLights();
            }
        }

        return getNumberOfLightsOn();
    }

    private void splitLinesIntoWords() {
        words = new ArrayList<>();

        for(String line : lines) {
            words.addAll(List.of(line.split(" ")));
        }
    }

    private void createGridOfLights() {
        for(int x = 0; x < 1000; x++) {
            for(int y = 0; y < 1000; y++) {
                if(!grid.containsKey(x)) {
                    grid.put(x, new HashMap<>());
                }

                if(!grid.get(x).containsKey(y)) {
                    grid.get(x).put(y, false);
                }
            }
        }
    }

    private void setCoordinates(int i) {
        List<String> startingCoordinateStrings = Arrays.asList(words.get(i + 1).split(","));
        List<String> endingCoordinateStrings = Arrays.asList(words.get(i + 2).split(","));

        List<String> coordinates = Stream.concat(startingCoordinateStrings.stream(), endingCoordinateStrings.stream()).toList();

        xStart = Integer.parseInt(coordinates.get(0));
        yStart = Integer.parseInt(coordinates.get(1));
        xEnd = Integer.parseInt(coordinates.get(2));
        yEnd = Integer.parseInt(coordinates.get(3));
    }

    private void toggleLights() {
        for(int i = xStart; i <= xEnd; i++) {
            for(int j = yStart; j <= yEnd; j++) {
                grid.get(i).put(j, !grid.get(i).get(j));
            }
        }
    }

    private void turnOnLight() {
        for(int i = xStart; i <= xEnd; i++) {
            for(int j = yStart; j <= yEnd; j++) {
                grid.get(i).put(j, true);
            }
        }
    }

    private void turnOffLights() {
        for(int i = xStart; i <= xEnd; i++) {
            for(int j = yStart; j <= yEnd; j++) {
                grid.get(i).put(j, false);
            }
        }
    }

    private int getNumberOfLightsOn() {
        int numOfLightsOn = 0;

        for(int x = 0; x < 1000; x++) {
          for(int y = 0; y < 1000; y++) {
              if(grid.get(x).get(y).equals(true)) {
                  numOfLightsOn++;
              }
          }
        }
        return numOfLightsOn;
    }
}
