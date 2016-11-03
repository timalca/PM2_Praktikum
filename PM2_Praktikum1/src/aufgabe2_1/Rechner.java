<<<<<<< HEAD
/**
 * PM2 Praktikum
 * @author Johannes Kruber
 * @author Luis Nickel 
 */

package aufgabe2_1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

/**
 * Klasse zum rechnen mit den vier Grundrechenarten
 */
public class Rechner
{
	Map<Operation, BinaryOperator<Double>> operationen;

	/**
	 * initialisiert die vier Rechenarten in einer HashMap
	 */
	public Rechner()
	{
		operationen = new HashMap<Operation, BinaryOperator<Double>>();

		BinaryOperator<Double> plus = (a, b) -> a + b;
		operationen.put(Operation.PLUS, plus);

		BinaryOperator<Double> minus = (a, b) -> a - b;
		operationen.put(Operation.MINUS, minus);

		BinaryOperator<Double> mal = (a, b) -> a * b;
		operationen.put(Operation.MAL, mal);

		BinaryOperator<Double> geteilt = (a, b) -> a / b;
		operationen.put(Operation.GETEILT, geteilt);
	}

	/**
	 * verechnet 2 Werte nach der Gewünschten Operation. Die
	 * 
	 * @param op
	 *            gewünschte Rechenoperation
	 * @param wert1
	 * @param wert2
	 * @return ergebnis
	 */
	public double berechne(Operation op, double wert1, double wert2)
	{
		return operationen.get(op).apply(wert1, wert2);
=======
package aufgabe2_1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Rechner {

	private Map<Operation,BinaryOperator<Double>> operatoren;
	
	public Rechner(){
		
		operatoren=new HashMap<Operation,BinaryOperator<Double>>();
		
		BinaryOperator<Double> addition=(a,b)->a+b;
		operatoren.put(Operation.ADDITION,addition);
		
		BinaryOperator<Double> subtraktion=(a,b)->a-b;
		operatoren.put(Operation.SUBTRAKTION,subtraktion);
		
		BinaryOperator<Double> multiplikation=(a,b)->a*b;
		operatoren.put(Operation.MULTIPLIKATION,multiplikation);
		
		BinaryOperator<Double> division=(a,b)->a/b;
		operatoren.put(Operation.DIVISION,division);
	}
	
	public double berechne(Operation operator, double wert1, double wert2)
	{
		return operatoren.get(operator).apply(wert1, wert2);
>>>>>>> refs/heads/Luis1
	}
}
