package br.ulbra;

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
    private Button btPercent;
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
            Double n1 = Double.parseDouble(factor1);
            Double n2 = Double.parseDouble(factor2);
            
            // TODO finish
        });
    }

    private void updateDisplay() {
        txDisplay.setText(factor1 + operation + factor2);
    }
}
