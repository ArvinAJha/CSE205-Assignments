import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GradePane extends BorderPane {

    private ArrayList<Course> courseList;
    private ComboBox<Course> courseDropDown;
    private ComboBox<String> gradeDropDown;

    private Label errorLabel;
    private TextField gradeName, pointsReceived, pointsAvailable;
    
    private Button addGradeButton;
    private Button removeGradeButton;

    private VBox gradesAddedBox;
    
    public GradePane(ArrayList<Course> courselist) {
        this.courseList = courselist;

        //containers
        HBox addGradeContainer = new HBox();       //holds added courses and fields to add more courses
        VBox dropDownBox = new VBox();             //holds the dropdowns
        GridPane fieldContainer = new GridPane();
        VBox leftSideBox = new VBox();

        /**
         * TOP SIDE 
         */
        courseDropDown = new ComboBox<Course>();
        gradeDropDown = new ComboBox<String>();
        gradeDropDown.getItems().addAll("Assignment", "Quiz", "Test");

        courseDropDown.setPrefWidth(AssignmentHonors.WINSIZE_X);
        gradeDropDown.setPrefWidth(AssignmentHonors.WINSIZE_X);

        dropDownBox.getChildren().addAll(courseDropDown, gradeDropDown);

        /**
         * LEFT SIDE
         */

        //labels
        Label nameLabel = new Label("Name: ");
        Label pointsGotLabel = new Label("Points you got: ");
        Label totalPointsLabel = new Label("Total Points: ");

        //error label
        errorLabel = new Label("");
        errorLabel.setPadding(new Insets(10, 10, 10, 10));
        errorLabel.setTextFill(Color.RED);

        //text fields
        gradeName = new TextField();
        pointsReceived = new TextField();
        pointsAvailable = new TextField();
        
        //add labels, fields to grid container
        fieldContainer.add(nameLabel, 0, 0);
        fieldContainer.add(pointsGotLabel, 0, 1);
        fieldContainer.add(totalPointsLabel, 0, 2);
        fieldContainer.add(gradeName, 1, 0);
        fieldContainer.add(pointsReceived, 1, 1);
        fieldContainer.add(pointsAvailable, 1, 2);

        fieldContainer.setHgap(10);
        fieldContainer.setVgap(5);
        fieldContainer.setPadding(new Insets(10, 10, 10, 10));
        
        //make buttons
        addGradeButton = new Button("Add");
        removeGradeButton = new Button("Remove");

            //button listener
            // addCourseButton.setOnAction(new ButtonHandler());
            // removeGradeButton.setOnAction();

        //assemble fields and button
        leftSideBox.getChildren().addAll(errorLabel, fieldContainer, addGradeButton);
        leftSideBox.setAlignment(Pos.CENTER);

        /**
         * RIGHT SIDE
         */
        gradesAddedBox = new VBox();               //holds checkboxes for all the courses
        gradesAddedBox.setPadding(new Insets(10, 10, 10, 10));
        gradesAddedBox.setAlignment(Pos.CENTER_LEFT);

        //scroll pane for right side course container
        ScrollPane addedGradesScroll = new ScrollPane();
        addedGradesScroll.setContent(gradesAddedBox);
        addedGradesScroll.setPrefWidth(AssignmentHonors.WINSIZE_X/2);
        addedGradesScroll.setPrefHeight(AssignmentHonors.WINSIZE_Y/2);
        addedGradesScroll.setMaxHeight(AssignmentHonors.WINSIZE_Y);

        //remove button and courses container
        VBox rightSideBox = new VBox();
        rightSideBox.getChildren().addAll(addedGradesScroll, removeGradeButton);
        rightSideBox.setPadding(new Insets(30, 0, 0, 0));

        //assemble left and right side
        addGradeContainer.getChildren().addAll(leftSideBox, rightSideBox);

        this.setTop(dropDownBox);
        this.setCenter(addGradeContainer);

    }


    public void updateDropDown() {
        courseDropDown.getItems().clear();
        try {
            for(Course aCourse: courseList) {
                courseDropDown.getItems().add(aCourse);
            }
        } catch (Exception e) {
            System.out.println("heh");
        }
    }

}
