public class Person {
  private String name;
  private Education level;

  public Person(String name, Education level) {
    this.name = name;
    this.level = level;
  }

  public Education getEducation() {
    return this.level;
  }

  @Override
  public String toString() {
    return name + ", " + level;
  }
}
