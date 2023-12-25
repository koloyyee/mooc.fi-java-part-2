
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // test your method here

    }

    public static int sum(int[] array, int fromWhere, int toWhere, int smallest, int largest) {

        final int from = fromWhere > 0 ? fromWhere : 0;
        final int to = toWhere > array.length ? array.length : toWhere;
        int sum = 0;
        for (int i = from; i < to; i++) {
            if (array[i] >= smallest && array[i] <= largest) {
                sum += array[i];
            }
        }
        return sum;
    }
}
