package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        NumberAxis xAxis = new NumberAxis(2005, 2018, 1);
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai Ranking");

        /*
         * 2007 73
         * 2008 68
         * 2009 72
         * 2010 72
         * 2011 74
         * 2012 73
         * 2013 76
         * 2014 73
         * 2015 67
         * 2016 56
         * 2017 56
         */

        XYChart.Series<Number, Number> shChart = new XYChart.Series<>();

        int[] rankings = { 73, 68, 72, 72, 74, 73, 76, 73, 67, 56, 56 };
        int[] years = { 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016,
                2017 };
        for (int i = 0; i < years.length; i++) {
            shChart.getData().add(new XYChart.Data<>(years[i], rankings[i]));
        }

        lineChart.getData().add(shChart);

        Scene scene = new Scene(lineChart, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

}
