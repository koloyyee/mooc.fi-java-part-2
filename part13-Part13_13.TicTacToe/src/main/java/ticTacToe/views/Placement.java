/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ticTacToe.views;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

/**
 *
 * @author loyyeeko
 */
public class Placement extends Button {
  private Button btn;

  public Placement() {
    this("");
  }

  public Placement(String btn) {
    this.btn = new Button(btn);
    this.btn.setFont(Font.font("Monospaced", 40));
  }

  public void setbtn(String btn) {
    this.btn.setText(btn);
  }

  public void clearbtn() {
    this.btn.setText("");
  }

  public boolean isEmpty() {
    return this.btn.getText().isEmpty();
  }
}
