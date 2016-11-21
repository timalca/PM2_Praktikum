/**
 * PM2 Praktikum
 * @author Johannes Kruber
 * @author Luis Nickel 
 */

package aufgabe2_1.jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import aufgabe2_1.DoubleDoubleZuDouble;
import aufgabe2_1.Operation;
import aufgabe2_1.Rechner;

public class testAufgabe2_1
{
	@Test
	public void testRechner()
	{
		Rechner rechner = new Rechner();
		assertEquals(21, rechner.berechne(Operation.MAL, 3, 7), 1E-5);
		assertEquals(3, rechner.berechne(Operation.GETEILT, 21, 7), 0.0000001);
		assertEquals(-4, rechner.berechne(Operation.MINUS, 3, 7), 0.0000001);
		assertEquals(10, rechner.berechne(Operation.PLUS, 3, 7), 0.0000001);
		
	}
	
	@Test
	public void testeFuncInterface()
	{
		DoubleDoubleZuDouble test = (a, b) -> a*b;
		assertEquals(21, test.werteAus(3, 7), 0.0001);
		
		test = (a, b) -> (-b)/a;
		
		assertEquals(-7, test.werteAus(3, 21), 0.0001);
	}

}
