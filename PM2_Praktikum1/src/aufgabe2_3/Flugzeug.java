/**
 * PM2 Praktikum 
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package aufgabe2_3;

public class Flugzeug extends Thread
{
	private Flughafen flughafen;
	private String id;
	private int flugdauer, startzeit, zeit;
	private Status status;

	public Flugzeug(String id, int flugdauer, Flughafen flughafen,
			int startzeit)
	{
		this.id = id;
		this.flugdauer = flugdauer;
		this.flughafen = flughafen;
		this.startzeit = startzeit;
		status = Status.FLUG;
		zeit = startzeit;
	}
	
	/**
	 * setzt die Zeit für das flugzeug
	 * nötig um aktuelle zeit gemeldet zu bekommen
	 * @param zeit
	 */
	public void setZeit(int zeit)
	{
		this.zeit = zeit;
	}
	
	@Override
	public void run() // not finished
	{
		while (!isInterrupted())
		{
			if(zeit - startzeit >= flugdauer && status != Status.GELANDET)
			{
				status = Status.LANDE;
				flughafen.landen(this);
			}
		}
	}
	
	public void gelandet()
	{
		status= Status.GELANDET;
	}
	
	
	public boolean istGelandet()
	{
		if(status == Status.GELANDET)
		{
			return true;
		}
		
		return false;
	}
	
	public String toString()
	{
		return id + "\nStart: " + startzeit + "\nDauer: " + flugdauer + "\nStatus: " + status;
	}
}
