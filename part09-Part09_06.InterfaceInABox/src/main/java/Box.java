import java.util.ArrayList;

public class Box implements Packable {

  private ArrayList<Packable> box;
  private double maximumCapacity;

  public Box(double maximumCapacity) {
    this.maximumCapacity = maximumCapacity;
    this.box = new ArrayList<>();
  }

  public void add(Packable item) {
    if (this.weight() + item.weight() < maximumCapacity) {
      this.box.add(item);
    }
  }

  @Override
  public double weight() {
    return box.stream().mapToDouble(item -> item.weight()).sum();
  }

  @Override
  public String toString() {
    return "Box: " + this.box.size() + " items, total weight " + this.weight() + " kg";
  }
}
