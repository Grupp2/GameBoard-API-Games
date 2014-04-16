package testsrc.io;

import src.impl.OthelloGameState;
import src.io.OthelloConsoleOutputUnit;
import junit.framework.TestCase;
/**
 * Created by HuggTop on 2014-04-16.
 */
public class OthelloConsoleOutputUnitTest extends TestCase {
    private OthelloConsoleOutputUnit consoleOutputUnit;
	private OthelloGameState gameState;
    public void setUp() throws Exception {
        super.setUp();
		gameState = new OthelloGameState();
        consoleOutputUnit = new OthelloConsoleOutputUnit();
    }

    public void testPublish() {
		consoleOutputUnit.publish(gameState);
    }
}
