/**
 * Assignment #6 
 * ASU - CSE205
 * Name: Arvin Jha
 * Student ID: 1221497264
 * Lecture: 10:10AM - 11:00AM M W F
 * Description: GeneratePane creats a pane where a user can enter
course information and create a list of available courses.
*/

/* --------------- */
/* Import Packages */
/* --------------- */

import java.util.ArrayList;

import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * GeneratePane builds a pane where a user can enter a course
 * information and create a list of available courses.
 */
public class CoursePane extends HBox {
    /* ------------------ */
    /* Instance variables */
    /* ------------------ */

    ArrayList<Course> courseList;
    private SelectPane selectPane;
    private Label message;
    private TextField courseTitleField, instructorNameField, universityNameField, studentSizeField;
    private Button addCourseButton;
    private TextArea addedCoursesArea;

    /**
     * CreatePane constructor
     *
     * @param list   the list of courses
     * @param sePane the SelectPane instance
     */
    public CoursePane(ArrayList<Course> list, SelectPane sePane) {
        /* ------------------------------ */
        /* Instantiate instance variables */
        /* ------------------------------ */
        courseList = list;
        selectPane = sePane;

        //buttons
        addCourseButton = new Button("Add a course");

        //text fields
        courseTitleField = new TextField();
        instructorNameField = new TextField();
        universityNameField = new TextField();
        studentSizeField = new TextField();

        /* ------------------------------ */
        /*  Instantiate local variables   */
        /* ------------------------------ */

        //labels
        Label courseTitleLabel = new Label("Course Title");
        Label instructorNameLabel = new Label("Instructor Name");
        Label universityNameLabel = new Label("University");
        Label studentSizeLabel = new Label("Number of Students");

            //msg label
            message = new Label("");
            message.setTextFill(Color.RED);

        //vboxes
        VBox generatePaneVBox = new VBox();
        VBox textFieldsAndButtonVBox = new VBox();

        //grid pane
        GridPane gridPane = new GridPane();		

		//left half layout of the GeneratePane.
        //grid pane nodes
        gridPane.add(courseTitleLabel, 0, 0); //course title
        gridPane.add(courseTitleField, 1, 0);
        gridPane.add(instructorNameLabel, 0, 1); //instructor
        gridPane.add(instructorNameField, 1, 1);
        gridPane.add(universityNameLabel, 0, 2); //university
        gridPane.add(universityNameField, 1, 2);
        gridPane.add(studentSizeLabel, 0, 3); //number of students
        gridPane.add(studentSizeField, 1, 3);

        //grid pane layout
        gridPane.setHgap(10);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //grid and button layout
        textFieldsAndButtonVBox.getChildren().addAll(gridPane, addCourseButton);
        textFieldsAndButtonVBox.setAlignment(Pos.CENTER);

        //msg
        message.setPadding(new Insets(10, 0, 10, 10));

        //error msg and grid layout
        generatePaneVBox.getChildren().addAll(message, textFieldsAndButtonVBox);
        generatePaneVBox.setAlignment(Pos.TOP_LEFT);

        // Set both left and right columns to 50% width (half of window)
		ColumnConstraints halfWidth = new ColumnConstraints();
		halfWidth.setPercentWidth(50);
        gridPane.getColumnConstraints().addAll(halfWidth, halfWidth);

        //right half layout
		//text area
        addedCoursesArea = new TextArea("No Courses");
        addedCoursesArea.setEditable(false);

        //combine
        this.getChildren().addAll(generatePaneVBox, addedCoursesArea);

		//register/link source object with event handler
        ButtonHandler handler = new ButtonHandler();
        addCourseButton.setOnAction(handler);        // Bind button click action to event handler


    } // end of constructor

    /**
     * ButtonHandler ButtonHandler listens to see if the button "Add a course" is pushed
     * or not, When the event occurs, it asks for course and instructor name, number of students enrolled,
     * and its university information from the relevant text fields, then create a
     * new course and adds it to the courseList. Meanwhile it will display the course's
     * information inside the text area. using the toString method of the Course
     * class. It also does error checking in case any of the text fields are empty,
     * or a non-numeric value was entered for number of student
     */
    private class ButtonHandler implements EventHandler<ActionEvent> {
        /**
         * handle Override the abstract method handle()
         */
        public void handle(ActionEvent event) {
            // Declare local variables
            Course newCourse;
            int numberOfStudents = 0;

            // If any field is empty, set isEmptyFields flag to true (?)
            if(courseTitleField.getText().isEmpty() || instructorNameField.getText().isEmpty() || universityNameField.getText().isEmpty() || studentSizeField.getText().isEmpty()) {
                message.setText("Please fill all fields");
                return;
            }

            // If all fields are filled, try to add the course
            try {
                    //cast number of students as int, throws NumberFormatExxception if failed
                    numberOfStudents = Integer.parseInt(studentSizeField.getText());

                    //make new course
                    newCourse = new Course(courseTitleField.getText(), new Instructor("", instructorNameField.getText(), "", 0), universityNameField.getText(), numberOfStudents);
                    
                    // Loop through existing departments to check for duplicates
                    // and if exist do not add it to the list and display a message
                    for(Course aCourse: courseList){
                        if(newCourse.toString().equalsIgnoreCase(aCourse.toString())) {
                            throw new Exception();
                        }
                    }

                    //add it to list
                    courseList.add(newCourse);
                    message.setText("Course Added");

                    //display all courses
                    addedCoursesArea.setText("");
                    String currentText = "";
                    for(Course course: courseList) {
                        currentText += course.toString();
                    }
                    addedCoursesArea.setText(currentText);

                    //reset fields
                    courseTitleField.setText("");
                    universityNameField.setText("");
                    instructorNameField.setText("");
                    studentSizeField.setText("");

                    //update selectPane
                    selectPane.updateCourseList(newCourse); 


                } //end of try
                catch (NumberFormatException e) {
                    // If the number of students entered was not an integer, display an error
                    message.setText("Please enter an integer for the number of student(s)");
                } 
                catch (Exception e) {
                    // Catches generic exception and displays message
                    // Used to display 'Course is not added - already exist' message if course already exist
                    message.setText("Course is not added - already exist");                                                  //must be red msg
                }

           
        } // end of handle() method
    } // end of ButtonHandler class
} // end of GeneratePane class


