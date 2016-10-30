package aufgabe2_2.jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import aufgabe2_2.Streams;

public class StreamTestKlasse {

	@Test
	public void testeStringEingabeBearbeiten() {
		//test1
		String[] stringEingabe1={"Eingabe ","Äußeres ",null,"Straßen-Feger"," ein Haus"};
		String[] stringVergleich1={"EINGABE","AEUSSERE","STRASSEN","EIN HAUS"};
		Streams stream1=new Streams(stringEingabe1);
		assertArrayEquals(stringVergleich1,stream1.stringEingabeBearbeiten().toArray());
		
		//test2
		String[] stringEingabe2={"Feuerwehrmann","Ägypten ",null,null," Sieben  "};
		String[] stringVergleich2={"FEUERWEH","AEGYPTEN","SIEBEN"};
		Streams stream2=new Streams(stringEingabe2);
		assertArrayEquals(stringVergleich2,stream2.stringEingabeBearbeiten().toArray());
		
		//test3
		String[] stringEingabe3={" Förster","Österreich "," Übung"};
		String[] stringVergleich3={"FOERSTER","OESTERRE","UEBUNG"};
		Streams stream3=new Streams(stringEingabe3);
		assertArrayEquals(stringVergleich3,stream3.stringEingabeBearbeiten().toArray());

		//test4
		String[] stringEingabe4={"SONNE","WARM"};
		String[] stringVergleich4={"SONNE","WARM"};
		Streams stream4=new Streams(stringEingabe4);
		assertArrayEquals(stringVergleich4,stream4.stringEingabeBearbeiten().toArray());
		
		//test5
		String[] stringEingabe5={" "};
		String[] stringVergleich5={""};
		Streams stream5=new Streams(stringEingabe5);
		assertArrayEquals(stringVergleich5,stream5.stringEingabeBearbeiten().toArray());
	}

}
