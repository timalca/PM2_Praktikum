/**
 * Prof. Philipp Jenke
 * Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * Lecture demo program.
 */
package braitenberg;

import braitenberg.braitenbergvehikel.BVBewegungAbstossung;
import braitenberg.braitenbergvehikel.BVBewegungAttraktion;
import braitenberg.braitenbergvehikel.BVSimulation;
import braitenberg.braitenbergvehikel.BraitenbergVehikel;
import braitenberg.braitenbergvehikel.Vektor2;
import braitenberg.view.BVCanvas;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * JavaFX Anwendung zur Darstellung und Interaktion mit einer
 * Braitenberg-Vehikel-Simulation.
 * 
 * @author Philipp Jenke
 */
public class BVAnwendung extends Application
{

	@Override
	public void start(Stage primaryStage)
	{
		// Simulation zusammenstellen
		BVSimulation sim = erzeugeSimulationsszene();

		// Canvas setzen
		BVCanvas canvas = new BVCanvas(600, 600, sim);

		canvas.zeichneSimulation();

		// Szenengraph aufbauen
		primaryStage.setTitle("Braitenberg-Vehikel!");
		BorderPane wurzel = new BorderPane();
		wurzel.setCenter(canvas);
		CheckBox checkbox = new CheckBox();
		checkbox.setText("Simuliere!");
		Button button = new Button();
		button.setText("Simuliere");
		GridPane grid = new GridPane();
		grid.add(button, 0, 0);
		grid.add(checkbox, 0, 1);
		wurzel.setLeft(grid);

		button.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				System.out.println("Schritt!");
				sim.simulationsSchritt();
			}

		});

		checkbox.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent event)
			{
				if (checkbox.isSelected())
				{
					System.out.println("Selected");
					sim.starteThread();
					
				}
				else
				{
					System.out.println("Not Selected");
					sim.beendeThread();
				}
			}
		});

		primaryStage.setScene(new Scene(wurzel, 850, 600));
		primaryStage.show();
	}

	/**
	 * Erzeugt eine Simulationsszene zum Testen.
	 */
	public BVSimulation erzeugeSimulationsszene()
	{
		BraitenbergVehikel vehikel1 = new BraitenbergVehikel("Susi",
				new BVBewegungAttraktion());
		BraitenbergVehikel vehikel2 = new BraitenbergVehikel("Mike",
				new BVBewegungAbstossung(), new Vektor2(-100, 100),
				new Vektor2(1, 0));
		BVSimulation sim = new BVSimulation();
		sim.vehikelHinzufuegen(vehikel1);
		sim.vehikelHinzufuegen(vehikel2);
		return sim;
	}

	// @Override
	// public void handle(ActionEvent event)
	// {
	// System.out.println("EVENT!!!!");
	// }
	//
	// public static void main(String[] args)
	// {
	// launch(args);
	// }

}
