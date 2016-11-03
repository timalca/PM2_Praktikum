/**
 * PM2 Praktikum 
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package aufgabe2_2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Diese Klasse kann String-Array in eine modifizierte Liste<Strings> umwandeln
 */

public class Streams {
	private String[] stringEingabe;
	
	public Streams(String[] stringEingabe){
		this.stringEingabe=stringEingabe;
	
	}
	/**
	 * Diese Methode bearbeitet die String-Arrays
	 * @return
	 */
	public List<String> stringEingabeBearbeiten(){
		
		//String Array in ArrayList<String>
		List<String> listEingabe=new ArrayList<String>();
		for(String string:stringEingabe){
			listEingabe.add(string);
		}
		//List in Stream
		listEingabe=listEingabe.stream()
				//Entfernt sämtliche Null-Objekte
				.filter(wort -> wort!=null)
				//wandelt alle Buchstaben in Großbuchstaben
				.map(String::toUpperCase)
				//entfernt alle Leerzeichen am Anfang und Ende
				.map(String::trim)
				//ersetzt alle Umlaute
				.map(wort -> wort.replace("Ä", "AE"))
				.map(wort -> wort.replace("Ö", "OE"))
				.map(wort -> wort.replace("Ü", "UE"))
				//beschränkt die Anzahl jeden Strings auf max 8 Zeichen
				.map(wort ->{if(wort.length()>7)return wort.substring(0, 8);return wort;})
				//stream zu Liste
				.collect(Collectors.toList());
		
		return listEingabe;
	}
}
