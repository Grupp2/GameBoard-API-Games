package battleships.gui.panels;

import java.awt.*;

import javax.swing.JPanel;

import battleships.backend.Settings;
import generics.GameBoardPanel;
import translator.TranslatorAdapter;
import game.api.GameState;

public class BattleshipGamePanels {
	private JPanel player1;
	private JPanel player2;

	public BattleshipGamePanels(GameState gameState, TranslatorAdapter ta) {
		separationOfPlayers(gameState, ta);

	}

	private void separationOfPlayers(GameState gameState, TranslatorAdapter ta) {
		player1 = new JPanel();
		player2 = new JPanel();

		player1.setLayout(new GridLayout(10, 10));
		player2.setLayout(new GridLayout(10, 10));

        player1.setPreferredSize(new Dimension(600, 600));
        player2.setPreferredSize(new Dimension(600, 600));

		GameBoardPanel gb = new GameBoardPanel(gameState, ta, Settings.TILE_COLOR);

		for (int i = 0; i < 100; i++) {
			player1.add(gb.getButton(i));
            player2.add(gb.getButton(i+100));
		}
	}

	public JPanel getPlayer1() {
		return player1;
	}

	public JPanel getPlayer2() {
		return player2;
	}

}
