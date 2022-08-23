package AdventOfCode.Day9WithAbram;

import java.io.File;
import java.util.*;

public class Input {

    private Map<String, Integer> distances = new HashMap<>();
    private Set<String> cities = new HashSet<>();

    private Input() {

    }

    public static Input getInput() {
        File file = new File("C:\\Users\\getorres.CORPORATE\\Documents\\gitProjects\\AdventOfCode2015\\src\\main\\java\\AdventOfCode\\Input\\Day9Input");
        Scanner scanner;

        Input input = new Input();

        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String[] words = scanner.nextLine().split(" ");

                input.distances.put(words[0] + " -> " + words[2], Integer.parseInt(words[4]));
                input.distances.put(words[2] + " -> " + words[0], Integer.parseInt(words[4]));

                input.cities.add(words[0]);
                input.cities.add(words[2]);
            }

        } catch (Exception ignored) {

        }

        return input;
    }

    public Map<String, Integer> getDistances() {
        return distances;
    }

    public Set<String> getCities() {
        return cities;
    }
}
