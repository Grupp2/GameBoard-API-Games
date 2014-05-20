package client;

import battleships.backend.BattleShipsGameState;
import battleships.gui.BattleShipsInputUnit;
import battleships.gui.ContentPanel;
import battleships.gui.GUIUpdater;
import battleships.gui.panels.BattleshipDeployPanel;
import client.ClientWindow;
import client.GameSelectionPanel;
import game.api.GameState;
import game.init.Runner;
import game.io.OutputUnit;
import gui.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import othello.backend.OthelloGameFacade;
import othello.gui.*;
import othello.gui.OthelloContentPanel;

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

        GameState state = new OthelloGameFacade();
        state.reset();

        OthelloGuiInputUnit inputUnit = new OthelloGuiInputUnit();
        OthelloContentPanel contentPanel = new OthelloContentPanel(state, inputUnit);

        GameUpdatable guiUpdater = new OthelloGuiUpdater(contentPanel);

		OutputUnit outputUnit = new GameOutputUnit(guiUpdater);


        frame.setContentPane(contentPanel);
		new Runner(state, new GameIoFactory(inputUnit, outputUnit)).run();
        frame.pack();
	}
	
	private void startBattleShipsGame() {
		GameState gameState = new BattleShipsGameState();
        gameState.reset();

        BattleShipsInputUnit inputUnit = new BattleShipsInputUnit();

        BattleshipDeployPanel deployPanel = new BattleshipDeployPanel(gameState, inputUnit);

        ContentPanel contentPanel = new ContentPanel(inputUnit, deployPanel);

        GUIUpdater guiUpdater = new GUIUpdater(contentPanel);

        OutputUnit outputUnit = new GameOutputUnit(guiUpdater);

        frame.setContentPane(contentPanel);
        new Runner(gameState, new GameIoFactory(inputUnit, outputUnit)).run();
        frame.pack();
	}
}

