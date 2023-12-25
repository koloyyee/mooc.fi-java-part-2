/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package FlightControl.logic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import FlightControl.model.Flight;
import FlightControl.model.Place;
import FlightControl.model.Plane;

/**
 *
 * @author loyyeeko
 */
public class FlightControl {
  final private Map<String, Plane> planes;
  final private Map<String, Flight> flights;
  final private Map<String, Place> places;

  public FlightControl() {
    this.planes = new HashMap<>();
    this.flights = new HashMap<>();
    this.places = new HashMap<>();
  }

  public void addPlane(String id, int capacity) {
    Plane plane = new Plane(id, capacity);
    planes.putIfAbsent(id, plane);
  }

  public void addFlight(Plane plane, String departureId, String destinationId) {
    this.places.putIfAbsent(departureId, new Place(departureId));
    this.places.putIfAbsent(destinationId, new Place(destinationId));

    Flight flight = new Flight(plane, this.places.get(departureId), this.places.get(destinationId));

    this.flights.put(flight.toString(), flight);
  }

  public Collection<Plane> getPlanes() {
    return this.planes.values();
  }

  public Collection<Place> getPlaces() {
    return this.places.values();
  }

  public Collection<Flight> getFlights() {
    return this.flights.values();
  }

  public Plane getPlane(String id) {
    return this.planes.get(id);
  }
}
