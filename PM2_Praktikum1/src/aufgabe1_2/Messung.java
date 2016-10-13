package aufgabe1_2;

import java.time.LocalDateTime;

public class Messung {

	double wert;
	LocalDateTime zeitstempel;
	
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
	// TODO Auto-generated method stub
	return wert;
}
public LocalDateTime getZeitstempel() {
	// TODO Auto-generated method stub
	return zeitstempel;
}
}
