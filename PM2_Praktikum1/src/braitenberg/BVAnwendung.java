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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
	
	public void addCombobox(ComboBox<String> cBox,BraitenbergVehikel vehikel){
		cBox.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				if(cBox.getValue()=="ABSTOSSUNG"){
					vehikel.setBewegung(new BVBewegungAbstossung());
				}
				else{
					vehikel.setBewegung(new BVBewegungAttraktion());
				}
			}	
		});
	}

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
		GridPane simulationGrid = new GridPane();
		GridPane bewegungsGrid =new GridPane();
		
		ObservableList<String> bewegungsList =FXCollections.observableArrayList("ATTRAKTION","ABSTOSSUNG");
		for(int i=0;i<sim.getAnzahlVehike();i++){
			ComboBox<String> bewegungCombobox=new ComboBox<String>(bewegungsList);
			Label vehikelName=new Label(sim.getVehikel(i).getName());
			bewegungsGrid.add(vehikelName,0,i);
			bewegungsGrid.add(bewegungCombobox,1, i);
			if(sim.getVehikel(i).getBewegung() instanceof BVBewegungAbstossung){
				bewegungCombobox.setValue("ABSTOSSUNG");
			}else{
				bewegungCombobox.setValue("ATTRAKTION");
			}
			addCombobox(bewegungCombobox, sim.getVehikel(i));
		}
		
		simulationGrid.add(button, 0, 0);
		simulationGrid.add(checkbox, 0, 1);
		wurzel.setLeft(simulationGrid);
		wurzel.setRight(bewegungsGrid);
		

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
