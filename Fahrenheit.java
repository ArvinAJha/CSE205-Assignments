
import javafx.application.Application;
//import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

import javafx.scene.*;
public class Fahrenheit extends Application
{
   public void start(Stage stage1)
   {
      FahrenheitGUI gui1 = new FahrenheitGUI();
      Pane pane1 = gui1.createFahrenheitGUI();
      Scene scene1 = new Scene(pane1);

      stage1.setScene(scene1);
      stage1.setTitle("Temp Converter");
      stage1.show();
   }
   
   public static void main(String[] args) {
	   launch(args);
   }
}
