import java.util.List;

/**
 *
 * @author loyyeeko
 */
public class Pipe<T> {

  List<T> data;

  public void putIntoPipe(T value) {
    data.add(value);
  }

  public T takeFromPipe() {
    if (this.data.isEmpty()) {
      return null;
    }
    T value = data.get(0);
    data.remove(0);
    return value;
  }

  public boolean isInPipe() {
    return !data.isEmpty();
  }
}
