/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package application;

import java.util.Random;

/**
 *
 * @author loyyeeko
 */
public class TemperatureSensor implements Sensor {

  private boolean isStateOn;
  private int temp;

  public TemperatureSensor() {
    isStateOn = false;
  }

  @Override
  public boolean isOn() {
    return isStateOn;
  }

  @Override
  public void setOn() {
    this.isStateOn = true;
  }

  @Override
  public void setOff() {
    this.isStateOn = false;
  }

  @Override
  public int read() {
    int low = -30;
    int high = 30;

    temp = new Random().nextInt(high - low) + low;
    if (isStateOn == false) {
      throw new IllegalStateException("sensor is off");
    }
    return temp;
  }

}
