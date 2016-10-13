/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package aufgabe1_3;

public class ArrayListe<T extends Comparable<T>>
{
	int anzahlElemente;
	private Object elemente[];

	// ----------------Konstruktor

	public ArrayListe()
	{
		anzahlElemente = 0;
		elemente = new Object[5];
	}

	// ----------------Getter und Setter

	public int getAnzahlElemente()
	{
		return anzahlElemente;
	}

	/**
	 * Gibt das nach comparTo() kleinste Element wieder
	 * 
	 * @return kleinstes Element
	 * @throws ElementException
	 */
	@SuppressWarnings("unchecked")
	public T getKleinstesElement() throws ElementException
	{
		if (anzahlElemente <= 0)
		{
			throw new ElementException("No Element in List");
		}
		T ele = (T) elemente[0];
		for (int i = 1; i < anzahlElemente; i++)
		{
			if (ele.compareTo((T) elemente[i]) > 0)
			{
				ele = (T) elemente[i];
			}
		}

		return ele;
	}

	/**
	 * gibt das Element aus dem Array beim Index zurück
	 * 
	 * @param index
	 * @return Element beim Index
	 * @throws noEleOnIndexException
	 */
	@SuppressWarnings("unchecked")
	public T get(int index) throws ElementException
	{
		if (index > anzahlElemente)
		{
			throw new ElementException("Index to High");
		}
		return (T) elemente[index];
	}

	// ----------------Weitere Methoden

	/**
	 * erweitert das Array um 5 mögliche Einträge
	 */
	private void arrayErweitern()
	{
		Object temp[] = new Object[elemente.length + 5];
		System.arraycopy(elemente, 0, temp, 0, elemente.length);
		elemente = temp;
	}

	/**
	 * sucht ein bestimmtes element
	 * 
	 * @param ele,
	 *            gesuchtes element
	 * @return index des gesuchten elementes im Array
	 */
	private int sucheElement(T ele)
	{
		for (int i = 0; i < anzahlElemente; i++)
		{
			if (elemente[i].equals(ele))
			{
				return i;
			}
		}

		return -1;
	}

	/**
	 * fügt ein Element an der ersten freien Stelle ins Array ein
	 * 
	 * @param ele
	 */
	public void hinzufuegen(T ele) throws ElementException
	{
		if (sucheElement(ele) != -1)
		{
			throw new ElementException("Element already exists");
		}
		if (anzahlElemente >= elemente.length)
		{
			arrayErweitern();
		}
		elemente[anzahlElemente] = ele;
		anzahlElemente++;
	}

	/**
	 * Entfernt ein Element aus der Liste
	 * 
	 * @param ele
	 * @throws ElementException
	 */
	public void entfernen(T ele) throws ElementException
	{
		int index = sucheElement(ele);
		if (index == -1)
		{
			throw new ElementException("Element doesn't exist");
		}
		entferneElementAnIndex(index);
	}

	/**
	 * Entfernt das Element an einem bestimmten Index
	 * 
	 * @param index
	 * @throws ElementException
	 */
	public void entferneElementAnIndex(int index) throws ElementException
	{
		if (index >= elemente.length || elemente[index] == null)
		{
			throw new ElementException("no Element at this index");
		}
		for (int i = index; i < anzahlElemente - 1; i++)
		{
			elemente[i] = elemente[i + 1];
		}
		elemente[anzahlElemente-1] = null;
		anzahlElemente--;
	}

}
