package backend;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Properties;

import game.api.GameState;

import org.junit.Before;
import org.junit.Test;

import backend.util.PropertiesReaderWriter;

public class TestCoordinateTranslator {

    GameState state;
    CoordinateTranslator translator;
    PropertiesReaderWriter propIO;

    @Before
    public void setUp() throws Exception {
	state = mock(GameState.class);
	translator = new CoordinateTranslator(state);
	propIO = new PropertiesReaderWriter();
    }

    @Test
    public void testTranslationFromGUItoGame() {
	Properties propRead = propIO.getCoordinatePropertyValues();
	String rowDataType = propRead.getProperty("rowDataType");
	String columnDataType = propRead.getProperty("columnDataType");
	String isLinear = propRead.getProperty("isLinear");

	char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
		'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
		'W', 'X', 'Y', 'Z' };
	int[] numbers = new int[200];
	for (int i = 1; i < numbers.length; i++)
	    numbers[i - 1] = i;

	if (rowDataType.equals("numbers") && columnDataType.equals("letters")) {
	    for (int i = 1; i <= 26; i++) {
		if (!translator.translateFromGui(
			Character.toString(letters[i - 1])
				+ Integer.toString(numbers[i])).equals(
			i + letters[i - 1])) {
		    fail("Invalid translation. " + letters[i - 1] + " -> " + i);
		}
	    }
	}

    }

}
