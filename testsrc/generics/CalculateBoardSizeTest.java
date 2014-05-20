package generics;

import static org.junit.Assert.*;
import othello.backend.OthelloGameFacade;

import org.junit.Before;
import org.junit.Test;

import translator.TextFileTranslator;
import translator.TranslatorAdapter;

public class CalculateBoardSizeTest {
	private GameBoardSizeCalculator gameSizeCalc;
	private OthelloGameFacade gameState;
	private TranslatorAdapter ta;

	@Before
	public void setUp() throws Exception {
		gameState = new OthelloGameFacade();
		ta = new TranslatorAdapter(new TextFileTranslator());
	}

	@Test
	public void test() {
		gameState.reset();
		gameSizeCalc = new GameBoardSizeCalculator();
		int[] result = gameSizeCalc.calculateBoardSize(gameState, ta);
		assertEquals(8, result[0]);
		assertEquals(8, result[1]);
	}

}
