/**
 *
 * @author loyyeeko
 */
public class List<T> {
  private T[] list;
  private int firstFreeIndex;

  public List() {
    this.list = (T[]) new Object[10];
    this.firstFreeIndex = 0;
  }

  public void add(T el) {
    if (list.length == firstFreeIndex) {
      grow();
    }
    this.list[firstFreeIndex] = el;
    firstFreeIndex++;
  }

  public void remove(T el) {
    // before
    // boolean found = false;

    // for (int i = 0; i < firstFreeIndex; i++) {

    // if (found) {
    // list[i - 1] = list[i];
    // } else if (list[i].equals(el) || list[i] == el) {
    // list[i] = null;
    // firstFreeIndex--;
    // found = true;
    // }
    // }
    int idx = indexOf(el);
    if (idx < 0) {
      return;
    }
    shiftLeft(idx);
    firstFreeIndex--;
  }

  public int indexOf(T el) {
    for (int i = 0; i < list.length; i++) {
      if (list[i] == el || list[i].equals(el)) {
        return i;
      }
    }
    return -1;
  }

  private void grow() {
    int size = list.length + (list.length / 2);
    T[] newArr = (T[]) new Object[size];

    for (int i = 0; i < list.length; i++) {
      newArr[i] = list[i];
    }
  }

  public void shiftLeft(int fromIdx) {
    for (int i = fromIdx; i < firstFreeIndex - 1; i++) {
      list[i] = list[i + 1];
    }
  }

  public boolean contains(T el) {
    // before
    // for (int i = 0; i < firstFreeIndex; i++) {
    // if (list[i].equals(el)) {
    // return true;
    // }
    // }
    // return false;

    // after
    return indexOf(el) >= 0;
  }

  public T value(int idx) {
    if (idx < 0 || idx >= firstFreeIndex) {
      throw new ArrayIndexOutOfBoundsException("Index: " + idx + "is not between 0 - " + firstFreeIndex);
    }
    return list[idx];
  }
}
