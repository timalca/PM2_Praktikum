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
	
	public Zug getZug(int index)
	{
		return zuege[index];
	}
	
	public synchronized void einfahren(Zug zug, int gleisnr)
			throws reservedException
	{		
		while (reserved[gleisnr])
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(reserved[gleisnr])
		{
			throw new reservedException("reserved");
		}
		
		reserved[gleisnr] = true;
		
		aufZufahrtsGleis();
		zuege[gleisnr] = zug;
		setChanged();
		notifyObservers();
		
	}

	public synchronized void ausfahren(int gleisnr)throws reservedException
	{
		
		while(zuege[gleisnr] == null)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(zuege[gleisnr] == null)
		{
			throw new reservedException("empty");
		}
		aufZufahrtsGleis();		
		zuege[gleisnr] = null;
		reserved[gleisnr]= false;
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

	public boolean isReserved(int gleisNummer){
		return reserved[gleisNummer];
	}
}
