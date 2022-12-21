import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import receipt.Read.Read;
import receipt.Read.ReadConsole;
import receipt.Read.ReadFactory;
import receipt.Read.ReadFile;

public class ReadFactoryTest {
    @Test
    public void getFromFactoryTest() {
        Read read1 = ReadFactory.getFromFactory("FILE");
        Read read2 = ReadFactory.getFromFactory("CONSOLE");
        Assertions.assertTrue(read1 instanceof ReadFile);
        Assertions.assertTrue(read2 instanceof ReadConsole);
    }
}
