
/**
 * Assignment #7 
 * 
 * Name: 
 * Student ID: 
 * Lecture: 
 * Description:
 * 
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Assignment7 extends Application
{
    public static final int WINSIZE_X = 400, WINSIZE_Y = 400;
    private final String WINTITLE = "Assignment7: Drawing Circles";

    @Override
    public void start(Stage stage) throws Exception
    {
        DisplayCirclePane rootPane = new DisplayCirclePane();
        rootPane.setPrefSize(WINSIZE_X, WINSIZE_Y);
        Scene scene = new Scene(rootPane, WINSIZE_X, WINSIZE_Y);
        stage.setTitle(WINTITLE);
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
