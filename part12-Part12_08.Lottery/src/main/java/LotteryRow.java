
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        // Implement the random number generation here
        // the method containsNumber is probably useful
        int hi = 40;
        int lo = 1;

        while (this.numbers.size() < 7) {
            int rand = new Random().nextInt(hi) + lo;
            if (!containsNumber(rand)) {
                numbers.add(rand);
            }
        }
    }

    public boolean containsNumber(int number) {
        // Check here whether the number is among the drawn numbers
        for (int num : numbers) {
            if (number == num) {
                return true;
            }
        }
        return false;
    }
}
