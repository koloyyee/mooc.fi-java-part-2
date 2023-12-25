/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author loyyeeko
 */
public class AverageSensor implements Sensor {

  final private List<Sensor> sensors;
  final private List<Integer> readings;

  public AverageSensor() {
    sensors = new ArrayList<>();
    readings = new ArrayList<>();

  }

  @Override
  public boolean isOn() {
    boolean state = false;
    for (Sensor sensor : sensors) {
      state = sensor.isOn();
    }
    return state;

  }

  @Override
  public void setOn() {
    for (Sensor sensor : sensors) {
      sensor.setOn();
    }
  }

  @Override
  public void setOff() {
    sensors.forEach(Sensor::setOff);
  }

  @Override
  public int read() {
    int avg = (int) sensors.stream().mapToInt(sensor -> sensor.read()).average().getAsDouble();

    readings.add(avg);

    return avg;
  }

  public void addSensor(Sensor toAdd) {
    this.sensors.add(toAdd);
  }

  public List<Integer> readings() {
    return readings;
  }

}
