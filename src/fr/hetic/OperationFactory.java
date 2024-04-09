package fr.hetic;

public class OperationFactory {
    public static Operation getOperation(String operator) {
        switch (operator) {
            case "+":
                return new Addition();
            case "-":
                return new Subtraction();
            case "*":
                return new Multiplication();
            default:
                throw new IllegalArgumentException("Opérateur invalide: " + operator);
        }
    }
}
