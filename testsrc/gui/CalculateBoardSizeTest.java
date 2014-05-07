package gui;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import backend.OthelloGameState;

public class CalculateBoardSizeTest {
	private GameBoardSizeCalculator gameSizeCalc;
	private OthelloGameState gameState;

	@Before
	public void setUp() throws Exception {
		gameState = new OthelloGameState();
	}

	@Test
	public void test() {
		gameState.reset();
		gameSizeCalc = new GameBoardSizeCalculator();
		int[] result = gameSizeCalc.calculateBoardSize(gameState);
		assertEquals(8, result[0]);
		assertEquals(8, result[1]);
	}

}
