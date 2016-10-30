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
	}
}
