package Aut.Ap.Workshop10.src;

import java.util.Random;

public class Colors {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    public static String setColor(String message, String color) {
        return color + message + RESET;
    }

    public static String generateColor() {
        int rnd = new Random().nextInt(6) + 1;
        try {
            return (String) Colors.class.getFields()[rnd].get(null);
        } catch (IllegalAccessException e) {
            return BLUE;
        }
    }
}
