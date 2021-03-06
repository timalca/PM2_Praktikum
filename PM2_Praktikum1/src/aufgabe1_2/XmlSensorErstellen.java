/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package aufgabe1_2;


import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**
 * Klasse zum erstellen einer Xml-Datei f�r Sensor-Objekte.
 *
 */
public class XmlSensorErstellen {
	Document doc;
	public XmlSensorErstellen() {

		
	}
	
	
	/**
	 * Nimmt einen Sensor und speichert diesen in einer Xml-Datei.
	 * @param sensor der gespeichert wird
	 * @param dateiname: Name der Datei.
	 */
	public void speicherSensor(Sensor sensor, String dateiname)
	{
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder;
			docBuilder = docFactory.newDocumentBuilder();
			doc= docBuilder.newDocument();

			Element sensorElement = doc.createElement("Sensor");
			sensorElement.setAttribute("id", sensor.getId());
			ArrayList<Messung> messungen = sensor.getMessungen();
			Iterator<Messung> it = messungen.iterator();
			while (it.hasNext()) {
				sensorElement.appendChild(messungsElementHinzufuegen((Messung) (it.next()), doc));
			}

			doc.appendChild(sensorElement);

			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult streamresult = new StreamResult(
					dateiname+".xml");
			transformer.transform(source, streamresult);
		} catch (ParserConfigurationException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	/**
	 * Fuecgt dem Document eine Messung hinzu
	 * @param messung, die dem Document hinzugefuegt werden soll.
	 * @param doc, Document dem die Messung hinzugef�gt wird.
	 * @return messungElement
	 */
	private Element messungsElementHinzufuegen(Messung messung, Document doc) {
		Element messungElement = doc.createElement("Messung");
		Attr wertAttribut = doc.createAttribute("wert");
		Attr zeitstempelAttribut = doc.createAttribute("zeitstempel");
		wertAttribut.setValue(Double.toString(messung.getWert()));
		zeitstempelAttribut.setValue(messung.getZeitstempel().toString());
		messungElement.setAttributeNode(wertAttribut);
		messungElement.setAttributeNode(zeitstempelAttribut);
		return messungElement;

	}

}
