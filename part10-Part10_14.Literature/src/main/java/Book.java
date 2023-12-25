public class Book implements Comparable<Book> {
  private String title;
  private int ageRecomm;

  public Book(String title, int ageRecomm) {
    this.title = title;
    this.ageRecomm = ageRecomm;
  }

  public String toString() {
    return this.title + " (" + "recommended for " + this.ageRecomm + " year-olds or older)";
    // return this.title + ", " + this.ageRecomm;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getAgeRecomm() {
    return ageRecomm;
  }

  public void setAgeRecomm(int ageRecomm) {
    this.ageRecomm = ageRecomm;
  }

  @Override
  public int compareTo(Book o) {
    if (this.ageRecomm == o.getAgeRecomm()) {
      return this.title.compareTo(o.getTitle());
    }
    return this.ageRecomm - o.getAgeRecomm();
  }
}
