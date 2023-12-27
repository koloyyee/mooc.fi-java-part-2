package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ticTacToe.views.Board;

public class TicTacToeApplication extends Application {

    private int count;

    public void init() throws Exception {
        count = 9;
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();

        Label nextTurn = new Label("Turn: X");
        Button reset = new Button("Reset");

        layout.setPadding(new Insets(10, 10, 10, 10));

        Board board = new Board(3, nextTurn);

        reset.setOnAction((event) -> board.reset());

        layout.setTop(nextTurn);
        layout.setCenter(board.getView());
        layout.setBottom(reset);

        Scene scene = new Scene(layout, 300, 300);
        stage.setScene(scene);
        stage.show();
    }

}
