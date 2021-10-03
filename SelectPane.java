/**
 * Assignment #6 
 * ASU - CSE205
 * Name: Arvin Jha
 * Student ID: 1221497264
 * Lecture: 10:10AM - 11:00AM M W F
 * Description: SelectPane displays a list of available courses
    from which a user can select and compute total number of students in multiple courses.
*/

import java.util.ArrayList;

import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
* SelectPane displays a list of available courses from which a user
* can select and compute total number of students for selected courses.
*/
public class SelectPane extends BorderPane {

    //declare instance varibales
    private ArrayList<Course> courseList;
    private final Label selectCoursesPromptLabel = new Label("Select course(s)"); //constant label
    private Label totalStudentNumberLabel;
    private VBox checkboxContainer;
    private SelectionHandler handler;
    private ScrollPane scrollPane;

    public SelectPane(ArrayList<Course> list) {
        /* ------------------------------ */
        /* Instantiate instance variables */
        /* ------------------------------ */

        this.courseList = list;

        //student num label
        totalStudentNumberLabel = new Label("Total number of students for the selected course(s): 0");

        //handler
        handler = new SelectionHandler(0);

        //vbox
        checkboxContainer = new VBox();

        //scroll
        scrollPane = new ScrollPane();
        scrollPane.setContent(checkboxContainer);
        scrollPane.setPrefSize(checkboxContainer.getMaxHeight(), checkboxContainer.getMaxWidth());

        //SelectPane is a BorderPane - add the components here
        selectCoursesPromptLabel.setPadding(new Insets(10, 10, 10, 10));        //top
        this.setTop(selectCoursesPromptLabel);

        checkboxContainer.setPadding(new Insets(10, 10, 10, 10));
        scrollPane.setPadding(new Insets(10, 10, 10, 10));                      //middle
        this.setCenter(scrollPane);

        totalStudentNumberLabel.setPadding(new Insets(10, 10, 10, 10));
        this.setBottom(totalStudentNumberLabel);                                //bottom
                
    } // end of SelectPane constructor

    // This method uses the newly added parameter Course object
    // to create a CheckBox and add it to a pane created in the constructor
    // Such check box needs to be linked to its handler class
    public void updateCourseList(Course newcourse) {
        // Create checkbox for new course with appropriate text
        CheckBox newBox = new CheckBox(newcourse.toString());
        newBox.setPadding(new Insets(10, 10, 10, 10));

        // Bind checkbox toggle action to event handler
        newBox.setOnAction(handler);                                   //doesnt seem correct
        // Passes the number of students in each course to the handler. When the checkbox is
        // toggled, this number will be added/subtracted from the total number of selected students                         //HOW

        // Add new checkbox to checkbox container
        checkboxContainer.getChildren().add(newBox);

    } // end of updateCourseList method

    /**
     * SelectionHandler This class handles a checkbox toggle event. When the
     * checkbox is toggled, this number will be added/subtracted from the total
     * number of selected students.
     */
    private class SelectionHandler implements EventHandler<ActionEvent> {
        // Instance variable for number of students associated with a given course/checkbox
        private int numStudents;


        public SelectionHandler(int nums) {
            this.numStudents = nums;
        } // end of SelectionHandler constructor

        //over-ride the abstract method handle
        public void handle(ActionEvent event) {
            // Get the object that triggered the event, and cast it to a checkbox, since
            // only a course checkbox
            // can trigger the SelectionHandler event. The cast is necessary to have access
            // to the isSelected() method

            CheckBox source = (CheckBox) event.getSource();

            // Update the label with the new number of selected students
            for(Course aCourse: courseList) {
                if(aCourse.toString().equalsIgnoreCase(source.getText())) {
                    if(source.isSelected()) {
                        numStudents += aCourse.getNumStudents();
                    } else {
                        numStudents -= aCourse.getNumStudents();
                    }
                }
            }

            totalStudentNumberLabel.setText("Total number of students for the selected course(s): " + numStudents);


        } // end handle method

    } // end of SelectHandler class
} // end of SelectPane class
