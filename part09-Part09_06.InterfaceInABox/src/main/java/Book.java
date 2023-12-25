public class Book implements Packable {

  private String author;
  private String title;
  private double weight;

  public Book(String author, String title, double weight) {
    this.author = author;
    this.title = title;
    this.weight = weight;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  @Override
  public double weight() {
    return this.weight;
  }

  @Override
  public String toString() {
    return this.author + ": " + this.title;
  }

}
