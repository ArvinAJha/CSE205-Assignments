import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

        topPane.setPrefWidth(AssignmentHonors.WINSIZE_X);
        GridPane.setHgrow(topPane, Priority.ALWAYS);

        leftLabel = new Label("");
        leftLabel.setPrefSize(AssignmentHonors.WINSIZE_X/2, AssignmentHonors.WINSIZE_Y/2);
        leftLabel.setFont(new Font(30));
        leftLabel.setAlignment(Pos.CENTER);
        leftLabel.setWrapText(true);

        rightLabel = new Label("");
        rightLabel.setPrefSize(AssignmentHonors.WINSIZE_X/2, AssignmentHonors.WINSIZE_Y/2);
        rightLabel.setFont(new Font(30));
        rightLabel.setAlignment(Pos.CENTER);
        rightLabel.setWrapText(true);

        GridPane grid = new GridPane();
        grid.add(leftLabel, 0, 0);
        grid.add(rightLabel, 1, 0);

        grid.setAlignment(Pos.CENTER);

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
        Course current = courseList.get(courseIndex);
        String message = "";
        double finalgrade = current.calculateFinal();

        if(finalgrade < 60) {
            return "You're grade is so low that you don't need me to tell you how much trouble you're in";
        } else {

            double halfgrade = current.getQuizLinkedList().calculateGrade() * current.getQuizWorth() + 
                                current.getAssignmentLinkedList().calculateGrade() * current.getAssignmentWorth();

            for(int i = 100; i > 0; i--) {

                double testGrade = current.getTestLinkedList().calculateGrade(i, 100) * current.getTestWorth();
                double newFinal = testGrade + halfgrade;
                System.out.println("new" + newFinal + "\nfinal: " + finalgrade);

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
        return "ha";
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
