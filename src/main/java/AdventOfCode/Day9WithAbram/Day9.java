package AdventOfCode.Day9WithAbram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day9 {

    public static void main(String[] args) {
        Input input = Input.getInput();
        List<Integer> distances = new ArrayList<>();

        for(String city : input.getCities()) {
            TripSegment tripSegment = TripSegment.createTripSegment(city, input.getCities().stream().toList(), input.getDistances());

            distances.addAll(tripSegment.getDistances());

            System.out.println(Collections.max(distances));
        }
    }
}
