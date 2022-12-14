import java.util.ArrayList;
import javafx.scene.paint.Color;
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
public class CoursePane extends ScrollPane {

    private ArrayList<Course> courseList;
    private ComboBox<Course> courseDropDown;
    private Label errorLabel;
    private TextField courseName, courseCode, assignmentWorthField, quizWorthField, testWorthField;
    private CheckBox lowestTestDropped;
    private VBox coursesAddedBox;
    private GradePane gradePane;

    public CoursePane(GradePane gradePane, ComboBox<Course> courseDropDown, ArrayList<Course> courselist) {
        this.courseDropDown = courseDropDown;
        this.courseList = courselist;
        this.gradePane = gradePane;

        //containers
        GridPane fieldContainer = new GridPane();
        VBox leftSideBox = new VBox();

        /**
         * LEFT SIDE OF TOP PORTION
         */
        //labels
        Label nameLabel = new Label("Course Name: ");
        Label codeLabel = new Label("Code: ");
        Label assignmentWorthLabel = new Label("Percent that Assignments are worth: ");
        Label quizWorthLabel = new Label("Percent that Quizzes are worth: ");
        Label testWorthLabel = new Label("Percent that Tests are worth: ");
        Label testDroppedLabel = new Label("Is the lowest test score dropped? ");

            //error label
            errorLabel = new Label("");
            errorLabel.setPadding(new Insets(10, 10, 10, 10));
            errorLabel.setTextFill(Color.RED);

        //text fields
        courseName = new TextField();
        courseCode = new TextField();
        assignmentWorthField = new TextField();
        quizWorthField = new TextField();
        testWorthField = new TextField();

        //check box
        lowestTestDropped = new CheckBox();
        
        //add labels, fields to grid container
        fieldContainer.add(nameLabel, 0, 0);
        fieldContainer.add(codeLabel, 0, 1);
        fieldContainer.add(assignmentWorthLabel, 0, 2);
        fieldContainer.add(quizWorthLabel, 0, 3);
        fieldContainer.add(testWorthLabel, 0, 4);
        fieldContainer.add(courseName, 1, 0);
        fieldContainer.add(courseCode, 1, 1);
        fieldContainer.add(assignmentWorthField, 1, 2);
        fieldContainer.add(quizWorthField, 1, 3);
        fieldContainer.add(testWorthField, 1, 4);

        //add checkbox to grid container
        fieldContainer.add(testDroppedLabel, 0, 5);
        fieldContainer.add(lowestTestDropped, 1, 5);

        fieldContainer.setHgap(10);
        fieldContainer.setVgap(5);
        fieldContainer.setPadding(new Insets(10, 10, 10, 10));
        
        //make buttons
        Button addCourseButton = new Button("Add Course");
        Button removeCourseButton = new Button("Remove Course");

            //listener
            addCourseButton.setOnAction(new ButtonHandler());
            removeCourseButton.setOnAction(new CourseRemovalHandler());

        //assemble fields and button
        leftSideBox.getChildren().addAll(errorLabel, fieldContainer, addCourseButton);
        leftSideBox.setAlignment(Pos.CENTER);

        /**
         * RIGHT SIDE OF TOP PORTION
         */
        coursesAddedBox = new VBox();               //holds checkboxes for all the courses
        coursesAddedBox.setPadding(new Insets(10, 10, 10, 10));
        coursesAddedBox.setAlignment(Pos.CENTER_LEFT);

        //scroll pane for right side course container
        ScrollPane addedCoursesScroll = new ScrollPane();
        addedCoursesScroll.setContent(coursesAddedBox);
        addedCoursesScroll.setPrefWidth(AssignmentHonors.WINSIZE_X/2);
        addedCoursesScroll.setPrefHeight(AssignmentHonors.WINSIZE_Y/2);
        addedCoursesScroll.setMaxHeight(AssignmentHonors.WINSIZE_Y);

        //remove button and courses container
        VBox rightSideBox = new VBox();
        rightSideBox.getChildren().addAll(addedCoursesScroll, removeCourseButton);
        rightSideBox.setPadding(new Insets(30, 0, 0, 0));

        //assemble left and right side
        HBox finalBox = new HBox();
        finalBox.getChildren().addAll(leftSideBox, rightSideBox);

        //add scroll to entire pane
        this.setContent(finalBox);
        
        //update content in boxes and courses available
        updateBox();
        updateDropDown();

        //update courses in dropdown in grade pane
        gradePane.updateDropDown();
    }

