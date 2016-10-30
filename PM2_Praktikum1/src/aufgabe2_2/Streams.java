package aufgabe2_2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Streams {
	private String[] stringEingabe;
	
	public Streams(String[] stringEingabe){
		this.stringEingabe=stringEingabe;
	
	}
	
	public List<String> stringEingabeBearbeiten(){
		List<String> listEingabe=new ArrayList<String>();
		for(String string:stringEingabe){
			listEingabe.add(string);
		}
		
		listEingabe=listEingabe.stream()
		
				.filter(wort -> wort!=null)
				.map(String::toUpperCase)
				.map(String::trim)
				.map(wort -> wort.replace("Ä", "AE"))
				.map(wort -> wort.replace("Ö", "OE"))
				.map(wort -> wort.replace("Ü", "UE"))
				.map(wort ->{if(wort.length()>7)return wort.substring(0, 8);return wort;})
				.collect(Collectors.toList());
		
		return listEingabe;
	}
}
