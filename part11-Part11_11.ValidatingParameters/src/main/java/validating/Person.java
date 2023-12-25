package validating;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        try {

            if (name.length() > 40 || name.isEmpty()) {
                throw new IllegalArgumentException("Too short");
            } else {
                this.name = name;
            }
            if (age < 0 || age > 120) {
                throw new IllegalArgumentException("Age between 0 and 120");
            } else {
                this.age = age;
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Too short");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
