package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BorderPaneApplication extends Application {

    public static void main(String[] args) {
        launch(BorderPaneApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();
        layout.setTop(new Label("NORTH"));
        layout.setLeft(new Label("WEST"));
        layout.setRight(new Label("EAST"));
        layout.setBottom(new Label("SOUTH"));
        layout.setCenter(new Label("CENTER"));

        HBox hBox = hBox();
        VBox vBox = vBox();
        GridPane grid = grid(5);

        layout.setCenter(new TextArea());
        layout.setCenter(grid);
        layout.setTop(hBox);
        layout.setLeft(vBox);

        Scene scene = new Scene(layout);
        // Scene hBoxScene = new Scene(hBox);
        // Scene vBoxScene = new Scene(vBox);
        // Scene gridScene = new Scene(grid);

        stage.setScene(scene);
        // stage.setScene(hBoxScene);
        // stage.setScene(vBoxScene);
        // stage.setScene(gridScene);
        stage.show();

        // example(stage);

    }

    public HBox hBox() {
        HBox layout = new HBox();
        layout.setSpacing(10);
        layout.getChildren().add(new Label("first"));
        layout.getChildren().add(new Label("second"));
        layout.getChildren().add(new Label("third"));

        return layout;

    }

    public VBox vBox() {
        VBox layout = new VBox();
        layout.setSpacing(10);
        layout.getChildren().add(new Label("top"));
        layout.getChildren().add(new Label("mid"));
        layout.getChildren().add(new Label("bottom"));

        return layout;

    }

    public GridPane grid(int size) {
        GridPane layout = new GridPane();

        for (int x = 1; x <= size; x++) {
            for (int y = 1; y <= size; y++) {
                layout.add(new Button("" + x + "-" + y), x, y);
            }
        }
        return layout;
    }

    public void example(Stage window) {
        BorderPane layout = new BorderPane();

        HBox buttons = new HBox();
        buttons.setSpacing(10);
        buttons.getChildren().add(new Button("First"));
        buttons.getChildren().add(new Button("Second"));
        buttons.getChildren().add(new Button("Third"));

        VBox texts = new VBox();
        texts.setSpacing(10);
        texts.getChildren().add(new Label("First"));
        texts.getChildren().add(new Label("Second"));
        texts.getChildren().add(new Label("Third"));

        layout.setTop(buttons);
        layout.setLeft(texts);

        layout.setCenter(new TextArea(""));

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }
}
