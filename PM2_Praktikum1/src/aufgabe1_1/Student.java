/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package aufgabe1_1;

import java.util.*;

public class Student implements Comparable<Student>, Comparator<Student>
{
	private String vorname, nachname;
	private int matrikelnr;
	private List<Pruefungsleistung> leistungen;

	public Student(String vorname, String nachname, int matrikelnr)

	{
		this.vorname = vorname;
		this.nachname = nachname;
		this.matrikelnr = matrikelnr;
		leistungen = new ArrayList<Pruefungsleistung>();
	}
	
	public String getVorname()
	{
		return vorname;
	}
	
	public String getNachname()
	{
		return nachname;
	}
	
	public boolean addLeistung(Pruefungsleistung leistung)
	{
		return leistungen.add(leistung);
	}

	@Override
	public int hashCode()
	{
		int hash = (matrikelnr / 1000)*13;
		return hash;
	}

	@Override
	public boolean equals(Object that)
	{
		if (that instanceof Student)
		{
			if (this.matrikelnr == ((Student) that).matrikelnr)
			{
				return true;
			}
		}

		return false;
	}

	@Override
	public int compareTo(Student o)
	{
		if (this.matrikelnr > o.matrikelnr)
		{
			return 1;
		}
		else if (this.matrikelnr < o.matrikelnr)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public int compare(Student stud1, Student stud2)
	{
		if (stud1.nachname.equals(stud2.nachname)){
				return stud1.vorname.compareTo(stud2.vorname);
		}
		return stud1.nachname.compareTo(stud2.nachname);
	
	}
}
