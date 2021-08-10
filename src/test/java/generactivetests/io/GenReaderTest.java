package generactivetests.io;

import com.gevorgbagratunyan.generactive.io.GenReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GenReaderTest {



    static final String FILEPATH = "src\\main\\resources\\item.csv";
    GenReader reader = new GenReader(FILEPATH);


    @Test
    @DisplayName("Read Item fields From .csv")
    public void  readObjectFromCSV() {
        assertNotNull(reader.readObject());
    }

    @Test
    @DisplayName("Throw exception when passed wrong path")
    public void  readObjectFromWrongFilePath() {
        assertThrows(NullPointerException.class, () -> {
            GenReader reader = new GenReader("Wrong File Path");
            reader.readObject();
        });
    }


}
