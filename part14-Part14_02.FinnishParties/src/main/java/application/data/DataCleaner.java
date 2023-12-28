/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package application.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 *
 * @author loyyeeko
 */
public class DataCleaner {
  private BufferedReader reader;

  public DataCleaner() {
    try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("partiesdata.tsv"))) {
      this.reader = bufferedReader;
    } catch (IOException e) {
      System.out.println(e);
    }

  }
  // public void dataCleaning() {
  // try (BufferedReader reader =
  // Files.newBufferedReader(Paths.get("partiesdata.tsv"))) {
  // // ArrayList<Integer> years = getYears(reader);
  // // Map<String, Map<Integer, Double>> partiesYearRates =
  // // getPartiesYearRates(reader);

  // List<String> names = getPartiesNames(reader);
  // System.out.println(names);
  // } catch (Exception e) {
  // System.out.println(e);
  // }
  // }

  public ArrayList<Integer> getYears() {
    String header = reader.lines().findFirst().orElse("");

    String[] headerArr = header.split("\t");
    ArrayList<Integer> years = new ArrayList<>();

    for (int i = 1; i < headerArr.length; i++) {
      years.add(Integer.valueOf(headerArr[i]));
    }
    return years;
  }

  public List<String> getPartiesNames() {
    return reader.lines()
        .map(line -> line.split("\t")[0])
        .skip(1)
        .collect(Collectors.toList());
  }

  public Map<String, Map<Integer, Double>> getPartiesYearRates() {

    ArrayList<Integer> years = getYears();

    Map<String, Map<Integer, Double>> partyYearRate = new HashMap<>();
    reader.lines().forEach(line -> {
      Map<Integer, Double> yearRate = new TreeMap<>();
      ArrayList<Double> rates = new ArrayList<>();

      String[] party = line.split("\t");
      String partyName = party[0];

      Arrays.stream(party).skip(1).forEach(el -> {
        Double rate = el.equals("-") ? 0 : Double.valueOf(el);
        rates.add(rate);
      });
      for (int i = 0; i < years.size(); i++) {
        yearRate.put(years.get(i), rates.get(i));
      }
      partyYearRate.putIfAbsent(partyName, yearRate);
    });
    return partyYearRate;
  }
}
