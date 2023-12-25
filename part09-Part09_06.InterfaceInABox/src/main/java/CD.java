public class CD implements Packable {

  private String singer;
  private String title;
  private int year;
  private double weight;

  public CD() {
    this.weight = 0.1;
  }

  public CD(String singer, String title, int year) {
    this();
    this.singer = singer;
    this.title = title;
    this.year = year;
  }

  public String getSinger() {
    return singer;
  }

  public void setSinger(String singer) {
    this.singer = singer;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
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
    return this.singer + ": " + this.title + " (" + this.year + ")";
  }

}
