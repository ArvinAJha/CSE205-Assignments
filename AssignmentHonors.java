
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
    public void start(Stage stage) throws Exception
    {
        DisplayCirclePane rootPane = new DisplayCirclePane();
        rootPane.setPrefSize(Constants.WINSIZE_X, Constants.WINSIZE_Y);
        Scene scene = new Scene(rootPane, Constants.WINSIZE_X, Constants.WINSIZE_Y);
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
    public static void main(String[] args)
    {
        launch(args);
    }
}
