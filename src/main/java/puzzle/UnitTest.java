package puzzle;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTest {

    // Test for the bestScoreWriter function
    @Test
    public void testBestScoreWriter() throws java.io.FileNotFoundException{
        // Create an instance of your class
        GameScreen gameScreen = new GameScreen();

        // Define a line for testing
        String testLine = "Test Line";

        // Call the bestScoreWriter function and check for exceptions
        assertDoesNotThrow(() -> {
            try {
                gameScreen.bestScoreWriter(testLine);
            } catch (IOException e) {
                fail("IOException should not be thrown");
            }
        });
    }
}
