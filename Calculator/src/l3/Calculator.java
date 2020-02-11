package l3;

// imports 
import java.io.*;
import java.util.*;

public class Calculator { 
	
	// main driver function
     public static void main (String [] args) 
     {  
          while (true) {
               System.out.println("Enter an equation or press q to quit: ");
               tokenGenerator token = new tokenGenerator(); 
               token.getNextToken(); 
               Evaluate express = new Evaluate(token); 
               int result = express.operandAddSub(); 
               System.out.println ("= " + result + "\n");
                
          }
               
     } // end of main method 
} // end of Calculator class

class tokenGenerator
{ 
    int value = 0; 
    String name, tokenString; 
    BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokens;

    // generate the new tokens for the buffer
    tokenGenerator() { 
         try { 
        	  // store the string input into tokenstring
              tokenString = buff.readLine();
              
              // tokenize the string to find the numbers
              tokens = new StringTokenizer(tokenString, "+-*/() ", true); 
              
         } catch (IOException e) {
        	 System.out.println("Must input numbers, or mathematical operators!");
        } 
    } // constructor 
  
     public void getNextToken() { 
    	 
          char op = ' '; 
          // store the next token
          if (tokens.hasMoreTokens()) { 
               String token = tokens.nextToken(); 
               op = token.charAt(0);
               
               // check if a space was found
               while (op == ' ') 
               { 
                    token = tokens.nextToken(); 
                    op = token.charAt(0); 
               }
               // check if a number was found
               if (('0' <= op) && (op <= '9')) 
               { 
                    name = "digit"; 
                    try { 
                    	value = Integer.parseInt(token); 
                    } catch (NumberFormatException e) {
                    	value = 0;
                    } 
               } else {    
            	   switch (op) 
                    { 
               			// check which operand has been found
                         case '+': 
                        	 name = "add"; 
                        	 break; 
                         case '-': 
                        	 name = "subtract"; 
                        	 break; 
                         case '*': 
                        	 name = "multiply"; 
                        	 break; 
                         case '/': 
                        	 name = "divide"; 
                        	 break; 
                         case '^': 
                        	 name = "exponent"; 
                        	 break; 
                         case '(': 
                        	 name = "openParenthesis"; 
                        	 break; 
                         case ')': name = "closedParenthesis"; 
                         	 break; 
                         	default: 
                        	 name = "other"; 
                    } // end of switch statement
               } // end of else statement 
          } 
          else name = "other"; 
     } //method getToken
     
     // get method to return the string values of the operations
     public String getName () { 
    	 return name; 
     }
  // get method to return the int values of the operations
     public int getValue () {
    	 return value; 
     }

} // class Token

class Evaluate {
	// create a private token instance
     private tokenGenerator token; 
     Evaluate (tokenGenerator token) {
    	 this.token = token; 
     } // constructor 
  
     // check for and perform addition and subtraction operations in this method
     public int operandAddSub() { 
          String operand; 
          int result; 
          result = operandMultDiv(); 
          while ((token.getName().equals("add")) || (token.getName().equals("subtract"))) 
          { 
               operand = token.getName(); 
               token.getNextToken(); 
               if (operand.equals ("add")) 
               { 
                    result = result + operandMultDiv(); 
                   
                } 
               else 
               { 
                    result = result - operandMultDiv(); 
                    
               } 
          } 
          return result; 
     } // method operandAddSub 
  
     // handle the multiplication, division, and exponent operations
     public int operandMultDiv() { 
          String operand; 
          int result; 
          result = solveOperandAddSub(); 
          
          // check if multiply, divide, or exponent was entered, then do operations
          while ((token.getName().equals("multiply")) || (token.getName().equals("divide"))) 
          { 
               operand = token.getName(); 
               token.getNextToken(); 
               
               if (operand.equals("multiply")) { 
            	   
                   result = result * solveOperandAddSub(); 
                   
               }  else { 
                    result = result / solveOperandAddSub(); 
                    
               } 
          } 
          return result; 
     } // method Operand

     // solveoperandAddSub the operandAddSub out
     public int solveOperandAddSub() { 
    	 
    	 
          int output = 0; 
          // get the next digit
          if (token.getName().equals("digit")) 
          { 
               output = token.getValue(); 
               
               token.getNextToken();
               
          }
          // get the next operandAddSub and check for errors
          else if (token.getName().equals("openParenthesis")) 
          { 
        	   // check for end of each expression
               token.getNextToken(); 
               output = operandAddSub(); 
               if (token.getName().equals("closedParenthesis")) { 
                    token.getNextToken();
               } else {
                    System.out.print("Error, missing right parenthesis!"); 
               }
          } else {
               System.out.print("Error! Invalid. Tokens ");
               System.exit(0); 
          }
          return output; 
     }  
} // end of Calculator 