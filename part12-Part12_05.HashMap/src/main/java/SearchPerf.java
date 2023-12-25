/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *
 * @author loyyeeko
 */
public class SearchPerf {
  public static void main(String[] args) {
    List<String> myList = new ArrayList<>();
    HashMap<String, String> hashMap = new HashMap<>();

    for (int i = 0; i < 1000000; i++) {
      myList.add("" + i);
      hashMap.putIfAbsent("" + i, "" + i);
    }

    List<String> elements = new ArrayList<>();
    Random randomizer = new Random();
    for (int i = 0; i < 1000; i++) {
      elements.add("" + randomizer.nextInt(2000000));
    }

    long listSearchStartTime = System.nanoTime();
    for (int i = 0; i < elements.size(); i++) {
      myList.contains(elements.get(i));
    }
    long listSearchEndTime = System.nanoTime();

    long hashMapSearchStartTime = System.nanoTime();
    for (int i = 0; i < elements.size(); i++) {
      hashMap.get(elements.get(i));
    }
    long hashMapSearchEndTime = System.nanoTime();

    long listSearch = listSearchEndTime - listSearchStartTime;
    System.out.println("List: the search took about " + listSearch / 1000000 + " milliseconds (" +
        listSearch + " nanoseconds.)");

    long hashMapSearch = hashMapSearchEndTime - hashMapSearchStartTime;
    System.out.println("Hash map: the search took about " + hashMapSearch / 1000000 +
        " milliseconds (" + hashMapSearch + " nanoseconds.)");
  }
}
