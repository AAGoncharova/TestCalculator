import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * @author AAGoncharova
 *
 * This class handles all interactions with the database.
 * It establishes connections to the database and executes SQL statements.
 */
public final class DBManager {
    private Connection connection;

    public DBManager() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/calculator";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");
        connection = DriverManager.getConnection(url, props);
    }

    public void writeToDB(int result){
        String query = "insert into public.output_data (data) values (" + result + ")";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Gets data from the first row of input data table.
     * @return an array of strings where first element is function name and all next are numbers.
     * @throws IOException
     */
    public String[] readFromDB() throws IOException {
        String func = "";
        String data = "";
        String query = "select * from public.input_data limit 1";

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                func = rs.getString("function");
                data = rs.getString("data");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(func.isEmpty() || data.isEmpty())
            throw new IOException("No input data in DB!!!");

        String[] funcAsArray = {func};
        String[] dataAsArray = data.split(" ");

        return Stream.concat(Arrays.stream(funcAsArray), Arrays.stream(dataAsArray)).toArray(String[]::new);
    }

    public void closeDBConnection() throws SQLException {
        connection.close();
    }
}
