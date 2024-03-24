import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IOControllerTest {

    @Test
    void programArgsFormatTest() throws SQLException {
        String incorrectInputMode = "d";
        String incorrectOutputMode = "d";

        IOController controller = new IOController(incorrectInputMode, incorrectOutputMode);

        assertThrows(IOException.class, () -> {controller.readInputData();});
    }
}
