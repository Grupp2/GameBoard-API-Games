package client;

import battleships.backend.BattleShipsGameState;
import battleships.gui.BattleShipsInputUnit;
import battleships.gui.ContentPanel;
import battleships.gui.GUIUpdater;
import battleships.gui.panels.BattleshipDeployPanel;
import client.games.BattleShipsGame;
import client.games.OthelloGame;
import game.api.GameState;
import game.init.Runner;
import game.io.OutputUnit;
import gui.*;

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
		gameSelectionPanel.getBtnGameOne().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { startOthelloGame(); }});
		gameSelectionPanel.getBtnGameTwo().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { startBattleShipsGame(); }});
	}

	private void startOthelloGame() {
        OthelloGame game = new OthelloGame();

        frame.setContentPane(game.getContentPane());
        game.start();
        frame.pack();
	}
	
	private void startBattleShipsGame() {
        BattleShipsGame game = new BattleShipsGame();

        frame.setContentPane(game.getContentPane());
        game.start();
        frame.pack();
	}
}

