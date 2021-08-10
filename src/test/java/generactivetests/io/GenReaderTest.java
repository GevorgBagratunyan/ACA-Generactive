package generactivetests.io;

import com.gevorgbagratunyan.generactive.exception.FileIsEmptyException;
import com.gevorgbagratunyan.generactive.io.GenReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GenReaderTest {


    static final String FILEPATH = "src\\main\\resources\\item.csv";
    GenReader reader = new GenReader(FILEPATH);


    @Test
    @DisplayName("Read Item fields From .csv")
    public void readObjectFromCSV() {
        assertNotNull(reader.readObject());
    }

    @Test
    @DisplayName("Read and assert Item fields From .csv")
    public void readObjectFieldsFromCSV_andAssertAll() {
        List<String> params = reader.readObject();
        assertAll("Should return Item fields from .csv",
                () -> assertEquals("1", params.get(0)),
                () -> assertEquals("25.0", params.get(1)),
                () -> assertEquals("https://m.media-amazon.com/images/P/B0863V2HSX.01._SCLZZZZZZZ_SX500_.jpg", params.get(3)),
                () -> assertEquals("2", params.get(4)));
    }

    //This method throws NullPointerException, because when passing wrong path, the
    //BufferedReader remains not created , and assigned as null
    @Test
    @DisplayName("Throw exception when passed wrong path")
    public void readObjectFromWrongFilePath() {
        assertThrows(NullPointerException.class, () -> {
            GenReader reader = new GenReader("Wrong File Path");
            reader.readObject();
        });
    }


    @Test
    @DisplayName("Throw exception when file is empty")
    public void readObjectFromEmptyFile() {
        assertThrows(FileIsEmptyException.class, () -> {
            GenReader reader = new GenReader(FILEPATH);
            reader.readObject();
        });
    }


}
