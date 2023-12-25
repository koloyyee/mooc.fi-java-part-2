
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here
        List<Integer> list = new ArrayList<>();
        System.out.println("When input equals:");
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            list.add(Integer.valueOf(input));
        }
        List<Integer> pos = positive(list);
        System.out.println(pos.toString());
        scanner.close();
    }

    public static List<Integer> positive(List<Integer> numbers) {
        List<Integer> pos = numbers.stream().filter(el -> el > 0)
                .collect(Collectors.toCollection(ArrayList::new))
        // .collect(Collectors.toList())
        ;
        return pos;
    }

}
