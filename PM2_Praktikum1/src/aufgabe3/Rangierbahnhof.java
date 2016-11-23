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
	private boolean[] reserved;

	public Rangierbahnhof(int anzahlGleise)
	{
		zuege = new Zug[anzahlGleise];
		reserved = new boolean[anzahlGleise];

		for (int i = 0; i < reserved.length; i++)
		{
			reserved[i] = false;
		}

	}

	public int getGleiszahl()
	{
		return zuege.length;
	}
	public synchronized void einfahren(Zug zug, int gleisnr)
			throws reservedException
	{
		if (reserved[gleisnr] == true)
		{
			throw new reservedException("already reserved");
		}
		reserved[gleisnr] = true;
		aufZufahrtsGleis();
		zuege[gleisnr] = zug;
		setChanged();
		notifyObservers();
	}

	public void ausfahren(int gleisnr)throws reservedException
	{
		if(zuege[gleisnr] == null)
		{
			throw new reservedException("Empty Gleis");
		}
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
