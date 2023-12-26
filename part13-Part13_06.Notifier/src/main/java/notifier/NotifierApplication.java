package notifier;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {

        VBox vBox = new VBox();
        Button updateBtn = new Button("Update");
        TextField topField = new TextField();
        Label bottomField = new Label();

        updateBtn.setOnAction((ActionEvent event) -> {
            bottomField.setText(topField.getText());
            // topField.clear();
        });

        vBox.getChildren().addAll(topField, updateBtn, bottomField);

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();

    }

    public void example(Stage stage) {

        Button button = new Button("Action!");
        // button.setOnAction(new EventHandler<ActionEvent>() {

        // @Override
        // public void handle(ActionEvent e) {
        // System.out.println(e + "Pressed.");
        // }
        // });
        // lambda
        button.setOnAction((ActionEvent e) -> {
            System.out.println(e + "Pressed.");
        });

        TextField leftText = new TextField();
        TextField rightText = new TextField();
        Button copy = new Button("Copy");

        copy.setOnAction((ActionEvent event) -> rightText.setText(leftText.getText()));

        HBox componentGroup = new HBox();
        componentGroup.setSpacing(20);
        componentGroup.getChildren().addAll(leftText, copy, rightText);

        FlowPane layout = new FlowPane();
        layout.getChildren().add(button);

        Scene viewport = new Scene(componentGroup);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.setScene(viewport);
        stage.show();
    }
}
