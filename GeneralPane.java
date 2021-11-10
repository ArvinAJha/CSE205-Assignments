import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class GeneralPane extends BorderPane { //grid pane

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
    private Label quizLabel;
    private Label testLabel = new Label("Test");

    public GeneralPane(ArrayList<Course> list) {

        /** General Nodes */
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
            GridPane.setHgrow(topBox, Priority.ALWAYS);







        /**
         * Assignments
         */
        //top part of assignment node
        assignmentLabel = new Label("Assignments");
        assignmentLabel.setPadding(new Insets(10, 10, 10, 10));

        //middle part of node
        assignmentsBox = new VBox();
        bar1 = new ScrollPane();
        bar1.setContent(assignmentsBox);

        assignmentsBox.setPadding(new Insets(10, 0, 0, 10));
        
        //bottom part of node
        assignmentGradeBox = new HBox();
        assignmentGradeLabel = new Label("grade");  
        assignmentWorth = new Label("worth");
        assignmentGradeBox.getChildren().addAll(assignmentGradeLabel, assignmentWorth);
        assignmentGradeBox.setPadding(new Insets(10, 10, 10, 10));

        //assemble assignment vertical node
        GridPane assignmentNode = new GridPane();
        assignmentNode.add(assignmentLabel, 0, 0);
        assignmentNode.add(bar1, 0, 1);
        assignmentNode.add(assignmentGradeBox, 0, 2);

        //layout settings
        assignmentNode.setPrefWidth(AssignmentHonors.WINSIZE_X/3);
        assignmentNode.setAlignment(Pos.CENTER);
        assignmentNode.setStyle("-fx-background-color: red");                           //temp

        //resize entire assignment column
        GridPane.setVgrow(assignmentNode, Priority.ALWAYS);
        GridPane.setHgrow(assignmentNode, Priority.ALWAYS);

        //resize the list of assignments user added
        GridPane.setVgrow(bar1, Priority.ALWAYS);
        GridPane.setHgrow(bar1, Priority.ALWAYS);







        /**
         * Quizzes
         */
        //top part of quiz node
        quizLabel = new Label("Quizzes");
        quizLabel.setPadding(new Insets(10, 10, 10, 10));
        
        //middle part
        quizBox = new VBox();
        quizBox.setPadding(new Insets(10, 10, 10, 10));
        bar2 = new ScrollPane();
        bar2.setContent(quizBox);

        //bottom part
        quizGradeBox = new HBox();
        quizGradeLabel = new Label("quiz grade");
        quizWorth = new Label("quiz worth");
        quizGradeBox.getChildren().addAll(quizGradeLabel, quizWorth);
        quizGradeBox.setPadding(new Insets(10, 10, 10, 10));

        //assemble node
        GridPane quizNode = new GridPane();
        // quizNode.add(quizLabel, 0, 0);
        quizNode.add(bar2, 0, 1);
        // quizNode.add(quizGradeBox, 0, 2);

        //layout settngs
        quizNode.setPrefWidth(AssignmentHonors.WINSIZE_X/3);
        quizNode.setAlignment(Pos.TOP_CENTER);
        quizNode.setStyle("-fx-background-color: black");
        GridPane.setVgrow(quizNode, Priority.ALWAYS);
        GridPane.setHgrow(quizNode, Priority.ALWAYS);





        /**
         * Assignments
         */
        //top part of assignment node
        testLabel = new Label("Assignments");
        testLabel.setPadding(new Insets(10, 10, 10, 10));

        //middle part of node
        testBox = new VBox();
        testBox.setPadding(new Insets(10, 10, 10, 10));
        bar3 = new ScrollPane();
        bar3.setContent(assignmentsBox);

        //bottom part of node
        testGradeBox = new HBox();
        testGradeLabel = new Label("grade");  
        testWorth = new Label("worth");
        testGradeBox.getChildren().addAll(testGradeLabel, testWorth);
        testGradeBox.setPadding(new Insets(10, 10, 10, 10));

        //assemble assignment vertical node
        GridPane testNode = new GridPane();
        // assignmentNode.add(assignmentLabel, 0, 0);
        testNode.add(bar3, 0, 1);
        // assignmentNode.add(assignmentGradeBox, 0, 2);

        //layout settings
        // assignmentsBox.setMaxHeight(Double.MAX_VALUE);
        testNode.setPrefWidth(AssignmentHonors.WINSIZE_X/3);
        testNode.setAlignment(Pos.TOP_CENTER);
        testNode.setStyle("-fx-background-color: red");

        GridPane.setVgrow(testNode, Priority.ALWAYS);
        GridPane.setHgrow(testNode, Priority.ALWAYS);





        /**
         * Placement to tab
         */
        GridPane finalPane = new GridPane();
        finalPane.add(assignmentNode, 0, 0);
        finalPane.add(quizNode, 1, 0);
        finalPane.add(testNode, 2, 0);

        this.setTop(topBox);
        this.setCenter(finalPane);
        

    }
}