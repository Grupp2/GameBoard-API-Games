package battleships.gui.panels;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import translator.CoordinateTranslator;
import translator.TranslatorAdapter;
import battleships.BattleShipsInputUnit;
import battleships.gui.listeners.BattleshipsDeployListeners;
import battleships.gui.panels.logic.BattleshipsDeployLogic;
import game.api.GameState;

public class BattleshipDeployPanel {
	private GameState gameState;
	private JPanel deployPanel;
	private BattleshipsDeployListeners deployListener;
	private BattleShipsInputUnit inputUnit;
	private BattleshipsDeployLogic deployLogic;

	public BattleshipDeployPanel(GameState gameState, BattleShipsInputUnit inputUnit) {
		this.gameState = gameState;
		this.inputUnit = inputUnit;
	}

	public void createDeployPanel(JPanel deployPanel) {
		this.deployPanel = deployPanel;
		deployPanel.setLayout(new BorderLayout());
		
		TranslatorAdapter ta = new TranslatorAdapter(new CoordinateTranslator());
		
		deployListener = new BattleshipsDeployListeners();
		deployLogic = new BattleshipsDeployLogic(gameState);
		
	}
	public JPanel getDeployPanel(){
		return deployPanel;
	}

}
