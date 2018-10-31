package calculator;

import java.lang.Math;

public class Calculator {
    
    // calculate the result
    public float Calculate(long num1, long num2, String operator){
        
       if (operator.equals("+")) {
                    return num1 + num2;
            } else if (operator.equals("*")) {
                    return num1 * num2;
            } else if (operator.equals("-")) {
                    return num1 - num2;
            } else if (operator.equals("/")) {
                     if (num2 == 0) {
                             System.out.println("Cannot divide by 0!");
                             System.exit(0);
                     }
                    return num1 / num2;
            } else if (operator.equals("^")) {
                    return (float) Math.pow(num1, num2);
            } else if (num2 == 0){
                    return 0;
            } else {
                    
            }
            return 0;
    }
}