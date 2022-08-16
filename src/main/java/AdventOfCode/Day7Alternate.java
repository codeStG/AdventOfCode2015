package AdventOfCode;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Day7Alternate {
    private List<String> lines;
    private List<String> words;
    private HashMap<String, Integer> wires;

    public int getSignalToWireA(String input) {
        lines = new ArrayList<>(List.of(input.split("\n")));

        addWiresToList();

        for(int j = 0; j < lines.size(); j++) {
            for (String line : lines) {

                splitLineIntoWords(line);

                if (words.contains("AND") && Character.isDigit(words.get(0).charAt(0))) {
                    if (wires.get(words.get(2)) != null) {
                        performBitwiseAnd(words.get(0), words.get(2), words.get(4));
                    }
                } else if (words.contains("AND")) {
                    if (wires.get(words.get(0)) != null && wires.get(words.get(2)) != null) {
                        performBitwiseAnd(words.get(0), words.get(2), words.get(4));
                    }
                } else if (words.contains("OR")) {
                    if (wires.get(words.get(0)) != null && wires.get(words.get(2)) != null) {
                        performBitwiseOr(words.get(0), words.get(2), words.get(4));
                    }
                } else if (words.contains("NOT")) {
                    if (wires.get(words.get(1)) != null) {
                        performBitwiseNot(words.get(1), words.get(3));
                    }
                } else if (words.contains("LSHIFT")) {
                    if (wires.get(words.get(0)) != null) {
                        performBitwiseLShift(words.get(0), Integer.parseInt(words.get(2)), words.get(4));
                    }
                } else if (words.contains("RSHIFT")) {
                    if (wires.get(words.get(0)) != null) {
                        performBitwiseRShift(words.get(0), Integer.parseInt(words.get(2)), words.get(4));
                    }
                } else {
                    if (Character.isDigit(words.get(0).charAt(0))) {
                        wires.put(words.get(2), Integer.parseInt(words.get(0)));
                    } else if (wires.get(words.get(0)) != null) {
                        wires.put(words.get(2), wires.get(words.get(0)));
                    }
                }
            }
        }

        return wires.get("a");
    }

    private void splitLineIntoWords(String line) {
        words = new ArrayList<>();

        Collections.addAll(words, line.split(" "));
    }

    private void addWiresToList() {
        wires = new HashMap<>();

        for(String line : lines) {
            for(String word : line.split(" ")) {
                if (StringUtils.isAllLowerCase(word)) {
                    wires.put(word, null);
                }
            }
        }
    }

    private void performBitwiseAnd(String wireOne, String wireTwo, String wireToSet) {
        if (Character.isDigit(wireOne.charAt(0))) {
            int plainValue = Integer.parseInt(wireOne);
            int wireTwoSignal = wires.get(wireTwo);

            wires.put(wireToSet, plainValue & wireTwoSignal);
        } else {
            int wireOneSignal = wires.get(wireOne);
            int wireTwoSignal = wires.get(wireTwo);

            wires.put(wireToSet, wireOneSignal & wireTwoSignal);
        }
    }

    private void performBitwiseOr(String wireOne, String wireTwo, String wireToSet) {
        int wireOneSignal = wires.get(wireOne);
        int wireTwoSignal = wires.get(wireTwo);

        wires.put(wireToSet, wireOneSignal | wireTwoSignal);
    }

    private void performBitwiseNot(String wire, String wireToSet) {
        int wireSignal = wires.get(wire);
        int value = 65535 - Math.abs(~wireSignal) + 1;

        wires.put(wireToSet, value);
    }

    private void performBitwiseRShift(String wire, int value, String wireToSet) {
        int wireSignal = wires.get(wire);

        wires.put(wireToSet, wireSignal >> value);
    }

    private void performBitwiseLShift(String wire, int value, String wireToSet) {
        int wireSignal = wires.get(wire);

        wires.put(wireToSet, wireSignal << value);
    }
}
