/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mooc.logic;

import mooc.ui.UserInterface;

/**
 *
 * @author loyyeeko
 */
public class ApplicationLogic {
  private UserInterface ui;

  public ApplicationLogic(UserInterface ui) {
    this.ui = ui;

  }

  public void execute(int times) {
    for (int i = 0; i < times; i++) {
      System.out.println("Application logic is working");
      ui.update();
    }
  }
}
