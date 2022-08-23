package AdventOfCode.Day9WithAbram;

import java.util.*;

public class TripSegment {

    TripSegment parent;
    String name;
    List<TripSegment> children = new ArrayList<>();
    Integer distance = 0;

    private TripSegment() {

    }

    public static TripSegment createTripSegment(String name, List<String> destinations, Map<String, Integer> distances) {
        return createTripSegment(null, name, destinations, distances);
    }

    private static TripSegment createTripSegment(TripSegment parent, String name, List<String> destinations, Map<String, Integer> distances) {
        TripSegment tripSegment = new TripSegment();
        List<String> destinationsCopy = new ArrayList<>(destinations.stream().toList());
        destinationsCopy.remove(name);

        if(parent != null) {
            tripSegment.distance = distances.get(name + " -> " + parent.name);
        }

        tripSegment.parent = parent;
        tripSegment.name = name;

        for(String destination : destinationsCopy) {
            tripSegment.children.add(createTripSegment(tripSegment, destination, destinationsCopy, distances));
        }

        return tripSegment;
    }

    public List<Integer> getDistances() {
        List<Integer> distances = new ArrayList<>();

        if(children.size() == 0) {
            distances.add(distance);
        } else {
            for(TripSegment child : children) {
                List<Integer> childDistances = child.getDistances();

                for(Integer childDistance : childDistances) {
                    distances.add(distance + childDistance);
                }
            }
        }

        return distances;
    }
}
