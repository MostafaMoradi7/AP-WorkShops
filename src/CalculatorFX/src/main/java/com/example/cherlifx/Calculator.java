package CalculatorFX.src.main.java.com.example.cherlifx;


public class Calculator {
    private String input;

    public Calculator() {
        input = "";
    }

    public void add() {
        input = input + " + ";
    }

    public void multiply() {
        input = input + " * ";
    }

    public void divide() {
        input = input + " / ";
    }

    public void diminish() {
        input = input + " - ";
    }
    public void cleanScreen(){
        input = "";
    }

    public void addNumber(String number){
        String[] ins = input.split(" ");
        if (!(ins[ins.length - 1].contains(".") && number.equals(".")))
         input = input + number;
    }

    public void calculate() {
        String[] ins = input.split(" ", 3);
        if (ins.length == 3) {
            double n1 = Double.parseDouble(ins[0]);
            double n2 = Double.parseDouble(ins[2]);
            String operation = ins[1];
            switch (operation) {
                case "+" -> {
                    input = String.valueOf(n1 + n2);
                }

                case "-"-> {
                    input = String.valueOf(n1 - n2);
                }

                case "*" -> {
                    input = String.valueOf(n1 * n2);
                }

                case "/" -> {
                    input = String.valueOf(n1 / n2);
                }
                default -> {}
            }
        }
    }

//    public double calculateResult(){
//        double result = 0;
//        String[] ins = input.split(" ");
//        for (int i = 0; i < ins.length; i++) {
//
//        }
//
//        return result;
//    }


    public String getInput(){
        return input;
    }
}
