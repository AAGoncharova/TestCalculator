import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private int[] numbers = {7, 9, 3};

    @Test
    void sumTest(){
        assertEquals(Calculator.sum(numbers), 19);
    }

    @Test
    void multiplyTest(){
        assertEquals(Calculator.multiply(numbers), 189);
    }

    @Test
    void multiplyAndSumTest(){
        assertEquals(Calculator.multiplyAndSum(numbers[0], numbers[1], numbers[2]), 66);
    }

    @Test
    void incrementAndMultiplyTest(){
        assertEquals(Calculator.incrementAndMultiply(numbers), 320);
    }
}
