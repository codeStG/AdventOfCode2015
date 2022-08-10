package AdventOfCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day2 {
    private List<Integer> currentDimensions;

    public int getSqFtNeeded(String input) {
        String[] allDimensions = input.split("\\n");
        int totalSqFt = 0;
        int totalRibbonSqFt = 0;

        for (String rawDimension : allDimensions) {
            setCurrentDimensions(rawDimension);
            currentDimensions.sort(Comparator.naturalOrder());

            totalSqFt += getBoxArea() + getAreaOfSmallestSide();
            totalRibbonSqFt += getRibbonBaseSqFt() + getRibbonBowSqFt();
        }

        return totalRibbonSqFt;
    }

    private int getRibbonBowSqFt() {
        int l = currentDimensions.get(0);
        int w = currentDimensions.get(1);
        int h = currentDimensions.get(2);

        return l*h*w;
    }

    private int getRibbonBaseSqFt() {
        int firstSide = currentDimensions.get(0);
        int secondSide = currentDimensions.get(1);

        return firstSide*2 + secondSide*2;
    }

    private void setCurrentDimensions(String rawDimension) {
        currentDimensions = new ArrayList<>();

        for(String num : rawDimension.split("x")) {
            currentDimensions.add(Integer.parseInt(num));
        }
    }

    private int getBoxArea() {
        int l = currentDimensions.get(0);
        int w = currentDimensions.get(1);
        int h = currentDimensions.get(2);

        return 2*l*w + 2*w*h + 2*h*l;
    }

    private int getAreaOfSmallestSide() {
        return currentDimensions.get(0) * currentDimensions.get(1);
    }
}
