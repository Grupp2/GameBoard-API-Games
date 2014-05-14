package othello.consoleui;

import othello.backend.OthelloGameFacade;
import othello.consoleui.OthelloConsoleOutputUnit;
import junit.framework.TestCase;


/**
 * Created by HuggTop on 2014-04-16.
 */
public class OthelloConsoleOutputUnitTest extends TestCase {
	private OthelloConsoleOutputUnit consoleOutputUnit;
	private OthelloGameFacade gameState;

	public void setUp() throws Exception {
		super.setUp();
		gameState = new OthelloGameFacade();
		gameState.reset();
		consoleOutputUnit = new OthelloConsoleOutputUnit();
	}

	public void testPublish() {
		consoleOutputUnit.publish(gameState);
	}

	 
	
//    public void setUp() throws Exception {
//        super.setUp();
//		gameState = new OthelloGameFacade();
//        consoleOutputUnit = new OthelloConsoleOutputUnit();
//    }

    public void testResetPublish() {
    	gameState.reset();
    	String[] outputString = consoleOutputUnit.getOutputString(gameState).split("\\n");
    	if (!outputString[0].equals("  1  2  3  4  5  6  7  8 "))
    		fail("Line 1 is incorrect!");
    	if (!outputString[1].equals("A ·  ·  ·  ·  ·  ·  ·  ·  "))
    		fail("Line 2 is incorrect!");
    	if (!outputString[2].equals("B ·  ·  ·  ·  ·  ·  ·  ·  "))
    		fail("Line 3 is incorrect!");
    	if (!outputString[3].equals("C ·  ·  ·  ·  ·  ·  ·  ·  "))
    		fail("Line 4 is incorrect!");
    	if (!outputString[4].equals("D ·  ·  ·  X  O  ·  ·  ·  "))
    		fail("Line 5 is incorrect!");
    	if (!outputString[5].equals("E ·  ·  ·  O  X  ·  ·  ·  "))
    		fail("Line 6 is incorrect!");
    	if (!outputString[6].equals("F ·  ·  ·  ·  ·  ·  ·  ·  "))
    		fail("Line 7 is incorrect!");
    	if (!outputString[7].equals("G ·  ·  ·  ·  ·  ·  ·  ·  "))
    		fail("Line 8 is incorrect!");
    	if (!outputString[8].equals("H ·  ·  ·  ·  ·  ·  ·  ·  "))
    		fail("Line 9 is incorrect!");
    	
    	
    }

}
