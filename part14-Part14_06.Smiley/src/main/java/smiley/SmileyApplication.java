package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Canvas paintingCanvas = new Canvas(640, 480);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();
        painter.setFill(Color.WHITE);

        BorderPane paintingLayout = new BorderPane();
        paintingLayout.setCenter(paintingCanvas);
        painter.setFill(Color.BLACK);
        painter.fillRect(180, 50, 80, 80);
        painter.fillRect(360, 50, 80, 80);

        painter.fillRect(80, 180, 80, 80);
        painter.fillRect(480, 180, 80, 80);

        painter.fillRect(160, 260, 80, 80);
        painter.fillRect(240, 260, 80, 80);
        painter.fillRect(320, 260, 80, 80);
        painter.fillRect(400, 260, 80, 80);

        Scene view = new Scene(paintingLayout);

        stage.setScene(view);
        stage.show();
    }

}
