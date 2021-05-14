import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
	This is a JavaFX application that simulates the rolling of a pair of
	dice. When the user clicks a button, the application should generate
	two random numbers, each in the range of 1 through 6, to represent
	the value of the dice. Use ImageView component to display the dice. 

    @author Jeremy Hill
    @version 1.8.0_271
 */
public class DiceSimulator extends Application
{
	/**
	* The main method calls the Application class launch
	* @param args the command line arguments
	*/
	public static void main(String[] args) 
	{
		launch(args);
	}

	/**
	* The start method takes a Stage object as an argument.
	* It also calls the Stage object's show() method after 
	* the dice have been "tossed" which displays the two dice.
	* @param stage Stage object to display scene
	*/
	@Override
	public void start(Stage stage) 
	{
		//instantiate die1
		ImageView die1 = new ImageView();
		die1.setFitHeight(104);   		//set height
		die1.setFitWidth(104);    		//set width
		//instantiate die2
		ImageView die2 = new ImageView();
		die2.setFitHeight(104);   		//set height
		die2.setFitWidth(104);    		//set width
		//create HBox with 10 px spacing and both ImageView dice
		HBox hbox = new HBox(10, die1, die2);
		//create the toss button
		Button tossButton = new Button("Toss");
		//create VBox with 10 px spacing, the HBox and toss button
		VBox vbox = new VBox(10, hbox, tossButton);
		vbox.setAlignment(Pos.CENTER);		//center align
		vbox.setPadding(new Insets(10));	//10 px padding

		//When clicked two random numbers will be genterated
		//and the corresponding dice images will be displayed. 
		tossButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event) 
			{
				//generating random numbers from 1 to 6
           		int randNum1 = (int)((Math.random()*6)+1);
           		int randNum2 = (int)((Math.random()*6)+1);
           		//create Image objects using the random numbers
           		Image image1 = new Image("file:Die" + randNum1 + ".png");
           		Image image2 = new Image("file:Die" + randNum2 + ".png");
           		//set ImageView images to the new Image objects
           		die1.setImage(image1);
           		die2.setImage(image2);
			}
		});
	  	//create the scene
		Scene scene = new Scene(vbox);
		//set the scene
		stage.setScene(scene);
		//display the scene
		stage.show();
	}
}