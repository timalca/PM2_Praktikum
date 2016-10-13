/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package aufgabe1_3;

public class pruefeListeAufZahl
{
	/**
	 * Prüft ob das erste Element einer ArrayListe eine Zahl ist
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	static public boolean pruefeListe(ArrayListe list)
	{
		if (list.getAnzahlElemente() < 1)
		{
			try
			{
				Object ele = list.get(0);
				if (ele instanceof Number)
				{
					return true;
				}
			}
			catch (ElementException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return false;
	}
}
