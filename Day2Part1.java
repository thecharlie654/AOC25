import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2Part1 {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");

        long total = 0;

        try (Scanner reader = new Scanner(inputFile)) {
            reader.useDelimiter(",");
            while (reader.hasNext()) {
                String range = reader.next();
                int hyphenIndex = range.indexOf("-");
                long rangeStart = Long.parseLong(range.substring(0, hyphenIndex));
                long rangeEnd = Long.parseLong(range.substring(hyphenIndex + 1));
                
                for (long i = rangeStart; i <= rangeEnd; i++) {
                    String iAsString = Long.toString(i);
                    if (iAsString.length() % 2 == 0) {
                        int halfLength = iAsString.length() / 2;
                        String firstHalf = iAsString.substring(0, halfLength);
                        String secondHalf = iAsString.substring(halfLength);
                        
                        if (firstHalf.equals(secondHalf)) {
                            // System.out.println("Found invalid ID: " + iAsString);
                            total += i;
                        }
                    }
                }
            }
            System.out.println(total);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
        }

    }
}
