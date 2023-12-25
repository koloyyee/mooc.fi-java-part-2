
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LiteracyComparison {

    public static void main(String[] args) {

        List<Nation> rows = read("literacy.csv");
        rows.stream().forEach(System.out::println);
    }

    public static List<Nation> read(String file) {
        List<Nation> nations = new ArrayList<>();
        try {

            Files
                    .lines(Paths.get(file))
                    .map(el -> el.split(","))
                    .map(line -> {
                        String sex = line[2].trim().split(" ")[0];
                        return new Nation(line[3], Integer.valueOf(line[4]), sex, Double.valueOf(line[5]));
                    }).forEach(nation -> nations.add(nation));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return nations.stream().sorted().collect(Collectors.toList());
    }

}
