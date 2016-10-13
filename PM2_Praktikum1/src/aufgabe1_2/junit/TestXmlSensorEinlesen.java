package aufgabe1_2.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import aufgabe1_2.Sensor;
import aufgabe1_2.SensorException;
import aufgabe1_2.XmlSensorEinlesen;

public class TestXmlSensorEinlesen {

	@Test
	public void test() {
		XmlSensorEinlesen reader = new XmlSensorEinlesen("C:/Users/Luis/git/PM2_Praktikum/PM2_Praktikum1/src/aufgabe1_2/beispielSensor.xml");
		
		try {
			Sensor sensor = reader.erstelleSensor();
			assertEquals("Temperatur Wohnzimmer", sensor.getId());
			assertEquals(23.2, sensor.getMessungen().get(0).getWert(),0.001);
			assertEquals(24.5, sensor.getMessungen().get(1).getWert(),0.001);
			
			assertEquals("2016-06-23T16:51:40.408", sensor.getMessungen().get(0).getZeitstempel().toString());
			assertEquals("2016-06-24T12:12:52.001", sensor.getMessungen().get(1).getZeitstempel().toString());
		} catch (SensorException e) {
			fail(e.getMessage());
		}
		
		
	}

}
