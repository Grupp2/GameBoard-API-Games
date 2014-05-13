package translator;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import translator.CoordinateTranslator;

public class TestCoordinateTranslator {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testTranslationFromGUItoGame() {
	    	String output;
	    	CoordinateTranslator translator = new CoordinateTranslator();
		String rowDataType = "numbers";
		String columnDataType = "letters";
		translator.OverWritePropertyValues(rowDataType, columnDataType);
		

		if (!(output = translator.translateRowFromGui("A")).equals("1"))
			fail("invalid translation, " + output);
		if (!(output = translator.translateRowFromGui("Z")).equals("26"))
			fail("invalid translation, " + output);

		if (!(output = translator.translateColumnFromGui("1")).equals("A"))
		    	fail("invalid translation, " + output);
		if (!(output = translator.translateColumnFromGui("26")).equals("Z"))
		    	fail("invalid translation, " + output);

		if (!(output = translator.translateFromUiToGameState("A1")).equals("1A"))
		    	fail("invalid translation, " + output);
		if (!(output = translator.translateFromUiToGameState("Z26")).equals("26Z"))
		    	fail("invalid translation, " + output);
		
		rowDataType = "letters";
		columnDataType = "letters";
		translator.OverWritePropertyValues(rowDataType, columnDataType);

		if (!(output = translator.translateColumnFromGui("1")).equals("A"))
		    	fail("invalid translation, " + output);
		if (!(output = translator.translateColumnFromGui("26")).equals("Z"))
		    	fail("invalid translation, " + output);

		if (!(output = translator.translateFromUiToGameState("A1")).equals("AA"))
		    	fail("invalid translation, " + output);
		if (!(output = translator.translateFromUiToGameState("Z26")).equals("ZZ"))
		    	fail("invalid translation, " + output);
		
		rowDataType = "letters";
		columnDataType = "numbers";
		translator.OverWritePropertyValues(rowDataType, columnDataType);
		
		if (!(output = translator.translateFromUiToGameState("A1")).equals("A1"))
			fail("invalid translation, " + output);
		if (!(output = translator.translateFromUiToGameState("Z26")).equals("Z26"))
			fail("invalid translation, " + output);

	}

	@Test
	public void testTranslationFromGameStateToGui() {
	    	String output;
	    	CoordinateTranslator translator = new CoordinateTranslator();
		String rowDataType = "letters";
		String columnDataType = "letters";
		translator.OverWritePropertyValues(rowDataType, columnDataType);
		
		if (!(output = translator.translateFromGameStateToUi("AA")).equals("A1"))
			fail("invalid translation");
		if (!(output = translator.translateFromGameStateToUi("ZZ")).equals("Z26"))
			fail("invalid translation");
		
		rowDataType = "numbers";
		columnDataType = "letters";
		translator.OverWritePropertyValues(rowDataType, columnDataType);
		
		if (!(output = translator.translateFromGameStateToUi("1A")).equals("A1"))
			fail("invalid translation, " + output);
		output = translator.translateFromGameStateToUi("26Z");
		if (!(output = translator.translateFromGameStateToUi("26Z")).equals("Z26"))
			fail("invalid translation, " + output);
		
		rowDataType = "letters";
		columnDataType = "numbers";
		translator.OverWritePropertyValues(rowDataType, columnDataType);
		
		if (!(output = translator.translateFromGameStateToUi("A1")).equals("A1"))
			fail("invalid translation, " + output);
		if (!(output = translator.translateFromGameStateToUi("Z26")).equals("Z26"))
			fail("invalid translation, " + output);
	
		
	}

}
