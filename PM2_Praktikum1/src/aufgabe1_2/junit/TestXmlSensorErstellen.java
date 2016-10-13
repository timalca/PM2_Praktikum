package aufgabe1_2.junit;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import aufgabe1_2.Messung;
import aufgabe1_2.Sensor;
import aufgabe1_2.SensorException;
import aufgabe1_2.XmlSensorEinlesen;
import aufgabe1_2.XmlSensorErstellen;

public class TestXmlSensorErstellen {

	@Test
	public void test() {
		String zeit1 ="2016-05-20T16:51:40.408", zeit2="2014-02-10T16:51:40.408";
		String datei= "TestSensor";
		double wert1 = 12.6, wert2 = 3.09;
		Sensor sensor = new Sensor();
		sensor.setId("HAW-Zaehler");
		sensor.messunghinzufuegen(new Messung(wert1,LocalDateTime.parse(zeit1)));
		sensor.messunghinzufuegen(new Messung(wert2,LocalDateTime.parse(zeit2)));
		
		XmlSensorErstellen b = new XmlSensorErstellen();
		b.speicherSensor(sensor, datei);
		
		XmlSensorEinlesen a= new XmlSensorEinlesen("C:/Users/Luis/git/PM2_Praktikum/PM2_Praktikum1/src/aufgabe1_2/" + datei +".xml");
		
		try {
			Sensor sensor2 = a.erstelleSensor();
			assertEquals("HAW-Zaehler", sensor.getId());
			assertEquals(wert1, sensor2.getMessungen().get(0).getWert(),0.001);
			assertEquals(wert2, sensor2.getMessungen().get(1).getWert(),0.001);
			
			assertEquals(zeit1, sensor2.getMessungen().get(0).getZeitstempel().toString());
			assertEquals(zeit2, sensor2.getMessungen().get(1).getZeitstempel().toString());
		} catch (SensorException e) {
			fail(e.getMessage());
		}
	}

}
