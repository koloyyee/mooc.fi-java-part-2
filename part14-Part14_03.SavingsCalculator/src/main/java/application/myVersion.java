/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author loyyeeko
 */
public class myVersion extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {

    // Full Layout
    BorderPane layout = new BorderPane();
    layout.setPrefSize(500, 400);

    // savings slider
    Slider savingsSlider = new Slider(25, 250, 25);
    savingsSlider.setShowTickMarks(true);
    savingsSlider.setShowTickLabels(true);
    savingsSlider.setSnapToTicks(true);
    savingsSlider.setBlockIncrement(500);

    BorderPane savings = new BorderPane();
    Label currSavingsLabel = new Label("25");
    savings.setLeft(new Label("Monthly savings"));
    savings.setCenter(savingsSlider);
    savings.setRight(currSavingsLabel);
    savings.setPadding(new Insets(10));

    // interest slider
    Slider interestSlider = new Slider(0, 10, 0);
    interestSlider.setShowTickMarks(true);
    interestSlider.setShowTickLabels(true);
    interestSlider.setMinorTickCount(4);

    BorderPane interest = new BorderPane();
    Label currInterestLabel = new Label("0");
    interest.setLeft(new Label("Yearly interest rate"));
    interest.setCenter(interestSlider);
    interest.setRight(currInterestLabel);
    interest.setPadding(new Insets(10));

    VBox top = new VBox();
    top.setPadding(new Insets(10));
    top.setSpacing(10);
    top.getChildren().addAll(savings, interest);

    // Chart Section
    NumberAxis xAxis = new NumberAxis(0, 30, 1);
    NumberAxis yAxis = new NumberAxis();

    LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
    lineChart.setTitle("Savings calculator");

    XYChart.Series<Number, Number> savingsChart = new XYChart.Series<>();
    XYChart.Series<Number, Number> interestChart = new XYChart.Series<>();

    updateSavings(savingsSlider.getValue(), interestSlider.getValue(),
        savingsChart, interestChart);
    lineChart.setAnimated(false);
    lineChart.setLegendVisible(false);
    lineChart.getData().addAll(savingsChart, interestChart);
    layout.setTop(top);
    layout.setCenter(lineChart);

    // on change events
    savingsSlider.valueProperty()
        .addListener((change, oldValue,
            newValue) -> {

          currSavingsLabel.setText(String.valueOf(newValue.intValue()));
          updateSavings(savingsSlider.getValue(), interestSlider.getValue(),
              savingsChart, interestChart);
        });
    interestSlider.valueProperty()
        .addListener((change, oldValue,
            newValue) -> {
          currInterestLabel.setText(String.valueOf(newValue.intValue()));

          updateSavings(savingsSlider.getValue(), interestSlider.getValue(),
              savingsChart, interestChart);
        });
    Scene scene = new Scene(layout, 640, 480);
  }

  private void updateSavings(double savings, double interest,
      XYChart.Series<Number, Number> savingsChart,
      XYChart.Series<Number, Number> interestChart) {

    savingsChart.getData().clear();
    interestChart.getData().clear();

    savingsChart.getData().add(new XYChart.Data<>(0, 0));
    interestChart.getData().add(new XYChart.Data<>(0, 0));

    double savs = 0.0;
    double intrs = 0.0;

    for (int i = 1; i <= 30; i++) {
      savs += savings * 12;
      intrs = (intrs + savings * 12) * (1.0 + interest / 100.0);

      savingsChart.getData().add(new XYChart.Data<>(i, savs));
      interestChart.getData().add(new XYChart.Data<>(i, intrs));

    }

  }
}
