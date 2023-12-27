package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(50, 50, 50, 50));
        hbox.setSpacing(30);
        hbox.setAlignment(Pos.CENTER);

        Button q = new Button("?");
        Button a = new Button("!");
        hbox.getChildren().addAll(q, a);

        layout.setTop(hbox);

        StackPane jokePane = createView("What do you call a bear with no teeth?");
        StackPane ansPane = createView("A gummy bear.");

        q.setOnAction((event) -> layout.setCenter(jokePane));
        a.setOnAction((event) -> layout.setCenter(ansPane));

        layout.setCenter(jokePane);
        // layout.setCenter(createView("Dad Joke Time!"));
        Scene scene = new Scene(layout);
        stage.setScene(scene);

        stage.show();
    }

    public StackPane createView(String text) {
        StackPane layout = new StackPane();
        layout.setPadding(new Insets(50, 50, 50, 50));
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);
        return layout;
    }
}
