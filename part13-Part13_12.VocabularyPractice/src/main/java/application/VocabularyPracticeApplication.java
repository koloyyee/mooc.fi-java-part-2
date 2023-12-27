package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// END SOLUTION
public class VocabularyPracticeApplication extends Application {
    private Dictionary dictionary;

    @Override
    public void init() throws Exception {
        this.dictionary = new Dictionary();
    }

    @Override
    public void start(Stage stage) throws Exception {
        PracticeView practiceView = new PracticeView(dictionary);
        InputView inputView = new InputView(dictionary);

        BorderPane layout = new BorderPane();
        HBox menu = new HBox();
        menu.setPadding(new Insets(10, 10, 10, 10));
        menu.setSpacing(10);

        Button enterButton = new Button("Enter New Word");
        Button practiceButton = new Button("Go Practice");
        menu.getChildren().addAll(enterButton, practiceButton);
        layout.setTop(menu);

        enterButton.setOnAction((event) -> layout.setCenter(inputView.getView()));
        practiceButton.setOnAction((event) -> layout.setCenter(practiceView.getView()));

        layout.setCenter(inputView.getView());

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }
}
