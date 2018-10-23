import java.lang.Math;

public class Model {
	// method used to calculate the result
		public double Calculate(double num1, double num2, String operator) {
			
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
