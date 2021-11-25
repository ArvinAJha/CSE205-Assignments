import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import LinkedLists.GradeLinkedList;
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

public class GradePane extends BorderPane {

    private ArrayList<Course> courseList;
    private ComboBox<Course> courseDropDown;
    private ComboBox<String> gradeDropDown;

    private Label errorLabel;
    private TextField gradeName, pointsReceived, pointsAvailable;
    private VBox gradesAddedBox;
    
    public GradePane(ArrayList<Course> courselist) {
        this.courseList = courselist;

        //containers
        HBox addGradeContainer = new HBox();       //holds added courses and fields to add more courses
        VBox dropDownBox = new VBox();             //holds the dropdowns
        GridPane fieldContainer = new GridPane();
        VBox leftSideBox = new VBox();

        /**
         * TOP SIDE 
         */
        courseDropDown = new ComboBox<Course>();
        gradeDropDown = new ComboBox<String>();
        gradeDropDown.getItems().addAll("Assignment", "Quiz", "Test");
        gradeDropDown.getSelectionModel().selectFirst();

        //listeners
        courseDropDown.setOnAction(new courseDropDownHandler());
        gradeDropDown.setOnAction(new GradeDropDownHandler());

        courseDropDown.setPrefWidth(AssignmentHonors.WINSIZE_X);
        gradeDropDown.setPrefWidth(AssignmentHonors.WINSIZE_X);

        dropDownBox.getChildren().addAll(courseDropDown, gradeDropDown);

        /**
         * LEFT SIDE
         */

        //labels
        Label nameLabel = new Label("Name: ");
        Label pointsGotLabel = new Label("Points you got: ");
        Label totalPointsLabel = new Label("Total Points: ");

        //error label
        errorLabel = new Label("");
        errorLabel.setPadding(new Insets(10, 10, 10, 10));
        errorLabel.setTextFill(Color.RED);

        //text fields
        gradeName = new TextField();
        pointsReceived = new TextField();
        pointsAvailable = new TextField();
        
        //add labels, fields to grid container
        fieldContainer.add(nameLabel, 0, 0);
        fieldContainer.add(pointsGotLabel, 0, 1);
        fieldContainer.add(totalPointsLabel, 0, 2);
        fieldContainer.add(gradeName, 1, 0);
        fieldContainer.add(pointsReceived, 1, 1);
        fieldContainer.add(pointsAvailable, 1, 2);

        fieldContainer.setHgap(10);
        fieldContainer.setVgap(5);
        fieldContainer.setPadding(new Insets(10, 10, 10, 10));
        
        //make buttons
        Button addGradeButton = new Button("Add");
        Button removeGradeButton = new Button("Remove");

            //button listener
            addGradeButton.setOnAction(new GradeButtonHandler());
            removeGradeButton.setOnAction(new GradeRemoveButtonHandler());

        //assemble fields and button
        leftSideBox.getChildren().addAll(errorLabel, fieldContainer, addGradeButton);
        leftSideBox.setAlignment(Pos.CENTER);

        /**
         * RIGHT SIDE
         */
        gradesAddedBox = new VBox();               //holds checkboxes for all the courses
        gradesAddedBox.setPadding(new Insets(10, 10, 10, 10));
        gradesAddedBox.setAlignment(Pos.CENTER_LEFT);

        //scroll pane for right side course container
        ScrollPane addedGradesScroll = new ScrollPane();
        addedGradesScroll.setContent(gradesAddedBox);
        addedGradesScroll.setPrefWidth(AssignmentHonors.WINSIZE_X/2);
        addedGradesScroll.setPrefHeight(AssignmentHonors.WINSIZE_Y/2);
        addedGradesScroll.setMaxHeight(AssignmentHonors.WINSIZE_Y);

        //remove button and courses container
        VBox rightSideBox = new VBox();
        rightSideBox.getChildren().addAll(addedGradesScroll, removeGradeButton);
        rightSideBox.setPadding(new Insets(30, 0, 0, 0));

        //assemble left and right side
        addGradeContainer.getChildren().addAll(leftSideBox, rightSideBox);

        this.setTop(dropDownBox);
        this.setCenter(addGradeContainer);

        updateGradeBox();
    }

