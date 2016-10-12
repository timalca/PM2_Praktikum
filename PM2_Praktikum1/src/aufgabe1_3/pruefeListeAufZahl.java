package aufgabe1_3;

public class pruefeListeAufZahl
{
	/**
	 * Prüft ob das erste Element einer ArrayListe eine Zahl ist
	 * @param list
	 * @return
	 */
	static public boolean pruefeListe(ArrayListe list)
	{
		if (list.getAnzahlElemente() < 1)
		{
			try
			{
				Object ele = list.get(0);
				if (ele instanceof Integer || ele instanceof Double
						|| ele instanceof Long || ele instanceof Short
						|| ele instanceof Float)
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
