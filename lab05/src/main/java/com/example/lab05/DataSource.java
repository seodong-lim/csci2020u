package com.example.lab05;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DataSource extends Application {
    public TableView<StudentRecord> table = new TableView<StudentRecord>();
    public static ObservableList<StudentRecord> getAllMarks() {
        ObservableList<StudentRecord> marks =
                FXCollections.observableArrayList();

        // Student ID, Assignments, Midterm, Final exam
        marks.add(new StudentRecord("100100100", 75.0f, 68.0f, 54.25f));
        marks.add(new StudentRecord("100100101", 70.0f, 69.25f, 51.5f));
        marks.add(new StudentRecord("100100102", 100.0f, 97.0f, 92.5f));
        marks.add(new StudentRecord("100100103", 90.0f, 88.5f, 68.75f));
        marks.add(new StudentRecord("100100104", 72.25f, 74.75f, 58.25f));
        marks.add(new StudentRecord("100100105", 85.0f, 56.0f, 62.5f));
        marks.add(new StudentRecord("100100106", 70.0f, 66.5f, 61.75f));
        marks.add(new StudentRecord("100100107", 55.0f, 47.0f, 50.5f));
        marks.add(new StudentRecord("100100108", 40.0f, 32.5f, 27.75f));
        marks.add(new StudentRecord("100100109", 82.5f, 77.0f, 74.25f));
        return marks;
    }
    public static void main(String[] args) {
        launch(args);
    }

    
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Lab 05");
        stage.setWidth(700);
        stage.setHeight(700);

        final Label label = new Label("Student marks");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn student_idCol = new TableColumn("Student ID");
        student_idCol.setMinWidth(100);
        student_idCol.setCellValueFactory(
                new PropertyValueFactory<StudentRecord, String>("Sid"));

        TableColumn assignmentsCol = new TableColumn("Assignments");
        assignmentsCol.setMinWidth(100);
        assignmentsCol.setCellValueFactory(
                new PropertyValueFactory<StudentRecord, Float>("assignment"));

        TableColumn midtermCol = new TableColumn("Midterm");
        midtermCol.setMinWidth(100);
        midtermCol.setCellValueFactory(
                new PropertyValueFactory<StudentRecord, Float>("midTerm"));

        TableColumn finalExamCol = new TableColumn("Final Exam");
        finalExamCol.setMinWidth(100);
        finalExamCol.setCellValueFactory(
                new PropertyValueFactory<StudentRecord, Float>("finalExam"));

        TableColumn finalMark = new TableColumn("Final Mark");
        finalMark.setMinWidth(100);
        finalMark.setCellValueFactory(
                new PropertyValueFactory<StudentRecord, Float>("finalMark"));

        TableColumn letterGrade = new TableColumn("Letter Grade");
        letterGrade.setMinWidth(100);
        letterGrade.setCellValueFactory(
                new PropertyValueFactory<StudentRecord, Float>("letterGrade"));


        table.setItems(getAllMarks());
        table.getColumns().addAll(student_idCol,assignmentsCol,midtermCol,finalExamCol,finalMark,letterGrade);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group)scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }
    public static class StudentRecord {

        private String Sid;
        private float midTerm;
        private float Assignment;
        private float finalExam;
        private float finalMark;
        private String letterGrade;

        public StudentRecord(String s, float v, float v1, float v2) {
            this.Sid = s;
            this.Assignment = v;
            this.midTerm = v1;
            this.finalExam = v2;
            this.finalMark = getFinalMark();
            this.letterGrade = getLetterGrade();
        }
        public String getSid(){
            return this.Sid;
        }
        public void setSid(String s){
            this.Sid = s;
        }

        public float getAssignment(){
            return this.Assignment;
        }
        public void setAssignment(float s){
            this.Assignment = s;
        }

        public float getMidTerm(){
            return this.midTerm;
        }
        public void setMidTerm(float s){
            this.midTerm = s;
        }

        public float getFinalExam(){
            return this.finalExam;
        }
        public void setFinalExam(float s){
            this.finalExam = s;
        }

        public float getFinalMark(){
            this.finalMark= (this.midTerm+this.finalExam+this.Assignment)/3;
            return this.finalMark;
        }
        public float setFinalMark(){
            return this.finalMark= (this.midTerm+this.finalExam+this.Assignment)/3;
        }

        public String getLetterGrade(){
            String a = null;
            if(this.finalMark>80){
                a = "A";
                return a;
            }
            else if(this.finalMark>70){
                a = "B";
                return a;
            }
            else if(this.finalMark>60){
                a = "C";
                return a;
            }
            else if(this.finalMark>50){
                a = "D";
                return a;
            }
            else{
                a = "F";
            }
            return a;
        }
    }
}