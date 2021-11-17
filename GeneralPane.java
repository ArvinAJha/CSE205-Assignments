import java.util.ArrayList;

import LinkedLists.GradeLinkedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class GeneralPane extends BorderPane { //grid pane

    private ArrayList<Course> courseList; 

    private ComboBox<Course> courseDropDown;

    private VBox assignmentsBox, quizBox, testBox;

    private Label finalGradeLabel;
    private Label assignmentGradeLabel, assignmentWorth, quizGradeLabel, quizWorth, testGradeLabel, testWorth;

    public GeneralPane(ComboBox<Course> box, ArrayList<Course> list) {

        courseList = list;

        /** Dropdown and total grade */
        courseDropDown = box;
        finalGradeLabel = new Label("None");
        
        //drop down listener
        courseDropDown.setOnAction(new DropDownListener());

        //top part of window
        GridPane topBox = new GridPane();
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
        Label assignmentLabel = new Label("Assignments");
        assignmentLabel.setPadding(new Insets(10, 10, 10, 10));

        //middle part of node
        assignmentsBox = new VBox();

        ScrollPane bar1 = new ScrollPane();
        bar1.setContent(assignmentsBox);

        assignmentsBox.setPadding(new Insets(10, 0, 0, 10));
        
        //bottom part of node
        HBox assignmentGradeBox = new HBox();
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
        assignmentNode.setStyle("-fx-background-color: white");

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
        Label quizLabel = new Label("Quizzes");
        quizLabel.setPadding(new Insets(10, 10, 10, 10));
        
        //middle part
        quizBox = new VBox();
        ScrollPane bar2 = new ScrollPane();
        bar2.setContent(quizBox);

        quizBox.setPadding(new Insets(10, 0, 0, 10));

        //bottom part
        HBox quizGradeBox = new HBox();
        quizGradeLabel = new Label("quiz grade");
        quizWorth = new Label("quiz worth");
        quizGradeBox.getChildren().addAll(quizGradeLabel, quizWorth);
        quizGradeBox.setPadding(new Insets(10, 10, 10, 10));

        //assemble node
        GridPane quizNode = new GridPane();
        quizNode.add(quizLabel, 0, 0);
        quizNode.add(bar2, 0, 1);
        quizNode.add(quizGradeBox, 0, 2);

        //layout settngs
        quizNode.setPrefWidth(AssignmentHonors.WINSIZE_X/3);
        quizNode.setAlignment(Pos.TOP_CENTER);
        quizNode.setStyle("-fx-background-color: white");

        GridPane.setVgrow(bar2, Priority.ALWAYS);
        GridPane.setHgrow(bar2, Priority.ALWAYS);

        GridPane.setVgrow(quizNode, Priority.ALWAYS);
        GridPane.setHgrow(quizNode, Priority.ALWAYS);

        /**
         * Tests
         */
        //top part of assignment node
        Label testLabel = new Label("Tests");
        testLabel.setPadding(new Insets(10, 10, 10, 10));

        //middle part of node
        testBox = new VBox();
        testBox.setPadding(new Insets(10, 10, 10, 10));
        ScrollPane bar3 = new ScrollPane();
        bar3.setContent(testBox);

        //bottom part of node
        HBox testGradeBox = new HBox();
        testGradeLabel = new Label("grade");
        testWorth = new Label("worth");
        testGradeBox.getChildren().addAll(testGradeLabel, testWorth);
        testGradeBox.setPadding(new Insets(10, 10, 10, 10));

        //assemble assignment vertical node
        GridPane testNode = new GridPane();
        testNode.add(testLabel, 0, 0);
        testNode.add(bar3, 0, 1);
        testNode.add(testGradeBox, 0, 2);

        //layout settings
        testNode.setPrefWidth(AssignmentHonors.WINSIZE_X/3);
        testNode.setAlignment(Pos.TOP_CENTER);
        testNode.setStyle("-fx-background-color: white");

        GridPane.setVgrow(bar3, Priority.ALWAYS);
        GridPane.setHgrow(bar3, Priority.ALWAYS);

        GridPane.setVgrow(testNode, Priority.ALWAYS);
        GridPane.setHgrow(testNode, Priority.ALWAYS);





        /**
         * Placement to tab
         */
        //place into columns
        GridPane finalPane = new GridPane();
        finalPane.add(assignmentNode, 0, 0);
        finalPane.add(quizNode, 1, 0);
        finalPane.add(testNode, 2, 0);

        //place columns into tab
        this.setTop(topBox);
        this.setCenter(finalPane);
    }


    private class DropDownListener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            //find current course num on dropdown
            int currentCourse = courseDropDown.getSelectionModel().getSelectedIndex();

            //update columns (just assignments for now)
            updateColumns(currentCourse);

            //update final and sub grades
            finalGradeLabel.setText(getFinalGradeString(currentCourse));

            updateWorth(currentCourse);
            updateColumnGrade(currentCourse);
        }

    }

    private void updateColumns(int currentCourse) {

        if(courseList.size() < 1) {    //when there are no courses, do not update anything
            return;
        }

        assignmentsBox.getChildren().clear();
        quizBox.getChildren().clear();
        testBox.getChildren().clear();
        
        try {
            updateColumnHelper(courseList.get(currentCourse).getAssignmentLinkedList(), "Assignment");
            updateColumnHelper(courseList.get(currentCourse).getQuizLinkedList(), "Quiz");
            updateColumnHelper(courseList.get(currentCourse).getTestLinkedList(), "Test");
        } catch (Exception e) {}

    }

    private void updateColumnHelper(GradeLinkedList list, String box) {
        int count = 0;

        try {
            while(count < list.getNumOfGrade()) {           //while count < size()
                CheckBox newCourseCheckBox = new CheckBox();
                newCourseCheckBox.setPadding(new Insets(10, 10, 10, 10));

                String assignmentVals = list.toStringAtIndex(count);
                newCourseCheckBox.setText(assignmentVals);
    
                if(box.equals("Assignment"))
                    assignmentsBox.getChildren().addAll(newCourseCheckBox);
                else if(box.equals("Quiz"))
                    quizBox.getChildren().addAll(newCourseCheckBox);
                else
                    testBox.getChildren().addAll(newCourseCheckBox);

    
                count++;
            }
        } catch (IndexOutOfBoundsException e) {}
    }

    private void updateWorth(int currentCourse) {

        try {
            String assignmentW = courseList.get(currentCourse).getAssignmentWorth() + "%";
            String quizW = courseList.get(currentCourse).getQuizWorth() + "%";
            String testW = courseList.get(currentCourse).getTestWorth() + "%";
    
            assignmentWorth.setText(assignmentW);
            quizWorth.setText(quizW);
            testWorth.setText(testW);
        } catch (Exception e) {}
    }

    private void updateColumnGrade(int currentCourse) {

        //so you're going to have to somehow calculate the grade for the indiv column
        try {
            String assignmentG = courseList.get(currentCourse).getAssignmentWorth() + " - ";
            String quizG = courseList.get(currentCourse).getQuizWorth() + " - ";
            String testG = courseList.get(currentCourse).getTestWorth() + " - ";
        } catch (Exception e) {}
    }

    private String getFinalGradeString(int currentCourse) {

        try {
            return "" + courseList.get(currentCourse).calculate();
        } catch (Exception e) {
            return "None";
        }
    }

}
