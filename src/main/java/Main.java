import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws SQLException {
        if (args.length < 2) {
            System.out.println("No arguments!!! Program start format: java Main INPUT_MODE INPUT_MODE, where INPUT_ and OUTPUT_MODE can be '-', 'db' or file name");
        } else {
            System.out.println("Program started");
            IOController ioController = new IOController(args[0], args[1]);
            try {
                ioController.readInputData();
                int[] inputData = ioController.getInputData();
                CalcController cc = new CalcController(ioController.getFunction(), ioController.getInputData());
                int result = cc.compute();
                ioController.writeOutputData(result);
            } catch (IOException | SQLException | NumberFormatException ex) {
                if(ex.getClass() == NumberFormatException.class){
                    System.out.println("Invalid input data format! Should be numbers!");
                } else{
                    System.out.println(ex.getMessage());
                }
            }
            System.out.println("Program finished");
        }
    }
}
