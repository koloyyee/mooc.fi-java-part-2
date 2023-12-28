package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public final class PartiesApplication extends Application {

    private final Map<String, Map<Integer, Double>> partyYearRate;
    private final List<Integer> years;

    public PartiesApplication() {
        partyYearRate = getPartiesYearRates();
        years = getYears();
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {

        NumberAxis xAxis = new NumberAxis(years.get(0), years.get(years.size() - 1),
                4);

        NumberAxis yAxis = new NumberAxis();

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Relative support of the parties");

        for (Entry<String, Map<Integer, Double>> entry : partyYearRate.entrySet()) {
            XYChart.Series<Number, Number> xyChart = new XYChart.Series<>();
            xyChart.setName(entry.getKey());
            for (Entry<Integer, Double> values : entry.getValue().entrySet()) {
                xyChart.getData().add(new XYChart.Data<>(values.getKey(),
                        values.getValue()));
            }
            lineChart.getData().add(xyChart);
        }
        Scene scene = new Scene(lineChart);
        stage.setScene(scene);
        stage.show();

    }

    public ArrayList<Integer> getYears() {
        ArrayList<Integer> list = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("partiesdata.tsv"))) {
            String header = reader.lines().findFirst().orElse("");

            String[] headerArr = header.split("\t");

            for (int i = 1; i < headerArr.length; i++) {
                list.add(Integer.valueOf(headerArr[i]));
            }
        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }
        return list;
    }

    // public List<String> getPartiesNames() {
    // return reader.lines()
    // .map(line -> line.split("\t")[0])
    // .skip(1)
    // .collect(Collectors.toList());
    // }

    public Map<String, Map<Integer, Double>> getPartiesYearRates() {

        ArrayList<Integer> years = new ArrayList<>();
        Map<String, Map<Integer, Double>> map = new HashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("partiesdata.tsv"))) {

            // get years
            String header = reader.lines().findFirst().orElse("");

            String[] headerArr = header.split("\t");

            for (int i = 1; i < headerArr.length; i++) {
                years.add(Integer.valueOf(headerArr[i]));
            }

            // get party, year, rates map
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
                map.putIfAbsent(partyName, yearRate);
            });
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;

    }
}
