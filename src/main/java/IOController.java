import enums.FunctionEnum;
import enums.IOModeEnum;

import java.io.*;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author AAGoncharova
 *
 * This class controls input/output (IO) methods based on program parameters.
 * It analizes IO parameters provided by the user and triggers correspnding IO mode.
 * Additionally, it includes a readInputData() method that reads data from the input source
 * and converts it to the appropriate format.
 */
public class IOController {
    private final IOModeEnum inputMode;
    private final IOModeEnum outputMode;
    private FunctionEnum function;
    private int[] inputData;
    private String inputFile;
    private String outputFile;
    private DBManager dbManager;

    public IOController(String inputModeString, String outputModeString) throws SQLException {
        this.inputMode = getIOModeFromString(inputModeString);
        this.outputMode = getIOModeFromString(outputModeString);

        if(this.inputMode == IOModeEnum.DB || this.outputMode == IOModeEnum.DB)
            this.dbManager = new DBManager();

        if(inputMode == IOModeEnum.FILE)
            this.inputFile = inputModeString;
        if(this.outputMode == IOModeEnum.FILE)
            this.outputFile = outputModeString;
    }

    private IOModeEnum getIOModeFromString(String ioModeString){
        if(ioModeString.equals("-"))
            return IOModeEnum.CONSOLE;
        else if(ioModeString.equals("db"))
            return IOModeEnum.DB;
        return IOModeEnum.FILE;
    }

    public int[] getInputData(){
        return this.inputData;
    }

    public FunctionEnum getFunction(){
        return this.function;
    }

    /**
     * Reads data from the input source.
     *
     * @throws IOException
     * @throws SQLException
     * @throws NumberFormatException
     */
    public void readInputData() throws IOException, SQLException, NumberFormatException {
        String[] input;
        switch(this.inputMode){
            case FILE:
                input = readInputDataFromFile();
                break;
            case DB:
                input = this.dbManager.readFromDB();
                break;
            default: //CONSOLE mode is default
                System.out.println("Enter function name and numbers");
                input = readInputDataFromConsole();
        }

        this.function = getFunctionFromString(input[0]);
        if(this.function == null)
            throw new IOException("Function name is invalid!");

        //this.function = input[0];
        this.inputData = fromStringToNumbers(Arrays.copyOfRange(input, 1, input.length));
    }

    /**
     * Writes result to the appropriate output destination.
     *
     * @param result
     * @throws IOException
     * @throws SQLException
     */
    public void writeOutputData(int result) throws IOException, SQLException {
        switch(this.outputMode){
            case CONSOLE:
                System.out.println("Result: " + result);
                break;
            case FILE:
                System.out.println("Result: " + result);
                FileWriter writer = new FileWriter(this.outputFile);
                writer.write(Integer.toString(result));
                writer.close();
                break;
            case DB:
                this.dbManager.writeToDB(result);
                this.dbManager.closeDBConnection();
        }
    }

    private String[] readInputDataFromConsole() throws IOException, NumberFormatException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String currentLine = reader.readLine();
        reader.close();
        if(currentLine.isEmpty()){
            throw new IOException("No function arguments are provided!!!");
        }
        return currentLine.split(" ");
    }

    private String[] readInputDataFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.inputFile));
        String currentLine = reader.readLine();
        reader.close();
        if(currentLine.isEmpty()){
            throw new IOException("Input file is empty! No function arguments are provided!");
        }
        return currentLine.split(" ");
    }

    private int[] fromStringToNumbers(String[] inputDataAsString) throws NumberFormatException{
        return Arrays.stream(inputDataAsString).mapToInt(Integer::parseInt).toArray();
    }

    private FunctionEnum getFunctionFromString(String funcString) {
        switch(funcString){
            case "add": return FunctionEnum.ADD;
            case "mul": return FunctionEnum.MUL;
            case "mul-then-add": return FunctionEnum.MUL_TWO_THEN_SUM_WITH_THIRD;
            case "inc-then-mul": return FunctionEnum.INCREMENT_THEN_MUL;
        }
        return null;
    }
}
