package textstatistics;

import java.util.Arrays;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
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

        TextArea ta = new TextArea();
        Label wordLabel = new Label("Words: " + 0);
        Label letterLabel = new Label("Letters: " + 0);
        Label longestLabel = new Label("The longest word is: ");

        ta.textProperty().addListener((ObservableValue<? extends String> change, String oldValue, String newValue) -> {
            // System.out.println(oldValue + " -> " + newValue);
            String[] words = newValue.split(" ");
            int lettersCount = newValue.length();
            letterLabel.setText("Letters: " + lettersCount);

            int wordsCount = words.length;
            wordLabel.setText("Words: " + wordsCount);

            String longest = Arrays.stream(words)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            longestLabel.setText("The longest word is: " + longest);

        });

        HBox bottom = hbox(letterLabel, wordLabel, longestLabel);
        layout.setCenter(ta);
        layout.setBottom(bottom);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }

    public HBox hbox(Label... labels) {
        HBox hbox = new HBox();

        hbox.getChildren().addAll(Arrays.asList(labels));
        return hbox;
    }

}
