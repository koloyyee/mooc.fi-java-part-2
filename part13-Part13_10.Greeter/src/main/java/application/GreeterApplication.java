package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Label instruction = new Label("Enter your and start");
        Button startBtn = new Button("Start");
        TextField textField = new TextField();
        Label errorMsg = new Label();

        Label username = new Label();

        GridPane loginPane = new GridPane();

        loginPane.add(instruction, 0, 0);
        loginPane.add(textField, 0, 1);
        loginPane.add(startBtn, 0, 2);
        loginPane.add(errorMsg, 0, 3);
        loginPane.setPrefSize(300, 180);
        loginPane.setPadding(new Insets(20, 20, 20, 20));

        Scene loginScene = new Scene(loginPane);

        BorderPane welcomePane = new BorderPane();
        welcomePane.setPrefSize(300, 180);
        welcomePane.setPadding(new Insets(20, 20, 20, 20));
        Scene welcomeScene = new Scene(welcomePane);

        startBtn.setOnAction((event) -> {
            if (textField.getText().isEmpty()) {
                errorMsg.setText("Cannot be empty");
            } else {
                username.setText("Welcome " + textField.getText() + "!");
                welcomePane.setCenter(username);
                stage.setScene(welcomeScene);
            }

        });
        stage.setScene(loginScene);
        stage.show();
    }

}
