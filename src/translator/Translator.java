package translator;

public interface Translator {

	public String translateFromGameStateToUi(String str);
	
	public String translateFromUiToGameState(String str);
}
