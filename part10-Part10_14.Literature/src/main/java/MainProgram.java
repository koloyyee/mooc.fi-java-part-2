
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainProgram {

    public MainProgram() {
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Book> books = new ArrayList<>();

            while (scanner.hasNext()) {
                System.out.println("Input the name of the book, empty stops:");
                String title = scanner.nextLine();
                if (title.isEmpty()) {
                    break;
                }
                System.out.println("Input the age recommendation: ");
                int ageRecomm = Integer.parseInt(scanner.nextLine());

                books.add(new Book(title, ageRecomm));
            }
            System.out.println(books.size() + " books in total.");

            Comparator<Book> comparator = Comparator.comparing(Book::getAgeRecomm).thenComparing(Book::getTitle);

            Collections.sort(books, comparator);
            System.out.println("Books");
            books.stream().forEach(System.out::println);
        }
    }

}
