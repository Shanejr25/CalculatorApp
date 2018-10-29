import java.lang.Math;

public class Calculations {
	
	// default constructor
	public Calculations() {
		
	}
	
	// method to dissect the input line and figures out what to calculate first
	public String findCalculation(String line) {
		return line;
	}
	// method used to calculate the result
	public double Calculate(long num1, long num2, String operator) {
			
		if (operator.equals("+")) {
			return num1 + num2;
		} else if (operator.equals("*")) {
			return num1 * num2;
		} else if (operator.equals("-")) {
			return num1 - num2;
		} else if (operator.equals("/")) {
			return num1 / num2;
		} else if (operator.equals("^")) {
			return Math.pow(num1, num2);
		} else if (num2 == 0){
			return 0;
		} else {
			// print a statement stating that the input is wrong
		}
		return 0;
	}
}
