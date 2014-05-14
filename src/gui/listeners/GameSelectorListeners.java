package gui.listeners;

import game.init.Runner;
import gui.GameFrame;
import gui.GameSelectorPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import othello.backend.OthelloGameFacade;
import othello.gui.OthelloGameFrame;
import othello.gui.OthelloGuiIOFactory;
import othello.gui.OthelloGuiInputUnit;
import othello.gui.OthelloGuiOutputUnit;

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
		OthelloGuiInputUnit inputUnit = new OthelloGuiInputUnit();
		OthelloGuiOutputUnit outputUnit = new OthelloGuiOutputUnit(new OthelloGameFrame(inputUnit));
		new Runner(new OthelloGameFacade(), new OthelloGuiIOFactory(inputUnit, outputUnit)).run();
	}
	
	private void startBattleShipsGame() {
		
	}
}
