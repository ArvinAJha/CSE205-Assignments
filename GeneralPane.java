import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GeneralPane extends BorderPane {

    private ComboBox<Course> courseDropDown;
    private Label finalGradeLabel;
    private HBox topBox;

    private VBox assignmentNode, quizNode, testNode;


    private VBox assignmentsBox, quizBox, testBox;
    private ScrollPane bar1, bar2, bar3;
    private HBox assignmentGradeBox, quizGradeBox, testGradeBox;
    private Label assignmentGradeLabel, assignmentWorth, quizGradeLabel, quizWorth, testGradeLabel, testWorth;
    private final Label assignmentLabel = new Label("Assignments");
    private final Label quizLabel = new Label("Quizzes");
    private final Label testLabel = new Label("Test");

    public GeneralPane() {
        courseDropDown = new ComboBox<Course>();
        finalGradeLabel = new Label("This is where the grade will go");

        topBox = new HBox();
        topBox.getChildren().addAll(courseDropDown, finalGradeLabel);

        assignmentNode = new VBox();

        //bottom part of node
        assignmentGradeBox = new HBox();
        assignmentGradeLabel = new Label("grade");  
        assignmentWorth = new Label("worth");
        assignmentGradeBox.getChildren().addAll(assignmentGradeLabel, assignmentWorth);

        //middle part of node
        assignmentsBox = new VBox();
        bar1 = new ScrollPane();
        bar1.setContent(assignmentsBox);


        assignmentNode.getChildren().addAll(assignmentLabel, assignmentsBox, assignmentGradeBox); //assignment node complete

        this.setTop(topBox);
        this.setCenter(assignmentNode);

    }
}
