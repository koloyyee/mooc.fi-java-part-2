package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndTextFieldApplication extends Application {

    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {

        FlowPane componentGroup = new FlowPane();
        Scene scene = new Scene(componentGroup);

        final Button submit = new Button("Submit");
        final TextField usernameInput = new TextField("Username");

        componentGroup.getChildren().add(usernameInput);
        componentGroup.getChildren().add(submit);

        window.setScene(scene);
        window.show();
    }

}
