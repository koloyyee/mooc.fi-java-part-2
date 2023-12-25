import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
  private List<Person> people;

  public Employees() {
    this.people = new ArrayList<>();
  }

  public void add(Person personToAdd) {
    people.add(personToAdd);
  }

  public void add(List<Person> peopleToAdd) {
    peopleToAdd.stream().forEach(person -> people.add(person));
  }

  public void print() {
    Iterator<Person> iterator = people.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());

    }

  }

  public void print(Education education) {
    Iterator<Person> iterator = people.iterator();

    while (iterator.hasNext()) {
      Person next = iterator.next();
      if (next.getEducation().equals(education)) {
        System.out.println(next);
      }
    }
  }

  public void fire(Education education) {
    Iterator<Person> it = people.iterator();
    while (it.hasNext()) {
      Person next = it.next();
      if (next.getEducation().equals(education)) {
        it.remove();
      }

    }
  }
}
