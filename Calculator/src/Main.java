import java.io.*;
import java.util.Scanner;
import java.util.Stack;

// main class
public class Main {
	public static void main(String[] args) {
		
		// create new scanner and other variables
		Scanner keyboard = new Scanner(System.in);
		String input = "";
		double output;
		
		System.out.println("Hello! Welcome to the calculator app. \n"
				+ "What would you like to calculate? ");
		
		// store input
		input = keyboard.nextLine();
		keyboard.close();
		
		Calculations cal = new Calculations();
		output = cal.findCalculation(input);
		System.out.println("Result: "+ Double.parseDouble(output.toString()));
	}
}
