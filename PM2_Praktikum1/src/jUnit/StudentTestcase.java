/**
 * PM2 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package jUnit;

import static org.junit.Assert.*;
import org.junit.Before;
//import org.junit.AfterClass;
import org.junit.Test;

import aufgabe1_1.*;

public class StudentTestcase
{
	Student student1;
	Student student2;

	@Before
	public void setUp()
	{
		System.out.println("SetUp");
		student1 = new Student("Martin", "Mueller", 123456);
		student2 = new Student("Marius", "Mueller", 987654);
		student1.addLeistung(new Pruefungsleistung("Mathe", 12));
		student1.addLeistung(new Pruefungsleistung("PM", 11));
	}

	@Test
	public void equalTest()
	{
		System.out.println("equalTest");
		assertTrue(student1.equals(student1));
		assertFalse(student1.equals(student2));
	}

	@Test
	public void compareTest()
	{
		System.out.println("compareTest");
		assertTrue(student1.compare(student1.getNachname(),
				student2.getNachname()) == 0);
		assertTrue(student1.compare(student1.getVorname(),
				student2.getVorname()) > 0);
	}

}
