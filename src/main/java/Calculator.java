import java.util.Arrays;

/**
 * @author AAGoncharova
 *
 * This class handles all arithmetic computations.
 */
public class Calculator {
    public static int sum(int[] numbers){
        return Arrays.stream(numbers).sum();
    }

    public static int multiply(int[] numbers){
        return Arrays.stream(numbers).reduce(1, (x, y) -> x*y);
    }

    public static int multiplyAndSum(int first, int second, int third){
        return (first * second) + third;
    }

    public static int incrementAndMultiply(int[] numbers){
        return Arrays.stream(numbers).map(x -> x + 1).reduce(1, (x, y) -> x*y);
    }
}
