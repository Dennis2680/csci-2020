package com.example.lab07;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        int floodCount = 0;
        int thunderStorm = 0;
        int specMarine = 0;
        int tornado = 0;
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\com\\example\\lab07\\info.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }

            for(int i = 0; i < records.size(); i++){
                if(records.get(i).get(5).toString().equals("FLASH FLOOD")){
                    floodCount += 1;
                } else if(records.get(i).get(5).toString().equals("SEVERE THUNDERSTORM")) {
                    thunderStorm += 1;
                } else if (records.get(i).get(5).toString().equals("SPECIAL MARINE")){
                    specMarine += 1;
                } else if(records.get(i).get(5).toString().equals("TORNADO")){
                    tornado += 1;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(floodCount);
        System.out.println(thunderStorm);
        System.out.println(specMarine);
        System.out.println(tornado);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage.setTitle("Lab07");

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("FLASH FLOOD", floodCount),
                        new PieChart.Data("SEVERE THUNDERSTORM", thunderStorm),
                        new PieChart.Data("SPECIAL MARINE", specMarine),
                        new PieChart.Data("TORNADO", tornado));
        final PieChart chart = new PieChart(pieChartData);
        chart.setLegendSide(Side.LEFT);
        Scene scene = new Scene(chart, 800, 800);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws FileNotFoundException {
        launch();
    }
}