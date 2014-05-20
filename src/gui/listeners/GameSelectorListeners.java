package gui.listeners;

import battleships.BattleShipsGameState;
import battleships.BattleShipsInputUnit;
import battleships.gui.ContentPanel;
import battleships.gui.GUIUpdater;
import battleships.gui.panels.BattleshipGamePanels;
import game.api.GameState;
import game.init.Runner;
import game.io.OutputUnit;
import gui.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import othello.backend.OthelloGameFacade;
import othello.gui.*;
import othello.gui.OthelloContentPanel;
import translator.CoordinateTranslator;
import translator.Translator;
import translator.TranslatorAdapter;

import javax.swing.*;

public class GameSelectorListeners {
	private GameSelectorPanel gameSelectorPanel;
    private GameFrame frame;

	public GameSelectorListeners (GameSelectorPanel gameSelectorPanel, GameFrame frame) {
		this.gameSelectorPanel = gameSelectorPanel;
        this.frame = frame;
	}
	
	public void addGameSelectorListeners() {
		gameSelectorPanel.getBtnGameOne().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { startOthelloGame(); }});
		gameSelectorPanel.getBtnGameTwo().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { startBattleShipsGame(); }});
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

        TranslatorAdapter translatorAdapter = new TranslatorAdapter(new CoordinateTranslator());

        BattleshipGamePanels gamePanels = new BattleshipGamePanels(gameState, translatorAdapter);

        ContentPanel contentPanel = new ContentPanel(inputUnit, gamePanels);

        GUIUpdater guiUpdater = new GUIUpdater(contentPanel);

        OutputUnit outputUnit = new GameOutputUnit(guiUpdater);

        frame.setContentPane(contentPanel);
        new Runner(gameState, new GameIoFactory(inputUnit, outputUnit)).run();
        frame.pack();
	}
}