    private class courseDropDownHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {
                updateGradeBox();
            } catch (NullPointerException e) {}
        }

    }

    private class GradeDropDownHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {
                updateGradeBox();
            } catch (NullPointerException e) {
                errorLabel.setText("No course selected");
            }
        }
        
    }

    private class GradeButtonHandler implements EventHandler<ActionEvent> {

        private String name;
        private double points;
        private double total;

        @Override
        public void handle(ActionEvent event) {
            int courseIndex = courseDropDown.getSelectionModel().getSelectedIndex();
            String gradeType = gradeDropDown.getSelectionModel().getSelectedItem();

            errorLabel.setText("");

            try {

                name = gradeName.getText();
                points = Double.parseDouble(pointsReceived.getText());
                total = Double.parseDouble(pointsAvailable.getText());

                if(gradeType.equalsIgnoreCase("Assignment")) {
                    courseList.get(courseIndex).getAssignmentLinkedList().add(points, total, name);
                } else if(gradeType.equalsIgnoreCase("Quiz")) {
                    courseList.get(courseIndex).getQuizLinkedList().add(points, total, name);
                } else {
                    courseList.get(courseIndex).getTestLinkedList().add(points, total, name);
                }

                updateGradeBox();

                gradeName.setText("");
                pointsReceived.setText("");
                pointsAvailable.setText("");

            } catch (NumberFormatException e) {
                errorLabel.setText("Please enter numbers for the points.");
            } catch (NullPointerException e) {
                errorLabel.setText("There are no courses selected");
            } catch (IndexOutOfBoundsException e) {
                errorLabel.setText("There are no courses selected");
            }

        }
        
    }

    private class GradeRemoveButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            errorLabel.setText("");

            if(gradesAddedBox.getChildren().isEmpty()) {
                errorLabel.setText("No grades available");
                return;
            }

            try {

                int courseIndex = courseDropDown.getSelectionModel().getSelectedIndex();
                String gradetype = gradeDropDown.getSelectionModel().getSelectedItem();

                GradeLinkedList grades = null;

                if(gradetype.equals("Assignment")) {
                    grades = courseList.get(courseIndex).getAssignmentLinkedList();
                } else if(gradetype.equals("Quiz")) {
                    grades = courseList.get(courseIndex).getQuizLinkedList();
                } else {
                    grades = courseList.get(courseIndex).getTestLinkedList();
                }

                removeGrades(grades);
                updateGradeBox();

            } catch(NullPointerException e) {
                errorLabel.setText("No courses selected");
            } catch (IndexOutOfBoundsException e) {
                errorLabel.setText("No courses selected");
            }
        }

    }

    private void removeGrades(GradeLinkedList grades) {
        for(int i = 0; i < grades.getNumOfGrade(); i++) {
            CheckBox box = (CheckBox) gradesAddedBox.getChildren().get(i);

            if(box.isSelected()) {
                // gradesAddedBox.getChildren().remove(i);

                /**
                 * Bro change the remove method later please
                 */
                grades.printList();
                grades.remove(grades.getNameAtPos(i), grades.getValueAtPos(i), grades.getTotalPointsAtPos(i));
                System.out.println("________________________");
                grades.printList();
                //i--;

            }
        }
    }
    
    private void updateGradeBox() {

        gradesAddedBox.getChildren().clear();

        try {
            int courseIndex = courseDropDown.getSelectionModel().getSelectedIndex();
            if(courseIndex < 0) {
                return;
            }
            Course course = courseList.get(courseIndex);

            String gradeType = gradeDropDown.getSelectionModel().getSelectedItem();

            switch(gradeType) {
                case "Assignment": helpUpdate(course.getAssignmentLinkedList()); break;
                case "Quiz": helpUpdate(course.getQuizLinkedList()); break;
                case "Test": helpUpdate(course.getTestLinkedList()); break;
            }

        } catch (Exception e) {
            errorLabel.setText("some error");
            e.printStackTrace();
        }

        try {
            FileOutputStream fileout = new FileOutputStream("courseList.ser");
            ObjectOutputStream objOut = new ObjectOutputStream(fileout);

            objOut.writeObject(courseList);
            objOut.flush();
            objOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void helpUpdate(GradeLinkedList list) {

        if(list.getNumOfGrade() == 0) {
            return;
        }
        
        for(int i = 0; i < list.getNumOfGrade(); i++) {
            //create checkbox 
            CheckBox gradeCheckBox = new CheckBox(list.toStringAtIndex(i));
            gradeCheckBox.setPadding(new Insets(10, 10, 10, 10));

            //add to container
            gradesAddedBox.getChildren().addAll(gradeCheckBox);
        }
    }

    public void updateDropDown() {
        courseDropDown.getItems().clear();
        try {
            for(Course aCourse: courseList) {
                courseDropDown.getItems().add(aCourse);
            }
        } catch (Exception e) {}

        try {
            FileOutputStream fileout = new FileOutputStream("courseList.ser");
            ObjectOutputStream objOut = new ObjectOutputStream(fileout);

            objOut.writeObject(courseList);
            objOut.flush();
            objOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
