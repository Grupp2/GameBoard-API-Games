package backend;

import java.util.HashMap;
import java.util.Properties;

import translator.Translator;
import backend.util.PropertiesReaderWriter;
import game.api.GameState;

public class CoordinateTranslator implements Translator {
	
	private PropertiesReaderWriter propIO;
	private String columnDataType;
	private String rowDataType;
	private String isLinear;
	private HashMap<String, String> lettersToNumbers;
	private HashMap<String, String> numbersToLetters;

	public CoordinateTranslator() {
		propIO = new PropertiesReaderWriter();
		InitializePropertyValues();

		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z'};
		int[] numbers = new int[200];
		for (int i = 0; i < numbers.length; i++)
			numbers[i] = i + 1;

		lettersToNumbers = new HashMap<String, String>();

		for (int i = 0; i < letters.length; i++) {
			lettersToNumbers.put(Character.toString(letters[i]),
					Integer.toString(numbers[i]));
		}

		numbersToLetters = new HashMap<String, String>();
		for (int i = 0; i < letters.length; i++) {
			numbersToLetters.put(Integer.toString(numbers[i]),
					Character.toString(letters[i]));
		}

	}

	private void InitializePropertyValues() {
		Properties prop = propIO.getCoordinatePropertyValues();
		columnDataType = prop.getProperty("columnDataType");
		rowDataType = prop.getProperty("rowDataType");
		isLinear = prop.getProperty("isLinear");
	}

	public String translateFromGameStateToUi(String input) {
		return translateRowFromGame(input) + translateColumnFromGame(input);
	}
	
	protected String translateRowFromGame(String input) {
		String output = "";
		if (rowDataType.equals("numbers")) {
			if (input.length() >= 3)
				output += numbersToLetters.get(input.substring(0, 3));
			else
				output += numbersToLetters.get(Character.toString(input.charAt(0)));
		} else {
			if (input.length() >= 3)
				output += input.substring(0, 3);
			else
				output += Character.toString(input.charAt(0));
		}
		return output;
	}
	
	protected String translateColumnFromGame(String input) {
		String output = "";
		if (columnDataType.equals("letters")) {
			if (input.length() >= 3)
				output += lettersToNumbers.get(input.substring(1, 4));
			else
				output += lettersToNumbers.get(Character.toString(input.charAt(1)));
		} else {
			if (input.length() >= 3)
				output += input.substring(1, 4);
			else
				output += Character.toString(input.charAt(1));
		}
		return output;
	}
	
	protected String translateRowFromGui(String rowData) {
		String output = "";
		if (rowDataType.equals("numbers"))
			output += lettersToNumbers.get(rowData);
		else if (rowDataType.equals("letters"))
			output += rowData;
		return output;
		
	}
	
	protected String translateColumnFromGui(String columnData) {
		String output = "";
		if (columnDataType.equals("letters"))
			output += numbersToLetters.get(columnData);
		else if (columnDataType.equals("numbers"))
			output += columnData;
		return output;
	}

	public String translateFromUiToGameState(String input) {
		String rowData;
		String columnData;
		if (rowDataType.equals("numbers") && columnDataType.equals("numbers")) {
			
		}
		rowData = Character.toString(input.charAt(0));
		columnData = input.substring(1);
		return translateRowFromGui(rowData) + translateColumnFromGui(columnData);
	}
}
