package battleships.gui.panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import translator.CoordinateTranslator;
import translator.TranslatorAdapter;
import battleships.BattleShipsInputUnit;
import battleships.gui.listeners.BattleshipsDeployListeners;
import battleships.gui.panels.logic.BattleshipsDeployLogic;
import game.api.GameState;
import gui.panels.GameBoardPanel;

public class BattleshipDeployPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JPanel gameBoardPanel;
	private GameState gameState;
	private JPanel deployPanel;
	private BattleshipsDeployListeners deployListener;
	private BattleshipsDeployLogic deployLogic;
	private BattleshipGamePanels gamePanels;

	public BattleshipDeployPanel(GameState gameState,BattleShipsInputUnit inputUnit) {
		this.gameState = gameState;
		createDeployPanel(inputUnit);
	}

	public void createDeployPanel(BattleShipsInputUnit inputUnit) {
		deployPanel.setLayout(new BorderLayout());

		TranslatorAdapter ta = new TranslatorAdapter(new CoordinateTranslator());
		createGameBoardPanel(ta);

		deployListener = new BattleshipsDeployListeners();
		deployLogic = new BattleshipsDeployLogic(gameState);
		gamePanels = new BattleshipGamePanels(gameState, ta);

	}
	
	private void createGameBoardPanel(TranslatorAdapter ta) {
		this.gameBoardPanel = new BattleshipGameBoardPanel(gameState, ta);
	}

}
