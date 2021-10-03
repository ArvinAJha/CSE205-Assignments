/**
 * Assignment #7
 *
 * Name:
 * Student ID:
 * Lecture:
 * Description:
 *
 */

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class DisplayCirclePane extends GridPane
{

    // add instance variables
    private ArrayList<Circle> circleList;

    private CanvasPane canvas; // where to draw Circles
    private ComboBox<String> comboBoxColors;
    private Button btnErase, btnUndo;

    //constructor
    public DisplayCirclePane()
    {
        // Initialize data models
        circleList = new ArrayList<Circle>();

        //combo box
        comboBoxColors = new ComboBox<String>();
        comboBoxColors.getItems().addAll(
            "BLACK",
            "RED",
            "GREEN",
            "ORANGE"
        );

        //combo box handler
        comboBoxColors.setOnAction(new ColorComboBoxHandler());

        //buttons
        btnErase = new Button("Erase");
        btnUndo = new Button("Undo");

        //button handler
        ButtonHandler handler = new ButtonHandler();
        btnErase.setOnAction(handler);
        btnUndo.setOnAction(handler);

        //canvas
        canvas = new CanvasPane();
        canvas.setStyle("-fx-background-color: white;");

        //step 3- register your canvas to listen to mouse events
        canvas.setOnMouseDragged(new PointerHandler());

        // Resize the canvas automatically
        GridPane.setVgrow(canvas, Priority.ALWAYS);
        GridPane.setHgrow(canvas, Priority.ALWAYS);
        // Make the ComboBox of colors to fill the space of the control panel
        GridPane.setHgrow(comboBoxColors, Priority.ALWAYS);
        // Set the preferred size of the control buttons (1/3 the size of the
        // initial window)

        // Optional adjustments to the layout
        comboBoxColors.setMaxWidth(Double.MAX_VALUE);

        double btnPrefWidth = Assignment7.WINSIZE_X / 3;
        btnErase.setPrefWidth(btnPrefWidth);
        btnUndo.setPrefWidth(btnPrefWidth);

        this.getChildren().add(btnUndo);
    }

    /**
     * CanvasPane is the panel where Circles will be drawn on.
     */
    private class CanvasPane extends Pane
    {   //instance variables
        private Circle placeholder;
        private boolean isPlaceholderOn;

        public CanvasPane()
        {
            //implement the constrctor
        }

        public void drawPlaceHolder(int x, int y, int radius)
        {
            // Change the position of the placeholder
            //write your code here

            // If this is the first time we draw the placeholder, add it to the canvas
            if (!isPlaceholderOn)
            {
                //write your code here
            }

        }

        public void erasePlaceHolder()
        {
            // Simply remove the placeholder Circle from the canvas
           // write your code here
        }

        /**
         * Erase and redraw all Circles in the Circle list (not including the
         * placeholder)
         */
        public void repaint()
        {
            // Redraw all circles in the list
            this.getChildren().clear();
            for (Circle c : circleList)
            {
                this.getChildren().add(c);
            }

            // Make the control panel always visible
            ctrlPanel.toFront();
        }
    }

    /**
     * Step 2: ButtonListener defines actions to take in case the "Undo" or "Erase"
     * button is clicked
     */
    private class ButtonHandler implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent e)
        {
            Object source = e.getSource();

            // Check if source refers to the Erase button
            if (source == btnErase)
            {
                //write your code here
            }
            // Check if source refers to the Undo button
            else if (source == btnUndo)
            {
                // Erase the last Circle in the list
                // write your code here





                // Repaint the Canvas
                canvas.repaint();
            }
        }

    }

    /**
     * Step2: A listener class used to set the color chosen by the user via the
     * ComboBox of Colors.
     */
    private class ColorComboBoxHandler implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent e)
        {
            System.out.println(e.getSource().getClass());
        }

    }

    /**
     * A listener class that handles any mouse events on the Canvas
     */
    private class PointerHandler implements EventHandler<MouseEvent>
    {
        // 1=pressed, 2=dragged, 3=released
        private int x1, y1, x2, y2, x3, y3;

        @Override
        public void handle(MouseEvent e)
        {
            //write your code here








        }

        /**
         * A helper method in case you need it. Get the Euclidean distance between (x1,y1) and (x2,y2)
         */
        private double getDistance(int x1, int y1, int x2, int y2)
        {
            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }

    }//end of class PointerHandler
}//end of DisplayCirclePane class
