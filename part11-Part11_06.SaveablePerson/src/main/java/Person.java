/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loyyeeko
 */
public class Person implements Saveable {
  final private String name;
  final private String address;

  public Person(String name, String address) {
    this.address = address;
    this.name = name;
  }

  @Override
  public void save() {

  }

  @Override
  public void load(String address) {

  }

  @Override
  public void delete() {

  }
}
