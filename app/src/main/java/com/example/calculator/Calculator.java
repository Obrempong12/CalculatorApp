package com.example.calculator;

import java.util.Stack;

public class Calculator {
    public double evaluate(String expression) {
        try {
            String[] tokens = expression.split(" ");
            Stack<Double> values = new Stack<>();
            Stack<String> ops = new Stack<>();

            for (String token : tokens) {
                if (token.matches("-?\\d+(\\.\\d+)?")) {
                    values.push(Double.parseDouble(token));
                } else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                    ops.push(token);
                } else if (token.equals("=") && !ops.isEmpty() && values.size() >= 2) {
                    double b = values.pop();
                    double a = values.pop();
                    String op = ops.pop();

                    switch (op) {
                        case "+": values.push(a + b); break;
                        case "-": values.push(a - b); break;
                        case "*": values.push(a * b); break;
                        case "/": values.push(a / b); break;
                    }
                }
            }
            return values.pop();
        } catch (Exception e) {
            return 0;
        }
    }
}
