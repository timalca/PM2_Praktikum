/**
 * PM2 Praktikum
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package aufgabe3;

import java.util.Observable;

public class Rangierbahnhof extends Observable
{
	private Zug[] zuege;

	public Rangierbahnhof(int anzahlGleise)
	{
		zuege = new Zug[anzahlGleise];
	}

	public void einfahren(Zug zug, int gleisnr)
	{
		aufZufahrtsGleis();
		zuege[gleisnr] = zug;
		setChanged();
		notifyObservers();
	}

	public void ausfahren(int gleisnr)
	{
		aufZufahrtsGleis();
		zuege[gleisnr] = null;
		setChanged();
		notifyObservers();
	}

	private synchronized void aufZufahrtsGleis()
	{
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Zug getZug(int gleisnr)
	{
		return zuege[gleisnr];
	}
}
