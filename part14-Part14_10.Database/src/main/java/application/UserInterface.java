package application;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }

            // implement the functionality here
            switch (command) {
                case "1":
                    listTodos();
                    break;
                case "2":
                    addTodo();
                    break;
                case "3":
                    markAsDone();
                    break;
                case "4":
                    remove();
                    break;
                default:
                    break;
            }

        }

        System.out.println("Thank you!");
    }

    public void listTodos() {
        try {
            System.out.println("Listing the database contents");
            database.list().stream().forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Listing failed");
            e.printStackTrace();
        }
    }

    public void addTodo() {
        try {
            System.out.println("Add a new todo");
            System.out.println("Enter name");
            String name = scanner.nextLine();
            System.out.println("Enter description");
            String description = scanner.nextLine();
            Todo todo = new Todo(name, description, false);

            database.add(todo);
        } catch (SQLException e) {
            System.out.println("Adding failed.");
            e.printStackTrace();
        }
    }

    public void markAsDone() {
        System.out.println("Which todo should be marked as done (give the id)?");
        int id = Integer.parseInt(scanner.nextLine());
        try {
            database.markAsDone(id);
        } catch (SQLException e) {
            System.out.println("Failed to mark as done");
            e.printStackTrace();
        }
    }

    public void remove() {
        System.out.println("Which todo should be removed (give the id)?");
        int id = Integer.parseInt(scanner.nextLine());
        try {

            database.remove(id);
        } catch (SQLException e) {
            System.out.println("Failed to remove");
            e.printStackTrace();
        }
    }
}
