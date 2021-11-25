import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class AnxietyPane extends BorderPane {

    private Label gpaLabel, topLeftLabel, topRightLabel, botLeftLabel, botRightLabel;

    public AnxietyPane() {

        //refresh button
        Button refreshButton = new Button();
        refreshButton.setPrefWidth(AssignmentHonors.WINSIZE_X/2);
        
        //listener
        refreshButton.setOnAction(new ButtonHanlder());

        //gpa label
        gpaLabel = new Label("0.0");
        gpaLabel.setPrefWidth(AssignmentHonors.WINSIZE_X/2);

        //top part of the pane - horizontal alignment
        GridPane topPane = new GridPane();
        topPane.add(gpaLabel, 0, 0);
        topPane.add(refreshButton, 1, 0);

        topPane.setPrefWidth(AssignmentHonors.WINSIZE_X);
        GridPane.setHgrow(topPane, Priority.ALWAYS);

        topLeftLabel = new Label("first");
        topLeftLabel.setPrefSize(AssignmentHonors.WINSIZE_X/2, AssignmentHonors.WINSIZE_Y/2);
        // label1.setStyle("-fx-background-color: white");
        topLeftLabel.setAlignment(Pos.CENTER);

        topRightLabel = new Label("second");
        topRightLabel.setPrefSize(AssignmentHonors.WINSIZE_X/2, AssignmentHonors.WINSIZE_Y/2);
        // label2.setStyle("-fx-background-color: black");
        topRightLabel.setAlignment(Pos.CENTER);

        botLeftLabel = new Label("third");
        botLeftLabel.setPrefSize(AssignmentHonors.WINSIZE_X/2, AssignmentHonors.WINSIZE_Y/2);
        // label3.setStyle("-fx-background-color: red");
        botLeftLabel.setAlignment(Pos.CENTER);

        botRightLabel = new Label("fourth");
        botRightLabel.setPrefSize(AssignmentHonors.WINSIZE_X/2, AssignmentHonors.WINSIZE_Y/2);
        // label4.setStyle("-fx-background-color: blue");
        botRightLabel.setAlignment(Pos.CENTER);

        GridPane square = new GridPane();
        square.add(topLeftLabel, 0, 0);
        square.add(topRightLabel, 1, 0);
        square.add(botLeftLabel, 0, 1);
        square.add(botRightLabel, 1, 1);

        // GridPane.setVgrow(square, Priority.ALWAYS);
        // GridPane.setHgrow(square, Priority.ALWAYS);

        square.setAlignment(Pos.CENTER);

        this.setTop(topPane);
        this.setCenter(square);
    }
    private class ButtonHanlder implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {
                topLeftLabel.setText(predictSomething());
                topRightLabel.setText(predictSomething());
                botLeftLabel.setText(predictSomething());
                botRightLabel.setText(predictSomething());

                gpaLabel.setText(predictSomething());
            } catch (Exception e) {
                System.out.println("UH OH");
            }
        }

    }

    private String predictSomething() {
        return "STUP";
    }
    
}
