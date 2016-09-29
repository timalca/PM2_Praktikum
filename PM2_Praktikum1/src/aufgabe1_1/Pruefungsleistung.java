/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package aufgabe1_1;

public class Pruefungsleistung
{
	private String modulName;
	private int note; // 1-15 Punkte

	public Pruefungsleistung(String modulname, int note)
	{
		this.modulName = modulname;
		this.note = note;
	}
	
	public String getModulName()
	{
		return modulName;
	}
	
	public int getNote()
	{
		return note;
	}
}
