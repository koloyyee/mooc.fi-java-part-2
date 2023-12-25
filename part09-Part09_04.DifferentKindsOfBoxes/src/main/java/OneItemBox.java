
public class OneItemBox extends Box {
  private Item[] items;

  public OneItemBox() {
    this.items = new Item[1];
  }

  @Override
  public void add(Item item) {
    if (items[0] == null) {
      this.items[0] = item;
    }
  }

  @Override
  public boolean isInBox(Item item) {
    if (items[0] != null) {
      return this.items[0].equals(item);
    }
    return false;
  }

}
