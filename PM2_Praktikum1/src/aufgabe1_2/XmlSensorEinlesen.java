/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package aufgabe1_2;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
/**
 * Klasse zum Einlesen einer Xml-Datei für Sensor-Objekte.
 *
 */
public class XmlSensorEinlesen {
	private Document document;
	
	public XmlSensorEinlesen(String dateiname) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(new File(dateiname));
	
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println("Fehler beim Einlesen der XML-Datei.");
		}
	}
/**
 * erstellt einen Sensor aus einer Xml-Datei und gibt diesen zurück
 * @return eingelesenen Sensor
 * @throws SensorException
 */
	public Sensor erstelleSensor()throws SensorException {
		Element element=document.getDocumentElement();
		if (element != null && element.getNodeName().equals("Sensor")) {
			Sensor xmlSensor = new Sensor();
			NamedNodeMap attribute = element.getAttributes();
			Node attribut = attribute.item(0);
			xmlSensor.setId(attribut.getNodeValue());

			// Verschachtelte Kind-Elemente verarbeiten
			for (int i = 0; i < element.getChildNodes().getLength(); i++) {
				Node kindKnoten = element.getChildNodes().item(i);
				if (kindKnoten instanceof Element) {
					Element kindElement = (Element) kindKnoten;
					switch (kindElement.getNodeName()) {
					case "Messung":
						xmlSensor=messungEinlesen(kindElement,xmlSensor);
						break;
					default:
						System.out
								.println("Behandlung für Knoten " + kindKnoten.getNodeName() + " nicht implementiert.");
					}
				}
			}
		    return xmlSensor;
		} else {
			throw new SensorException("Fehler beim Lesen eines Sensor-Knotens.");
			
		}
	}

	/**
	 * liest die Attribute, der Messung eines Sensors ein
	 * @param element Messung
	 * @param xmlSensor Sensor-Objekt dem die Messung zugewiesen wird.
	 * @return
	 */
	private Sensor messungEinlesen(Element element, Sensor xmlSensor) {
		if (element != null && element.getNodeName().equals("Messung")) {

			Messung messung = new Messung(0, null);
			NamedNodeMap attribute = element.getAttributes();
			for (int i = 0; i < attribute.getLength(); i++) {
				Node attribut = attribute.item(i);
				switch (attribut.getNodeName()) {
				case "wert":
					messung.setWert(Double.parseDouble(attribut.getNodeValue()));
					break;
				case "zeitstempel":
					messung.setZeitstempel(LocalDateTime.parse(attribut.getNodeValue()));
					break;
				}

			}
			xmlSensor.messunghinzufuegen(messung);
		} else {
			System.out.println("Fehler beim Lesen eines Messung-Knotens.");
		}
		return xmlSensor;
	}
}
