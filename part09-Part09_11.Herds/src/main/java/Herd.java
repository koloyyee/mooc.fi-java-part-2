import java.util.ArrayList;
import java.util.List;

public class Herd implements Movable {

  private List<Movable> herd;

  public Herd() {
    herd = new ArrayList<>();
  }

  public void addToHerd(Movable movable) {
    herd.add(movable);
  }

  @Override
  public void move(int dx, int dy) {
    for (Movable movable : herd) {
      movable.move(dx, dy);
    }
  }

  @Override
  public String toString() {
    String ans = "";
    for (Movable m : herd) {
      ans += m.toString() + "\n";
    }
    return ans;
  }
}
