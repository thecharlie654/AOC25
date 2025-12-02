import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2Part2 {
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

                    for (int j = 1; j <= (iAsString.length() / 2); j++) {
                        String stringElements = "";
                        String stringElement = iAsString.substring(0, j);
                        while (stringElements.length() < iAsString.length()) {
                            stringElements += stringElement;
                        }
                        if (stringElements.equals(iAsString)) {
                            total += i;
                            break;
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
