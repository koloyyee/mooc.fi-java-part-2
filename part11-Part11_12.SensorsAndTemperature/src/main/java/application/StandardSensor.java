package application;

/**
 *
 * @author loyyeeko
 */
public class StandardSensor implements Sensor {
  final private int meter;

  public StandardSensor(int meter) {
    this.meter = meter;
  }

  @Override
  public boolean isOn() {
    return true;
  }

  @Override
  public void setOn() {

  }

  @Override
  public void setOff() {
  }

  @Override
  public int read() {
    return this.meter;
  }

}
