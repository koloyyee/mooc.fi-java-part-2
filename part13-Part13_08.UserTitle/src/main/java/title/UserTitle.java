package title;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class UserTitle extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    Parameters param = getParameters();
    String title = param.getNamed().get("title");

    BorderPane layout = new BorderPane();
    layout.setCenter(new Label(title));

    Scene scene = new Scene(layout);

    stage.setScene(scene);
    stage.setTitle("Welcome! " + title);
    stage.show();
  }

}
