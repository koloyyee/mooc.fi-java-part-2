/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loyyeeko
 */
public class Pair<K, V> {
  private K k;
  private V v;

  public Pair(K k, V v) {
    this.k = k;
    this.v = v;
  }

  public K getKey() {
    return k;
  }

  public V getValue() {
    return v;
  }

  public void setValue(V v) {
    this.v = v;
  }
}
