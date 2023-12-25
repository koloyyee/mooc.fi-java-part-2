import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {
  private int capacity;
  private ArrayList<Item> items;

  public BoxWithMaxWeight(int capacity) {
    this.capacity = capacity;
    this.items = new ArrayList<>();
  }

  @Override
  public void add(Item item) {
    int currentCap = 0;
    for (Item i : items) {
      currentCap += i.getWeight();
    }
    if (currentCap + item.getWeight() <= this.capacity) {
      this.items.add(item);
    }

  }

  @Override
  public boolean isInBox(Item item) {
    for (Item i : items) {
      if (i.equals(item)) {
        return true;
      }
    }
    return false;
  }

}
