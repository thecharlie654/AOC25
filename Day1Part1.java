import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1Part1 {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        
        int dialPosition = 50;
        int count = 0;

        try (Scanner reader = new Scanner(inputFile)) {
            while (reader.hasNext()) {
                String line = reader.nextLine();
                Character direction = line.charAt(0);
                int step = Integer.parseInt(line.substring(1));
                
                if (direction.equals('L')) {
                    step *= -1;
                }
                
                dialPosition += step;
                dialPosition %= 100;

                if (dialPosition == 0) {
                    count++;
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getStackTrace());
        }

        System.out.println(count);
    }
}
