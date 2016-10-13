package aufgabe1_2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import aufgabe1_1.Pruefungsleistung;

public class Sensor {
	private String id;
	List<Messung> messungen ;
	

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
		return (ArrayList<Messung>) messungen;
	}
	
	public void messungAusgeben(){
		
		
	}
	public static void main(String[]args){
		XmlSensorEinlesen xmls = new XmlSensorEinlesen("C:/Users/Luis/git/PM2_Praktikum/PM2_Praktikum1/src/aufgabe1_2/beispielSensor.xml");
		Sensor sensor=new Sensor();
		sensor=xmls.XmlSensorAusgabe();
		XmlSensorErstellen sensorXmlerstelle=new XmlSensorErstellen(sensor);
		
	}

	public double getWert() {
		// TODO Auto-generated method stub
		return 0;
	}
}
