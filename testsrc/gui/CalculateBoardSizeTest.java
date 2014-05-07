package gui;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import backend.OthelloGameState;

public class CalculateBoardSizeTest {
	private GameBoardPanel gameBoardPanel;
	private OthelloGameState gameState;

	@Before
	public void setUp() throws Exception {
		gameState = new OthelloGameState();

	}

	@Test
	public void test() {
		gameState.reset();
		gameBoardPanel = new GameBoardPanel(gameState);
		assertEquals(8, gameBoardPanel.getxSize());

	}

}
