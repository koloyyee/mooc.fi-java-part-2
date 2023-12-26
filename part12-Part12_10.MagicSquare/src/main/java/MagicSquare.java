
import java.util.ArrayList;
import java.util.Collections;

public class MagicSquare {

    private int[][] square;

    // ready constructor
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }

        this.square = new int[size][size];
    }

    // implement these three methods
    public ArrayList<Integer> sumsOfRows() {
        ArrayList<Integer> sums = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            int sum = 0;
            for (int col = 0; col < square[row].length; col++) {
                sum += square[row][col];
            }
            sums.add(sum);
        }
        return sums;
    }

    public ArrayList<Integer> sumsOfColumns() {

        ArrayList<Integer> sums = new ArrayList<>();
        /*
         * 8 0 8
         * 0 1 1
         * 0 1 8
         *
         * s[0][0]:8 + s[1][0]:0 + s[2][0]:0 = 8
         * s[0][1]:0 + s[1][1]:1 + s[2][1]:1 = 2
         * s[0][2]:8 + s[1][2]:1 + s[2][2]:8 = 17
         */

        for (int row = 0; row < square.length; row++) {
            int sum = 0;
            for (int col = 0; col < square[row].length; col++) {
                // System.out.printf("square[%s][%s]:%d%n", col, row, square[col][row]);
                sum += square[col][row];
            }
            sums.add(sum);
        }
        return sums;
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        ArrayList<Integer> sums = new ArrayList<>();
        /*
         * 8 0 8
         * 0 1 1
         * 0 1 8
         *
         * s[0][0]:8 + s[1][1]:1 + s[2][2]:8 = 17
         * s[2][0]:0 + s[1][1]:1 + s[0][2]:8 = 9
         */
        int startTop = 0;
        for (int row = 0; row < square.length; row++) {
            // System.out.printf("square[%s][%s]:%d%n", row, row, square[row][row]);
            startTop += square[row][row];
        }
        // System.out.println("startTop " + startTop);

        sums.add(startTop);

        int startBottom = 0;
        for (int row = square.length - 1; row >= 0; row--) {
            // System.out.printf("square[%s][%s]:%d%n", row, (square.length - 1 - row),
            // square[row][square.length - 1 - row]);
            startBottom += square[row][square.length - 1 - row];
        }
        sums.add(startBottom);
        return sums;
    }

    // ready-made helper methods -- don't touch these
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return -1;
        }

        return this.square[y][x];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
