import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {

  private Map<String, Integer> products;
  private Map<String, Integer> quantities;

  public Warehouse() {
    this.products = new HashMap<>();
    this.quantities = new HashMap<>();
  }

  public void addProduct(String product, int price, int stock) {
    this.products.putIfAbsent(product, price);
    this.quantities.putIfAbsent(product, stock);
  }

  public int price(String product) {
    return this.products.getOrDefault(product, -99);
  }

  public int stock(String product) {
    return this.quantities.getOrDefault(product, 0);
  }

  public boolean take(String product) {
    if (this.stock(product) > 0) {

      this.quantities.put(product, this.quantities.get(product) - 1);

      return true;
    }
    return false;
  }

  public Set<String> products() {
    return this.products.keySet();
  }
}
