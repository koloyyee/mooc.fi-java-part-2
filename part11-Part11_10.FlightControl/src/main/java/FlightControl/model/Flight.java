/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package FlightControl.model;

/**
 *
 * @author loyyeeko
 */
public class Flight {
  final private Plane plane;
  final private Place departureId;
  final private Place destinationId;

  public Flight(Plane plane, Place departureId, Place destinationId) {
    this.plane = plane;
    this.departureId = departureId;
    this.destinationId = destinationId;
  }

  public Plane getPlane() {
    return this.plane;
  }

  public Place getDepartureId() {
    return departureId;
  }

  public Place getDestinationId() {
    return destinationId;
  }

  @Override
  public String toString() {
    return this.plane.toString() + " (" + this.departureId + "-" + this.destinationId + ")";
  }
}
