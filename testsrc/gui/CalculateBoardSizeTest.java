package gui;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import translator.TextFileTranslator;
import translator.TranslatorAdapter;
import backend.OthelloGameState;

public class CalculateBoardSizeTest {
	private GameBoardSizeCalculator gameSizeCalc;
	private OthelloGameState gameState;
	private TranslatorAdapter ta;

	@Before
	public void setUp() throws Exception {
		gameState = new OthelloGameState();
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
