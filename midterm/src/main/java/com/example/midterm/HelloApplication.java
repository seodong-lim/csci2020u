package com.example.midterm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class HelloApplication extends Application {

    Stage main; // main stage
    Scene Animation,About,twod; // other stages

    public void start(Stage stage) throws IOException {
        main = stage;

        // labels
        Label label1 = new Label("home screen");
        Label label2 = new Label("animation page");
        Label label3 = new Label("2d page");
        Label label4 = new Label("about page");

        // buttons
        Button buttonAnimation = new Button("Animation");
        Button buttonAbout = new Button("About");
        Button buttonGoBack = new Button("go back");
        Button buttonGoBack1 = new Button("go back");
        Button buttonGoBack2 = new Button("go back");
        Button buttontwod = new Button("twod");

        // shape
        Rectangle r = new Rectangle();
        int x = 50;
        int y = 50;
        r.setX(50);
        r.setY(250);
        r.setWidth(50);
        r.setHeight(50);



        // home screen layout
        VBox layoutHome = new VBox(20);
        layoutHome.getChildren().addAll(label1,buttonAnimation,buttontwod,buttonAbout);
        Scene homeScene = new Scene(layoutHome, 300, 300);
        buttonAnimation.setOnAction(event -> main.setScene(Animation)); // button changing scenes
        buttonAbout.setOnAction(event -> main.setScene(About)); // button changing scenes
        buttontwod.setOnAction(event -> main.setScene(twod)); // button changing scenes

        buttonGoBack.setOnAction(event -> main.setScene(homeScene)); // home screen button
        buttonGoBack1.setOnAction(event -> main.setScene(homeScene)); // home screen button
        buttonGoBack2.setOnAction(event -> main.setScene(homeScene)); // home screen button

        // animation screen layout
        Pane layoutAnimation = new Pane();
        layoutAnimation.getChildren().addAll(label2,buttonGoBack,r);

        Animation = new Scene(layoutAnimation,300,300);

        // 2d page
        VBox layouttwod = new VBox(20);
        layouttwod.getChildren().addAll(label3,buttonGoBack1);
        twod = new Scene(layouttwod,300,300);

        // about page
        VBox layoutAbout = new VBox(20);
        layoutAbout.getChildren().addAll(label4,buttonGoBack2);
        About = new Scene(layoutAbout,300,300);


        // setting up home screen to show
        main.setScene(homeScene);
        main.setTitle("Home screen");
        main.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}