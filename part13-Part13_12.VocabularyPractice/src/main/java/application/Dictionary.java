/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author loyyeeko
 */
public class Dictionary {
  private List<String> words;
  private Map<String, String> translations;

  public Dictionary() {
    this.words = new ArrayList<>();
    this.translations = new HashMap<>();
    add("sana", "word");
  }

  public String get(String word) {
    return this.translations.get(word);
  }

  public void add(String word, String translation) {
    if (!translations.containsKey(word)) {
      words.add(word);
    }
    translations.put(word, translation);
  }

  public void remove(String word) {
    if (translations.containsKey(word)) {
      translations.remove(word);
      words.remove(words.indexOf(word));
    }
  }

  public String getRandomWord() {
    Random rand = new Random();
    return this.words.get(rand.nextInt(words.size()));
  }
}
