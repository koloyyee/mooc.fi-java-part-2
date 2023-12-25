/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loyyeeko
 */
public class Hideout<T> {

  private T obj;

  public Hideout() {

  }

  public void putIntoHideout(T toHide) {
    obj = toHide;
  }

  public T takeFromHideout() {
    return obj;
  }

  public boolean isInHideout() {
    return obj != null;
  }
}
