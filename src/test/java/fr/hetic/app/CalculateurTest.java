package fr.hetic.app;

import org.junit.jupiter.api.Test;
import java.util.function.BinaryOperator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import fr.hetic.app.Calculateur;

public class CalculateurTest {
    @Test
    public void testAddition() {
        BinaryOperator<Double> operation = Calculateur.getOperation("+");
        double result = operation.apply(2.0, 3.0);
        assertEquals(5.0, result, 0.0001);
    }

    @Test
    public void testSubtraction() {
        BinaryOperator<Double> operation = Calculateur.getOperation("-");
        double result = operation.apply(5.0, 3.0);
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void testMultiplication() {
        BinaryOperator<Double> operation = Calculateur.getOperation("*");
        double result = operation.apply(2.0, 3.0);
        assertEquals(6.0, result, 0.0001);
    }
}