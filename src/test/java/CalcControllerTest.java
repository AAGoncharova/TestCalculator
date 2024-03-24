import enums.FunctionEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcControllerTest {

    private int[] numbers = {7, 9, 3};

    @Test
    void calcControllerAddTest(){
        CalcController cc = new CalcController(FunctionEnum.ADD, numbers);
        assertEquals(cc.compute(), 19);
    }

    @Test
    void calcControllerMulTest(){
        CalcController cc = new CalcController(FunctionEnum.MUL, numbers);
        assertEquals(cc.compute(), 189);
    }

    @Test
    void calcControllerMulAddTest(){
        CalcController cc = new CalcController(FunctionEnum.MUL_TWO_THEN_SUM_WITH_THIRD, numbers);
        assertEquals(cc.compute(), 66);
    }

    @Test
    void calcControllerIncrementMulTest(){
        CalcController cc = new CalcController(FunctionEnum.INCREMENT_THEN_MUL, numbers);
        assertEquals(cc.compute(), 320);
    }
}
