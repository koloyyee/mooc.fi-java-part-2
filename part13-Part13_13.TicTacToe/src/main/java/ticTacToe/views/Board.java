package ticTacToe.views;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import ticTacToe.Player;

/**
 *
 * @author loyyeeko
 */
public class Board {

  private String[][] board;
  private int count;
  final private int size;
  private final Label nextTurn;

  public Board(int size, Label nextTurn) {
    this.size = size;
    this.count = size * size;
    this.nextTurn = nextTurn;
    this.board = createEmptyBoard();
  }

  public Parent getView() {
    GridPane layout = new GridPane();

    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        Button btn = new Button(" ");
        btn.setFont(Font.font("Monospaced", 40));
        int currRow = row;
        int currCol = col;
        btn.setOnAction((event) -> {

          Player nextPlayer = getCount() % 2 != 0 ? Player.X : Player.O;

          if (btn.getText().trim().isEmpty() && count > 0) {
            btn.setText(nextPlayer.toString());

            placeValue(currCol, currRow, nextPlayer.toString());

            if (rowCheck() || colCheck() || diagonalCheck()) {
              // nextTurn.setText("Winner is " + nextPlayer.toString() + "!");
              nextTurn.setText("The end!");
              // gameSet();
            } else {

              setCount();
              nextPlayer = getCount() % 2 != 0 ? Player.X : Player.O;
              nextTurn.setText("Turn: " + nextPlayer);
            }
          }
        });

        layout.setHgap(2);
        layout.setVgap(2);
        layout.add(btn, row, col);
      }
    }
    layout.setAlignment(Pos.CENTER);
    return layout;
  }

  public int getCount() {
    return count;
  }

  public void setCount() {
    count--;
  }

  public void gameSet() {
    count = 0;
  }

  public void reset() {
    count = 0;
    this.board = createEmptyBoard();
    System.out.println(printBoard());
  }

  public void placeValue(int row, int col, String value) {
    this.board[row][col] = value;
  }

  public boolean rowCheck() {
    ArrayList<String> cells = new ArrayList<>();

    for (int row = 0; row < board.length; row++) {
      StringBuilder cell = new StringBuilder();
      for (int col = 0; col < board[row].length; col++) {
        cell.append(board[row][col]);
      }
      cells.add(cell.toString());
    }

    return checker(cells);
  }

  public boolean colCheck() {
    ArrayList<String> cells = new ArrayList<>();
    for (int row = 0; row < board.length; row++) {
      StringBuilder cell = new StringBuilder();
      for (int col = 0; col < board[row].length; col++) {
        cell.append(board[col][row]);
      }
      cells.add(cell.toString());
    }
    return checker(cells);
  }

  public boolean diagonalCheck() {
    ArrayList<String> cells = new ArrayList<>();
    StringBuilder topLCell = new StringBuilder();

    for (int row = 0; row < board.length; row++) {
      topLCell.append(board[row][row]);
    }
    cells.add(topLCell.toString());

    StringBuilder bottomLCell = new StringBuilder();
    for (int row = board.length - 1; row >= 0; row--) {
      bottomLCell.append(board[row][board.length - 1 - row]);
    }
    cells.add(bottomLCell.toString());
    return checker(cells);
  }

  public boolean checker(ArrayList<String> cells) {
    for (String cell : cells) {
      if (cell.length() == 3 && cell.chars().distinct().count() == 1) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        result.append(board[row][col]).append("\t");
      }

      result.append("\n");
    }

    return result.toString();
  }

  public String printBoard() {
    StringBuilder result = new StringBuilder();
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        result.append(board[row][col]).append("\t");
      }
      result.append("\n");
    }
    return result.toString();
  }

  final public String[][] createEmptyBoard() {
    String[][] square = new String[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        square[i][j] = "";
      }
    }

    return square;

  }
}
