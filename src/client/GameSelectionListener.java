package client;


import client.games.BattleShipsGame;
import client.games.GameStartup;
import client.games.OthelloGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSelectionListener {
	private GameSelectionPanel gameSelectionPanel;
    private ClientWindow frame;

	public GameSelectionListener(GameSelectionPanel gameSelectionPanel, ClientWindow frame) {
		this.gameSelectionPanel = gameSelectionPanel;
        this.frame = frame;
	}
	
	public void addGameSelectorListeners() {

		gameSelectionPanel.getBtnGameOne().addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    startOthelloGame();
                }
            }
        );

		gameSelectionPanel.getBtnGameTwo().addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    startBattleShipsGame();
                }
            }
        );
	}

    private void startGame(GameStartup game){
        frame.setContentPane(game.getContentPane());
        game.start();
        frame.pack();
    }

	private void startOthelloGame() {
        startGame(new OthelloGame());
	}
	
	private void startBattleShipsGame() {
        startGame(new BattleShipsGame());
	}
}

