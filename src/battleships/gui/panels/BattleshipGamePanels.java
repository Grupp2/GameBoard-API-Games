package battleships.gui.panels;

import java.awt.GridLayout;

import javax.swing.JPanel;

import translator.TranslatorAdapter;
import game.api.GameState;
import gui.GameBoardSizeCalculator;

public class BattleshipGamePanels {
	private GameState gameState;
	private JPanel player1;
	private JPanel player2;
	
	public BattleshipGamePanels(GameState gameState, TranslatorAdapter ta){
		
	}
	private void separationOfPlayers(GameState gameState,TranslatorAdapter ta){
		player1 = new JPanel();
		player2 = new JPanel();
		GameBoardSizeCalculator gc = new GameBoardSizeCalculator();
		int[] xy = gc.calculateBoardSize(gameState, ta);
		player1.setLayout(new GridLayout(xy[1]/2, xy[0]));
		player2.setLayout(new GridLayout(xy[1]/2, xy[0]));
		BattleshipGameBoardPanel gb = new BattleshipGameBoardPanel(gameState, ta);
		
		for(int i = 0 ; i < 100 ; i++){
			player1.add(gb.getComponent(i));
		}
		for(int i = 100; i < 200; i++){
			player2.add(gb.getComponent(i));
		}
		
	}

}
