import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AssignmentHonors extends Application
{
    public static final String WINTITLE = "Honors Project";
    public static final int WINSIZE_X = 800, WINSIZE_Y = 400;

    private TabPane tabPane;
    private GeneralPane generalPane;
    private AnxietyPane anxietyPane;
    private CoursePane coursePane;
    private GradePane gradePane;

    private ArrayList<Course> courseList;

    @Override
    @SuppressWarnings("unchecked")      //ignore this. it will just get rid of warnings.
    public void start(Stage stage) {

        StackPane rootPane = new StackPane();

        try {

            //Read object from file
            FileInputStream fileInput = new FileInputStream("courseList.ser");      //txt file??
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);

            courseList = (ArrayList<Course>) objectInput.readObject();

            objectInput.close();
        } catch (FileNotFoundException e) {     //if the file has not been found then make one

            courseList = new ArrayList<Course>();
            writeObject();
            
        } catch(IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ComboBox<Course> courseDropDown = new ComboBox<Course>();
                
        tabPane = new TabPane();
        generalPane = new GeneralPane(courseDropDown, courseList);
        anxietyPane = new AnxietyPane();
        gradePane = new GradePane(courseList);
        coursePane = new CoursePane(gradePane, courseDropDown, courseList);

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
        tab4.setText("Add Grades");
        tab4.setContent(gradePane);

        tab1.setClosable(false);
        tab2.setClosable(false);
        tab3.setClosable(false);
        tab4.setClosable(false);

        tabPane.getSelectionModel().select(0);
        tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);

        rootPane.getChildren().add(tabPane);

        Scene scene = new Scene(rootPane, WINSIZE_X, WINSIZE_Y);

        stage.setTitle(WINTITLE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void writeObject() {
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