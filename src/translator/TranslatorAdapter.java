package translator;

public class TranslatorAdapter {

	private Translator currentTranslator;
	
	public TranslatorAdapter(Translator newTranslator) {
		this.currentTranslator = newTranslator;
	}
	
	public String translateFromGameStateToUi(String str) {
		return currentTranslator.translateFromGameStateToUi(str);
	}
	
	public String translateFromUiToGameState(String str) {
		return currentTranslator.translateFromUiToGameState(str);
	}
}