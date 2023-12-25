import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
  private List<Item> list;
  // private Map<String, Item> list;

  public ShoppingCart() {
    this.list = new ArrayList<>();
    // this.list = new HashMap<>();
  }

  public void add(String product, int price) {
    // list.put(product, new Item(product, 1, price));
    Item newItem = new Item(product, 1, price);
    if (!this.list.contains(newItem)) {
      this.list.add(newItem);
    } else {
      for (Item item : this.list) {
        if (item.getProduct().equals(product)) {
          // item.setUnitPrice(item.getUnitPrice() + price);
          item.setQty(item.getQty() + 1);
        }
      }
    }
  }

  public int price() {
    // return this.list.values().stream().mapToInt(item -> item.price()).sum();
    return this.list.stream().mapToInt(item -> item.price()).sum();
  }

  public void print() {
    // this.list.values().stream().forEach(System.out::println);
    this.list.stream().forEach(System.out::println);
  }
}
