
package calculator;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Shanejr
 */
public class UIController {
    
    @FXML
    private long num1 = 0;
    private long num2 = 0;
    String oldHistory = "";
    private String operator = "";
    private String value = "";
    private String set = "";
    private long num = 0;
    
    // create the button variables here
    @FXML
    public Button zero;
    public Button one;
    public Button two;
    public Button three;
    public Button four;
    public Button five;
    public Button six;
    public Button seven;
    public Button eight;
    public Button nine;
    public Button multi;
    public Button equal;
    public Button division;
    public Button add;
    public Button sub;
    public Button exp;
    public Button openPar;
    public Button closePar;
    public TextField input;
    public Label history;
    public Button clear;
    
    // create a method for each action here
    public void enter_zero() {
    	value = input.getText();
    	set = "0";
    	input.setText(value + set);
    }
    public void enter_one() {
    	value = input.getText();
    	set = "1";
    	input.setText(value + set);
    }
    public void enter_two() {
    	value = input.getText();
    	set = "2";
    	input.setText(value + set);
    }
    public void enter_three() {
    	value = input.getText();
    	set = "3";
    	input.setText(value + set);
    }
    public void enter_four() {
    	value = input.getText();
    	set = "4";
    	input.setText(value + set);
    }
    public void enter_five() {
    	value = input.getText();
    	set = "5";
    	input.setText(value + set);
    }
    public void enter_six() {
    	value = input.getText();
    	set = "6";
    	input.setText(value + set);
    }
    public void enter_seven() {
    	value = input.getText();
    	set = "7";
    	input.setText(value + set);
    }
    public void enter_eight() {
    	value = input.getText();
    	set = "8";
    	input.setText(value + set);
    }
    public void enter_nine() {
    	value = input.getText();
    	set = "9";
    	input.setText(value + set);
    }
    public void enter_multi() {
    	value = input.getText();
    	
    	if (!value.equals(" ")) {
	    	num = Integer.parseInt(value);
	    	this.num1 = num;
	    	input.setText("");
	    	history.setText(value + "*");
	    	operator = "*";
    	}
    }
    public void enter_add() {
    	value = input.getText();
    	
    	if (!value.equals(" ")) {
	    	num = Integer.parseInt(value);
	    	this.num1 = num;
	    	input.setText("");
	    	history.setText(value + "+");
	    	operator = "+";
    	}
    }
    public void enter_sub() {
    	value = input.getText();
    	
    	if (!value.equals(" ")) {
	    	num = Integer.parseInt(value);
	    	this.num1 = num;
	    	input.setText("");
	    	history.setText(value + "-");
	    	operator = "-";
    	}
    }
    public void enter_division() {
    	
    	value = input.getText();
    	
    	if (!value.equals(" ")) {
	    	num = Integer.parseInt(value);
	    	this.num1 = num;
	    	input.setText("");
	    	history.setText(value + "/");
	    	operator = "/";
    	}
    }
    public void enter_equals() {
            
    switch (operator){
        case "+":
        	
	            String valueADD = input.getText();
	            
	            this.num2 = Integer.parseInt(valueADD);
	            long outputADD = this.num1 + this.num2;
	            input.setText(String.valueOf(outputADD));
	            String oldHistory = history.getText();
	            history.setText(oldHistory + valueADD);
	            break;
        	
        case "-":
        	
	        	String valueSUB = input.getText();
	            this.num2 = Integer.parseInt(valueSUB);
	            long outputSUB= this.num1 - this.num2;
	            input.setText(String.valueOf(outputSUB));
	            String oldHistorySUB = history.getText();
	            history.setText(oldHistorySUB + valueSUB);
	            break;
        	
        case "*":
        	
	        	String valueMULT = input.getText();
	            this.num2 = Integer.parseInt(valueMULT);
	            long outputMULT = this.num1 * this.num2;
	            input.setText(String.valueOf(outputMULT));
	            String oldHistoryMULT = history.getText();
	            history.setText(oldHistoryMULT + valueMULT);
	            break;
        
        case "/":
        	
	        	String valueDIV = input.getText();
	            this.num2 = Long.parseLong(valueDIV);
	            long outputDIV = this.num1 / this.num2;
	            input.setText(String.valueOf(outputDIV));
	            String oldHistoryDIV = history.getText();
	            history.setText(oldHistoryDIV + valueDIV);
	            break;
        
        case "n^x":
        	
	        	String valueEXP = input.getText();
	            this.num2 = Integer.parseInt(valueEXP);
	            long outputEXP = (long) Math.pow(this.num1, this.num2);
	            input.setText(String.valueOf(outputEXP));
	            String oldHistoryEXP = history.getText();
	            history.setText(oldHistoryEXP + valueEXP);
	            break;
	    default:
	    	String valuePar = input.getText();
	    	String oldHistoryPar = history.getText();
            history.setText(oldHistoryPar + valuePar);	
        	
    	}
    }
    public void enter_exponent() {
    	
	    value = input.getText();
	    	
	    if (!value.equals("")) {
	    	num = Integer.parseInt(value);
	    	this.num1 = num;
	    	input.setText("");
	    	history.setText(value + "^");
	    	operator = "n^x";
    	}
    }
    public void enter_openParenthesis() {
    	value = input.getText();
    }
    public void enter_closedParenthesis() {
    	value = input.getText();
    }

    @FXML
    public void enter_clear(){
        input.setText("");
        history.setText("");
        this.num1 = 0;
        this.num2 = 0;
    }
} 
