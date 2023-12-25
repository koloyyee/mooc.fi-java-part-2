
import java.util.ArrayList;

/**
 *
 * @author loyyeeko
 */
public class HashMap<K, V> {
  private ArrayList<ArrayList<Pair<K, V>>> map;
  private int firstFreeIndex;

  public HashMap() {
    this.map = new ArrayList<>();
    this.firstFreeIndex = 0;
  }

  public V get(K k) {
    int hashValue = Math.abs(k.hashCode() % this.map.size());
    if (this.map.get(hashValue) == null) {
      return null;
    }
    ArrayList<Pair<K, V>> valueAtIndex = this.map.get(hashValue);
    for (int i = 0; i < valueAtIndex.size(); i++) {
      if (valueAtIndex.get(i).getKey().equals(k)) {
        return valueAtIndex.get(i).getValue();
      }
    }
    return null;
  }

  public void add(K k, V v) {
    // before
    // int hashValue = Math.abs(k.hashCode() % map.size());
    // if (map.get(hashValue) == null) {
    // map.add(new ArrayList<>());
    // }
    // ArrayList<Pair<K, V>> valueAtIndex = map.get(hashValue);
    // int index = -1;
    // for (int i = 0; i < map.size(); i++) {
    // if (valueAtIndex.get(i).equals(k)) {
    // index = i;
    // break;
    // }
    // }

    // after
    ArrayList<Pair<K, V>> valueAtIndex = getListByKey(k);
    int index = getIndexByKey(valueAtIndex, k);

    if (index < 0) {
      valueAtIndex.add(new Pair<K, V>(k, v));
      this.firstFreeIndex++;
    } else {
      valueAtIndex.get(index).setValue(v);
    }
  }

  private ArrayList<Pair<K, V>> getListByKey(K k) {
    int hashValue = Math.abs(k.hashCode() % map.size());
    if (map.get(hashValue) == null) {
      map.add(new ArrayList<>());
    }
    return map.get(hashValue);
  }

  private int getIndexByKey(ArrayList<Pair<K, V>> innerMap, K k) {
    for (int i = 0; i < map.size(); i++) {
      if (innerMap.get(i).equals(k)) {
        return i;
      }
    }
    return -1;
  }
}
