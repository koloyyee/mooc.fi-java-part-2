package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();

        HBox bottom = hbox(0, 0, "");

        layout.setCenter(new TextArea());
        layout.setBottom(bottom);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }

    public HBox hbox(int wordsCount, int lettersCount, String longest) {
        HBox hbox = new HBox();
        hbox.getChildren().add(new Label("Letters: " + lettersCount));
        hbox.getChildren().add(new Label("Words: " + wordsCount));
        hbox.getChildren().add(new Label("The longest word is: " + longest));

        return hbox;
    }

}
