import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class GeneralPane extends GridPane { //grid pane

    private ComboBox<Course> courseDropDown;
    private Label finalGradeLabel;
    private GridPane topBox;

    // private VBox assignmentNode, quizNode, testNode;
    private ArrayList<Course> courselist; 

    private VBox assignmentsBox, quizBox, testBox;
    private ScrollPane bar1, bar2, bar3;
    private HBox assignmentGradeBox, quizGradeBox, testGradeBox;
    private Label assignmentGradeLabel, assignmentWorth, quizGradeLabel, quizWorth, testGradeLabel, testWorth;

    private Label assignmentLabel;
    private Label quizLabel = new Label("Quizzes");
    private Label testLabel = new Label("Test");

    public GeneralPane(ArrayList<Course> list) {
        courselist = list;

        courseDropDown = new ComboBox<Course>();
        courseDropDown.getItems().add(courselist.get(0));
        finalGradeLabel = new Label("This is where the grade will go");

        //top part of window
        topBox = new GridPane();
            topBox.add(courseDropDown, 0, 0);
            topBox.add(finalGradeLabel, 1, 0);

            topBox.setVgap(5);
            topBox.setHgap(5);

            courseDropDown.setMaxWidth(Double.MAX_VALUE);
            courseDropDown.setPrefWidth(AssignmentHonors.WINSIZE_X/2);

            finalGradeLabel.setPrefWidth(AssignmentHonors.WINSIZE_X/2);
            finalGradeLabel.setAlignment(Pos.CENTER);

            GridPane.setHgrow(courseDropDown, Priority.ALWAYS);

        //top part of middle assignment node
        assignmentLabel = new Label("Assignments");
            assignmentLabel.setPrefHeight(AssignmentHonors.WINSIZE_X/2);
            GridPane.setHgrow(assignmentLabel, Priority.ALWAYS);

        //middle part of node
        assignmentsBox = new VBox();
        bar1 = new ScrollPane();
        bar1.setContent(assignmentsBox);

        //bottom part of node
        assignmentGradeBox = new HBox();
        assignmentGradeLabel = new Label("grade");  
        assignmentWorth = new Label("worth");
        assignmentGradeBox.getChildren().addAll(assignmentGradeLabel, assignmentWorth);

        // assignmentNode.getChildren().addAll(assignmentLabel, assignmentsBox); //assignment node complete

        this.add(topBox, 0, 0);                             //top row
        GridPane.setHgrow(topBox, Priority.ALWAYS);

        this.add(assignmentLabel, 0, 1);                    //second row
        this.add(quizLabel, 1, 1);
        this.add(testLabel, 2, 1);

        this.add(assignmentsBox, 0, 2);                     //third row

        this.add(assignmentGradeBox, 0, 3);                 //last row


        

    }
}
