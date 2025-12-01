import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1Part2 {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        
        int dialPosition = 50;
        int count = 0;

        try (Scanner reader = new Scanner(inputFile)) {
            while (reader.hasNext()) {

                String line = reader.nextLine();
                Character direction = line.charAt(0);
                int step = Integer.parseInt(line.substring(1));

                int modifier;
                if (direction == 'L') {
                    modifier = -1;
                } else {
                    modifier = 1;
                }

                for (int i = 0; i < step; i++) {
                    dialPosition += modifier;
                    if (dialPosition < 0) {
                        dialPosition += 100;
                    } else if (dialPosition >= 100) {
                        dialPosition -= 100;
                    }
                    if (dialPosition == 0) {
                        count++;
                    }
                }
                
            }
            
            System.out.println(count);

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
        }
    }
}
