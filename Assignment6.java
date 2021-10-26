
/**
 * Assignment #6 
 * CSE205
 * Name: Arvin Jha
 * Student ID: 1221497264
 * Lecture: 10:10AM - 11:00AM M W F
 * Description: Main Application Class that creates a Tabbed Pane
 * with two tabs, one for course Creation and one for course Selection
 * 
 * 
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;

public class Assignment6 extends Application {
    private TabPane tabPane;
    private CoursePane coursePane;
    private SelectPane selectPane;
    private ArrayList<Course> courseList;

    public void start(Stage stage) {
        StackPane root = new StackPane();

        // courseList to be used in both generatePane & selectPane
        courseList = new ArrayList<Course>();

        selectPane = new SelectPane(courseList);
        coursePane = new CoursePane(courseList, selectPane);

        tabPane = new TabPane();

        Tab tab1 = new Tab();
        tab1.setText("Add Course");
        tab1.setContent(coursePane);

        Tab tab2 = new Tab();
        tab2.setText("Select Course");
        tab2.setContent(selectPane);

        Tab tab3 = new Tab();
        tab3.setText("Add/RemoveCourse");
        tab3.setContent(coursePane);

        tabPane.getSelectionModel().select(0);
        tabPane.getTabs().addAll(tab1, tab2);

        root.getChildren().add(tabPane);

        Scene scene = new Scene(root, 900, 400);
        stage.setTitle("Course Selection App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}