package title;

import java.util.Scanner;

import javafx.application.Application;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("May I have your title, please? ");
        final String title = scanner.nextLine();
        if (!title.isEmpty()) {
            Application.launch(UserTitle.class, "--title=" + title);
        }

        scanner.close();

    }

}
