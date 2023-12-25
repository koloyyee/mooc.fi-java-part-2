
public class Checker {
  public static void main(String[] args) {
    Checker c = new Checker();
    if (c.timeOfDay("18:38:59")) {
      System.out.println("this format is correct");
    } else {
      System.out.println("this format is incorrect");
    }
  }

  public boolean isDayOfWeek(String string) {
    return string.toLowerCase().matches("mon|tue|wed|thu|fri|sat|sun");
  }

  public boolean allVowels(String string) {

    return string.toLowerCase().matches("[aeiou]+");
  }

  public boolean timeOfDay(String string) {
    return string.matches("([0-1][0-9]|[2][0-3]):[0-5][0-9]:[0-5][0-9]");
  }
}
