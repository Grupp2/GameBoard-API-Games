package io;

import game.api.GameState;
import game.io.OutputUnit;
import impl.OthelloGameState;
import io.OthelloConsoleOutputUnit;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

/**
 * Created by HuggTop on 2014-04-16.
 */
public class OthelloConsoleOutputUnitTest extends TestCase {
	private OthelloConsoleOutputUnit consoleOutputUnit;
	private OthelloGameState gameState;

	public void setUp() throws Exception {
		super.setUp();
		gameState = new OthelloGameState();
		gameState.reset();
		consoleOutputUnit = new OthelloConsoleOutputUnit();
	}

	public void testPublish() {
		consoleOutputUnit.publish(gameState);
	}
}
