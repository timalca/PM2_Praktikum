/**
 * PM2 Praktikum
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package aufgabe3;

public class Zug
{
	static private int anzahl = 0;
	private int nummer;
	public Zug()
	{
		anzahl++;
		nummer = anzahl;
	}
	
	public int getNummer()
	{
		return nummer;
	}
}
