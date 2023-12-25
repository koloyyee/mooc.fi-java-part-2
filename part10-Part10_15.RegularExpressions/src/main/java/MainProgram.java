import java.util.ArrayList;

public class MainProgram {

    public static void main(String[] args) {
        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise
        ArrayList<String> words = new ArrayList<>();
        words.add("first");
        words.add("second");
        words.add("third");

        StringBuilder connectedString = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            connectedString.append(words.get(i));
        }
        System.out.println(connectedString.toString());

    }
}
