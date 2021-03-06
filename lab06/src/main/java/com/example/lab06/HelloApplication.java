package com.example.lab06;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    @Override


    public void start(Stage stage) throws IOException {
        stage.setTitle("Bar Chart");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc =
                new BarChart<String,Number>(xAxis,yAxis);

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("avg housing");
        series1.getData().add(new XYChart.Data("1", avgHousingPricesByYear[0]));
        series1.getData().add(new XYChart.Data("2", avgHousingPricesByYear[1]));
        series1.getData().add(new XYChart.Data("3", avgHousingPricesByYear[2]));
        series1.getData().add(new XYChart.Data("4", avgHousingPricesByYear[3]));
        series1.getData().add(new XYChart.Data("5", avgHousingPricesByYear[4]));
        series1.getData().add(new XYChart.Data("6", avgHousingPricesByYear[5]));
        series1.getData().add(new XYChart.Data("7", avgHousingPricesByYear[6]));
        series1.getData().add(new XYChart.Data("8", avgHousingPricesByYear[7]));
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("avg commercial");
        series2.getData().add(new XYChart.Data("1", avgCommercialPricesByYear[0]));
        series2.getData().add(new XYChart.Data("2", avgCommercialPricesByYear[1]));
        series2.getData().add(new XYChart.Data("3", avgCommercialPricesByYear[2]));
        series2.getData().add(new XYChart.Data("4", avgCommercialPricesByYear[3]));
        series2.getData().add(new XYChart.Data("5", avgCommercialPricesByYear[4]));
        series2.getData().add(new XYChart.Data("6", avgCommercialPricesByYear[5]));
        series2.getData().add(new XYChart.Data("7", avgCommercialPricesByYear[6]));
        series2.getData().add(new XYChart.Data("8", avgCommercialPricesByYear[7]));

        bc.setBarGap(3);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data(ageGroups[0], purchasesByAgeGroup[0]),
                        new PieChart.Data(ageGroups[1], purchasesByAgeGroup[1]),
                        new PieChart.Data(ageGroups[2], purchasesByAgeGroup[2]),
                        new PieChart.Data(ageGroups[3], purchasesByAgeGroup[3]),
                        new PieChart.Data(ageGroups[4], purchasesByAgeGroup[4]));
        final PieChart chart = new PieChart(pieChartData);



        Pane pane  = new Pane();
        bc.getData().addAll(series1,series2);
        pane.getChildren().add(bc);
        pane.getChildren().add(chart);
        chart.setLayoutX(500);
        Scene scene = new Scene(pane,1000,1000);
        stage.setScene(scene);
        stage.show();
        applyCustomColorSequence(
                pieChartData,
                "aqua",
                "gold",
                "orange",
                "salmon",
                "green",
                "plum"
        );

    }
    private void applyCustomColorSequence(ObservableList<PieChart.Data> pieChartData, String... pieColors) {
        int i = 0;
        for (PieChart.Data data : pieChartData) {
            data.getNode().setStyle("-fx-pie-color: " + pieColors[i % pieColors.length] + ";");
            i++;
        }
    }
    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };
    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };

    private static String[] ageGroups = {
            "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
    };
    private static int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };
    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };



    public static void main(String[] args) {
        launch();
    }
}