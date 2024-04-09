package fr.hetic;

import java.io.*;

public class Calculateur {

    public static void main(String[] args) {
        double num1, num2;

        System.out.println("Veuillez saisir le chemin du dossier contenant les fichiers d'opérations:");
        String folderPath = System.console().readLine();

        if (folderPath == null || folderPath.isEmpty()) {
            folderPath = System.getProperty("user.dir");
        }

        File folder = new File(folderPath);

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
                writeResult(folder, "addition", num1, operator, num2);
                break;
            case "-":
                System.out.println("Le résultat est: " + (num1 - num2));
                writeResult(folder, "soustraction", num1, operator, num2);
                break;
            case "*":
                System.out.println("Le résultat est: " + (num1 * num2));
                writeResult(folder, "multiplication", num1, operator, num2);
                break;
            default:
                System.out.println("Opérateur invalide");
        }
    }

    private static void writeResult(File folder, String operation, double num1, String operator, double num2) {
        try {
            if (!folder.exists()) {
                folder.mkdirs();
            }

            File operationFile = new File(folder, operation + ".op");
            File resultFile = new File(folder, operation + ".res");

            FileWriter operationWriter = new FileWriter(operationFile);
            operationWriter.write(String.format("%.2f %s %.2f", num1, operator, num2));
            operationWriter.close();

            FileWriter resultWriter = new FileWriter(resultFile);
            double result = 0;
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
            }
            resultWriter.write(String.valueOf(result));
            resultWriter.close();

            System.out.println("Opération et résultat écrits avec succès.");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans les fichiers.");
            e.printStackTrace();
        }
    }
}
