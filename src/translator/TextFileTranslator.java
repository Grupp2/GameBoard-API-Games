package translator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TextFileTranslator implements Translator {
	private Map<String, String> gameStateToUiMap = new HashMap<String, String>();
	private Map<String, String> UiTogameStateMap = new HashMap<String, String>();

	public TextFileTranslator() {
		loadTranslationFile();
	}

	private void loadTranslationFile() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new FileReader("Translation.txt"));
			String line;
			while ((line = br.readLine()) != null)
				processTranslationFile(line);
		} catch (IOException e) {

		} finally {
			if (br != null)
				try {
					br.close();
				} catch (Throwable t) {
				}

		}
	}

	private void processTranslationFile(String line) {
		String[] tmp = line.split("=");
		String state = tmp[0];
		String ui = tmp[1];
		gameStateToUiMap.put(state, ui);
		UiTogameStateMap.put(ui, state);
	}

	@Override
	public String translateFromGameStateToUi(String str) {
		return gameStateToUiMap.get(str);
	}

	@Override
	public String translateFromUiToGameState(String str) {
		return UiTogameStateMap.get(str);
	}
}