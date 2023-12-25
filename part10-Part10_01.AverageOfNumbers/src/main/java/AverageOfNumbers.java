
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfNumbers {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        System.out.println("Input numbers, type \"end\" to stop.");
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            list.add(input);
        }

        double avg = list.stream()
                .mapToInt(Integer::valueOf)
                .average()
                .getAsDouble();

        System.out.println("average of the numbers: " + avg);

    }
}
