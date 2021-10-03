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
    private GridPane ctrlPanel;
    private Color currentCircleColor; 
    private Double centerX, centerY; //needed instance fields to save values of cirles during drawing

    //constructor
    public DisplayCirclePane()
    {
        // Initialize data models
        circleList = new ArrayList<Circle>();
        centerX = 0.0;
        centerY = 0.0;

        //combo box
        comboBoxColors = new ComboBox<String>();
        comboBoxColors.getItems().addAll(
            "BLACK",
            "RED",
            "GREEN",
            "ORANGE"
        );
        comboBoxColors.getSelectionModel().selectFirst(); //set default for UI (does not align with handle method)

        //circle color
        currentCircleColor = Color.BLACK; //set to align with default (handle method does not activate on initialization so this is necessary)

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

        //register your canvas to listen to mouse events
        canvas.setOnMouseDragged(new PointerHandler());
        canvas.setOnMousePressed(new PointerHandler());
        canvas.setOnMouseReleased(new PointerHandler());

        //crtl panel holds buttons and combo box
        ctrlPanel = new GridPane();

        // Make the ComboBox of colors to fill the space of the control panel
        GridPane.setHgrow(comboBoxColors, Priority.ALWAYS);
        comboBoxColors.setMaxWidth(Double.MAX_VALUE);

        // Set the preferred size of the control buttons (1/3 the size of the
        // initial window)
        double btnPrefWidth = Assignment7.WINSIZE_X / 3;
        btnErase.setPrefWidth(btnPrefWidth);
        btnUndo.setPrefWidth(btnPrefWidth);

        //add button and combo to ctrl
        ctrlPanel.add(btnUndo, 0, 0);
        ctrlPanel.add(btnErase, 1, 0);
        ctrlPanel.add(comboBoxColors, 2, 0);

        // Resize the canvas automatically
        GridPane.setVgrow(canvas, Priority.ALWAYS);
        GridPane.setHgrow(canvas, Priority.ALWAYS);

        //add control panel and canvas to scene
        this.add(ctrlPanel, 0, 0);
        this.add(canvas, 0, 1);

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
            isPlaceholderOn = false;
        }

        //draws temporary circle while mouse is dragging
        public void drawPlaceHolder(double x, double y, double radius)
        {
            // Change the position of the placeholder
            placeholder = new Circle(x, y, radius);
            placeholder.setFill(currentCircleColor);

            // If this is the first time we draw the placeholder, add it to the canvas
            if (!isPlaceholderOn)
            {
                canvas.getChildren().add(placeholder);
                isPlaceholderOn = true;             //place holder active
            }

            repaint();
        }

        //erase place holders when release
        public void erasePlaceHolder()
        {
            //Simply remove the placeholder Circle from the canvas
            isPlaceholderOn = false; //deactivate place holder
            canvas.getChildren().remove(placeholder);
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

        private ArrayList<Circle> tempArrayList = new ArrayList<Circle>();

        @Override
        //handle erase and undo button events
        public void handle(ActionEvent e)
        {
            Object source = e.getSource();

            // Check if source refers to the Erase button
            if (source == btnErase)
            {
                for(Circle item: circleList) { //make a temporary array in case u need to retrieve it
                    tempArrayList.add(item);
                }
                circleList.clear();
                canvas.repaint();
            }
            // Check if source refers to the Undo button
            else if (source == btnUndo)
            {
                // Erase the last Circle in the list if there are any circles
                if(circleList.size() > 0) {
                    circleList.remove(circleList.size()-1);
                } else {                                    //if no circles, retrieve last array
                    for(Circle item: tempArrayList) {
                        circleList.add(item);
                    }
                }

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
        //handles color selection in dropdown menu
        public void handle(ActionEvent event)
        {
            //there is some error here, idk why the switch doesnt work
            String selectedOption = comboBoxColors.getSelectionModel().getSelectedItem(); //which item was chosen
            // switch(selectedOption) {
                // case "BLACK": currentCircleColor = Color.BLACK;
                // case "RED": currentCircleColor = Color.RED;
                // case "GREEN": currentCircleColor = Color.GREEN;
                // case "ORANGE": currentCircleColor = Color.ORANGE;
            // }

            //given chosen item, asign color value
            if(selectedOption.equalsIgnoreCase("BLACK")) {
                currentCircleColor = Color.BLACK;
            } else if(selectedOption.equalsIgnoreCase("RED")) {
                currentCircleColor = Color.RED;
            } else if(selectedOption.equalsIgnoreCase("GREEN")) {
                currentCircleColor = Color.GREEN;
            } else if(selectedOption.equalsIgnoreCase("ORANGE")) {
                currentCircleColor = Color.ORANGE;
            }

        }

    }

    /**
     * A listener class that handles any mouse events on the Canvas
     */
    private class PointerHandler implements EventHandler<MouseEvent>
    {
        // 1=pressed, 2=dragged, 3=released
        private double x1, y1, currentEndX, currentEndY, finalX, finalY;

        @Override
        //handles all mouse events on canvas
        public void handle(MouseEvent event)
        {

            if(event.getEventType() == MouseEvent.MOUSE_PRESSED) {  //press
                x1 = event.getX(); //center x
                y1 = event.getY(); //center y

                //store values in instance fields so they are saved for the drag and release methods
                centerX = x1;
                centerY = y1;

            } else if(event.getEventType() == MouseEvent.MOUSE_DRAGGED) {   //drag
                currentEndX = event.getX();
                currentEndY = event.getY();

                double radius = getDistance(centerX, centerY, currentEndX, currentEndY);

                canvas.drawPlaceHolder(centerX, centerY, radius); //while dragging, draw placeholder            error: doesnot go backwards

            } else if(event.getEventType() == MouseEvent.MOUSE_RELEASED) {  //release
                canvas.erasePlaceHolder();

                finalX = event.getX();
                finalY = event.getY();
                double radius = getDistance(centerX, centerY, finalX, finalY);

                Circle finalCircle = new Circle(centerX, centerY, radius);
                finalCircle.setFill(currentCircleColor);

                circleList.add(finalCircle);
                canvas.repaint();
            }

        }

        /**
         * A helper method in case you need it. Get the Euclidean distance between (centerX,centerY) and (x2,y2)
         */
        private double getDistance(double x1, double y1, double x2, double y2)
        {
            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }

    }//end of class PointerHandler
}//end of DisplayCirclePane class
