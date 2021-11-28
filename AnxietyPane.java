import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;

public class AnxietyPane extends BorderPane {

    private Label leftLabel, rightLabel;
    private ArrayList<Course> courseList;
    private ComboBox<Course> courseDropDown;

    /**
     * The leftmost quadrant displays a random anxiety inducing message and 
     * the rightmost quadrant displays what the future grade will be needed to maintain the current grade.
     */

    public AnxietyPane(ArrayList<Course> courseList) {

        this.courseList = courseList;

        //refresh button
        Button refreshButton = new Button("Refresh");
        refreshButton.setPrefWidth(AssignmentHonors.WINSIZE_X/2);
        refreshButton.setPrefHeight(AssignmentHonors.WINSIZE_Y/8);
        
        //listener
        refreshButton.setOnAction(new ButtonHanlder());

        //course drop down
        courseDropDown = new ComboBox<Course>();
        courseDropDown.setPrefWidth(AssignmentHonors.WINSIZE_X/2);
        courseDropDown.setPrefHeight(AssignmentHonors.WINSIZE_Y/8);
        courseDropDown.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));

        //top part of the pane - horizontal alignment
        GridPane topPane = new GridPane();
        topPane.add(courseDropDown, 0, 0);
        topPane.add(refreshButton, 1, 0);

        //top pane layout settings
        topPane.setPrefWidth(AssignmentHonors.WINSIZE_X);
        GridPane.setHgrow(topPane, Priority.ALWAYS);

        //left label + layout settings
        leftLabel = new Label("");
        leftLabel.setPrefSize(AssignmentHonors.WINSIZE_X/2, AssignmentHonors.WINSIZE_Y/2);
        leftLabel.setPadding(new Insets(10, 10, 10, 10));
        leftLabel.setFont(new Font(30));
        leftLabel.setAlignment(Pos.CENTER);
        leftLabel.setWrapText(true);

        //right label + layout settings
        rightLabel = new Label("");
        rightLabel.setPrefSize(AssignmentHonors.WINSIZE_X/2, AssignmentHonors.WINSIZE_Y/2);
        rightLabel.setPadding(new Insets(10, 10, 10, 10));
        rightLabel.setFont(new Font(30));
        rightLabel.setAlignment(Pos.CENTER);
        rightLabel.setWrapText(true);

        //grid to hold left and right labels
        GridPane grid = new GridPane();
        grid.add(leftLabel, 0, 0);
        grid.add(rightLabel, 1, 0);

        grid.setAlignment(Pos.CENTER);

        //assign to border pane of this tab
        this.setTop(topPane);
        this.setCenter(grid);

        updateDropDown();
    }
    private class ButtonHanlder implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {
                int index = courseDropDown.getSelectionModel().getSelectedIndex();
                courseDropDown.getSelectionModel().select(index);

                leftLabel.setText(generateAnxietyMessage());
                rightLabel.setText(predictGrade(index));

            } catch(IndexOutOfBoundsException ex) {
                leftLabel.setText("There are no courses selected");
                rightLabel.setText("There are no courses selected");
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            updateDropDown();
        }

    }

    private String predictGrade(int courseIndex) {
        //gets current course and current final grade
        Course current = courseList.get(courseIndex);
        String message = "";
        double finalgrade = current.calculateFinal();

        //only works for grades greater than 60
        if(finalgrade < 60) {
            return "You're grade is so low that you don't need me to tell you how much trouble you're in";
        } else {

            //calcualte grade except part with test
            double halfgrade = current.getQuizLinkedList().calculateGrade() * current.getQuizWorth() + 
                                current.getAssignmentLinkedList().calculateGrade() * current.getAssignmentWorth();

            //count down from 100/100 to 99/100
            for(int i = 100; i > 0; i--) {

                double testGrade = current.getTestLinkedList().calculateGrade(i, 100) * current.getTestWorth();
                double newFinal = testGrade + halfgrade;
                System.out.println("new" + newFinal + "\nfinal: " + finalgrade);

                //test if the new final grade is less than the final grade by 10 points but greater than 20 (or else you can just always get a 1/100 for the lowest amoutn)
                if(newFinal < finalgrade-10 && newFinal > finalgrade-20) {
                    return "If you get a " + i + "% on the next test, you're going to have " + newFinal + "% for the class";
                } else {
                    message = "looks like everythings ok...for now";
                }
            }

        }
        return message;
    }

    private String generateAnxietyMessage() {
        //random message generator
        
        //generate random number from 0-3: 4 total responses 
        int num = (int) (Math.random()*(4));
        switch(num) {
            case 0: return "THE NEXT ASSIGNMENT IS DUE TOMORROW";
            case 1: return "Wake up sleepy head. its morning..you missed the i̶n̶v̶a̶s̶i̶o̶n̶ final *evil laugh*";
            case 2: return "That last quiz was pretty bad, even for YOU";
            case 3: return "I think you left the stove on";
            default: return "I think you left the stove on";
        }

    }

    private void updateDropDown() {

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
