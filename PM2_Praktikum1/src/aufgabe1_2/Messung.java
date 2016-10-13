/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package aufgabe1_2;

import java.time.LocalDateTime;
/**
 *Diese Klasse repräsentiert Messungen für einen Sensor
 */
public class Messung {

	private double wert;
	private LocalDateTime zeitstempel;
	
	public Messung(double wert,LocalDateTime zeitstempel){
		this.wert=wert;
		this.zeitstempel=zeitstempel;
	}
	
public void setWert(double wert){
		this.wert=wert;
	}
	
public void setZeitstempel(LocalDateTime zeitstempel){
		this.zeitstempel=zeitstempel;
	}

public double getWert() {
	return wert;
}
public LocalDateTime getZeitstempel() {
	return zeitstempel;
}
}
