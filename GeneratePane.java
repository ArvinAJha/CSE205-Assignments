// Assignment 6: ASU - CSE 205
// Name:
// StudentID:
//Lecture Date and Time:
//  Description: GeneratePane creats a pane where a user can enter
//  course information and create a list of available courses.

/* --------------- */
/* Import Packages */
/* --------------- */

import java.util.ArrayList;

import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import

// JavaFX classes
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * GeneratePane builds a pane where a user can enter a course
 * information and create a list of available courses.
 */
public class GeneratePane extends HBox {
    /* ------------------ */
    /* Instance variables */
    /* ------------------ */

    ArrayList<Course> courseList;
    private SelectPane selectPane; // The relationship between GeneratePane and SelectPane is Aggregation
    //declare and init

    /**
     * CreatePane constructor
     *
     * @param list   the list of courses
     * @param sePane the SelectPane instance
     */
    public GeneratePane(ArrayList<Course> list, SelectPane sePane) {
        /* ------------------------------ */
        /* Instantiate instance variables */
        /* ------------------------------ */


        //initialize each instance variable (textfields, labels, textarea, button, etc.)
		//and set up the layout

		//create a GridPane to hold labels & text fields.
		//you can choose to use .setPadding() or setHgap(), setVgap()
		//to control the spacing and gap, etc.

		// Set both left and right columns to 50% width (half of window)
		ColumnConstraints halfWidth = new ColumnConstraints();
		halfWidth.setPercentWidth(50);
        gridPane.getColumnConstraints().addAll(halfWidth, halfWidth);
		//You might need to create a sub pane to hold the button

		//Set up the layout for the left half of the GeneratePane.

		//the right half of the GeneratePane is simply a TextArea object
		//Note: a ScrollPane will be added to it automatically when there are no more space
		//Add the left half and right half to the GeneratePane


		//Note: GeneratePane extends from HBox
		//register/link source object with event handler
                // Bind button click action to event handler


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

            // If any field is empty, set isEmptyFields flag to true

            // Display error message if there are empty fields


            // If all fields are filled, try to add the course
            try {
                    /*
                     * Cast students Field to an integer, throws NumberFormatException if unsuccessful
                     */


                    // Data is valid, so create new Department object and populate data

                    // Loop through existing departments to check for duplicates
                    // and if exist do not add it to the list and display a message




                    // else course is not a duplicate, so display it and add it to list

                } //end of try
                catch (NumberFormatException e) {
                    // If the number of students entered was not an integer, display an error

                } 
                catch (Exception e) {
                    // Catches generic exception and displays message
                    // Used to display 'Course is not added - already exist' message if course already exist

                }

           
        } // end of handle() method
    } // end of ButtonHandler class
} // end of GeneratePane class


