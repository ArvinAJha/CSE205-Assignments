import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AssignmentHonors extends Application
{
    public static final String WINTITLE = "Honors Project";
    public static final int WINSIZE_X = 400, WINSIZE_Y = 400;

    private TabPane tabPane;
    private GeneralPane generalPane;
    private AnxietyPane anxietyPane;
    private CoursePane coursePane;
    private EditCoursePane editCoursePane;

    @Override
    public void start(Stage stage) throws Exception {

        StackPane rootPane = new StackPane();

        ArrayList<Course> courselist = new ArrayList<Course>();
                
        tabPane = new TabPane();
        generalPane = new GeneralPane(courselist);
        anxietyPane = new AnxietyPane();
        coursePane = new CoursePane();

        Tab tab1 = new Tab();
        tab1.setText("General Grades");
        tab1.setContent(generalPane);

        Tab tab2 = new Tab();
        tab2.setText("Anxiety");
        tab2.setContent(anxietyPane);

        Tab tab3 = new Tab();
        tab3.setText("Add/Remove Course");
        tab3.setContent(coursePane);

        Tab tab4 = new Tab();
        tab4.setText("Edit Course Options");
        tab4.setContent(editCoursePane);

        tab1.setClosable(false);
        tab2.setClosable(false);
        tab3.setClosable(false);
        tab4.setClosable(false);

        tabPane.getSelectionModel().select(0);
        tabPane.getTabs().addAll(tab1, tab2, tab3);

        rootPane.getChildren().add(tabPane);

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
    public static void main(String[] args) {
        launch(args);
    }
}