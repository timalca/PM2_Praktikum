/**
*PM2 Paktikum
*@autor Johannes Kruber
*@autor Luis Nickel
*/
package aufgabe3;

public class Lokfuehrer extends Thread{

	private double aufgabe;
	private Rangierbahnhof bahnhof;
	private int gleisnummer;
	
	public Lokfuehrer(double aufgabe,Rangierbahnhof bahnhof,int gleisnummer){
		this.aufgabe=aufgabe;
		this.bahnhof=bahnhof;
		this.gleisnummer=gleisnummer;
	}
	
	public void run(){
		aufgabeAusfuehren();
	}
	
	private void aufgabeAusfuehren(){
		Zug zug=new Zug();
		if(aufgabe<0.5){
			bahnhof.einfahren(zug, gleisnummer);
			
		}
		else {
			bahnhof.ausfahren(gleisnummer);
			
		}

	}

}


