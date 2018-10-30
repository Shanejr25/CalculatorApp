import java.lang.Math;
import java.util.Stack;

public class Calculations {
	
	// determine the priority of the two operands
	public boolean Priority(char op1, char op2) 
    { 
		// check if the second operand has the highest priority
        if (op2 == '(' || op2 == ')') 
            return false; 
        // check if the first operand has higher priority over the second operand
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
            return false; 
        // go here if the first operand has a lower priority than the second one
        else
            return true; 
    } 
	
	// method to dissect the input line and figures out what to calculate first
	public double findCalculation(String line) {
		
		// create the stacks for operands and numbers
		Stack<Character> operands = new Stack<Character>();
		Stack<Double> values = new Stack<Double>();
		
		StringBuffer buff = new StringBuffer();
		
		// convert the line into a character array to test for operands
		char[] tokens = line.toCharArray();
		// find operators 
		for (int i = 0; i < tokens.length; i++) {
					
			// check for empty spaces
			if (tokens[i] == ' '){
				continue;
			}
			
			// check if a number is found
			else if (Character.isDigit(tokens[i])) {
				// check if there are more numbers next to it
				for (int j = i+1; j < tokens.length; j++) {
					if (Character.isDigit(tokens[j])) {
						// add the character to the array
						buff.append(tokens[i]);
						// add the value to the stack
						values.push(Double.parseDouble(buff.toString()));
					
					// exit the loop because a character is found
					} // end if
					else {
						break;
					} // end else
				}
			}
					// check for the beginning of a calculation
					else if (tokens[i] == '(') {
						operands.push(tokens[i]);
					
					// check for the end of the expression, then solve
					} else if (tokens[i] == ')') {
						// loop until another parenthesis is encountered
						while (operands.peek() != '(') {
							// push a number to the number stack as the result
							values.push(Calculate(values.pop(), values.pop(), operands.pop()));
						}
					}
					
				} // end for loop
		
		return values.pop();
	}
	// method used to calculate the result
	public double Calculate(double num1, double num2, char operator) {
			
		if (operator == ('+')) {
			return num1 + num2;
		} else if (operator == ('*')) {
			return num1 * num2;
		} else if (operator == ('-')) {
			return num1 - num2;
		} else if (operator == ('/')) {
			 if (num2 == 0) {
				 System.out.println("Cannot divide by 0!");
				 System.exit(0);
			 }
			return num1 / num2;
		} else if (operator == ('^')) {
			return (long) Math.pow(num1, num2);
		} else if (num2 == 0){
			return 0;
		} else {
			// print a statement stating that the input is wrong
			System.out.println("Using an unknown input, calculation cannot be completed!");
			System.out.println(0);
		}
		return 0;
	}
}
