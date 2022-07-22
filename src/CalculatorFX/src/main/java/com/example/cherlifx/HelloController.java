package CalculatorFX.src.main.java.com.example.cherlifx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    Calculator calculator = new Calculator();

    @FXML
    private Button ACcleaner;

    @FXML
    public void cleaner(ActionEvent e){
        calculator.cleanScreen();
        TextOnScreen.setText(calculator.getInput());
    }


    @FXML
    private Button Add;

    @FXML
    public void addNumber(ActionEvent e){
        calculator.calculate();
        calculator.add();
        TextOnScreen.setText(calculator.getInput());
    }

    @FXML
    private Button Button0;

    @FXML
    private Button Button1;

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;

    @FXML
    private Button Button4;

    @FXML
    private Button Button5;

    @FXML
    private Button Button6;

    @FXML
    private Button Button7;

    @FXML
    private Button Button8;

    @FXML
    private Button Button9;

    @FXML
    public void enterNumber(ActionEvent e){
        calculator.addNumber(  ((Button)e.getSource()).getText()  );
        TextOnScreen.setText( calculator.getInput() );
    }

    @FXML
    private Button Diminish;

    @FXML
    public void diminishNumber(ActionEvent e){
        calculator.calculate();
        calculator.diminish();
        TextOnScreen.setText( calculator.getInput() );
    }

    @FXML
    private Button Divide;

    @FXML
    public void divideNumber(ActionEvent e){
        calculator.calculate();
        calculator.divide();
        TextOnScreen.setText( calculator.getInput() );
    }

    @FXML
    private Button Equals;

    @FXML
    public void updateScreen(ActionEvent e){
        calculator.calculate();
        TextOnScreen.setText(calculator.getInput());
    }

    @FXML
    private Button Multiply;

    @FXML
    public void multiplyNumber(ActionEvent e){
        calculator.calculate();
        calculator.multiply();
        TextOnScreen.setText( calculator.getInput() );
    }

    @FXML
    private Button Point;

    @FXML
    private TextField TextOnScreen;






}