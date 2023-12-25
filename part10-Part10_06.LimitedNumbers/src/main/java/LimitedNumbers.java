
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        while (scanner.hasNext()) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input < 0) {
                break;
            }
            numbers.add(input);
        }
        Predicate<Integer> p = el -> el > 0 && el < 6;
        // String printable = numbers
        // .stream()
        // .filter(p)
        // .map(el -> String.valueOf(el))
        // .reduce("", (prev, curr) -> prev + curr + "\n");
        // System.out.println(printable);

        numbers.stream().filter(p).forEach(System.out::println);

        scanner.close();
    }
}
