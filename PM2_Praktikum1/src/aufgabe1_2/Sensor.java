/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package aufgabe1_2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import aufgabe1_1.Pruefungsleistung;

public class Sensor {
	private String id;
	private List<Messung> messungen ;
	

	public Sensor(){
		messungen = new ArrayList<Messung>();
	}
	
	public void messunghinzufuegen(Messung messung){
		messungen.add(messung);
	}
	
	public void setId(String id){
		this.id=id;
	}
	public String getId() {
		return id;
	}
	public ArrayList<Messung> getMessungen(){
		ArrayList<Messung> messungen = new ArrayList<Messung>();
		
		for(int i=0; i < this.messungen.size(); i++)
		{
			messungen.add(this.messungen.get(i));
		}
		return messungen;
	}
}
