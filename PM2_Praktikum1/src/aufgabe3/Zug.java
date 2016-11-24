/**
 * PM2 Praktikum
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package aufgabe3;

public class Zug
{
	static private int anzahl = 0;
	
	public Zug()
	{
		anzahl++;
	}
	
	public int getAnzahl()
	{
		return anzahl;
	}
}
