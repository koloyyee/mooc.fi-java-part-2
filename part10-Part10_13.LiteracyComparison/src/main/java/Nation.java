public class Nation implements Comparable<Nation> {
  private String name;
  private int year;
  private String sex;
  private double rate;

  public Nation(String name, int year, String sex, double rate) {
    this.name = name;
    this.year = year;
    this.sex = sex;
    this.rate = rate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public double getRate() {
    return rate;
  }

  public void setRate(double rate) {
    this.rate = rate;
  }

  public String toString() {
    return this.name + " (" + this.year + "), " + this.sex + ", " + this.rate;

    // String.format("%s (%d), %s, %.5f", name, year, sex, rate);
  }

  @Override
  public int compareTo(Nation o) {
    return (int) ((this.getRate() * 10000) - (o.getRate() * 10000));
  }
}
