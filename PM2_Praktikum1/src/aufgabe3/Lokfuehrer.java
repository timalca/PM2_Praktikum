/**
*PM2 Paktikum
*@autor Johannes Kruber
*@autor Luis Nickel
*/
package aufgabe3;

public class Lokfuehrer extends Thread{

	private boolean aufgabe;
	private Rangierbahnhof bahnhof;
	private int gleisnummer;
	
	public Lokfuehrer(boolean aufgabe,Rangierbahnhof bahnhof,int gleisnummer){
		this.aufgabe=aufgabe;
		this.bahnhof=bahnhof;
		this.gleisnummer=gleisnummer;
	}
	
	public void run(){
		aufgabeAusfuehren();
	}
	
	private void aufgabeAusfuehren(){
		Zug zug=new Zug();
		if(aufgabe){
			try {
				bahnhof.einfahren(zug, gleisnummer);
				System.out.println("Es ist ein Zug auf das "+gleisnummer+" eingefahren");
			} catch (reservedException e) {
				e.printStackTrace();
			}
			
		}
		else {
			try {
				bahnhof.ausfahren(gleisnummer);
				System.out.println("Der Zug auf dem "+gleisnummer+". Gleis hat den Bahnhof verlassen");
			} catch (reservedException e) {
				e.printStackTrace();
			}
			
		}

	}
	
	public boolean getAufgabe(){
		return aufgabe;
	}
	
	public int getGleis(){
		return gleisnummer;
	}
}


