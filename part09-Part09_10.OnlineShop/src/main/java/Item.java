public class Item {
  private String product;
  private int qty;
  private int unitPrice;

  public Item(String product, int qty, int unitPrice) {
    this.product = product;
    this.qty = qty;
    this.unitPrice = unitPrice;
  }

  public int price() {
    return qty * unitPrice;
  }

  public void increaseQuantity() {
    this.qty += 1;
  }

  public String toString() {
    return this.product + ": " + this.qty;
  }

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public int getQty() {
    return qty;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }

  public int getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(int unitPrice) {
    this.unitPrice = unitPrice;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((product == null) ? 0 : product.hashCode());
    result = prime * result + qty;
    result = prime * result + unitPrice;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Item other = (Item) obj;
    return this.getProduct().equals(other.getProduct())
        && this.getUnitPrice() == other.getUnitPrice();
  }

}
