/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package FlightControl.model;

/**
 *
 * @author loyyeeko
 */
public class Plane {
  final private String id;
  final private int capacity;

  public Plane(String id, int capacity) {
    this.id = id;
    this.capacity = capacity;
  }

  public String getId() {
    return this.id;
  }

  public int getCapacity() {
    return this.capacity;
  }

  @Override
  public String toString() {
    return this.id + " (" + this.capacity + " capacity)";
  }
}
