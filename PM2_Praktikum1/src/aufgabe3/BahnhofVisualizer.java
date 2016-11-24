/**
 * PM2 Praktikum
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package aufgabe3;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BahnhofVisualizer extends Application implements Observer
{
	private int gleiszahl;
	private Rangierbahnhof bahnhof;
	private Simulation simulation;
	BorderPane wurzel;

	public BahnhofVisualizer()
	{
		gleiszahl = 6;
		bahnhof = new Rangierbahnhof(gleiszahl);
		simulation = new Simulation(bahnhof);
		simulation.addObserver(this);
		new Thread(simulation).start();
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("Bahnhof Zooo");
		BorderPane wurzel = new BorderPane();
		this.wurzel = wurzel;
		Label labels[] = new Label[gleiszahl];
		// TableView<Zug> tabellenAnsicht = new TableView();
		// TableColumn gleisSpalte = new TableColumn ("Gleisnr");
		// TableColumn<Zug, Integer> zugSpalte = new TableColumn<Zug,
		// Integer>("Gleis");
		// zugSpalte.setCellValueFactory(new PropertyValueFactory<Zug,
		// Integer>("nummer"));
		// tabellenAnsicht.getColumns().add(gleisSpalte);
		// wurzel.setCenter(tabellenAnsicht);
		maleFenster();
		primaryStage.setScene(new Scene(wurzel, 1000, 500));
		primaryStage.show();
	}



	private void maleFenster()
	{
		GridPane gridpane = new GridPane();
		for (int i = 0; i < gleiszahl; i++)
		{
			Label label;
			if (simulation.zugliste.get(i) != null)
			{
				label = new Label(
						"Zug" + simulation.zugliste.get(i).getNummer());
			}
			else
			{
				label = new Label("Gleis " + i + " leer");
			}
			gridpane.add(label, i, 0);
		}

		gridpane.setHgap(10);
		gridpane.setVgap(10);
		wurzel.setCenter(gridpane);
	}
	@Override
	public void update(Observable o, Object arg)
	{
		Platform.runLater(new Runnable()
		{

			@Override
			public void run()
			{
				wurzel.getChildren().clear();
				maleFenster();

			}
		});

	}
	
	public static void main(String[] args)
	{
		//BahnhofVisualizer vis = new BahnhofVisualizer(4);
		launch(args);
	}

}
