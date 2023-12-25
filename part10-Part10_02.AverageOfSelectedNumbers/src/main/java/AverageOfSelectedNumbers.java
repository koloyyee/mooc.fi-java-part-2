
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        List<Integer> list = new ArrayList<>();
        System.out.println("When input equals:");
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            list.add(Integer.valueOf(input));
        }
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String pick = scanner.nextLine();
        boolean isN = pick.equalsIgnoreCase("n");
        Predicate<Integer> pos = el -> el > 0;
        Predicate<Integer> neg = el -> el < 0;
        String template = String.format("Average of the %s numbers: ", isN ? "negative" : "positive");

        double result = list.stream().filter(isN ? neg : pos).mapToDouble(Double::valueOf)
                .average().getAsDouble();
        System.out.println(template + result);
        scanner.close();
    }

}
