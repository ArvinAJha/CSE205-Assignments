import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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

    private final Label assignmentLabel = new Label("Assignments");
    private final Label quizLabel = new Label("Quizzes");
    private final Label testLabel = new Label("Test");

    public GeneralPane(ArrayList<Course> list) {
        courseDropDown = new ComboBox<Course>();
        finalGradeLabel = new Label("This is where the grade will go");

        topBox = new GridPane();
        // topBox.getChildren().addAll(courseDropDown, finalGradeLabel);
        topBox.add(courseDropDown, 0, 0);
        topBox.add(finalGradeLabel, 1, 0);
        topBox.setVgap(5);
        topBox.setHgap(5);

        topBox.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

        // assignmentNode = new VBox();
        this.courselist = list;

        //bottom part of node
        assignmentGradeBox = new HBox();
        assignmentGradeLabel = new Label("grade");  
        assignmentWorth = new Label("worth");
        assignmentGradeBox.getChildren().addAll(assignmentGradeLabel, assignmentWorth);

        //middle part of node
        assignmentsBox = new VBox();
        bar1 = new ScrollPane();
        bar1.setContent(assignmentsBox);


        // assignmentNode.getChildren().addAll(assignmentLabel, assignmentsBox); //assignment node complete

        this.add(topBox, 0, 0);

        this.add(assignmentLabel, 0, 1);
        this.add(quizLabel, 1, 1);
        this.add(testLabel, 2, 1);

        this.add(assignmentsBox, 0, 2);


        

    }
}
