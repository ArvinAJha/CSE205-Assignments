//import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.scene.control.*;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FahrenheitGUI
 {
   private Label inputLabel, outputLabel, resultLabel;
   private TextField fahrenheit;

   // constructor arranges components using a layout
   public Pane createFahrenheitGUI()
   {
      inputLabel = new Label ("Enter Fahrenheit temperature:");
      outputLabel = new Label ("Temperature in Celsius: ");
      resultLabel = new Label ("---");

      fahrenheit = new TextField ("---");
      fahrenheit.setPrefColumnCount(5);
      fahrenheit.setOnAction(new TempHandler());

      VBox pane1 = new VBox();
      pane1.getChildren().addAll(inputLabel, fahrenheit,outputLabel, resultLabel);
      //pane1.getChildren().add(inputLabel);
      //pane1.getChildren().add(fahrenheit);
      //pane1.getChildren().add(outputLabel);
      //pane1.getChildren().add(resultLabel);
      pane1.setMinSize(250, 50);
      return pane1;
   }

   //*****************************************************************
   //  Represents an action listener for the temperature input field.
   //*****************************************************************
   private class TempHandler implements EventHandler<ActionEvent>
   {
      //--------------------------------------------------------------
      //  Performs the conversion when the enter key is pressed in
      //  the text field.
      //--------------------------------------------------------------
      public void handle(ActionEvent event)
      {
         String text = fahrenheit.getText();

         int fahrenheitTemp = Integer.parseInt (text);
         int celsiusTemp = ((fahrenheitTemp-32) * 5)/9;
         resultLabel.setText (Integer.toString (celsiusTemp));
         fahrenheit.setText("");
      }
   }
}