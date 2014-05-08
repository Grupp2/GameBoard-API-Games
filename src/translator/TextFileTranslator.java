package translator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TextFileTranslator implements Translator {
	private Map<String, String> gameStateToUiMap = new HashMap<String, String>();
	private Map<String, String> UiTogameStateMap = new HashMap<String, String>();
	
	public TextFileTranslator() {
		loadTranslationFile();
	}

	private void loadTranslationFile() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("translator/Translation.txt");
		} catch (FileNotFoundException e1) {
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line;
		try {
			while ((line = br.readLine()) != null) {
				processTranslationFile(line);
			}
		} catch (IOException e) {

		} finally {
			if (br != null) 
			try {
				br.close();
			} catch (Throwable t) {
			}
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
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