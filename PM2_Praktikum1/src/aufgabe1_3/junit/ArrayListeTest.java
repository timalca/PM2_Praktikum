package aufgabe1_3.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import aufgabe1_3.ArrayListe;
import aufgabe1_3.ElementException;

public class ArrayListeTest
{
	int elemente;
	ArrayListe<Integer> intListe;

	@Before
	public void setUp()
	{
		elemente = 10;
		intListe = new ArrayListe<Integer>();
	}

	@Test
	public void testHinzufuegen()
	{
		for (int i = 0; i < elemente; i++)
		{
			try
			{
				intListe.hinzufuegen(i);
			}
			catch (ElementException e)
			{
				e.printStackTrace();
				fail("ElementException wurde geworfen");
			}
		}
		assertEquals(elemente, intListe.getAnzahlElemente());
	}

	@Test
	public void testEntferneElementAnIndex()
	{
		for (int i = 0; i < elemente; i++)
		{
			try
			{
				intListe.hinzufuegen(i);
			}
			catch (ElementException e)
			{
				//e.printStackTrace();
				fail("ElementException wurde geworfen: " + e.getMessage());
			}
		}
		
		try
		{
			intListe.entferneElementAnIndex(5);
			//assertNotEquals(5, (int)intListe.get(5));
			assertEquals(6, (int)intListe.get(5));
		}
		catch (ElementException e)
		{
			//e.printStackTrace();
			fail("ElementException wurde geworfen: " + e.getMessage());
		}
	}
	
	@Test
	public void testGetKleinstesElement()
	{
		try
		{
			intListe.hinzufuegen(10);		//0
			intListe.hinzufuegen(45);		//1
			intListe.hinzufuegen(100);		//2
			intListe.hinzufuegen(30);		//3
			intListe.hinzufuegen(90);		//4
			intListe.hinzufuegen(3);		//5
			intListe.hinzufuegen(5);		//6
			intListe.hinzufuegen(11);		//7
			intListe.hinzufuegen(335);		//8
			intListe.hinzufuegen(20);		//9
			
			assertEquals(3, (int)intListe.getKleinstesElement());
		}
		catch (ElementException e)
		{
			//e.printStackTrace();
			fail("ElementException wurde geworfen: " + e.getMessage());
		}
		
		
	}

}
