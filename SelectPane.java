// Assignment #: 6
// Arizona State University - CSE205
//  Description: SelectPane displays a list of available courses
//  from which a user can select and compute total number of students in multiple courses.

import java.util.ArrayList;

import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import
import javafx.scene.layout.BorderPane;

/**
* SelectPane displays a list of available courses from which a user
* can select and compute total number of students for selected courses.
*/
public class SelectPane extends BorderPane {

    //declare instance varibales
    private ArrayList<Course> courseList;



    public SelectPane(ArrayList<Course> list) {
        /* ------------------------------ */
        /* Instantiate instance variables */
        /* ------------------------------ */

        this.courseList = list;


        // Wrap checkboxContainer in ScrollPane so formatting is
        // correct when many courses are added



        // Setup layout

        //create an empty pane where you can add check boxes later


        //SelectPane is a BorderPane - add the components here



    } // end of SelectPane constructor

    // This method uses the newly added parameter Course object
    // to create a CheckBox and add it to a pane created in the constructor
    // Such check box needs to be linked to its handler class
    public void updateCourseList(Course newcourse) {
        // Create checkbox for new course with appropriate text

        // Bind checkbox toggle action to event handler
        // Passes the number of students in each course to the handler. When the checkbox is
        // toggled, this number will be added/subtracted from the total number of selected students


        // Add new checkbox to checkbox container

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
            this.numStudents = members; // Set instance variable
        } // end of SelectionHandler constructor

        //over-ride the abstract method handle
        public void handle(ActionEvent event) {
            // Get the object that triggered the event, and cast it to a checkbox, since
            // only a course checkbox
            // can trigger the SelectionHandler event. The cast is necessary to have access
            // to the isSelected() method


            // Update the label with the new number of selected students

        } // end handle method
    } // end of SelectHandler class
} // end of SelectPane class
