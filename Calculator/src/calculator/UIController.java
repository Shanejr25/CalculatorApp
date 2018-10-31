
package calculator;

// import statements
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Shanejr
 */
public class UIController {
    @FXML
    
    private Calculator m = new Calculator();
    private Label result;
    private long num1 = 0;
    private String operator = " ";
    // used to control the label display on the calculator
    private boolean start = true;
    // store the output 
    private float output = 0;
    
    // action event method used to handle the section of buttons with a numerical value
    @FXML
    public void numOperations(ActionEvent event) {
        if (start == true){
            // set the text to blank on startup
            result.setText(" ");
            start = false;
        }
        // get the text of the button press
        String value = ((Button)event.getSource()).getText();
        result.setText(result.getText() + value);
    } 
    
    @FXML
    public void opProcessor(ActionEvent event) {
        // get the operator text value
        String value = ((Button)event.getSource()).getText();
        
        // check if the equals button has been pressed
        if (!value.equals("=")){
            // check if there was an operator used
            if (!operator.isEmpty()){
                return;
            }
            operator = value;
            num1 = Long.parseLong(result.getText());
            // clear the display
            result.setText(" ");
        } else {
            if (operator.isEmpty()){
                return;
            }
            // store the second number value and store the output
            long num2 = Long.parseLong(result.getText());
            output =  m.Calculate(num1, num2, operator);
            // set the result to output
            result.setText(String.valueOf(output));
            // reset the operator and reset the display
            operator = " ";
            start = true;
        }
    } 
}
