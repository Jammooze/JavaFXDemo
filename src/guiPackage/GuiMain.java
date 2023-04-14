/**
*  @author Nguyen James 
*          CS 2012-03
*          Activity - Intro to JavaFX
*          GUIMain.java
*/

package guiPackage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GuiMain extends Application {

	public static void main(String[] args) { // Launches GUI Application
		Application.launch(args);
	}

    @Override
    public void start(Stage primaryStage) {
        try {
        	// Create two new texts
            Text txt1 = new Text("\nText at the Top of the VBox Stack\n");
            Text txt2 = new Text("Text at the Bottom of the VBox Stack\n");

            // Initialize two new Buttons
            Button button1 = new Button("This is button 1");
            Button button2 = new Button("This is button 2");
            
            // Define Button Commands
            button1.setOnAction(event -> { // Pressing Button 1 changes text
                txt1.setText("\nButton [1] has been pressed...\n");
            });
            
            button2.setOnAction(event -> { // Pressing Button 2 changes text
                txt1.setText("\nButton [2] has been pressed...\n");
            });
            
            // Initialize new colored Rectangle for the buttons container
            Rectangle coloredBg = new Rectangle(400, 100, Color.LIGHTPINK);

            // Initialize new (Horizontal)Box layout container for the buttons
            HBox hbox = new HBox();
            hbox.setSpacing(10);

            // Adding button1 & button2 to HBox
            hbox.getChildren().addAll(button1, button2);

            // set the position of the buttons
            hbox.setAlignment(Pos.CENTER);

            // create a new StackPane layout container
            StackPane stackPane = new StackPane();
            stackPane.setPadding(new Insets(10));
            stackPane.getChildren().addAll(coloredBg, hbox); // Using stackPane to overlap buttons over buttonRegion
            
            // Adding to new Initialized VBox 
            VBox vbox = new VBox();
            vbox.getChildren().addAll(txt1, txt2, stackPane); // Adding to vertical stack
            vbox.setAlignment(Pos.CENTER);

            // Outputting GUI Window
            Scene scene = new Scene(vbox, 500, 400); // (vbox, length, width)
            primaryStage.setScene(scene);
            primaryStage.show();
            
            // Initialize new Button for creating a new window
            Button newWindowButton = new Button("Open Color Grid\n        Window");
            
            // Create new GUI Window upon newWindowButton Click <-- 3x3 COLOR GRID WINDOW
            newWindowButton.setOnAction(e -> {
                // Creating new Stage & Scene
                Stage newWindow = new Stage();
                
                // Initialize two new VBox & HBox OBJs
                VBox newVBox = new VBox(); // Vertical
                newVBox.setSpacing(10);
                
                HBox HBox1 = new HBox(); // 3 Horizontal for 3 rows 
                HBox1.setSpacing(10);
                HBox HBox2 = new HBox();
                HBox2.setSpacing(10);
                HBox HBox3 = new HBox();
                HBox3.setSpacing(10);
                
                Text newText = new Text("COLOR GRID");
                
                // Initialize 9 Rectangle OBJs for 3x3 Colored Grid
                Rectangle square1 = new Rectangle(50, 50, Color.LIGHTPINK); // 1st Row
                Rectangle square2 = new Rectangle(50, 50, Color.LIGHTPINK);
                Rectangle square3 = new Rectangle(50, 50, Color.LIGHTPINK);
                Rectangle square4 = new Rectangle(50, 50, Color.LIGHTBLUE); // 2nd Row
                Rectangle square5 = new Rectangle(50, 50, Color.LIGHTPINK);
                Rectangle square6 = new Rectangle(50, 50, Color.LIGHTBLUE);
                Rectangle square7 = new Rectangle(50, 50, Color.LIGHTPINK); // 3rd Row
                Rectangle square8 = new Rectangle(50, 50, Color.LIGHTPINK);
                Rectangle square9 = new Rectangle(50, 50, Color.LIGHTBLUE);
                
                HBox1.getChildren().addAll(square1, square2, square3); // Adding 1st row to HBox1
                HBox1.setAlignment(Pos.CENTER);
                HBox2.getChildren().addAll(square4, square5, square6); // Adding 2nd row to HBox2
                HBox2.setAlignment(Pos.CENTER);
                HBox3.getChildren().addAll(square7, square8, square9); // Adding 3rd row to HBox3
                HBox3.setAlignment(Pos.CENTER);
                
                newVBox.getChildren().addAll(newText, HBox1, HBox2, HBox3); // Stacking to newVBox 
                newVBox.setAlignment(Pos.CENTER);
                
                // Output GUI Window
                Scene newScene = new Scene(newVBox, 300, 300);
                newWindow.setScene(newScene);
                newWindow.show();
            });
            
            // Add the new button to the HBox
            vbox.getChildren().add(newWindowButton);
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}