/**
 * PM2 Praktikum
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package aufgabe2_3;

import java.util.ArrayList;
import java.util.List;
//import java.time.Clock;
import java.time.LocalTime;

public class Flughafen extends Thread
{
	private int maxAnzahlFlugzeuge;
	private List<Flugzeug> flugzeuge;
	private int index;

	public Flughafen(int maxAnzhalFlugzeuge)
	{
		this.maxAnzahlFlugzeuge = maxAnzhalFlugzeuge;
		flugzeuge = new ArrayList<Flugzeug>();
		index = 0;
	}

	@Override
	public void run() 
	{
		while (!isInterrupted())
		{
			if (flugzeuge.size() < maxAnzahlFlugzeuge)
			{
				Flugzeug flugzeug = erzeugeFlugzeug(
						(int) (10000 * Math.random()), "Flugzeug " + index);
				flugzeug.start();
				flugzeuge.add(flugzeug);
			}
			for (int i = 0; i < flugzeuge.size(); i++)
			{
				Flugzeug flug = flugzeuge.get(i);
				flug.setZeit((int) (LocalTime.now().toNanoOfDay() / 1000000));

				if (flug.istGelandet())
				{
					flugzeuge.remove(i);
					flug.interrupt();
					System.out.println(flug.toString() + "\n");
				}
				else
				{
					System.out.println(flug.toString() + "\n\n");
				}
			}

			try
			{
				Thread.sleep(500);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Erzeugt ein Flugzeug
	 * 
	 * @param flugdauer
	 * @param id
	 * @return
	 */
	private Flugzeug erzeugeFlugzeug(int flugdauer, String id)
	{
		index++;
		return new Flugzeug(id, flugdauer, this,
				(int) (LocalTime.now().toNanoOfDay() / 1000000));
	}

	/**
	 * leitet die landung des flugzeuges ein und kontrolliert das nur eins zur
	 * zeit landen kann
	 * 
	 * @param flugzeug
	 */
	public synchronized void landen(Flugzeug flugzeug)
	{
		try
		{
			Thread.sleep(1500);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flugzeug.gelandet();
	}

	public static void main(String[] args)
	{
		Flughafen hafen = new Flughafen(5);
		hafen.start();

	}
}
