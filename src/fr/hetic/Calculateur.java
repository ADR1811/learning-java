package fr.hetic;

public class Calculateur {

    public static void main(String[] args) {
        double num1, num2;

        System.out.println("Entrez le premier nombre:");
        num1 = Double.parseDouble(System.console().readLine());

        String operator = "";

        while (!operator.equals("+") && !operator.equals("-") && !operator.equals("*")) {
            System.out.println("Entrez l'opérateur (+, -, *):");
            operator = System.console().readLine();
            operator = operator.replaceAll("\\s", "");
        }

        System.out.println("Entrez le deuxième nombre:");
        num2 = Double.parseDouble(System.console().readLine());

        switch (operator) {
            case "+":
                System.out.println("Le résultat est: " + (num1 + num2));
                break;
            case "-":
                System.out.println("Le résultat est: " + (num1 - num2));
                break;
            case "*":
                System.out.println("Le résultat est: " + (num1 * num2));
                break;
            default:
                System.out.println("Opérateur invalide");
        }

    }
    
}
