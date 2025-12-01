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
                System.out.println("Dial position: " + dialPosition);
                int countBefore = count;
                String line = reader.nextLine();
                System.out.println("Instruction: " + line);
                Character direction = line.charAt(0);
                int step = Integer.parseInt(line.substring(1));
                
                count += step / 100;

                if (direction.equals('L')) {
                    step *= -1;
                }
                
                int newDialPosition = dialPosition + step;

                if (step % 100 != 0) {
                    if (Math.abs(newDialPosition % 100) != newDialPosition && dialPosition != 0) {
                        count++;
                    } else if (newDialPosition == 0) {
                        count++;
                    }
                }

                while (newDialPosition < 0) {
                    newDialPosition += 100;
                }

                dialPosition = newDialPosition % 100;
                
                System.out.println("Passed zero " + (count - countBefore) + " times");
                System.out.println("Dial position: " + dialPosition);
                System.out.println();

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getStackTrace());
        }

        System.out.println(count);
    }
}
