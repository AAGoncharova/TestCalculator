import enums.FunctionEnum;

import java.util.Arrays;

/**
 * @author AAGoncharova
 *
 * This class manages arithmetic computations based on the input data.
 * It accepts a function name and an array of input numbers and
 * invokes the corresponding arithmetic function.
 */
public class CalcController {

    FunctionEnum arthFunc;
    int[] numbers;

    public CalcController(FunctionEnum function, int[] args) {
        this.arthFunc = function;
        this.numbers = args;
    }

    public int compute(){
        switch(this.arthFunc){
            case ADD: return Calculator.sum(numbers);
            case MUL: return Calculator.multiply(numbers);
            case MUL_TWO_THEN_SUM_WITH_THIRD: return Calculator.multiplyAndSum(numbers[0], numbers[1], numbers[2]); //todo: check that there are 3 parameters
            case INCREMENT_THEN_MUL: return Calculator.incrementAndMultiply(numbers);
        }
        return 0;
    }
}
