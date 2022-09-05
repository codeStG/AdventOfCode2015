import AdventOfCode.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScratchPaper {

    public static void main(String[] args) {
        Day11 test = new Day11();
//        File file = new File("C:\\Users\\getorres.CORPORATE\\Documents\\gitProjects\\AdventOfCode2015\\src\\main\\java\\AdventOfCode\\Day8Input");
//
//        try {
//            Scanner scanner = new Scanner(file);
//
//            while(scanner.hasNextLine()) {
//                test.calculateEscapeChars(scanner.nextLine());
//            }
//        } catch(FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(test.getTotalChars());

        System.out.println(test.getNextValidPassword("cqjxxyzz"));
    }
}
