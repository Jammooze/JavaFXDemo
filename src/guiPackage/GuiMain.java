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

// make sure to add these lines to the
// module-info.java file
//	 requires javafx.controls;
//   requires javafx.base;
//   requires javafx.graphics;
//   exports app; // <-name of the package

public class GuiMain extends Application {

	public static void main(String[] args) {
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
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}