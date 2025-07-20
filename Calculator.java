package calculator;

public class Calculator {

    public double evaluate(String expression) {
        String[] tokens;
        if (expression.contains("+")) {
            tokens = expression.split("\\+");
            return Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[1]);
        } else if (expression.contains("-")) {
            tokens = expression.split("-");
            return Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[1]);
        } else if (expression.contains("*")) {
            tokens = expression.split("\\*");
            return Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[1]);
        } else if (expression.contains("/")) {
            tokens = expression.split("/");
            if (Double.parseDouble(tokens[1]) == 0) throw new ArithmeticException("Division by zero");
            return Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[1]);
        }
        throw new IllegalArgumentException("Invalid expression");
    }
}
