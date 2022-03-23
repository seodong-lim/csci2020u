package com.example.lab07;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(new FileReader(new File("weatherwarnings-2015.csv")));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String columns[] = line.split(",");
            if (columns.length >= 6) {
                String field = columns[5].trim();
                if (map.containsKey(field)) {
                    int count = map.get(field);
                    count += 1;
                    map.put(field, count);
                } else {
                    map.put(field, 1);
                }
            }
        }
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        for (String key : map.keySet()) {
            data.add(new PieChart.Data(key, map.get(key)));
        }
        Pane root = new Pane();
        PieChart chart = new PieChart(data);
        root.getChildren().add(chart);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lab 07");
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}