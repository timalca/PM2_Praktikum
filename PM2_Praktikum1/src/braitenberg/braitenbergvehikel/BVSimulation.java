package braitenberg.braitenbergvehikel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import braitenberg.braitenbergvehikel.BraitenbergVehikel.Richtung;

/**
 * Simulation von Braitenberg-Vehikeln.
 * 
 * @author Philipp Jenke
 */
public class BVSimulation extends Observable
{

	/**
	 * Thread klasse f�r den simulations thread
	 */
	private class SimThread extends Thread
	{
		@Override
		public void run()
		{
			while (!isInterrupted())
			{
				simulationsSchritt();
				try
				{
					Thread.sleep(200);
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					interrupt();
				}
			}
		}

	};

	/**
	 * Position des Signals.
	 */
	private Vektor2 signal = new Vektor2(150, 200);

	/**
	 * Liste der zu simulierenden Vehikel
	 */
	private List<BraitenbergVehikel> vehikel = new ArrayList<BraitenbergVehikel>();

	private SimThread simThread;

	public BVSimulation()
	{

	}

	/**
	 * Führt einen Simulationsschritt für alle Vehikel durch.
	 */
	public void simulationsSchritt()
	{
		for (BraitenbergVehikel vehikel : this.vehikel)
		{
			// Berechne Sensorstärke
			vehikel.setSensorwert(Richtung.LINKS,
					getSignalstaerke(vehikel.getSensorPosition(Richtung.LINKS),
							vehikel.getOrientierung()));
			vehikel.setSensorwert(Richtung.RECHTS,
					getSignalstaerke(vehikel.getSensorPosition(Richtung.RECHTS),
							vehikel.getOrientierung()));

			// Bewege vehikel
			vehikel.bewege();
		}
		System.out.println("notify");
		setChanged();
		notifyObservers();
	}

	/**
	 * Berechnet die Signalstärke für einen Sensor durch die Lichtquelle.
	 */
	private double getSignalstaerke(Vektor2 sensorPosition,
			Vektor2 orientierung)
	{
		Vektor2 d = signal.subtrahiere(sensorPosition);
		double entfernung = d.getNorm();
		d = d.skaliere(1.0 / entfernung);
		double cosWinkel = d.skalarProdukt(orientierung);
		if (cosWinkel < 0)
		{
			// Vehikel sieht vom Sensor weg.
			return 0;
		}

		// Winkel-basierte Signalstärke
		return cosWinkel;
	}

	public void vehikelHinzufuegen(BraitenbergVehikel vehikel)
	{
		this.vehikel.add(vehikel);
	}

	public int getAnzahlVehike()
	{
		return vehikel.size();
	}

	public BraitenbergVehikel getVehikel(int index)
	{
		return vehikel.get(index);
	}

	public Vektor2 getSignal()
	{
		return signal;
	}

	public void setSignal(double x, double y)
	{
		signal = new Vektor2(x, y);
		setChanged();
		notifyObservers();
	}

	public void starteThread()
	{
		simThread = new SimThread();
		simThread.start();
	}

	public void beendeThread()
	{
		simThread.interrupt();
	}
}
