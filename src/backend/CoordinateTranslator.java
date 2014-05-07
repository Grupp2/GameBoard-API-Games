package backend;

import java.util.HashMap;
import java.util.Properties;

import backend.util.PropertiesReaderWriter;
import game.api.GameState;

public class CoordinateTranslator {
	private GameState gameState;
	private PropertiesReaderWriter propIO;
	private String columnDataType;
	private String rowDataType;
	private String isLinear;
	private boolean initialized = false;
	private HashMap<String, String> lettersToNumbers;
	private HashMap<String, String> numbersToLetters;

	public CoordinateTranslator(GameState gameState) {
		this.gameState = gameState;
		propIO = new PropertiesReaderWriter();
		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z'};
		int[] numbers = new int[200];
		for (int i = 1; i < numbers.length; i++)
			numbers[i - 1] = i;
		lettersToNumbers = new HashMap<String, String>();
		for (int i = 1; i < letters.length; i++) {
			lettersToNumbers.put(Character.toString(letters[i]),
					Integer.toString(numbers[i]));
		}

		numbersToLetters = new HashMap<String, String>();
		for (int i = 0; i < letters.length; i++) {
			numbersToLetters.put(Integer.toString(numbers[i]),
					Character.toString(letters[i]));
		}
		return;
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
		String firstPart = Character.toString(input.charAt(0));
		String secondPart = input.substring(1);

		String output = "";
		if (rowDataType.equals("numbers"))
			output += lettersToNumbers.get(firstPart);
		else if (rowDataType.equals("letters"))
			output += firstPart;

		if (rowDataType.equals("letters"))
			output += numbersToLetters.get(secondPart);
		else if (rowDataType.equals("numbers"))
			output += secondPart;

		return output;
	}
}
