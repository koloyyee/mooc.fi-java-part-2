/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author loyyeeko
 */
public class SaveableDictionary {
  private Map<String, String> dictionary;
  private String file;

  public SaveableDictionary() {
    dictionary = new HashMap<>();
  }

  public SaveableDictionary(String file) {
    this();
    this.file = file;
  }

  public void add(String words, String translation) {
    dictionary.putIfAbsent(words, translation);
  }

  public String translate(String word) {
    String ans = null;
    if (dictionary.containsKey(word)) {
      ans = dictionary.get(word);
    }

    if (dictionary.containsValue(word)) {
      ans = getKeyByValue(word);
    }
    return ans;
  }

  public void delete(String word) {
    if (dictionary.containsKey(word)) {
      dictionary.remove(word);
    } else if (dictionary.containsValue(word)) {
      String key = getKeyByValue(word);
      if (key != null) {
        dictionary.remove(key);
      }

    }
  }

  public boolean load() {
    try (Scanner fileReader = new Scanner(new File(file))) {

      while (fileReader.hasNext()) {
        String[] line = fileReader.nextLine().split(":");
        add(line[0], line[1]);
      }
      fileReader.close();
      return true;
    } catch (FileNotFoundException e) {
      return false;
    }
  }

  public boolean save() {
    try (PrintWriter writer = new PrintWriter(new File(file))) {

      ArrayList<String> existed = new ArrayList<>();
      this.dictionary
          .keySet()
          .stream()
          .forEach(word -> {
            if (existed.contains(word)) {
              return;
            }
            existed.add(word);
            existed.add(dictionary.get(word));
            writer.println(word + ":" + dictionary.get(word));

          });
      writer.close();
      return true;
    } catch (IOException e) {
      return false;
    }
  }

  public String getKeyByValue(String value) {

    for (Map.Entry<String, String> entry : dictionary.entrySet()) {
      if (value.equals(entry.getValue())) {
        return entry.getKey();
      }
    }

    return null;
  }

}
