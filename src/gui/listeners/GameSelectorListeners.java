package gui.listeners;

import game.api.GameState;
import game.init.Runner;
import game.io.InputUnit;
import game.io.OutputUnit;
import gui.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import othello.backend.OthelloGameFacade;
import othello.gui.*;
import othello.gui.panels.OthelloContentPanel;

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

        OthelloGuiInputUnit inputUnit = new OthelloGuiInputUnit();
        OthelloContentPanel contentPanel = new OthelloContentPanel(state, inputUnit);

        GameUpdatable guiUpdater = new OthelloGuiUpdater(contentPanel);


        JPanel contentPane = new JPanel();

		OutputUnit outputUnit = new GameOutputUnit(guiUpdater, contentPanel, contentPane);

        frame.setContentPane(contentPane);

		new Runner(state, new GameIoFactory(inputUnit, outputUnit)).run();
	}
	
	private void startBattleShipsGame() {
		
	}
}
