package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button firstBtn = new Button("To the first view!");
        Button secondBtn = new Button("To the second view!");
        Button thirdBtn = new Button("To the third view!");

        BorderPane layout = new BorderPane();
        VBox vbox = new VBox();
        GridPane grid = new GridPane();

        layout.setTop(new Label("First View!"));
        layout.setCenter(secondBtn);

        vbox.getChildren().add(thirdBtn);
        vbox.getChildren().add(new Label("Second view!"));
        // vbox.getChildren().add(secondBtn);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (i == 0 && j == 0) {
                    grid.getChildren().add(new Label("Third View!"));
                } else if (i == 1 && j == 1) {
                    grid.getChildren().add(firstBtn);
                }
            }
        }

        Scene first = new Scene(layout);
        Scene second = new Scene(vbox);
        Scene third = new Scene(grid);

        firstBtn.setOnAction((event) -> stage.setScene(first));
        secondBtn.setOnAction((event) -> stage.setScene(second));
        thirdBtn.setOnAction((event) -> stage.setScene(third));

        stage.setScene(first);
        stage.show();
    }

}
