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

public class XmlSensorErstellen {

	public XmlSensorErstellen(Sensor sensor){
		
		try {
		DocumentBuilderFactory docFactory =DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		
		Element sensorElement=doc.createElement("Sensor");
		sensorElement.setAttribute("id", sensor.getId());
		ArrayList<Messung> messungen=sensor.getMessungen();
	Iterator<Messung> it= messungen.iterator();
	while(it.hasNext()){
		sensorElement.appendChild(messungsElementHinzufuegen((Messung)(it.next()),doc));
		
	}
	
		
		
		doc.appendChild(sensorElement);
		
		TransformerFactory transFactory=TransformerFactory.newInstance();
		Transformer transformer=transFactory.newTransformer();
		DOMSource source=new DOMSource(doc);
		StreamResult streamresult=new StreamResult("C:/Users/Luis/git/PM2_Praktikum/PM2_Praktikum1/src/aufgabe1_2/beispielSensor2.xml");
		transformer.transform(source, streamresult);
		} catch (ParserConfigurationException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
	
		}
	}
	
	public Element messungsElementHinzufuegen(Messung messung, Document doc){
		Element messungElement=doc.createElement("Messung");
		Attr wertAttribut=doc.createAttribute("wert");
		Attr zeitstempelAttribut=doc.createAttribute("zeitstempel");
		wertAttribut.setValue("12.3");
		zeitstempelAttribut.setValue("2016-06-24T12:12:52.000");
		messungElement.setAttributeNode(wertAttribut);
		messungElement.setAttributeNode(zeitstempelAttribut);
		return messungElement;
		
	}
	
	
}
