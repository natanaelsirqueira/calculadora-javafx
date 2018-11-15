package br.ulbra;

import br.ulbra.operation.Operator;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController implements Initializable {

    @FXML
    private TextField txDisplay;
    @FXML
    private Button bt7;
    @FXML
    private Button bt8;
    @FXML
    private Button bt9;
    @FXML
    private Button btClear;
    @FXML
    private Button bt4;
    @FXML
    private Button bt5;
    @FXML
    private Button bt6;
    @FXML
    private Button btDivide;
    @FXML
    private Button bt1;
    @FXML
    private Button bt2;
    @FXML
    private Button bt3;
    @FXML
    private Button btTimes;
    @FXML
    private Button bt0;
    @FXML
    private Button btPlus;
    @FXML
    private Button btMinus;
    @FXML
    private Button btEquals;

    List<Button> numberButtons;
    List<Button> operationButtons;

    String factor1 = "";
    String operation = "";
    String factor2 = "";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numberButtons = new ArrayList(
                Arrays.asList(bt0, bt1, bt2, bt3, bt3, bt4, bt5, bt6, bt7, bt8, bt9)
        );

        operationButtons = new ArrayList(
                Arrays.asList(btPlus, btMinus, btTimes, btDivide)
        );

        numberButtons.forEach(bt -> bt.setOnAction(e -> {
            if (operation.equals(""))
                factor1 += bt.getText();
            else
                factor2 += bt.getText();
            
            updateDisplay();
        }));

        operationButtons.forEach(bt -> bt.setOnAction(e -> {
            operation = bt.getText();
            
            updateDisplay();
        }));
        
        btEquals.setOnAction(e -> {
            if (!factor2.equals("")) {
                Double x1 = Double.parseDouble(factor1);
                Double x2 = Double.parseDouble(factor2);

                Operator op = Operator.fromString(operation);

                factor1 = calculate(op, x1, x2);
                factor2 = "";

                txDisplay.setText(factor1);
            }
        });
        
        btClear.setOnAction(e -> {
            factor1 = "";
            operation = "";
            factor2 = "";
            updateDisplay();
        });
    }
    
    private String calculate(Operator op, Double x1, Double x2) {
        return String.valueOf(op.apply(x1, x2));
    }

    private void updateDisplay() {
        txDisplay.setText(factor1 + operation + factor2);
    }
}
