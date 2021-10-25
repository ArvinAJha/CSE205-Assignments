
/**
 * Assignment #7 
 * ASU - CSE205
 * Name: Arvin Jha
 * Student ID: 1221497264
 * Lecture: 10:10AM - 11:00AM M W F
 * Description: Main Application Class that creates the Stage, 
 * sets size and title of window and launches program. 
 * It will add on the DisplayCirclePane 
 * 
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AssignmentHonors extends Application
{
    @Override
    public void start(Stage stage) throws Exception {
        DisplayCirclePane rootPane = new DisplayCirclePane();
        rootPane.setPrefSize(Constants.WINSIZE_X, Constants.WINSIZE_Y);
        Scene scene = new Scene(rootPane, Constants.WINSIZE_X, Constants.WINSIZE_Y);

        StackPane root = new StackPane();

        // courseList to be used in both generatePane & selectPane
        courseList = new ArrayList<Course>();

        selectPane = new SelectPane(courseList);
        createPane = new GeneratePane(courseList, selectPane);

        tabPane = new TabPane();

        Tab tab1 = new Tab();
        tab1.setText("Add Course");
        tab1.setContent(createPane);

        Tab tab2 = new Tab();
        tab2.setText("Select Course");
        tab2.setContent(selectPane);

        tabPane.getSelectionModel().select(0);
        tabPane.getTabs().addAll(tab1, tab2);

        root.getChildren().add(tabPane);

        Scene scene = new Scene(root, 900, 400);
        stage.setTitle("Course Selection App");
        stage.setScene(scene);
        stage.show();


        stage.setTitle(Constants.WINTITLE);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Technically this is not needed for JavaFX applications. Added just in
     * case.
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