    /**
     * LISTENGERS
     */
    private class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            //reset error label
            errorLabel.setText("");

            // If any field is empty, display error
            if(courseName.getText().isEmpty() || courseCode.getText().isEmpty() || assignmentWorthField.getText().isEmpty() || quizWorthField.getText().isEmpty() || testWorthField.getText().isEmpty()) {
                errorLabel.setText("Please fill all fields");
                return;
            }

            try {
                //get text for all data fields and options selected
                String name = courseName.getText();
                String code = courseCode.getText();
                double worthPercentA = Double.parseDouble(assignmentWorthField.getText());
                double worthPercentQ = Double.parseDouble(quizWorthField.getText());
                double worthPercentT = Double.parseDouble(testWorthField.getText());
                boolean isTestDropped = lowestTestDropped.isSelected();

                //create course obj
                Course newCourse = new Course(name, code, isTestDropped, worthPercentA, worthPercentT, worthPercentQ);
                //check if course already exists
                for(Course aCourse: courseList){
                    if(newCourse.toString().equalsIgnoreCase(aCourse.toString())) {
                        throw new Exception();
                    }
                }
                
                //add to list
                courseList.add(newCourse);

                //reset fields
                courseName.setText("");
                courseCode.setText("");
                assignmentWorthField.setText("");
                quizWorthField.setText("");
                testWorthField.setText("");
                lowestTestDropped.setSelected(false);

            } catch (NumberFormatException e) {
                errorLabel.setText("Please enter decimal or integers for the percentages.");
            } catch (Exception e) {
                errorLabel.setText("Duplicate course detected.");
                e.printStackTrace();
            }

            //update listed courses and grades
            updateBox();
            updateDropDown();
            gradePane.updateDropDown();

        }
        
    }
    private class CourseRemovalHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            //reset error label
            errorLabel.setText("");

            try {

                if(coursesAddedBox.getChildren().isEmpty()) {   //no courses selected to be removed
                    errorLabel.setText("No courses available for removal");
                    return;
                }

                //go through each course box
                for(int i = 0; i < courseList.size(); i++) {
                    CheckBox box = (CheckBox) coursesAddedBox.getChildren().get(i);

                    //if box is selected, remove it from list and gui 
                    if(box.isSelected()) {
                        courseList.remove(i);
                        i--;
                    }
                }

                //update gui
                updateDropDown();
                gradePane.updateDropDown();
                updateBox();
            } catch (Exception e) {
                errorLabel.setText("Unidenfitied Error Occurred");
                e.printStackTrace();
            }
        }
        
    }

    //helper methods
    //updates courses box on right
    private void updateBox() {

        //remove all elements in gui
        coursesAddedBox.getChildren().clear();

        //iterate through courses
        for(int i = 0; i < courseList.size(); i++) {

            //create checkbox 
            CheckBox courseCheckBox = new CheckBox(courseList.get(i).toString());
            courseCheckBox.setPadding(new Insets(10, 10, 10, 10));

            //add to container
            coursesAddedBox.getChildren().addAll(courseCheckBox);
        }
    }

    //updates drop down of coureses
    public void updateDropDown() {

        //clears courses
        courseDropDown.getItems().clear();

        try {
            //re-add all courses from list
            for(Course aCourse: courseList) {
                courseDropDown.getItems().add(aCourse);
            }
        } catch (Exception e) {}
    }
}