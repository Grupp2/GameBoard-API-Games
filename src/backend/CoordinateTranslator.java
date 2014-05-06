package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.mockito.asm.tree.IntInsnNode;

import backend.util.PropertiesReaderWriter;
import game.api.GameState;


public class CoordinateTranslator {
	private GameState gameState;
	private PropertiesReaderWriter propIO;
	private String columnDataType;
	private String rowDataType;
	private String isLinear;
	private boolean initialized = false;
	private ArrayList<Character> letterRange;
	
	public CoordinateTranslator(GameState gameState) {
		this.gameState = gameState;
		propIO = new PropertiesReaderWriter();
		letterRange = new ArrayList<>();
		for (int i = 65; i <= 90; i++)
		    letterRange.add((char) i);
		
	}
	
	private void InitializePropertyValues() {
	    Properties prop = propIO.getCoordinatePropertyValues();
	    columnDataType = prop.getProperty("columnDataType");
	    rowDataType = prop.getProperty("rowDataType");
	    isLinear = prop.getProperty("isLinear");
	}
	
	public String translateFromGame(String input) {
	    if (!initialized)
		InitializePropertyValues();
	    
	    return input;
	    
	}
	
	public String translateFromGui(String input) {
	    if (!initialized)
		InitializePropertyValues();
	    Character firstPart = input.charAt(0);
	    String secondPart = input.substring(1, 2);
	    String output = "";
	    
	  
	    
	    return input;
	}
	

	
}
