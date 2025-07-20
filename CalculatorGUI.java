package gui;

import calculator.Calculator;
import calculator.History;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CalculatorGUI {

    private final Calculator calculator = new Calculator();
    private final History history = new History();

    public CalculatorGUI() {
        JFrame frame = new JFrame("Java Calculator");
        JTextField inputField = new JTextField();
        JTextArea historyArea = new JTextArea(10, 30);
        historyArea.setEditable(false);

        JButton evalButton = new JButton("Evaluate");

        evalButton.addActionListener((ActionEvent e) -> {
            try {
                String expression = inputField.getText();
                double result = calculator.evaluate(expression);
                String entry = expression + " = " + result;
                history.add(entry);
                historyArea.setText(String.join("\n", history.getAll()));
                inputField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(inputField, BorderLayout.NORTH);
        panel.add(evalButton, BorderLayout.CENTER);
        panel.add(new JScrollPane(historyArea), BorderLayout.SOUTH);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
