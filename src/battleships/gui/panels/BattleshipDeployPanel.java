package battleships.gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import translator.CoordinateTranslator;
import translator.TranslatorAdapter;
import battleships.backend.Settings;
import battleships.gui.BattleShipsInputUnit;
import battleships.gui.listeners.BattleshipsDeployListeners;
import battleships.gui.panels.logic.BattleshipsDeployLogic;
import game.api.GameState;
import generics.GameBoardPanel;

public class BattleshipDeployPanel extends JPanel {

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
		this.setLayout(new BorderLayout());

		TranslatorAdapter ta = new TranslatorAdapter(new CoordinateTranslator());
		createGameBoardPanel(ta);
		createBattleshipsUtilityPanel(inputUnit);

		deployListener = new BattleshipsDeployListeners(gameState,inputUnit);
		deployLogic = new BattleshipsDeployLogic(gameState);
		gamePanels = new BattleshipGamePanels(gameState, ta);
		add(getCurrentPlayerBoard(gameState));
	}
	
	private JPanel getCurrentPlayerBoard(GameState gameState) {
		if (gameState.getPlayerInTurn().getName().equals(Settings.PLAYER_ONE_NAME))
			deployPanel = gamePanels.getPlayer2();
		else
			deployPanel = gamePanels.getPlayer1();
		deployListener.createButtonListeners();
		return deployPanel;
	}

	private void createGameBoardPanel(TranslatorAdapter ta) {
		this.gameBoardPanel = new GameBoardPanel(gameState, ta, new Color(34, 177, 76, 255));
		
	}
	private void createBattleshipsUtilityPanel(BattleShipsInputUnit inputUnit){
		
	}

}
