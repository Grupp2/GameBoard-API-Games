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
		propIO = new PropertiesReaderWriter();
		translator = new CoordinateTranslator();
	}

	@Test
	public void testTranslationFromGUItoGame() {
		Properties propRead = propIO.getCoordinatePropertyValues();
		String rowDataType = propRead.getProperty("rowDataType");
		String columnDataType = propRead.getProperty("columnDataType");
		
		if (rowDataType.equals("numbers")) {
			if (!translator.translateRowFromGui("A").equals("1"))
				fail("invalid translation");
			if (!translator.translateRowFromGui("Z").equals("26"))
				fail("invalid translation");
		}
		
		if (columnDataType.equals("letters")) {
			if (!translator.translateColumnFromGui("1").equals("A"))
				fail("invalid translation");
			if (!translator.translateColumnFromGui("26").equals("Z"))
				fail("invalid translation");
		}
		
		if (rowDataType.equals("numbers") && columnDataType.equals("letters")) {
			if (!translator.translateFromUiToGameState("A1").equals("1A"))
				fail("invalid translation");
			if (!translator.translateFromUiToGameState("Z26").equals("26Z"))
				fail("invalid translation");
		}

	}

	@Test
	public void testTranslationToGameState() {
		Properties propRead = propIO.getCoordinatePropertyValues();
		String rowDataType = propRead.getProperty("rowDataType");
		String columnDataType = propRead.getProperty("columnDataType");
		
		if (!translator.translateFromGameStateToUi("1A").equals("A1"))
			fail("invalid translation");
	
		
	}

}
