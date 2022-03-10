package com.example.lab04;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // username label and text
        Label usernameLabel = new Label("Username");
        TextField usernameText = new TextField();

        // password label and text
        PasswordField passwordLabel = new PasswordField();
        Button pButton = new Button("Password");

        // full name label and text
        Label nameLabel = new Label("Full Name");
        TextField nameText = new TextField();

        // email label and text
        Label emailLabel = new Label("Email");
        TextField emailText = new TextField();

        // date of birth label and text
        Label dobLabel = new Label("Date of birth");
        DatePicker dobPicker = new DatePicker();

        // email label and text
        Label phoneLabel = new Label("Phone #");
        TextField phoneText = new TextField();

        // register button
        Button button = new Button("Register");

        // setting up Gridpane
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(500,500);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(7);
        gridPane.setHgap(7);
        gridPane.setAlignment(Pos.CENTER);

        // add all the labels/text
        gridPane.add(usernameLabel,0,0);
        gridPane.add(usernameText,1,0);

        gridPane.add(passwordLabel,1,1);
        gridPane.add(pButton,0,1);

        gridPane.add(nameLabel,0,2);
        gridPane.add(nameText,1,2);

        gridPane.add(emailLabel,0,3);
        gridPane.add(emailText,1,3);

        gridPane.add(dobLabel,0,4);
        gridPane.add(dobPicker,1,4);

        gridPane.add(phoneLabel,0,5);
        gridPane.add(phoneText,1,5);

        gridPane.add(button,1,6);

        // background
        gridPane.setStyle("-fx-background-color:WHITE;");

        // button commands
        // password button:
        Label label = new Label("");
        pButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String pWord = passwordLabel.getText();
                label.setText(pWord);

            }
        });
        gridPane.add(label,2,1);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                usernameLabel.setText(usernameLabel.getText());
                String eWord = emailLabel.getText();
                String dWord = dobLabel.getText();
                String nWord = nameLabel.getText();
                String phWord = phoneLabel.getText();


            }
        });


        // setting scene
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}