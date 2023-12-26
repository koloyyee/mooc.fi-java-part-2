package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {

        FlowPane componentGroup = new FlowPane();
        Scene scene = new Scene(componentGroup);
        Button buttonComponent = new Button("This is a button");
        Label textComponent = new Label("Text element");

        componentGroup.getChildren().add(buttonComponent);
        componentGroup.getChildren().add(textComponent);

        stage.setScene(scene);
        stage.show();
    }

}
