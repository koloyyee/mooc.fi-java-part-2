
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

    }

    public static List<Book> readBooks(String file) {
        // List<Book> books = new ArrayList<>();
        try {
            return Files
                    .lines(Paths.get(file))
                    .map(line -> line.split(","))
                    .map(parts -> new Book(parts[0], Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), parts[3]))
                    .collect(Collectors.toList());
            // .forEach(line -> {
            // String[] info = line.split(",");
            // String name = info[0];
            // int releaseYear = Integer.valueOf(info[1]);
            // int pages = Integer.valueOf(info[2]);
            // String author = info[3];

            // Book book = new Book(name, releaseYear, pages, author);

            // books.add(book);
            // });

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        // return books;
        return new ArrayList<>();
    }
}
