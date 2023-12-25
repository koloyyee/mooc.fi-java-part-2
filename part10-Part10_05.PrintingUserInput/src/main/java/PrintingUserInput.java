
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> inputs = new ArrayList<>();
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.equals(" ")
                    || input.equals("")) {
                break;
            }
            inputs.add(input);
        }
        String outputs = inputs.stream().reduce("", (prev, curr) -> prev + curr + "\n");
        System.out.println(outputs);
        scanner.close();
    }
}
